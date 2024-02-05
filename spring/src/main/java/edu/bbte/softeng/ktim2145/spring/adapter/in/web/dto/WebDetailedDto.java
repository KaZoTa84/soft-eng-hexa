package edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WebDetailedDto extends WebReducedDto {
    String description;
}
