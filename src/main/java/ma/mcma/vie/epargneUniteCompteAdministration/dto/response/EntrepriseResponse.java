package ma.mcma.vie.epargneUniteCompteAdministration.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntrepriseResponse {
    private Long id;

    private String code;

    private String raisonSociale;
}
