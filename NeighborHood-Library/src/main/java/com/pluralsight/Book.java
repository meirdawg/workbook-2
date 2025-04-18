package com.pluralsight;

public class Book {
    private static int nextId = 1;
    private int id;
    private String isbn;
    private String title;
    private boolean checkedOut;
    private String checkedOutTo;

    public Book(String isbn, String title) {
        this.id = nextId++;
        this.isbn = isbn;
        this.title = title;
        this.checkedOut = false;
        this.checkedOutTo = null;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void checkOut(String name) {
        this.checkedOut = true;
        this.checkedOutTo = name;
    }

    public void checkIn() {
        this.checkedOut = false;
        this.checkedOutTo = null;
    }
}