package com.project1.Driver.Pool.Apps.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.Driver.Pool.Apps.Entity.Log;
import com.project1.Driver.Pool.Apps.Entity.Transaction;
import com.project1.Driver.Pool.Apps.Repository.LogRepository;
import com.project1.Driver.Pool.Apps.Repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private LogRepository logRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(int id) {
        return transactionRepository.findById(id);
    }

    public Transaction saveTransaction(Transaction transaction) {
        Transaction saveTransaction = transactionRepository.save(transaction);
        logActivity("Created Transaction", saveTransaction);
        return saveTransaction;
    }

    public Transaction updateTransaction(int id, Transaction transaction) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);
        if (existingTransaction.isPresent()) {
            Transaction updatedTransaction = transactionRepository.save(transaction);
            logActivity("Updated Transaction", updatedTransaction);
            return updatedTransaction;
        } else {
            throw new IllegalArgumentException("Transaction not found");
        }
    }

    public void deleteTransaction(int id) {
        Optional<Transaction> transactionToDelete = transactionRepository.findById(id);
        if (transactionToDelete.isPresent()) {
            transactionRepository.deleteById(id);
            logActivity("Deleted Transaction", transactionToDelete.get());
        } else {
            logActivity("Delete Failed (Transaction Not Found)", null);
        }
    }

    // Log the action performed on a transaction entity
    private void logActivity(String action, Transaction transaction) {
        Log log = new Log();
        String logMessage = "{\"action\": \"" + action + "\"";

        if (transaction != null) {
            logMessage += ", \"transactionID\": \"" + transaction.getId() + "\"";
            logMessage += ", \"carID\": \"" + transaction.getCar().getId() + "\"";
            logMessage += ", \"driverID\": \"" + transaction.getDriver().getId() + "\"";
            logMessage += ", \"location\": \"" + transaction.getLocation() + "\"";
            logMessage += ", \"createdAt\": \"" + transaction.getCreatedAt() + "\""; // Log created_at
            logMessage += ", \"updatedAt\": \"" + transaction.getUpdatedAt() + "\""; // Log updated_at
        }

        logMessage += "}";

        log.setLog(logMessage);
        logRepository.save(log);
    }
}