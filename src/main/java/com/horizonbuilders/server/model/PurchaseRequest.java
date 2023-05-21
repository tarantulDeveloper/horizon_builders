package com.horizonbuilders.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseRequest extends DefaultModel{
    String customerName;
    String phoneNumber;
    @Column(columnDefinition = "TEXT")
    String message;
}
