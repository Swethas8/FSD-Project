package com.Expense;

public abstract class BaseExpense {
    protected int expenseId;
    protected double totalAmount;
    protected double splitAmount;

    // Constructor
    public BaseExpense(int expenseId, double totalAmount, double splitAmount) {
        this.expenseId = expenseId;
        this.totalAmount = totalAmount;
        this.splitAmount = splitAmount;
    }

    // Getters and Setters
    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(double splitAmount) {
        this.splitAmount = splitAmount;
    }

    @Override
    public String toString() {
        return "BaseExpense{" +
                "expenseId=" + expenseId +
                ", totalAmount=" + totalAmount +
                ", splitAmount=" + splitAmount +
                '}';
    }
}