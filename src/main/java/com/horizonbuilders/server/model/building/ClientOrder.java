package com.horizonbuilders.server.model.building;

import com.horizonbuilders.server.model.DefaultModel;
import com.horizonbuilders.server.model.enums.EPay;
import com.horizonbuilders.server.model.enums.EStatusOrder;
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
public class ClientOrder extends DefaultModel {
    String name;
    String surname;
    String phoneNumber;
    @Enumerated(EnumType.STRING)
    EPay payWay;
    @Enumerated(EnumType.STRING)
    EStatusOrder status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id")
    Apartment apartment;
}
