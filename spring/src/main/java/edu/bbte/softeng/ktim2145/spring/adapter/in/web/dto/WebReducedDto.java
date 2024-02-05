package edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebReducedDto implements Serializable {
    Long id;
    String name;
    String brand;
    String expiration;
    Double price;
}
