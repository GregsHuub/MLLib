package Entity;

import java.util.UUID;

public class Book {

    private String title;
    private Integer year;
    private String author;
    private String uuid;
    private Boolean lentStatus;
    private String person;


    public Book(String title, Integer year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.uuid = UUID.randomUUID().toString().substring(0,8);
        this.lentStatus = false;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getLentStatus() {
        return lentStatus;
    }

    public void setLentStatus(Boolean lentStatus) {
        this.lentStatus = lentStatus;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPerson() {
        return person;
    }

    @Override
    public String toString() {
        if(person != null) {
            return String.format("Title: %s, Year: %s, Author: %s, lent: %s, ID: [%s], holder: %s ", title, year, author, lentStatus, uuid, person);
        }else {
            return String.format("Title: %s, Year: %s, Author: %s, lent: %s, ID: [%s] ", title, year, author, lentStatus, uuid);
        }
    }
}
// TODO: 17.01.2020 teraz dodac szukanie 