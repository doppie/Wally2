package com.roundsquare.wally.business.database;

import com.roundsquare.wally.business.model.Account;
import com.roundsquare.wally.business.model.Category;
import com.roundsquare.wally.business.model.Transaction;

import java.util.HashMap;


/**
 * Created by Jelle on 28/04/2017.
 */

public class DatabaseAdapter implements IDatabaseAdapter {

    @Override
    public HashMap<Long, Account> getAccounts() {
        return null;
    }

    @Override
    public long addAccount(Account account) {
        return 0;
    }

    @Override
    public long removeAccount(Account account) {
        return 0;
    }

    @Override
    public long updateAccount(Account account) {
        return 0;
    }

    @Override
    public HashMap<Long, Transaction> getTransactions() {
        return null;
    }

    @Override
    public long addTransaction(Transaction transaction) {
        return 0;
    }

    @Override
    public long removeTransaction(Transaction transaction) {
        return 0;
    }

    @Override
    public long updateTransaction(Transaction transaction) {
        return 0;
    }

    @Override
    public HashMap<Long, Category> getCategories() {
        return null;
    }

    @Override
    public long addCategory(Category category) {
        return 0;
    }

    @Override
    public long removeCategory(Category category) {
        return 0;
    }

    @Override
    public long updateCategory(Category category) {
        return 0;
    }
}
