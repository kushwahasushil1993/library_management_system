package com.demo.librarymanagement.library_management_system.model;

import javax.validation.constraints.NotBlank;

public class BookRequest {

    private int id;
    @NotBlank(message = "Book name is required")
    private String bookName;

    @NotBlank(message = "Author name is required")
    private String authorName;

    @NotBlank(message = "Request type should be new")
    private String requestType;
    private String createdDate;
    private String updatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
