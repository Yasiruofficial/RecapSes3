package Model;

import java.io.Serializable;

public class BookBeen implements Serializable {


    private String _name;
    private String _author;
    private String _description;
    private float _uprice;

    public BookBeen() {
        _name = "UnKnown";
        _author = "UnKnown";
        _description = "UnKnown";
        _uprice = 0.0f;
    }

    public BookBeen(String name, String author, String description, float uprice) {
        _name = name;
        _author = author;
        _description = description;
        _uprice = uprice;
    }

    public String getName() {
        return _name;
    }

    public void setName(String Name) {
        _name = Name;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public float getUprice() {
        return _uprice;
    }

    public void setUprice(float uprice) {
        _uprice = uprice;
    }

}
