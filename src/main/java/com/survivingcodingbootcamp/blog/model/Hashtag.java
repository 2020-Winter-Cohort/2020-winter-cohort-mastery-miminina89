package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    String text;
    @ManyToMany
    private Collection<Post>posts;

    public Hashtag( String text,Post...posts) {

        this.text = text;
        this.posts= List.of(posts);
    }

    public Hashtag() {

    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashtag hashtag = (Hashtag) o;

        if (id != hashtag.id) return false;
        return text != null ? text.equals(hashtag.text) : hashtag.text == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
