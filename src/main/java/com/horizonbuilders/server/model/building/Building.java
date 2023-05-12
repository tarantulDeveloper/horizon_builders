package com.horizonbuilders.server.model.building;

import com.horizonbuilders.server.model.DefaultModel;
import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.model.enums.EState;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.*;

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
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "users_id")
    User employee;
}
