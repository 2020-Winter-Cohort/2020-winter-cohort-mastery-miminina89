package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    public Collection<Post> PostComment;

    public Comment( String name, Post... postComment) {
        this.name = name;
        this.PostComment = List.of(postComment);
    }

    public Comment() {

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Post> getPostComment() {
        return PostComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        return name != null ? name.equals(comment.name) : comment.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
