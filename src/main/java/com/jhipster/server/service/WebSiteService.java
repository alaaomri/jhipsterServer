package com.jhipster.server.service;

import com.jhipster.server.domain.WebSite;
import com.jhipster.server.repository.WebSiteRepository;
import com.jhipster.server.service.dto.WebSiteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class WebSiteService {
    private final Logger log = LoggerFactory.getLogger(WebSiteService.class);
    private final WebSiteRepository webSiteRepository;

    public WebSiteService(WebSiteRepository webSiteRepository) {
        this.webSiteRepository = webSiteRepository;
    }

    public WebSite createWebsite(WebSiteDTO webSiteDTO) {
        WebSite newWebSite = new WebSite();
        newWebSite.setName(webSiteDTO.getName());
        newWebSite.setDescription(webSiteDTO.getDescription());
        newWebSite.setUrl(webSiteDTO.getUrl());
        newWebSite.setUerAgent(webSiteDTO.getUerAgent());
        newWebSite.setHoldingTag(webSiteDTO.getHoldingTag());
        webSiteRepository.save(newWebSite);
        log.debug("Created Information for User: {}", newWebSite);
        return newWebSite;
    }

    @Transactional(readOnly = true)
    public Page<WebSiteDTO> getAllWebSites(Pageable pageable) {
        return webSiteRepository.findAll(pageable).map(WebSiteDTO::new);
    }
}
