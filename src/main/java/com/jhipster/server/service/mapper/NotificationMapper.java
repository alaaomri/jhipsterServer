package com.jhipster.server.service.mapper;


import com.jhipster.server.domain.*;
import com.jhipster.server.service.dto.NotificationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Notification} and its DTO {@link NotificationDTO}.
 */
@Mapper(componentModel = "spring", uses = {QuizMapper.class, UserMapper.class})
public interface NotificationMapper extends EntityMapper<NotificationDTO, Notification> {

    @Mapping(source = "quiz.id", target = "quizId")
    @Mapping(source = "quiz.code", target = "quizCode")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")
    NotificationDTO toDto(Notification notification);

    @Mapping(source = "quizId", target = "quiz")
    @Mapping(source = "userId", target = "user")
    Notification toEntity(NotificationDTO notificationDTO);

    default Notification fromId(Long id) {
        if (id == null) {
            return null;
        }
        Notification notification = new Notification();
        notification.setId(id);
        return notification;
    }
}
