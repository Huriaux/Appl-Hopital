package co.simplon.ECF_Appli_Hopital.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.ECF_Appli_Hopital.business.dto.PatientDTO;

@Service
public class PatientServiceImpl implements PatientService {

    // on simule une liste de patients
    List<PatientDTO> patients = new ArrayList<>();

    @Override
    public PatientDTO ajouterPatient(PatientDTO patient) {
        patients.add(patient); // On ajoute un patient à la liste
        return patient; // On retourne le patient ajouté
    }

    @Override
    public List<PatientDTO> afficherListePatients() {
        return patients;
    }

    @Override
    public PatientDTO afficherPatient(Long id) {
        for (PatientDTO patient : patients) { // on déclare un boucle 'for'
            if (Long.valueOf(patient.getIdPatient()).equals(id)) { // vérifie si l'identifiant du patient existe
                return patient; // retourne l'information du patient modifié
            }
        }
        return null; // retourne 'null' si le patient n'existe pas
    }

    @Override
    public PatientDTO modifierPatient(PatientDTO nouvelleInfosPatient, Long id) {
        for (int i = 0; i < patients.size(); i++) { // déclare une boucle 'for' qui parcours la liste de patients
            PatientDTO pdto = patients.get(i);

            if (Long.valueOf(pdto.getIdPatient()).equals(id)) { // vérifie si l'id du patient courant correspond à l'id du patient passé en paramètre
                // si oui, les informations suivantes du patient sont mise à jour
                pdto.setNom(nouvelleInfosPatient.getNom());
                pdto.setPrenom(nouvelleInfosPatient.getPrenom());
                pdto.setDateNaissance(nouvelleInfosPatient.getDateNaissance());
                pdto.setNumSecu(nouvelleInfosPatient.getNumSecu());
                pdto.setAdresse(nouvelleInfosPatient.getAdresse());
                pdto.setCp(nouvelleInfosPatient.getCp());
                pdto.setCommune(nouvelleInfosPatient.getCommune());
                pdto.setTelephone(nouvelleInfosPatient.getTelephone());
                pdto.setEmail(nouvelleInfosPatient.getEmail());
                return pdto;
            }
        }
        // si pas de correspondance avec l'id patient, retourne 'null'
        return null;
    }
}
