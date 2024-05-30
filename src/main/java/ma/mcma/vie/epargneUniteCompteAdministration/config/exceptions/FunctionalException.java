package ma.mcma.vie.epargneUniteCompteAdministration.config.exceptions;

import lombok.Getter;

@Getter
public class FunctionalException extends RuntimeException{

    private final String code;
    private final Object[] params;

    public FunctionalException(String code, Object... params) {
        super();
        this.code = code;
        this.params = params;
    }
}
