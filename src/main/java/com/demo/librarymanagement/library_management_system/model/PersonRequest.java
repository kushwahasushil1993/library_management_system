package com.demo.librarymanagement.library_management_system.model;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class PersonRequest {

    private int personId;
    @NotBlank(message = "first name is required")
    private String firstName;
    private String lastName;
    private String contactInfo;
    @NotBlank(message = "book issued date is required")
    private String bookIssueDate;
    @NotBlank(message = "book return date is required")
    private String bookReturnDate;
    private java.lang.Integer book;
    @NotBlank(message = "email address is required")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getBookIssueDate() {
        return bookIssueDate;
    }

    public void setBookIssueDate(String bookIssueDate) {
        this.bookIssueDate = bookIssueDate;
    }

    public String getBookReturnDate() {
        return bookReturnDate;
    }

    public void setBookReturnDate(String bookReturnDate) {
        this.bookReturnDate = bookReturnDate;
    }
}
