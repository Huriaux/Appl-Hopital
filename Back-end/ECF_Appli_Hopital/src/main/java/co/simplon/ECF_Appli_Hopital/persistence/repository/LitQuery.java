package co.simplon.ECF_Appli_Hopital.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ECF_Appli_Hopital.persistence.entity.Lit;

// l'Interface hérite de la classe Lit
public interface LitQuery extends JpaRepository<Lit, Long> {

}
