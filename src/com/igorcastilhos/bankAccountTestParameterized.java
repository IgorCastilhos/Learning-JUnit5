package com.igorcastilhos;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class bankAccountTestParameterized {
    private BankAccount account;
    private final double amount;
    private final boolean branch;
    private final double expected;

    public bankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Igor", "Castilhos", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00},
        });
    }

    @org.junit.Test
    public void getBalance_after_deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);
    }
}
