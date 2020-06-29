package com.jhipster.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Quiz.
 */
@Entity
@Table(name = "quiz")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Quiz extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "quiz_name", nullable = false)
    private String quizName;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "time_begin", nullable = false)
    private Instant timeBegin;

    @NotNull
    @Column(name = "time_end", nullable = false)
    private Instant timeEnd;

    @NotNull
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "quiz_question",
               joinColumns = @JoinColumn(name = "quiz_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"))
    private Set<Question> questions = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "quiz_subject",
               joinColumns = @JoinColumn(name = "quiz_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
    private Set<Subject> subjects = new HashSet<>();

    @ManyToMany(mappedBy = "quizzes")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<Customer> customers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public Quiz quizName(String quizName) {
        this.quizName = quizName;
        return this;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getCode() {
        return code;
    }

    public Quiz code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instant getTimeBegin() {
        return timeBegin;
    }

    public Quiz timeBegin(Instant timeBegin) {
        this.timeBegin = timeBegin;
        return this;
    }

    public void setTimeBegin(Instant timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Instant getTimeEnd() {
        return timeEnd;
    }

    public Quiz timeEnd(Instant timeEnd) {
        this.timeEnd = timeEnd;
        return this;
    }

    public void setTimeEnd(Instant timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getDuration() {
        return duration;
    }

    public Quiz duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Quiz questions(Set<Question> questions) {
        this.questions = questions;
        return this;
    }

    public Quiz addQuestion(Question question) {
        this.questions.add(question);
        question.getQuizzes().add(this);
        return this;
    }

    public Quiz removeQuestion(Question question) {
        this.questions.remove(question);
        question.getQuizzes().remove(this);
        return this;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public Quiz subjects(Set<Subject> subjects) {
        this.subjects = subjects;
        return this;
    }

    public Quiz addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.getQuizzes().add(this);
        return this;
    }

    public Quiz removeSubject(Subject subject) {
        this.subjects.remove(subject);
        subject.getQuizzes().remove(this);
        return this;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Quiz customers(Set<Customer> customers) {
        this.customers = customers;
        return this;
    }

    public Quiz addCustomer(Customer customer) {
        this.customers.add(customer);
        customer.getQuizzes().add(this);
        return this;
    }

    public Quiz removeCustomer(Customer customer) {
        this.customers.remove(customer);
        customer.getQuizzes().remove(this);
        return this;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Quiz)) {
            return false;
        }
        return id != null && id.equals(((Quiz) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Quiz{" +
            "id=" + getId() +
            ", quizName='" + getQuizName() + "'" +
            ", code='" + getCode() + "'" +
            ", timeBegin='" + getTimeBegin() + "'" +
            ", timeEnd='" + getTimeEnd() + "'" +
            ", duration=" + getDuration() +
            "}";
    }
}
