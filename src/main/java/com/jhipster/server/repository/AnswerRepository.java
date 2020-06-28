package com.jhipster.server.repository;

import com.jhipster.server.domain.Answer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Answer entity.
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "select distinct answer from Answer answer left join fetch answer.questions",
        countQuery = "select count(distinct answer) from Answer answer")
    Page<Answer> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct answer from Answer answer left join fetch answer.questions")
    List<Answer> findAllWithEagerRelationships();

    @Query("select answer from Answer answer left join fetch answer.questions where answer.id =:id")
    Optional<Answer> findOneWithEagerRelationships(@Param("id") Long id);
}
