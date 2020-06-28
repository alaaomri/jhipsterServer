package com.jhipster.server.service.mapper;


import com.jhipster.server.domain.*;
import com.jhipster.server.service.dto.QuizDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Quiz} and its DTO {@link QuizDTO}.
 */
@Mapper(componentModel = "spring", uses = {SubjectMapper.class})
public interface QuizMapper extends EntityMapper<QuizDTO, Quiz> {

    @Mapping(source = "subject.id", target = "subjectId")
    @Mapping(source = "subject.subjectName", target = "subjectSubjectName")
    QuizDTO toDto(Quiz quiz);

    @Mapping(source = "subjectId", target = "subject")
    @Mapping(target = "customers", ignore = true)
    @Mapping(target = "removeCustomer", ignore = true)
    @Mapping(target = "questions", ignore = true)
    @Mapping(target = "removeQuestion", ignore = true)
    Quiz toEntity(QuizDTO quizDTO);

    default Quiz fromId(Long id) {
        if (id == null) {
            return null;
        }
        Quiz quiz = new Quiz();
        quiz.setId(id);
        return quiz;
    }
}
