package com.roundsquare.wally.business.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.roundsquare.wally.business.model.Account;
import com.roundsquare.wally.business.model.Category;
import com.roundsquare.wally.business.model.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;


/**
 * Created by Jelle on 28/04/2017.
 */

public class DatabaseAdapter extends Database implements IDatabaseAdapter {

    public DatabaseAdapter(Context context) {
        super(context);
    }

    @Override
    public HashMap<Long, Account> getAccounts() {
        HashMap<Long, Account> accounts = new HashMap<>();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNTS, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            long id = c.getLong(c.getColumnIndex(S.ACCOUNTID));
            String name = c.getString(c.getColumnIndex(S.NAME));
            BigDecimal startingValue = new BigDecimal(c.getString(c.getColumnIndex(S.STARTING_VALUE)));

            accounts.put(id, new Account(id, name, startingValue));

            c.moveToNext();
        }
        c.close();
        return accounts;

    }

    @Override
    public long addAccount(Account account) {
        ContentValues values = new ContentValues();
        values.put(S.NAME, account.getName());
        values.put(S.STARTING_VALUE, account.getStartingValue().toString());

        return db.insert(TABLE_ACCOUNTS, null, values);
    }

    @Override
    public long removeAccount(Account account) {
        return db.delete(TABLE_ACCOUNTS, S.ACCOUNTID + "=" + account.getId(), null);
    }

    @Override
    public long updateAccount(Account account) {
        ContentValues values = new ContentValues();
        values.put(S.NAME, account.getName());
        values.put(S.STARTING_VALUE, account.getStartingValue().toString());

        return db.update(TABLE_ACCOUNTS, values, S.ACCOUNTID + "=" + account.getId(), null);
    }

    @Override
    public HashMap<Long, Transaction> getTransactions() {
        HashMap<Long, Transaction> transactions = new HashMap<>();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_TRANSACTIONS, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            long id = c.getLong(c.getColumnIndex(S.TRANSACTIONID));
            long accountid = c.getLong(c.getColumnIndex(S.ACCOUNTID));
            long categoryid = c.getLong(c.getColumnIndex(S.CATEGORYID));
            String description = c.getString(c.getColumnIndex(S.DESCRIPTION));
            String note = c.getString(c.getColumnIndex(S.NOTE));
            BigDecimal value = new BigDecimal(c.getString(c.getColumnIndex(S.VALUE)));

            transactions.put(id, new Transaction(id, accountid, categoryid, description, note, value));

            c.moveToNext();
        }
        c.close();
        return transactions;
    }

    @Override
    public long addTransaction(Transaction transaction) {
        ContentValues values = new ContentValues();
        values.put(S.ACCOUNTID, transaction.getAccountId());
        values.put(S.CATEGORYID, transaction.getCategoryId());
        values.put(S.DESCRIPTION, transaction.getDescription());
        values.put(S.NOTE, transaction.getNote());
        values.put(S.VALUE, transaction.getValue().toString());

        return db.insert(TABLE_TRANSACTIONS, null, values);
    }

    @Override
    public long removeTransaction(Transaction transaction) {
        return db.delete(TABLE_TRANSACTIONS, S.TRANSACTIONID + "=" + transaction.getId(), null);
    }

    @Override
    public long updateTransaction(Transaction transaction) {
        ContentValues values = new ContentValues();
        values.put(S.ACCOUNTID, transaction.getAccountId());
        values.put(S.CATEGORYID, transaction.getCategoryId());
        values.put(S.DESCRIPTION, transaction.getDescription());
        values.put(S.NOTE, transaction.getNote());
        values.put(S.VALUE, transaction.getValue().toString());

        return db.update(TABLE_TRANSACTIONS, values, S.TRANSACTIONID + "=" + transaction.getId(), null);
    }

    @Override
    public HashMap<Long, Category> getCategories() {
        HashMap<Long, Category> categories = new HashMap<>();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_CATEGORIES, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            long id = c.getLong(c.getColumnIndex(S.CATEGORYID));
            String name = c.getString(c.getColumnIndex(S.NAME));

            categories.put(id, new Category(id, name));

            c.moveToNext();
        }
        c.close();
        return categories;
    }

    @Override
    public long addCategory(Category category) {
        ContentValues values = new ContentValues();
        values.put(S.NAME, category.getName());

        return db.insert(TABLE_CATEGORIES, null, values);
    }

    @Override
    public long removeCategory(Category category) {
        return db.delete(TABLE_CATEGORIES, S.CATEGORYID + "=" + category.getId(), null);
    }

    @Override
    public long updateCategory(Category category) {
        ContentValues values = new ContentValues();
        values.put(S.NAME, category.getName());

        return db.update(TABLE_CATEGORIES, values, S.CATEGORYID + "=" + category.getId(), null);
    }
}
