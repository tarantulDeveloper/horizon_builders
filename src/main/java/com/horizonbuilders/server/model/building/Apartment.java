package com.horizonbuilders.server.model.building;

import com.horizonbuilders.server.model.DefaultModel;
import com.horizonbuilders.server.model.enums.EStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Apartment extends DefaultModel {
    int apartmentNumber;
    int floorNumber;
    int roomNumber;
    double area;
    double pricePerArea;
    double price;
    @Enumerated(EnumType.STRING)
    EStatus status;
    String imgUrl;
    @ManyToOne(cascade = CascadeType.PERSIST)
    Building building;
}
