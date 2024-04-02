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

    // TODO attention 'litService' --> vu avec Yassen
    private LitService litService; // Injection du service LitService

    // constructeur
    public ChambreServiceImpl(ChambreQuery chambreRepository, LitService litService) {
        this.chambreRepository = chambreRepository;
        this.litService = litService; // Initialisation du service LitService

    }

    @Override
    public List<ChambreDTO> afficherListeChambresDispos() {
        // Récupérer la liste des lits à partir du LitService
        List<LitDTO> lits = litService.afficherListeLits();

        List<LitDTO> litsDispos = new ArrayList<>();
        for (LitDTO lit : lits) {
            if (lit.getDispoLit()) {
                litsDispos.add(lit);
            }
        }

        // création d'une chambre correspondante pour chaque lit dispo
        List<ChambreDTO> chambresDispos = new ArrayList<>();
        for (LitDTO lit : litsDispos) {
            ChambreDTO chambre = new ChambreDTO();
            chambre.setIdChambre(lit.getIdLit()); // utiliser ID du lit comme Id de chambre
            chambre.setNumChambre("chambre " + lit.getIdLit()); // numéro de chambre fictif
            chambre.setIdLit(lit.getIdLit()); // lie la chambre au lit dispo
            chambresDispos.add(chambre);
        }
        return chambresDispos;
    }

    @Override
    public ChambreDTO afficherChambre(Long id) {
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
