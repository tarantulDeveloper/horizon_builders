package com.horizonbuilders.server.repository.projections;

import java.util.List;

public interface GlobalTypeListView {
    int getId();

    String getName();

    List<ShortSubTypeList> getSubTypeList();

    interface ShortSubTypeList {
        int getId();

        String getName();
        // TODO: get all subtype remove
        // TODO: get global type by id remove
        // TODO: implement
        // TODO: add bidirectional association
    }
}
