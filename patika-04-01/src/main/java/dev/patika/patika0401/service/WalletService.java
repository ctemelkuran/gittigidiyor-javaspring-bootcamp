package dev.patika.patika0401.service;

import dev.patika.patika0401.dto.WalletDTO;
import dev.patika.patika0401.exceptions.BadRequestException;
import dev.patika.patika0401.exceptions.CustomerNotFoundException;
import dev.patika.patika0401.exceptions.NotEnoughBalanceException;
import dev.patika.patika0401.exceptions.WalletAlreadyExistsException;
import dev.patika.patika0401.mappers.WalletMapper;
import dev.patika.patika0401.model.Customer;
import dev.patika.patika0401.model.Wallet;
import dev.patika.patika0401.model.WalletServiceTransactionLogger;
import dev.patika.patika0401.model.enums.Currency;
import dev.patika.patika0401.model.enums.TransactionType;
import dev.patika.patika0401.repository.CustomerRepository;
import dev.patika.patika0401.repository.TransactionLoggerRepository;
import dev.patika.patika0401.repository.WalletRepository;
import dev.patika.patika0401.util.ClientRequestInfo;
import dev.patika.patika0401.util.ErrorMessageConstants;
import dev.patika.patika0401.util.WalletValidatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletService{
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WalletMapper walletMapper;
    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Autowired
    private TransactionLoggerRepository transactionLoggerRepository;

    public Optional<Wallet> saveWallet(WalletDTO walletDTO) {
        this.validateRequest(walletDTO);
        Wallet wallet = walletMapper.mapFromWalletDTOToWallet(walletDTO);
        if (walletRepository.selectExistingWalletWithTheSameCurrency(wallet.getCurrency(), wallet.getCustomer().getId())){
            throw new WalletAlreadyExistsException("Wallet with currency type : " + wallet.getCurrency().getCurrencyName()
        + " is already exists!");
        }
        return Optional.of(walletRepository.save(wallet));
    }

    private void validateRequest(WalletDTO walletDTO) {
        WalletValidatorUtil.validateWalletBalance(walletDTO.getBalance());
    }

    public Customer findCustomerById(long customerId){
        Customer foundCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer not found with Id: "+ customerId)));
        return foundCustomer;
    }

    public Optional<Wallet> deposit(long customerId, String currencyName, double amount) {
        Optional<Wallet> wallet = getWallet(customerId, currencyName);
        this.saveTransactionToDatabase(wallet.get(), amount, TransactionType.DEPOSIT);
        wallet.get().setBalance(wallet.get().getBalance()+ amount);
        walletRepository.save(wallet.get());
        return wallet;

    }

    private void saveTransactionToDatabase(Wallet wallet, double amount, TransactionType transactionType) {
        WalletServiceTransactionLogger transactionLogger = new WalletServiceTransactionLogger();
        transactionLogger.setCustomerId(wallet.getCustomer().getId());
        transactionLogger.setBalanceBefore(wallet.getBalance());
        transactionLogger.setBalanceAfter(wallet.getBalance() + amount);
        transactionLogger.setTransactionAmount(amount);
        transactionLogger.setTransactionCurrency(wallet.getCurrency());
        transactionLogger.setTransactionDateTime(LocalDateTime.now());
        transactionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        transactionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        transactionLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        //transactionLogger.setTransactionType(transactionType);
    }


    public Optional<Wallet> withdraw(long customerId, String currencyName, double amount) {
        Optional<Wallet> wallet = getWallet(customerId, currencyName);
        if (amount > wallet.get().getBalance()){
            throw new NotEnoughBalanceException(ErrorMessageConstants.NO_ENOUGH_BALANCE + amount + " "+
                    wallet.get().getCurrency().getCurrencySign());
        }
        wallet.get().setBalance(wallet.get().getBalance()- amount);
        walletRepository.save(wallet.get());
        this.saveTransactionToDatabase(wallet.get(), amount, TransactionType.DEPOSIT);

        return wallet;
    }

    private Optional<Wallet> getWallet(long customerId, String currencyName) {
        Customer customer = this.findCustomerById(customerId);
        Optional<Wallet> wallet = customer.getWallets().stream().filter(w -> w.getCurrency().equals(Currency.valueOf(currencyName))).findFirst();
        if (wallet.isPresent()){
            throw new BadRequestException("Customer : " + customer.getFirstName() + " "+customer.getLastName()+ " doesn't have wallet with "
                    + currencyName);
        }
        return wallet;
    }


    public Optional<List<Wallet>> getWallets(long customerId) {
        Customer customer = this.findCustomerById(customerId);
        Optional<List<Wallet>> wallets = Optional.of(customer.getWallets());

        if (wallets.get().isEmpty()) {
            wallets = Optional.of(walletRepository.findAll());
        }

        return wallets;
    }

    public Page<List<WalletServiceTransactionLogger>> getAllTransactionsWithDate(String transactionDate, Integer page, Integer size, Pageable pageable) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        WalletValidatorUtil.validateTransactionDate(transactionDate, formatter);
        LocalDate transactionDateResult = LocalDate.parse(transactionDate, formatter);
        if(page != null && size != null){
            pageable = PageRequest.of(page, size);
        }
        return this.transactionLoggerRepository.findAllTransactionByTransactionDate(transactionDateResult, pageable);
    }
}
