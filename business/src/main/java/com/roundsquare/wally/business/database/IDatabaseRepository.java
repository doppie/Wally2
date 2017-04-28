package com.roundsquare.wally.business.database;

import com.roundsquare.wally.business.model.Account;
import com.roundsquare.wally.business.model.Category;
import com.roundsquare.wally.business.model.Transaction;

import java.util.ArrayList;

/**
 * Created by Jelle on 28/04/2017.
 */

public interface IDatabaseRepository {

    long addAccount(Account account);
    long removeAccount(Account account);
    long updateAccount(Account account);

    long addTransaction(Transaction transaction);
    long removeTransaction(Transaction transaction);
    long updateTransaction(Transaction transaction);

    long addCategory(Category category);
    long removeCategory(Category category);
    long updateCategory(Category category);

}
