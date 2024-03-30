package co.simplon.ECF_Appli_Hopital.presentation.controller.patient;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ECF_Appli_Hopital.business.dto.PatientDTO;
import co.simplon.ECF_Appli_Hopital.business.service.PatientService;

@RestController
public class PatientController {

    private final PatientService patientServ;

    public PatientController(PatientService patientServ) {
        this.patientServ = patientServ;
    }

    @GetMapping("/patient")
    public List<PatientDTO> listerPatients() {
        return patientServ.afficherListePatients();
    }
}
