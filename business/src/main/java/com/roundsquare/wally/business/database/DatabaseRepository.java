package com.roundsquare.wally.business.database;

import com.roundsquare.wally.business.model.Account;
import com.roundsquare.wally.business.model.Category;
import com.roundsquare.wally.business.model.Transaction;

import java.util.HashMap;

/**
 * Created by Jelle on 28/04/2017.
 */

public class DatabaseRepository implements IDatabaseRepository {

    protected HashMap<Long, Account> accounts;
    protected HashMap<Long, Transaction> transactions;
    protected HashMap<Long, Category> categories;

    private DatabaseAdapter dbAdapter;

    public DatabaseRepository() {
        dbAdapter = new DatabaseAdapter();
    }

    @Override
    public long addAccount(Account account) {
        long result = dbAdapter.addAccount(account);

        if(result >= 0) {
            accounts.put(result, new Account(result, account));
        }

        return result;
    }

    @Override
    public long removeAccount(Account account) {
        long result = dbAdapter.removeAccount(account);

        if(result >= 0) {
            accounts.remove(account.getId());
        }
        return result;
    }

    @Override
    public long updateAccount(Account updatedAccount) {
        long result = dbAdapter.updateAccount(updatedAccount);

        if(result >= 0) {
            accounts.put(updatedAccount.getId(), updatedAccount);
        }

        return result;
    }

    @Override
    public long addTransaction(Transaction transaction) {
        long result = dbAdapter.addTransaction(transaction);

        if(result >= 0) {
            transactions.put(result, new Transaction(result, transaction));
        }

        return result;
    }

    @Override
    public long removeTransaction(Transaction transaction) {
        long result = dbAdapter.removeTransaction(transaction);

        if(result >= 0) {
            transactions.remove(transaction.getId());
        }

        return result;
    }

    @Override
    public long updateTransaction(Transaction transaction) {
        long result = dbAdapter.updateTransaction(transaction);

        if(result >= 0) {
            transactions.put(transaction.getId(), transaction);
        }

        return result;
    }

    @Override
    public long addCategory(Category category) {
        long result = dbAdapter.addCategory(category);

        if(result >= 0) {
            categories.put(result, new Category(result, category));
        }

        return result;
    }

    @Override
    public long removeCategory(Category category) {
        long result = dbAdapter.removeCategory(category);

        if(result >= 0) {
            categories.remove(category.getId());
        }

        return result;
    }

    @Override
    public long updateCategory(Category category) {
        long result = dbAdapter.updateCategory(category);

        if(result >= 0) {
            categories.put(category.getId(), category);
        }

        return result;
    }
}
