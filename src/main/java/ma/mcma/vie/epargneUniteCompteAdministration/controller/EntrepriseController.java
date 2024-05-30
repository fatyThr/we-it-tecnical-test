package ma.mcma.vie.epargneUniteCompteAdministration.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.mcma.vie.epargneUniteCompteAdministration.dto.response.EntrepriseResponse;
import ma.mcma.vie.epargneUniteCompteAdministration.service.EntrepriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Client Api",
        description = "Rest API for CRUD operation")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/entreprise")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;
    @GetMapping("/slots")
    public ResponseEntity<List<EntrepriseResponse>>  getAllEntreprises() {
         return ResponseEntity.ok(entrepriseService.getAllEntreprises());
    }
}
