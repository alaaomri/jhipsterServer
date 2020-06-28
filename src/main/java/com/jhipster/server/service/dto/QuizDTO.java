package com.jhipster.server.service.dto;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.jhipster.server.domain.Quiz} entity.
 */
public class QuizDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String quizName;

    @NotNull
    private String code;

    @NotNull
    private LocalDate timeBegin;

    @NotNull
    private LocalDate timeEnd;

    @NotNull
    private Integer duration;


    private Long subjectId;

    private String subjectSubjectName;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(LocalDate timeBegin) {
        this.timeBegin = timeBegin;
    }

    public LocalDate getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDate timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectSubjectName() {
        return subjectSubjectName;
    }

    public void setSubjectSubjectName(String subjectSubjectName) {
        this.subjectSubjectName = subjectSubjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuizDTO)) {
            return false;
        }

        return id != null && id.equals(((QuizDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuizDTO{" +
            "id=" + getId() +
            ", quizName='" + getQuizName() + "'" +
            ", code='" + getCode() + "'" +
            ", timeBegin='" + getTimeBegin() + "'" +
            ", timeEnd='" + getTimeEnd() + "'" +
            ", duration=" + getDuration() +
            ", subjectId=" + getSubjectId() +
            ", subjectSubjectName='" + getSubjectSubjectName() + "'" +
            "}";
    }
}
