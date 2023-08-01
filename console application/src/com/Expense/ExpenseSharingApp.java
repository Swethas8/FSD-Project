package com.Expense;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseSharingApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DataStore dataStore = new DBConnection();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("Expense Sharing App");
            System.out.println("1. Adding the User details");
            System.out.println("2. Adding the Expense details");
            System.out.println("3. Splitting the Expenses");
            System.out.println("4. View the spliting expense details");
            System.out.println("5. View the total and splitted amount");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    splitExpense();
                    break;
                case 4:
                    viewExpenses();
                    break;
                case 5:
                    viewBalances();
                    break;
                case 6:
                	System.out.println("Thank You!");
                	return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addUser() {
        System.out.println("Enter the User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the User Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the User Email: ");
        String email = scanner.nextLine();

        System.out.println("Enter the User Password: ");
        String password = scanner.nextLine();

        User newUser = new User(userId, name, email, password);
        dataStore.addUser(newUser);

        System.out.println("User is added successfully!");
    }

    private static void addExpense() {
        System.out.println("Enter the user ID who payes the expense: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Check if the user with the given ID exists
        List<User> users = dataStore.getUsers();
        User user = getUserById(users, userId);
        if (user == null) {
            System.out.println("User is not found. Please enter valid user ID.");
            return;
        }

        System.out.println("Enter the description of the expense: ");
        String description = scanner.nextLine();

        System.out.println("Enter amount of the expense: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the date of the expense: ");
        String date = scanner.nextLine();

        System.out.println("Enter the members count involved in the expense: ");
        int countOfMembers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        int expenseId = dataStore.getExpenses().size() + 1;
        Expense expense = new Expense(expenseId, userId, description, amount, date, countOfMembers);
        dataStore.addExpense(expense);

        System.out.println("Expenses is added successfully!");
    }

    private static void splitExpense() {
        System.out.println("Enter the expense ID to split: ");
        int expenseId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Check if the expense with the given ID exists
        List<Expense> expenses = dataStore.getExpenses();
        Expense expense = getExpenseById(expenses, expenseId);
        if (expense == null) {
            System.out.println("Expense not found. Please enter valid expense ID.");
            return;
        }

        System.out.println("Enter total amount to split: ");
        double totalAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the members count involved in the split: ");
        int countOfMembers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        double splitAmount = totalAmount / countOfMembers;
        int splitExpenseId = dataStore.getSplitExpenses().size() + 1;
        SplitExpense splitExpense = new SplitExpense(splitExpenseId, expenseId, totalAmount, splitAmount);
        dataStore.addSplitExpense(splitExpense);

        System.out.println("Expense splitting is done successfully!");
    }

    private static void viewExpenses() {
        List<Expense> expenses = dataStore.getExpenses();
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            System.out.println("Expense ID | User ID | Description | Amount | Date | Count of Members");
            for (Expense expense : expenses) {
                System.out.println(expense.getExpenseId() + " | " + expense.getUserId() + " | " +
                        expense.getDescription() + " | " + expense.getAmount() + " | " +
                        expense.getDate() + " | " + expense.getCountOfMembers());
            }
        }
    }

    private static void viewBalances() {
        List<SplitExpense> splitExpenses = dataStore.getSplitExpenses();
        if (splitExpenses.isEmpty()) {
            System.out.println("No split expenses found.");
        } else {
            System.out.println("Split Expense ID | Total Amount | Split Amount");
            for (SplitExpense splitExpense : splitExpenses) {
                System.out.println(splitExpense.getExpenseId() + " | " + splitExpense.getTotalAmount() + " | " +
                        splitExpense.getSplitAmount());
            }
        }
    }
    

    // Helper methods to get User and Expense by ID
    private static User getUserById(List<User> users, int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    private static Expense getExpenseById(List<Expense> expenses, int expenseId) {
        for (Expense expense : expenses) {
            if (expense.getExpenseId() == expenseId) {
                return expense;
            }
        }
        return null;
    }
}