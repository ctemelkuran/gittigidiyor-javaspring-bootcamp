package dev.patika.patika0401.repository;

import dev.patika.patika0401.model.WalletServiceTransactionLogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionLoggerRepository extends PagingAndSortingRepository {
    Page<List<WalletServiceTransactionLogger>> findAllTransactionByTransactionDate(LocalDate transactionDateResult, Pageable pageable);
}
