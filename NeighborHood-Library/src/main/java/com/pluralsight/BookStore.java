package com.pluralsight;

import java.util.Scanner;

public class BookStore {
    private static final Book[] inventory = new Book[20];

    public static void main(String[] args) {
        initializeInventory();
        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("\n--- Book Store Home ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showAvailableBooks(scanner);
                case "2" -> showCheckedOutBooks(scanner);
                case "3" -> {
                    System.out.println("Exiting the Book Store. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeInventory() {
        String[][] books = {
                {"978-0439136365", "Harry Potter and the Prisoner of Azkaban"},
                {"978-0061120084", "Captain Underpants"},
                {"978-0451524935", "Berserk Chapter 1"},
                {"978-0544003415", "The Hobbit"},
                {"978-0141439600", "Death Note(Complete Addition)"},
                {"978-0060850524", "Brave New World"},
                {"978-0385472579", "Emotional Intelligence"},
                {"978-1501128035", "The men we reap"},
                {"978-0307277671", "Frankenstein"},
                {"978-0385545968", "Kindred"},
                {"978-0140177398", "Meg"},
                {"978-0142424179", "The Story of Philosophy"},
                {"978-0553296983", "Dune"},
                {"978-0385754729", "Escape from freedom"},
                {"978-0374533557", "Bible"},
                {"978-0143039433", "Minecraft Guide"},
                {"978-0743273565", "The Great Gatsby"},
                {"978-0143105985", "Moby Dick"},
                {"978-0812981605", "Greek Mythology"},
                {"978-0679783268", "A case of curiosity"}
        };

        for (int i = 0; i < books.length; i++) {
            inventory[i] = new Book(books[i][0], books[i][1]);
        }
    }

    private static void showAvailableBooks(Scanner scanner) {
        System.out.println("\n--- Available Books ---");
        boolean anyAvailable = false;
        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s%n", book.getId(), book.getIsbn(), book.getTitle());
                anyAvailable = true;
            }
        }

        if (!anyAvailable) {
            System.out.println("No available books.");
            return;
        }

        System.out.print("\nEnter Book ID to check out or X to return: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("X")) return;

        try {
            int id = Integer.parseInt(input);
            Book book = findBookById(id);
            if (book != null && !book.isCheckedOut()) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                book.checkOut(name);
                System.out.println("Book checked out successfully.");
            } else {
                System.out.println("Book not available or invalid ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private static void showCheckedOutBooks(Scanner scanner) {
        System.out.println("\n--- Checked Out Books ---");
        boolean anyCheckedOut = false;
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s | Checked Out To: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
                anyCheckedOut = true;
            }
        }

        if (!anyCheckedOut) {
            System.out.println("No books are currently checked out.");
            return;
        }

        System.out.print("\nEnter Book ID to check in or X to return: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("X")) return;

        try {
            int id = Integer.parseInt(input);
            Book book = findBookById(id);
            if (book != null && book.isCheckedOut()) {
                book.checkIn();
                System.out.println("Book checked in successfully.");
            } else {
                System.out.println("Invalid ID or book is not checked out.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private static Book findBookById(int id) {
        for (Book book : inventory) {
            if (book.getId() == id) return book;
        }
        return null;
    }
}