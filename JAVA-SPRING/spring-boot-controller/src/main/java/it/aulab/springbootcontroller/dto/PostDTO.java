package it.aulab.springbootcontroller.dto;

public class PostDTO {
    
    private String title;
    private String body;
    private Integer bodyLenght;
    private String authorFirstname;
    private String authorLastname;
    private String authorEmail;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getAuthorFirstname() {
        return authorFirstname;
    }
    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }
    public String getAuthorLastname() {
        return authorLastname;
    }
    public void setAuthorLastname(String authorLastname) {
        this.authorLastname = authorLastname;
    }
    public String getAuthorEmail() {
        return authorEmail;
    }
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
    public Integer getBodyLenght() {
        return bodyLenght;
    }
    public void setBodyLenght(Integer bodyLenght) {
        this.bodyLenght = bodyLenght;
    }
}
