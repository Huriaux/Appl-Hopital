package co.simplon.ECF_Appli_Hopital.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.ECF_Appli_Hopital.business.convert.PatientConvert;
import co.simplon.ECF_Appli_Hopital.business.dto.PatientDTO;
import co.simplon.ECF_Appli_Hopital.persistence.entity.Patient;
import co.simplon.ECF_Appli_Hopital.persistence.repository.PatientQuery;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientQuery patientRepository;

    @Autowired
    public PatientServiceImpl(PatientQuery patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    // permet d'ajouter un nouveau patient dans la BDD
    public PatientDTO ajouterPatient(PatientDTO patientDto) {
        // déclaration variable 'entityPatient' pour convertir le patient (à ajouter) de DTO à Entity
        Patient entityPatient = PatientConvert.getInstance().convertToEntity(patientDto);
        // déclation variable 'savePatient' pour sauvegarder le nouveau patient (Entity)
        Patient savePatient = patientRepository.save(entityPatient);
        // et on renvoi le patient sauvegardé converti en DTO
        return PatientConvert.getInstance().convertToDto(savePatient);
    }

    @Override
    // permet d'afficher tous les patient existant de la BDD
    public List<PatientDTO> afficherListePatients() {
        // déclaration variable 'listePatients' pour récupèrer tous les patients de la BDD sous forme de liste
        List<Patient> listePatient = patientRepository.findAll();
        // ici on retourne la liste des entités Patient convertie en DTO
        return PatientConvert.getInstance().convertListEntityToListDTO(listePatient);
    }

    @Override
    public PatientDTO afficherPatient(Long id) {
        // déclaration variable 'patientOptional' pour récupérer un patient précis par son id 
        // 'Optional' permet de récupérer une valeur qui peut être présente ou absente de la BDD avec la méthode 'findById()'
        Optional<Patient> patientOptional = patientRepository.findById(id);
        // condition : si le patient recherché par son id est présent dans la BDD
        if (patientOptional.isPresent()) {
            // on le récupère dans la variable déclarée 'patient'
            Patient patientTrouve = patientOptional.get();
            // et on le retourne converti en DTO
            return PatientConvert.getInstance().convertToDto(patientTrouve);
        } else { // dans le cas ou aucun id ne match avec le patient que l'on recherche...
            // ...on retourne 'null'
            return null;
        }
    }

    @Override
    public PatientDTO modifierPatient(PatientDTO patient, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierPatient'");
    }

}
