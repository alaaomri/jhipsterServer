package com.jhipster.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Notification.
 */
@Entity
@Table(name = "notification")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Notification extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "details")
    private String details;

    @NotNull
    @Column(name = "sent_date", nullable = false)
    private Instant sentDate;

    @Column(name = "is_opened")
    private Boolean isOpened;

    @ManyToOne
    @JsonIgnoreProperties(value = "notifications", allowSetters = true)
    private Quiz quiz;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "notifications", allowSetters = true)
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public Notification date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public Notification details(String details) {
        this.details = details;
        return this;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Instant getSentDate() {
        return sentDate;
    }

    public Notification sentDate(Instant sentDate) {
        this.sentDate = sentDate;
        return this;
    }

    public void setSentDate(Instant sentDate) {
        this.sentDate = sentDate;
    }

    public Boolean isIsOpened() {
        return isOpened;
    }

    public Notification isOpened(Boolean isOpened) {
        this.isOpened = isOpened;
        return this;
    }

    public void setIsOpened(Boolean isOpened) {
        this.isOpened = isOpened;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public Notification quiz(Quiz quiz) {
        this.quiz = quiz;
        return this;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public Notification user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Notification)) {
            return false;
        }
        return id != null && id.equals(((Notification) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Notification{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", details='" + getDetails() + "'" +
            ", sentDate='" + getSentDate() + "'" +
            ", isOpened='" + isIsOpened() + "'" +
            "}";
    }
}
