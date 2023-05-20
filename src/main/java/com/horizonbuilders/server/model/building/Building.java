package com.horizonbuilders.server.model.building;

import com.horizonbuilders.server.model.DefaultModel;
import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.model.enums.EState;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Building extends DefaultModel {
    String name;
    int numberOfFloors;
    String city;
    String address;
    String imgUrl;
    @Enumerated(EnumType.STRING)
    EState state;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "building_id")
    List<Apartment> apartmentList = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    List<User> employeeList = new ArrayList<>();
}
