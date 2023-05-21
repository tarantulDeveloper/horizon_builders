package com.horizonbuilders.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News extends DefaultModel{
    String imgUrl;
    String header;
    @Column(columnDefinition = "TEXT")
    String text;
    @CreationTimestamp
    LocalDate date;
}
