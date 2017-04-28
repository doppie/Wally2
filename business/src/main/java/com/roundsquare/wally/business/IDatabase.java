package com.roundsquare.wally.business;

import com.roundsquare.wally.business.model.Account;
import com.roundsquare.wally.business.model.Category;
import com.roundsquare.wally.business.model.Transaction;

import java.util.HashMap;

/**
 * Created by Jelle on 28/04/2017.
 */

public interface IDatabase extends IDatabaseRepository {

    HashMap<Long, Account> getAccounts();
    long addAccount(Account account);
    long removeAccount(Account account);
    long updateAccount(Account account);

    HashMap<Long, Transaction> getTransactions();
    long addTransaction(Transaction transaction);
    long removeTransaction(Transaction transaction);
    long updateTransaction(Transaction transaction);

    HashMap<Long, Category> getCategories();
    long addCategory(Category category);
    long removeCategory(Category category);
    long updateCategory(Category category);
}
