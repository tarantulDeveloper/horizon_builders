package com.horizonbuilders.server.repository.projections;

import com.horizonbuilders.server.model.building.Building;
import com.horizonbuilders.server.model.enums.EState;
import com.horizonbuilders.server.model.enums.EStatus;

public interface ApartmentListView {
    int getId();
    int getRoomNumber();
    double getArea();
    double getPricePerArea();
    double getPrice();
    EStatus getStatus();
    String getImgUrl();

    BuildingProjection getBuilding();

    interface BuildingProjection {
        String getName();
        String getAddress();
    }
}
