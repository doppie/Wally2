package com.roundsquare.wally.business;

import com.roundsquare.wally.business.model.Account;
import com.roundsquare.wally.business.model.Category;
import com.roundsquare.wally.business.model.Transaction;

import java.util.ArrayList;

/**
 * Created by Jelle on 28/04/2017.
 */

public interface IDataRepository {

    ArrayList<Account> getAccounts();
    Account getAccountById(long id);

    ArrayList<Transaction> getTransactions();
    Transaction getTransactionById(long id);
    ArrayList<Transaction> getTransactionsByAccountId(long accountId);
    ArrayList<Transaction> getTransactionsByCategoryId(long categoryId);

    ArrayList<Category> getCategories();
    Category getCategoryById(long id);



}
