/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseproject;

/**
 *
 * @author abram
 */

public class BookRecord {
    private String bookId;
    private String bookTitle;
    private String about;
    private String edition;
    private String bookAuthor;

    // Additional fields
    private String rollNumber;
    private String name;
    private String course;
    private String semester;
    private String email;
    private String phoneNumber;

    // Constructors

    // Default constructor
    public BookRecord() {
        // Default constructor
    }

    // Parameterized constructor
    public BookRecord(String bookId, String bookTitle, String about, String edition, String bookAuthor,
                      String rollNumber, String name, String course, String semester, String email, String phoneNumber) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.about = about;
        this.edition = edition;
        this.bookAuthor = bookAuthor;
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
        this.semester = semester;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    // Additional getters and setters

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

