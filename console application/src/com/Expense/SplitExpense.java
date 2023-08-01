package com.Expense;
public class SplitExpense extends BaseExpense {
    private int expenseId;

    // Constructor
    public SplitExpense(int splitExpenseId, int expenseId, double totalAmount, double splitAmount) {
        super(splitExpenseId, totalAmount, splitAmount);
        this.expenseId = expenseId;
    }

    // Getters and Setters
    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    @Override
    public String toString() {
        return "SplitExpense{" +
                "splitExpenseId=" + expenseId +
                ", totalAmount=" + totalAmount +
                ", splitAmount=" + splitAmount +
                '}';
    }
}