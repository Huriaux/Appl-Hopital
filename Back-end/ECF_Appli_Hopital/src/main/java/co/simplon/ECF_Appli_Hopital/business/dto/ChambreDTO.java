package co.simplon.ECF_Appli_Hopital.business.dto;

public class ChambreDTO {
    private long idChambre;
    private String numChambre;
    private long idLit; // clé étrangère de la Table Lit

    private Long idService;

    // getters et setters

    public long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(long idChambre) {
        this.idChambre = idChambre;
    }

    public String getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(String numChambre) {
        this.numChambre = numChambre;
    }

    public long getIdLit() {
        return idLit;
    }

    public void setIdLit(long idLit) {
        this.idLit = idLit;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public Long getIdService() {
        return idService;
    }

}
