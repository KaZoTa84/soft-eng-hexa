package edu.bbte.softeng.ktim2145.spring.adapter.out.persistence.dto;

import edu.bbte.softeng.ktim2145.spring.application.domain.entity.BaseEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersistenceDto {
    Long id;
    String name;
    String brand;
    String expiration;
    Double price;
    String description;
}
