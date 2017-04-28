package com.roundsquare.wally.business.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jelle on 28/04/2017.
 */

public class Database {

    public static final String TABLE_ACCOUNTS = "accounts";
    public static final String DB_CREATE_ACCOUNTS = "create table " + TABLE_ACCOUNTS
            + " (" + S.ACCOUNTID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + S.NAME + " TEXT NOT NULL, "
            + S.STARTING_VALUE + " TEXT NOT NULL);";

    public static final String TABLE_TRANSACTIONS = "transactions";
    public static final String DB_CREATE_TRANSACTIONS = "create table " + TABLE_TRANSACTIONS
            + " (" + S.TRANSACTIONID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + S.DESCRIPTION + " TEXT NOT NULL, "
            + S.NOTE + " TEXT, "
            + S.VALUE + " TEXT NOT NULL);";

    public static final String TABLE_CATEGORIES = "categories";
    public static final String DB_CREATE_CATEGORIES = "create table " + TABLE_CATEGORIES
            + " (" + S.CATEGORYID + " INTEGER PRIMARY KEY AUTOINCREMENT"
            + S.NAME + " TEXT NOT NULL);";

    public static final String TABLE_ACCOUNT_TRANSACTIONS = "account_transactions";
    public static final String DB_CREATE_ACCOUNT_TRANSACTIONS = "create table " + TABLE_ACCOUNT_TRANSACTIONS
            + " (" + S.ACCOUNT_TRANSACTION_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + S.ACCOUNTID + " INTEGER, "
            + S.TRANSACTIONID + " INTEGER, "
            + "foreign key(" + S.ACCOUNTID + ") references " + TABLE_ACCOUNTS + "(" + S.ACCOUNTID + "),"
            + "foreign key(" + S.TRANSACTIONID + ") references " + TABLE_TRANSACTIONS + "(" + S.TRANSACTIONID + "));";

    public static final String TABLE_CATEGORY_TRANSACTIONS = "account_transactions";
    public static final String DB_CREATE_CATEGORY_TRANSACTIONS = "create table " + TABLE_CATEGORY_TRANSACTIONS
            + " (" + S.CATEGORY_TRANSACTION_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + S.CATEGORYID + " INTEGER, "
            + S.TRANSACTIONID + " INTEGER, "
            + "foreign key(" + S.CATEGORYID + ") references " + TABLE_CATEGORIES + "(" + S.CATEGORYID + "),"
            + "foreign key(" + S.TRANSACTIONID + ") references " + TABLE_TRANSACTIONS + "(" + S.TRANSACTIONID + "));";

    public static final String DB_NAME = "wally_db";
    public static final int DB_VERSION = 1;

    protected Context context;
    protected DatabaseHelper dbHelper;
    protected SQLiteDatabase db;

    public Database(Context context) {
        this.context = context;
    }

    public static class DatabaseHelper extends SQLiteOpenHelper {


        DatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE_ACCOUNTS);
            db.execSQL(DB_CREATE_TRANSACTIONS);
            db.execSQL(DB_CREATE_CATEGORIES);
            db.execSQL(DB_CREATE_ACCOUNT_TRANSACTIONS);
            db.execSQL(DB_CREATE_CATEGORY_TRANSACTIONS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("db", "Upgrading database from version " + oldVersion + " to " + newVersion);
        }
    }
}
