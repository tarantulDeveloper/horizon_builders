package com.horizonbuilders.server.model.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.horizonbuilders.server.model.DefaultModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends DefaultModel {
    String name;
    int quantity;
    String imgUrl;
    double price;
    @JsonIgnore
    @ManyToOne
    SubType subType;

}
