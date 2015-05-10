package com.network.model;

import com.network.dao.entity.Contact;
import org.joda.time.LocalDateTime;

import java.io.Serializable;

public class MessageDTO implements Serializable {

    private long id;

    private LocalDateTime date;
    private Contact fromContact;
    private Contact toContact;
    private String content;

    public MessageDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Contact getFromContact() {
        return fromContact;
    }

    public void setFromContact(Contact fromContact) {
        this.fromContact = fromContact;
    }

    public Contact getToContact() {
        return toContact;
    }

    public void setToContact(Contact toContact) {
        this.toContact = toContact;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageDTO)) return false;

        MessageDTO message = (MessageDTO) o;

        return id == message.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
