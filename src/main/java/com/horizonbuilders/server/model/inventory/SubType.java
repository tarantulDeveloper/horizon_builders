package com.horizonbuilders.server.model.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.horizonbuilders.server.model.DefaultModel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class SubType extends DefaultModel {
    String name;
    @JsonIgnore
    @ManyToOne
    GlobalType globalType;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "sub_type_id")
    List<Product> productList = new ArrayList<>();
}
