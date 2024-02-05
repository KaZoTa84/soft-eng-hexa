package edu.bbte.softeng.ktim2145.spring.application.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ointments")
public class Ointment extends BaseEntity {
    @Column(name = "`name`", nullable = false)
    String name;
    @Column(nullable = false)
    String brand;
    @Column(nullable = false)
    String expiration;
    @Column(name = "`description`" ,nullable = false)
    String description;
    @Column(nullable = false)
    Double price;
}
