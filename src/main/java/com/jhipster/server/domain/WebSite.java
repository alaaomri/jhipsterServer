package com.jhipster.server.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "website")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WebSite extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "url")
    private String url;

    @NotNull
    @Column(name = "useragent")
    @ColumnDefault("Mozilla/17.0")
    private String uerAgent;

    @NotNull
    @Column(name = "holdingtag")
    private String holdingTag;

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
}
