package com.jhipster.server.service.dto;

import com.jhipster.server.domain.WebSite;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

public class WebSiteDTO {

    private Long id;

    private String name;

    private String description;

    @NotBlank
    private String url;

    @NotBlank
    private String uerAgent;

    @NotBlank
    private String holdingTag;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    public WebSiteDTO() {
    }

    public WebSiteDTO(WebSite webSite) {
        this.id = webSite.getId();
        this.name = webSite.getName();
        this.description = webSite.getDescription();
        this.url = webSite.getUrl();
        this.uerAgent = webSite.getUerAgent();
        this.holdingTag = webSite.getHoldingTag();
        this.createdBy = webSite.getCreatedBy();
        this.createdDate = webSite.getCreatedDate();
        this.lastModifiedBy = webSite.getLastModifiedBy();
        this.lastModifiedDate = webSite.getLastModifiedDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUerAgent() {
        return uerAgent;
    }

    public void setUerAgent(String uerAgent) {
        this.uerAgent = uerAgent;
    }

    public String getHoldingTag() {
        return holdingTag;
    }

    public void setHoldingTag(String holdingTag) {
        this.holdingTag = holdingTag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
