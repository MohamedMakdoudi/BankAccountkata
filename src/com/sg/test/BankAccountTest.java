package com.sg.test;

import static org.junit.jupiter.api.Assertions.*;
import com.sg.bank.BankAccount;
import com.sg.bank.Transaction;
import com.sg.bank.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Initialisation d'un nouveau compte bancaire avant chaque test
        account = new BankAccount();
    }

    @Test
    void depositShouldIncreaseBalance() {
        // Test vérifiant si le solde augmente après un dépôt
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        // Test vérifiant si le solde diminue après un retrait
        account.deposit(500); // Dépôt initial pour permettre le retrait
        account.withdraw(200);
        assertEquals(300, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalanceShouldThrowException() {
        // Test vérifiant qu'une exception est lancée lors d'un retrait supérieur au solde
        account.deposit(200);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(300);
        });
        assertEquals("Fonds insuffisants", exception.getMessage());
    }

    @Test
    void depositNegativeAmountShouldThrowException() {
        // Test vérifiant qu'une exception est lancée lors d'un dépôt d'un montant négatif
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
        assertEquals("Le montant doit être positif", exception.getMessage());
    }

    @Test
    void transactionHistoryShouldBeUpdatedAfterDeposit() {
        // Test vérifiant que l'historique des transactions est mis à jour après un dépôt
        account.deposit(500);
        List<Transaction> history = account.getTransactionHistory();
        assertEquals(1, history.size());
        assertEquals(TransactionType.DEPOSIT, history.get(0).getType());
        assertEquals(500, history.get(0).getAmount());
    }

    @Test
    void transactionHistoryShouldBeUpdatedAfterWithdrawal() {
        // Test vérifiant que l'historique des transactions est mis à jour après un retrait
        account.deposit(500); // Dépôt initial pour permettre le retrait
        account.withdraw(200);
        List<Transaction> history = account.getTransactionHistory();
        assertEquals(2, history.size());
        assertEquals(TransactionType.WITHDRAWAL, history.get(1).getType());
        assertEquals(-200, history.get(1).getAmount());
    }
}
