package it.aulab.springbootcontroller.dto;

public class AuthorDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Integer numberOfPost;
    public AuthorDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getNumberOfPost() {
        return numberOfPost;
    }
    public void setNumberOfPost(Integer numberOfPost) {
        this.numberOfPost = numberOfPost;
    }
}
