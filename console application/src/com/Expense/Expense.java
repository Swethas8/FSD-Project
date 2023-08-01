package com.Expense;
public class Expense extends BaseExpense {
    private int userId;
    private String description;
    private double amount;
    private String date;
    private int countOfMembers;

    // Constructor
    public Expense(int expenseId, int userId, String description, double amount, String date, int countOfMembers) {
        super(expenseId, amount, amount / countOfMembers);
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.countOfMembers = countOfMembers;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCountOfMembers() {
        return countOfMembers;
    }

    public void setCountOfMembers(int countOfMembers) {
        this.countOfMembers = countOfMembers;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", countOfMembers=" + countOfMembers +
                '}';
    }
}