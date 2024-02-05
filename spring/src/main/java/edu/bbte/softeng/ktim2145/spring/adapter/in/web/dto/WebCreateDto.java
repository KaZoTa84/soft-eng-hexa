package edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebCreateDto implements Serializable {
    @NotEmpty
    @Size(max = 256)
    String name;

    @NotEmpty
    @Size(max = 256)
    String brand;

    @NotEmpty
    @Size(max = 256)
    String expiration;

    @NotNull
    @Positive
    Double price;

    @NotEmpty
    @Size(max = 512)
    String description;
}
