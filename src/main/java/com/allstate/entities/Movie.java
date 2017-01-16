package com.allstate.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue

    private int id;

    @Version
    private int version;
    private String title;
    private boolean watched;
    private String rating;
    private Date released;
    private int length;
    private Date created;
    private Date updated;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isWatched() {
        return watched;
    }
    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getReleased() {
        return released;
    }
    public void setReleased(Date released) {
        this.released = released;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
