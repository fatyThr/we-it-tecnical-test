package ma.mcma.vie.epargneUniteCompteAdministration.mapper;

import ma.mcma.vie.epargneUniteCompteAdministration.dto.response.EntrepriseResponse;
import ma.mcma.vie.epargneUniteCompteAdministration.model.Entreprise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepriseMapper {
    EntrepriseResponse entrepriseToEntrepriseResponse(Entreprise entreprise);
}
