package com.sg.bank;

import java.time.LocalDateTime;

/**
 * Classe représentant une transaction sur un compte bancaire.
 */
public class Transaction {

    private TransactionType type; // Type de la transaction (dépôt ou retrait)
    private LocalDateTime date; // Date et heure de la transaction
    private double amount; // Montant de la transaction
    private double balanceAfterTransaction; // Solde du compte après la transaction

    /**
     * Constructeur pour créer une nouvelle transaction.
     *
     * @param type                   Type de la transaction (dépôt ou retrait)
     * @param date                   Date et heure de la transaction
     * @param amount                 Montant de la transaction
     * @param balanceAfterTransaction Solde du compte après la transaction
     */
    public Transaction(TransactionType type, LocalDateTime date, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    /**
     * Obtient le type de la transaction.
     *
     * @return Le type de la transaction.
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Obtient le montant de la transaction.
     *
     * @return Le montant de la transaction.
     */
    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", balanceAfterTransaction=" + balanceAfterTransaction +
                '}';
    }
}
