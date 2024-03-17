package ru.otus.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Service
public class TransactionWrapperService {
    @Transactional
    public <T> T doInTransaction(Supplier<T> supplier) {
        return supplier.get();
    }
}