package com.jhipster.server.service.mapper;


import com.jhipster.server.domain.*;
import com.jhipster.server.service.dto.AnswerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Answer} and its DTO {@link AnswerDTO}.
 */
@Mapper(componentModel = "spring", uses = {QuestionMapper.class})
public interface AnswerMapper extends EntityMapper<AnswerDTO, Answer> {


    @Mapping(target = "removeQuestion", ignore = true)

    default Answer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Answer answer = new Answer();
        answer.setId(id);
        return answer;
    }
}
