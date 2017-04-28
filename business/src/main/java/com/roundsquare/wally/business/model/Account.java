package com.roundsquare.wally.business.model;

import java.math.BigDecimal;

/**
 * Created by Jelle on 28/04/2017.
 */

public class Account {

    private long id;
    private String name;
    private BigDecimal startingValue;

    public Account(long id, String name, BigDecimal startingValue) {
        this.id = id;
        this.name = name;
        this.startingValue = startingValue;
    }

    public Account(long id, Account oldAccount) {
        this.id = id;
        this.name = oldAccount.getName();
        this.startingValue = oldAccount.getStartingValue();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getStartingValue() {
        return startingValue;
    }
}
