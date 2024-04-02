package co.simplon.ECF_Appli_Hopital.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.ECF_Appli_Hopital.business.convert.ChambreConvert;
import co.simplon.ECF_Appli_Hopital.business.dto.ChambreDTO;
import co.simplon.ECF_Appli_Hopital.business.dto.LitDTO;
import co.simplon.ECF_Appli_Hopital.persistence.entity.Chambre;
import co.simplon.ECF_Appli_Hopital.persistence.repository.ChambreQuery;

@Service
public class ChambreServiceImpl implements ChambreService {

    private ChambreQuery chambreRepository;
    private LitService litService;

    // constructeur
    public ChambreServiceImpl(ChambreQuery chambreRepository, LitService litService) {
        this.chambreRepository = chambreRepository;
        this.litService = litService;

    }

    @Override
    public List<ChambreDTO> afficherListeChambresDispos() {
        // Récupérer la liste des lits à partir du LitService
        List<LitDTO> litsDispos = litService.afficherListeLits();

        List<ChambreDTO> chambresDispos = new ArrayList<>();
        for (LitDTO lit : litsDispos) {
            ChambreDTO chambre = chambreRepository.findByLitId(lit.getIdLit());
            if (chambre != null && !chambresDispos.contains(chambre)) {
                chambresDispos.add(chambre);
            }
        }
        return chambresDispos;
    }

    @Override
    public ChambreDTO afficherChambre(Long id) {
        @SuppressWarnings("null")
        Optional<Chambre> chambreOptional = chambreRepository.findById(id);
        // condition : vérifie si la chambre rechercheé est présente dans la BDD
        if (chambreOptional.isPresent()) {
            Chambre chambreTrouve = chambreOptional.get();
            return ChambreConvert.getInstance().convertChambreToDTO(chambreTrouve);
        } else {
            return null;
        }
    }

}
