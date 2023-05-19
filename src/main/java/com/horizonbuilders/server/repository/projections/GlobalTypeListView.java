package com.horizonbuilders.server.repository.projections;

import java.util.List;

public interface GlobalTypeListView {
    int getId();
    String getName();
    List<ShortSubTypeList> getSubTypeList();
}
