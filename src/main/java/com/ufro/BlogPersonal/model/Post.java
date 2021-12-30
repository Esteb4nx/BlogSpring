package com.ufro.BlogPersonal.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Post {
    // en este atributo tanto post como user pueden ser GenerationType.AUTO pero se removió para evitar temporalmente
    // el WARN 'Error executing DDL "drop sequence hibernate_sequence"' en el log de la app (puede haber una solución mejor)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 120)
    private String title;

    @Column(name = "body", nullable = false, columnDefinition="TEXT")
    private String body;

    @Column(name = "post_date")
    private Timestamp postDate;

    @Column(name = "cover_picture", columnDefinition="TEXT")
    private String coverPicture;

    // FIXME: hibernate ddl log WARN`s: Error executing DDL "alter table post drop foreign key if exists FK12..." via JDBC Statement
    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User user;

    public Post() {
    }

    public Post(Long id, String title, String body, Timestamp postDate, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.postDate = postDate;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}