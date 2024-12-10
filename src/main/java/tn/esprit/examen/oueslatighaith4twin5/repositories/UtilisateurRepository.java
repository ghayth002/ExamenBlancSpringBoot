package tn.esprit.examen.oueslatighaith4twin5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.oueslatighaith4twin5.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
}
