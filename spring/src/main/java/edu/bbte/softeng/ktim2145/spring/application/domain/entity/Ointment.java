package edu.bbte.softeng.ktim2145.spring.application.domain.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Ointment extends BaseEntity {
    String name;
    String brand;
    String expiration;
    String description;
    Double price;
}
