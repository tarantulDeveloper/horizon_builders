package com.horizonbuilders.server.repository.projections;

import java.util.List;

public interface GlobalTypeListView {
    int getId();

    String getName();

    List<ShortSubTypeList> getSubTypeList();

    interface ShortSubTypeList {
        int getId();

        String getName();
        // TODO: implement
        // add descriptions to admin endpoints
    }
}
