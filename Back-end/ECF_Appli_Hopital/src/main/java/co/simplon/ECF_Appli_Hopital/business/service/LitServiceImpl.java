package co.simplon.ECF_Appli_Hopital.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.ECF_Appli_Hopital.business.convert.LitConvert;
import co.simplon.ECF_Appli_Hopital.business.dto.LitDTO;
import co.simplon.ECF_Appli_Hopital.persistence.entity.Lit;
import co.simplon.ECF_Appli_Hopital.persistence.repository.LitQuery;

@Service
public class LitServiceImpl implements LitService {
    // interaction avec la BDD pour l'entité Lit
    private LitQuery litRepository;

    // constructeur
    public LitServiceImpl(LitQuery litRepository) {
        this.litRepository = litRepository;
    }

    @Override
    // permet d'afficher tous les lits existant de la BDD
    public List<LitDTO> afficherListeLits() {
        List<Lit> listeLit = litRepository.findAll();
        return LitConvert.getInstance().convertListeLitToDTO(listeLit);
    }

    @Override
    public LitDTO afficherLit(Long id) {
        Optional<Lit> litOptional = litRepository.findById(id);
        // condition : vérifie si le lit recherché par son id est présent dans la BDD sinon retournera 'null'
        if (litOptional.isPresent()) {
            Lit litTrouve = litOptional.get();
            return LitConvert.getInstance().convertLitToDTO(litTrouve);
        } else {
            return null;
        }
    }
}
