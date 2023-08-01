package com.Expense;

import java.util.List;

public interface DataStore {
    void addUser(User user);
    void addExpense(Expense expense);
    void addSplitExpense(SplitExpense splitExpense);
    List<User> getUsers();
    List<Expense> getExpenses();
    List<SplitExpense> getSplitExpenses();
}
