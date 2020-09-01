package Beans;


import java.io.Serializable;

public class BookBeen implements Serializable {

    private String Name;
    private String author;
    private String description;
    private float uprice;

    public BookBeen() {
        this.Name = "UnKnown";
        this.author = "UnKnown";
        this.description = "UnKnown";
        this.uprice = 0.0f;
    }

    public BookBeen(String name, String author, String description, float uprice) {
        this.Name = name;
        this.author = author;
        this.description = description;
        this.uprice = uprice;
    }
    
        public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getUprice() {
        return uprice;
    }

    public void setUprice(float uprice) {
        this.uprice = uprice;
    }
 
}
