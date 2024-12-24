package org.example;

public class Book {
    private String name;
    private String status;
    private Long id;

    public Book(String name, String status, Long id){
        this.name = name;
        this.status = status;
        this.id = id;

    }
    public Book(String name, String status){
        this.name = name;
        this.status = status;
    }
    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
