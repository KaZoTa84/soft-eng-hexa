package edu.bbte.softeng.ktim2145.spring.util.config;

import edu.bbte.softeng.ktim2145.spring.application.domain.entity.Ointment;
import edu.bbte.softeng.ktim2145.spring.application.domain.service.PurchaseService;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.text.ParseException;

@Data
@Profile("in-memory")
@Configuration
public class InMemoryConfig {
    @Autowired
    private PurchaseService purchaseService;

    @PostConstruct
    public void postConstruct() throws ParseException {
        purchaseService.newOintment(new Ointment(
                "VapoRub",
                "Vicks",
                "2025-03-08",
                "Vicks VapoRub is a mentholated topical ointment,"
                        + " part of the Vicks brand of over-the-counter medications"
                        + " owned by the American consumer goods company Procter & Gamble."
                        + " VapoRub is intended for use on the chest, back and throat for cough"
                        + " suppression or on muscles and joints for minor aches and pains.",
                320.0
        ));

        purchaseService.newOintment(new Ointment(
                "VapoRub",
                "Vicks",
                "2023-12-31",
                "Vicks VapoRub is a mentholated topical ointment,"
                        + " part of the Vicks brand of over-the-counter medications"
                        + " owned by the American consumer goods"
                        + " company Procter & Gamble. VapoRub is intended for use on the chest,"
                        + " back and throat for cough suppression"
                        + " or on muscles and joints for minor aches and pains.",
                120.0
        ));

        purchaseService.newOintment(new Ointment(
                "Canespro",
                "Bayer",
                "2024-12-31",
                "Apply the cream to the affected area and massage it in gently."
                        + " You only need 1 application per day. Treatment should be continued"
                        + " for 3 weeks for Athlete’s Foot."
                        + " Please refer to Patient Information Leaflet for other fungal treatment duration.",
                420.0
        ));
    }
}
