package com.sg.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un compte bancaire.
 */
public class BankAccount {
    private double balance; // Solde actuel du compte
    private List<Transaction> transactionHistory; // Historique des transactions

    /**
     * Constructeur pour créer un nouveau compte bancaire.
     */
    public BankAccount() {
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Méthode pour déposer de l'argent sur le compte.
     *
     * @param amount Montant à déposer
     */
    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif");
        }
        balance += amount;
        transactionHistory.add(new Transaction(TransactionType.DEPOSIT, LocalDateTime.now(), amount, balance));
    }

    /**
     * Méthode pour retirer de l'argent du compte.
     *
     * @param amount Montant à retirer
     */
    public synchronized void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Fonds insuffisants");
        }
        balance -= amount;
        transactionHistory.add(new Transaction(TransactionType.WITHDRAWAL, LocalDateTime.now(), -amount, balance));
    }

    /**
     * Méthode pour obtenir l'historique des transactions du compte.
     *
     * @return Liste des transactions
     */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    /**
     * Méthode pour obtenir le solde actuel du compte.
     *
     * @return Solde actuel
     */
    public double getBalance() {
        return balance;
    }
}
