package co.simplon.ECF_Appli_Hopital.business.service;

import java.util.List;

import co.simplon.ECF_Appli_Hopital.business.dto.LitDTO;

public interface LitService {
    LitDTO afficherLitDisponible(LitDTO litDispo);

    List<LitDTO> afficherListeLitsDisponibles();

    LitDTO afficherLit(Long id);
}
