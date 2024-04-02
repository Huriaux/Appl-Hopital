package co.simplon.ECF_Appli_Hopital.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")

public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_service")
    private long idService;

    @Column(name = "nom_service")
    private String nomService;

    @OneToMany
    @JoinColumn(name = "id_chambre")
    private Chambre idChambre;

    // getters et setters

    public long getIdService() {
        return idService;
    }

    public void setIdService(long idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public Chambre getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Chambre idChambre) {
        this.idChambre = idChambre;
    }
}
