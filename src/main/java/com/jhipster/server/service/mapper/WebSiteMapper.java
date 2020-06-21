package com.jhipster.server.service.mapper;

import com.jhipster.server.domain.WebSite;
import com.jhipster.server.service.dto.WebSiteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface WebSiteMapper extends EntityMapper<WebSiteDTO, WebSite> {

    default WebSite fromId(Long id) {
        if (id == null)
            return null;
        WebSite webSite = new WebSite();
        webSite.setId(id);
        return webSite;
    }
}
