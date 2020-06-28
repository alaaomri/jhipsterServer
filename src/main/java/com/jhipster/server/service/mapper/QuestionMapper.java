package com.jhipster.server.service.mapper;


import com.jhipster.server.domain.*;
import com.jhipster.server.service.dto.QuestionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Question} and its DTO {@link QuestionDTO}.
 */
@Mapper(componentModel = "spring", uses = {QuizMapper.class})
public interface QuestionMapper extends EntityMapper<QuestionDTO, Question> {


    @Mapping(target = "removeQuiz", ignore = true)
    @Mapping(target = "answers", ignore = true)
    @Mapping(target = "removeAnswer", ignore = true)
    Question toEntity(QuestionDTO questionDTO);

    default Question fromId(Long id) {
        if (id == null) {
            return null;
        }
        Question question = new Question();
        question.setId(id);
        return question;
    }
}
