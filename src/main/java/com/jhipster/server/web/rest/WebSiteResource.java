package com.jhipster.server.web.rest;

import com.jhipster.server.security.AuthoritiesConstants;
import com.jhipster.server.service.WebSiteService;
import com.jhipster.server.service.dto.WebSiteDTO;
import com.jhipster.server.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class WebSiteResource {

    private static final String ENTITY_NAME = "webSite";
    private final Logger log = LoggerFactory.getLogger(WebSiteResource.class);
    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    private WebSiteService webSiteService;

    @PostMapping("/websites")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<WebSiteDTO> createWebSite(@Valid @RequestBody WebSiteDTO webSiteDTO) throws URISyntaxException {
        log.debug("REST request to save a WebSite : {}", webSiteDTO);
        if (webSiteDTO.getId() != null) {
            throw new BadRequestAlertException("A new website cannot already have an ID", ENTITY_NAME, "idexists");
        } else {
            WebSiteDTO result = webSiteService.createWebsite(webSiteDTO);
            return ResponseEntity.created(new URI("/api/website/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
        }
    }

    @PutMapping("/websites")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<WebSiteDTO> updateWebSite(@Valid @RequestBody WebSiteDTO webSiteDTO) throws URISyntaxException {
        log.debug("REST request to update WebSite : {}", webSiteDTO);
        if (webSiteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        } else {
            WebSiteDTO result = webSiteService.createWebsite(webSiteDTO);
            return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
        }
    }

    @GetMapping("/websites/{id}")
    public ResponseEntity<WebSiteDTO> getWebSiteById(@PathVariable Long id) {
        log.debug("REST request to get WebSite : {}", id);
        Optional<WebSiteDTO> webSiteDTO = webSiteService.findWebSiteById(id);
        return ResponseUtil.wrapOrNotFound(webSiteDTO);
    }

    @GetMapping("/websites")
    public ResponseEntity<List<WebSiteDTO>> getAllWebSites(Pageable pageable) {
        final Page<WebSiteDTO> page = webSiteService.getAllWebSites(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @DeleteMapping("/websites/{id}")
    public ResponseEntity<Void> deleteWebSite(@PathVariable Long id) {
        log.debug("REST request to delete WebSite : {}", id);
        webSiteService.deleteWebSite(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
