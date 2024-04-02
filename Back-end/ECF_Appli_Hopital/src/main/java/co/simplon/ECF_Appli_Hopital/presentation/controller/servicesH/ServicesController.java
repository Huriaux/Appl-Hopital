package co.simplon.ECF_Appli_Hopital.presentation.controller.servicesH;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ECF_Appli_Hopital.business.dto.ServicesDTO;
import co.simplon.ECF_Appli_Hopital.business.service.ServicesService;

@RestController
public class ServicesController {
    private final ServicesService servicesServ;

    // constructeur
    public ServicesController(ServicesService servicesService) {
        this.servicesServ = servicesService;
    }

    @CrossOrigin
    @GetMapping("./services")
    public ServicesDTO afficherServiceParID(@PathVariable Long id) {
        // renvoie les détails d'un service existant par son identifiant
        return servicesServ.afficherService(id);
    }

}
