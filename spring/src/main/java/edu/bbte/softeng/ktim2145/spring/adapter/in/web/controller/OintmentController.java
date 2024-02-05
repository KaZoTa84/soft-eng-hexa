package edu.bbte.softeng.ktim2145.spring.adapter.in.web.controller;

import edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto.WebCreateDto;
import edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto.WebDetailedDto;
import edu.bbte.softeng.ktim2145.spring.adapter.in.web.dto.WebReducedDto;
import edu.bbte.softeng.ktim2145.spring.adapter.in.web.mapper.WebDtoMapper;
import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import edu.bbte.softeng.ktim2145.spring.application.port.in.PurchaseUseCase;
import edu.bbte.softeng.ktim2145.spring.util.annotation.WebAdapter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@WebAdapter
@RestController
@RequestMapping("/ointments")
public class OintmentController {
    @Autowired
    private PurchaseUseCase<Ointment> purchaseUseCase;
    @Autowired
    private WebDtoMapper webDtoMapper;

    @GetMapping
    public Collection<WebReducedDto> showTheProducts() {
        log.info("GET /ointments");

        Collection<Ointment> ointments = purchaseUseCase.getAllOintment();
        return webDtoMapper.modelsToWebReducedDtos(ointments);
    }

    @GetMapping("/{id}")
    public WebDetailedDto describeTheProduct(@PathVariable(name = "id") Long id) {
        log.info("GET /ointments/" + id);

        Ointment ointment = purchaseUseCase.describeTheOintment(id);
        return webDtoMapper.modelToWebDetailedDto(ointment);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WebDetailedDto newProductArrived(@Valid @RequestBody WebCreateDto webCreateDto) {
        log.info("POST /ointments");

        Ointment ointment = webDtoMapper.createDtoToModel(webCreateDto);
        ointment = purchaseUseCase.newOintment(ointment);
        return webDtoMapper.modelToWebDetailedDto(ointment);
    }

    @DeleteMapping("/purchase/{id}/{balance}")
    public WebDetailedDto purchase(@PathVariable(name = "id") Long id,
                                   @PathVariable(name = "balance") Double balance) {
        log.info("DELETE /ointments/" + id + "/" + balance);

        Ointment ointment = purchaseUseCase.purchaseOintment(id, balance);
        return webDtoMapper.modelToWebDetailedDto(ointment);
    }
}
