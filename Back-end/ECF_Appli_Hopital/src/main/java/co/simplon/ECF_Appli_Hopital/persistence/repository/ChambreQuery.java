package co.simplon.ECF_Appli_Hopital.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ECF_Appli_Hopital.persistence.entity.Chambre;

public interface ChambreQuery extends JpaRepository<Chambre, Long> {
    List<Chambre> findAll();
}
