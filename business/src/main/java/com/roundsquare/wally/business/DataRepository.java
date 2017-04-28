package com.roundsquare.wally.business;


import com.roundsquare.wally.business.model.Account;
import com.roundsquare.wally.business.model.Category;
import com.roundsquare.wally.business.model.Transaction;

import java.util.ArrayList;

public class DataRepository extends DatabaseRepository implements IDataRepository {

    @Override
    public ArrayList<Account> getAccounts() {
        return (ArrayList<Account>) accounts.values();
    }

    @Override
    public Account getAccountById(long id) {
        return accounts.get(id);
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return (ArrayList<Transaction>) transactions.values();
    }

    @Override
    public Transaction getTransactionById(long id) {
        return transactions.get(id);
    }

    @Override
    public ArrayList<Transaction> getTransactionsByAccountId(long accountId) {
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions.values()) {
            if(transaction.getAccountId() == accountId) filteredTransactions.add(transaction);
        }
        return filteredTransactions;
    }

    @Override
    public ArrayList<Transaction> getTransactionsByCategoryId(long categoryId) {
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions.values()) {
            if(transaction.getCategoryId() == categoryId) filteredTransactions.add(transaction);
        }
        return filteredTransactions;
    }

    @Override
    public ArrayList<Category> getCategories() {
        return (ArrayList<Category>) categories.values();
    }

    @Override
    public Category getCategoryById(long id) {
        return categories.get(id);
    }
}
