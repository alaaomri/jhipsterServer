package com.jhipster.server.repository;

import com.jhipster.server.domain.WebSite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSiteRepository extends JpaRepository<WebSite, Long> {

    Page<WebSite> findAll(Pageable pageable);

}
