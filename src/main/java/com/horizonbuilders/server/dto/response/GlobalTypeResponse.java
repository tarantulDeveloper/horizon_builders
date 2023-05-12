package com.horizonbuilders.server.dto.response;

import java.util.List;

public record GlobalTypeResponse(
        int id,
        String name,
        List<SubTypeName> subTypeList
) {
    public record SubTypeName(
            int id,
            String name
    ) {

    }
}
