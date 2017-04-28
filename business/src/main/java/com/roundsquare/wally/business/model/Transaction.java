package com.roundsquare.wally.business.model;

import java.math.BigDecimal;

/**
 * Created by Jelle on 28/04/2017.
 */

public class Transaction {

    private long id;
    private long account_id;
    private long category_id;
    private String description;
    private String note;
    private BigDecimal value;

    public Transaction(long id, long account_id, long category_id, String description, String note, BigDecimal value) {
        this.id = id;
        this.account_id = account_id;
        this.category_id = category_id;
        this.description = description;
        this.note = note;
        this.value = value;
    }

    public Transaction(long id, Transaction oldTransaction) {
        this.id = id;
        this.account_id = oldTransaction.getAccountId();
        this.category_id = oldTransaction.getCategoryId();
        this.description = oldTransaction.getDescription();
        this.note = oldTransaction.getNote();
        this.value = oldTransaction.getValue();
    }

    public long getId() {
        return id;
    }

    public long getAccountId() {
        return account_id;
    }

    public long getCategoryId() {
        return category_id;
    }

    public String getDescription() {
        return description;
    }

    public String getNote() {
        return note;
    }

    public BigDecimal getValue() {
        return value;
    }
}
