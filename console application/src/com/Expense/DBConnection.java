package com.Expense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection implements DataStore {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/miniproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ABmh1078@";

    private Connection connection;

    public DBConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        try (PreparedStatement stmt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS users (userId INTEGER PRIMARY KEY, name TEXT, email TEXT, password TEXT)")) {
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement stmt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS expenses (expenseId INTEGER PRIMARY KEY, userId INTEGER, description TEXT, " +
                        "amount REAL, date TEXT, countOfMembers INTEGER)")) {
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement stmt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS split_expenses (splitExpenseId INTEGER PRIMARY KEY, expenseId INTEGER, " +
                        "totalAmount REAL, splitAmount REAL)")) {
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {
        String query = "INSERT INTO users (userId, name, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addExpense(Expense expense) {
        String query = "INSERT INTO expenses (expenseId, userId, description, amount, date, countOfMembers) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, expense.getExpenseId());
            stmt.setInt(2, expense.getUserId());
            stmt.setString(3, expense.getDescription());
            stmt.setDouble(4, expense.getAmount());
            stmt.setString(5, expense.getDate());
            stmt.setInt(6, expense.getCountOfMembers());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSplitExpense(SplitExpense splitExpense) {
        String query = "INSERT INTO split_expenses (splitExpenseId, expenseId, totalAmount, splitAmount) " +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, splitExpense.getExpenseId());
            stmt.setInt(2, splitExpense.getExpenseId());
            stmt.setDouble(3, splitExpense.getTotalAmount());
            stmt.setDouble(4, splitExpense.getSplitAmount());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                users.add(new User(userId, name, email, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Expense> getExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM expenses";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                int expenseId = resultSet.getInt("expenseId");
                int userId = resultSet.getInt("userId");
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                int countOfMembers = resultSet.getInt("countOfMembers");
                expenses.add(new Expense(expenseId, userId, description, amount, date, countOfMembers));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public List<SplitExpense> getSplitExpenses() {
        List<SplitExpense> splitExpenses = new ArrayList<>();
        String query = "SELECT * FROM split_expenses";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                int splitExpenseId = resultSet.getInt("splitExpenseId");
                int expenseId = resultSet.getInt("expenseId");
                double totalAmount = resultSet.getDouble("totalAmount");
                double splitAmount = resultSet.getDouble("splitAmount");
                splitExpenses.add(new SplitExpense(splitExpenseId, expenseId, totalAmount, splitAmount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return splitExpenses;
    }
}
