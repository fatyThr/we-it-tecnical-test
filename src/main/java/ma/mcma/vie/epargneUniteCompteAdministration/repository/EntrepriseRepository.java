package ma.mcma.vie.epargneUniteCompteAdministration.repository;

import ma.mcma.vie.epargneUniteCompteAdministration.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
}
