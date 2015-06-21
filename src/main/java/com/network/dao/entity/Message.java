package com.network.dao.entity;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @Column(name = "message_id")
    @GeneratedValue
    private long id;

    @Column(name = "date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime date;

    @ManyToOne(targetEntity = Contact.class)
    @JoinColumn(name="from_contact", referencedColumnName = "contact_id")
    private Contact fromContact;

    @Column(name = "to_contact")
    private Contact toContact;
    @Column(name = "content")
    private String content;

    public Message() {
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
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        return id == message.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", date=" + date +
                ", fromContact=" + fromContact.getFirstName() +
                ", toContact=" + toContact.getFirstName() +
                ", content='" + content + '\'' +
                '}';
    }
}
