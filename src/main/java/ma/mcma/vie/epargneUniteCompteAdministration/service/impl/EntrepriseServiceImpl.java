package ma.mcma.vie.epargneUniteCompteAdministration.service.impl;

import lombok.RequiredArgsConstructor;
import ma.mcma.vie.epargneUniteCompteAdministration.dto.response.EntrepriseResponse;
import ma.mcma.vie.epargneUniteCompteAdministration.mapper.EntrepriseMapper;
import ma.mcma.vie.epargneUniteCompteAdministration.repository.EntrepriseRepository;
import ma.mcma.vie.epargneUniteCompteAdministration.service.EntrepriseService;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class EntrepriseServiceImpl implements EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;
    private final EntrepriseMapper entrepriseMapper;

    @Override
    public List<EntrepriseResponse> getAllEntreprises() {

        List<EntrepriseResponse>  entrepriseResponses=entrepriseRepository.findAll().stream().map(entrepriseMapper::entrepriseToEntrepriseResponse).toList();
        //TODO Just for test
        entrepriseResponses.add(new EntrepriseResponse(1L,"MCMA","MCMA"));
        entrepriseResponses.add(new EntrepriseResponse(1L,"MAC","Mutuelle Attaamine Achaaabi"));
        return entrepriseResponses;
    }
}
