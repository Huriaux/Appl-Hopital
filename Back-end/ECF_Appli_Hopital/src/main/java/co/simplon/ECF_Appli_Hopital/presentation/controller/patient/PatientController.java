package co.simplon.ECF_Appli_Hopital.presentation.controller.patient;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ECF_Appli_Hopital.business.dto.PatientDTO;
import co.simplon.ECF_Appli_Hopital.business.service.PatientService;

@RestController
public class PatientController {

    private final PatientService patientServ;

    public PatientController(PatientService patientServ) {
        this.patientServ = patientServ;
    }

    @PostMapping("/patient")
    public ResponseEntity<String> postMethodName(@RequestBody PatientDTO patientDTO) {
        // 'try' et 'catch' sont utilisés pour gérer les exceptions en cas d'erreurs lors de l'exécution
        try {
            // appel la méthode patientServ pour ajouter le patient
            patientServ.ajouterPatient(patientDTO);
            // HttpStatus.CREATED indique que le patient a bien été ajouté (HTTP 201)
            return new ResponseEntity<>("Patient ajouté", HttpStatus.CREATED);
        } catch (Exception except) {

            return new ResponseEntity<>("Échec de l'ajout du nouveau patient" + except.getMessage(),
                    // HttpStatus.INTERNAL_SERVER_ERROR indique qu'il y a eu une erreur lors de l'ajout du nouveau patient (HTTP 500)
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patient")
    public List<PatientDTO> listerPatients() {
        return patientServ.afficherListePatients();
    }
}
