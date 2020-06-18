package com.jhipster.server.web.rest;

import com.jhipster.server.domain.WebSite;
import com.jhipster.server.security.AuthoritiesConstants;
import com.jhipster.server.service.WebSiteService;
import com.jhipster.server.service.dto.WebSiteDTO;
import com.jhipster.server.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class WebSiteResource {

    private final Logger log = LoggerFactory.getLogger(WebSiteResource.class);

    private static final String ENTITY_NAME = "webSite";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WebSiteService webSiteService;

    public WebSiteResource(WebSiteService webSiteService) {
        this.webSiteService = webSiteService;
    }

    @PostMapping("/websites")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<WebSite> createWebSite(@Valid @RequestBody WebSiteDTO webSiteDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", webSiteDTO);
        if (webSiteDTO.getId() != null) {
            throw new BadRequestAlertException("A new website cannot already have an ID", ENTITY_NAME, "idexists");
        } else {
            WebSite webSite = webSiteService.createWebsite(webSiteDTO);
            return ResponseEntity.created(new URI("/api/bank-accounts/" + webSite.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, webSite.getId().toString()))
                .body(webSite);
        }
    }

    @GetMapping("/websites")
    public ResponseEntity<List<WebSiteDTO>> getAllWebSites(Pageable pageable) {
        final Page<WebSiteDTO> page = webSiteService.getAllWebSites(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
