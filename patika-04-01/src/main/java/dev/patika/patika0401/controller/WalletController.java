package dev.patika.patika0401.controller;

import dev.patika.patika0401.dto.WalletDTO;
import dev.patika.patika0401.model.Wallet;
import dev.patika.patika0401.model.WalletServiceTransactionLogger;
import dev.patika.patika0401.service.WalletService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wallet")
public class WalletController {
    private final WalletService walletService;

    // Wallet da dönebilirdi, Response ile daha esneğinz
    @PostMapping("/save-wallet")
    public ResponseEntity<Wallet> saveWallet(@RequestBody @Valid WalletDTO walletDTO){
        Optional<Wallet> resultOptional = walletService.saveWallet(walletDTO);

        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/deposit/{customerId}/{currency}/{amount}")
    public ResponseEntity<Wallet> depositToWallet(@PathVariable long customerId,
                                                    @PathVariable("currency") String currencyName,
                                                  @PathVariable double amount){
        Optional<Wallet> resultOptional = walletService.deposit(customerId, currencyName, amount);

        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }

    @PutMapping("/withdraw/{customerId}/{currency}/{amount}")
    public ResponseEntity<Wallet> withdrawFromWallet(@PathVariable long customerId,
                                                  @PathVariable("currency") String currencyName,
                                                  @PathVariable double amount){
        Optional<Wallet> resultOptional = walletService.withdraw(customerId, currencyName, amount);

        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }


    /*
        Write an endpoint to get all wallets from DB (use customer id with requestparam
        and if customer id is not exist, get all wallets with same endpoint)
     */

    @GetMapping("/getWallets")
    public ResponseEntity<List<Wallet>> getWallets(@RequestParam int customerId){

        Optional<List<Wallet>> wallets = walletService.getWallets(customerId);

        return new ResponseEntity<>(wallets.get(), HttpStatus.OK);
    }

    @GetMapping("/get-transactions-by-date")
    public  ResponseEntity<Page<List<WalletServiceTransactionLogger>>> getAllTransactionWithDate(
            @ApiParam(value = "transaction query for the wallet usage", example = "05/07/2021", required = true)
            @RequestParam String transactionDate,
            @PageableDefault(page = 0, size = 10)Pageable pageable){
        return new ResponseEntity<>(this.walletService.getAllTransactionsWithDate(transactionDate, pageable), HttpStatus.OK);
    }
}
