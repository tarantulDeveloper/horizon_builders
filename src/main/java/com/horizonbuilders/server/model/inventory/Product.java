package com.horizonbuilders.server.model.inventory;

import com.horizonbuilders.server.model.DefaultModel;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Product extends DefaultModel {
    String name;
}
