package com.jhipster.server.repository;

import com.jhipster.server.domain.Quiz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Quiz entity.
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query(value = "select distinct quiz from Quiz quiz left join fetch quiz.questions left join fetch quiz.subjects",
        countQuery = "select count(distinct quiz) from Quiz quiz")
    Page<Quiz> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct quiz from Quiz quiz left join fetch quiz.questions left join fetch quiz.subjects")
    List<Quiz> findAllWithEagerRelationships();

    @Query("select quiz from Quiz quiz left join fetch quiz.questions left join fetch quiz.subjects where quiz.id =:id")
    Optional<Quiz> findOneWithEagerRelationships(@Param("id") Long id);
}
