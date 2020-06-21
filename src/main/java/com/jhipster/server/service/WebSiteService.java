package com.jhipster.server.service;

import com.jhipster.server.domain.WebSite;
import com.jhipster.server.repository.WebSiteRepository;
import com.jhipster.server.service.dto.WebSiteDTO;
import com.jhipster.server.service.mapper.WebSiteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class WebSiteService {
    private final Logger log = LoggerFactory.getLogger(WebSiteService.class);

    @Autowired
    private WebSiteRepository webSiteRepository;

    @Autowired
    private WebSiteMapper webSiteMapper;

    public void deleteWebSite(Long id) {
        webSiteRepository.findById(id).ifPresent(webSite -> {
            webSiteRepository.delete(webSite);
            log.debug("Deleted WebSite: {}", webSite);
        });
    }

    public Optional<WebSiteDTO> updateWebSite(WebSiteDTO webSiteDTO) {
        return Optional.of(webSiteRepository
            .findById(webSiteDTO.getId()))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(webSite -> {
                webSite = webSiteMapper.toEntity(webSiteDTO);
                log.debug("Changed Information for WebSite: {}", webSite);
                return webSite;
            })
            .map(WebSiteDTO::new);
    }

    public Optional<WebSiteDTO> findWebSiteById(final Long id) {
        Optional<WebSiteDTO> webSiteDTO = webSiteRepository.findById(id).map(webSiteMapper::toDto);
        return webSiteDTO;
    }

    public WebSiteDTO createWebsite(WebSiteDTO webSiteDTO) {
        WebSite webSite = webSiteMapper.toEntity(webSiteDTO);
        webSite = webSiteRepository.save(webSite);
        WebSiteDTO result = webSiteMapper.toDto(webSite);
        log.debug("Created Information for WebSite: {}", result);
        return result;
    }

    @Transactional(readOnly = true)
    public Page<WebSiteDTO> getAllWebSites(Pageable pageable) {
        return webSiteRepository.findAll(pageable).map(WebSiteDTO::new);
    }
}
