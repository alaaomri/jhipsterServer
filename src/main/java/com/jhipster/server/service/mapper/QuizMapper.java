package com.jhipster.server.service.mapper;


import com.jhipster.server.domain.*;
import com.jhipster.server.service.dto.QuizDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Quiz} and its DTO {@link QuizDTO}.
 */
@Mapper(componentModel = "spring", uses = {QuestionMapper.class, SubjectMapper.class})
public interface QuizMapper extends EntityMapper<QuizDTO, Quiz> {


    @Mapping(target = "removeQuestion", ignore = true)
    @Mapping(target = "removeSubject", ignore = true)
    @Mapping(target = "customers", ignore = true)
    @Mapping(target = "removeCustomer", ignore = true)
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
