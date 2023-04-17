package it.aulab.springbootcontroller.dto;

public class CreatePostDTO {
    // il postDTO serve per la visualizzazione, evitando informazioni futili per il frontend
    // per la creazione andiamo a prendere solo i dati necessari, quindi per esempio di Autore 
    // ci serve solo l'id. 
    private String title;
    private String body;
    private String publishDate;
    private Long authorId;
    public CreatePostDTO() {
    }
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
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

}
