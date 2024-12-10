package tn.esprit.examen.oueslatighaith4twin5.services;

import tn.esprit.examen.oueslatighaith4twin5.entities.TypeUtilisateur;
import tn.esprit.examen.oueslatighaith4twin5.entities.Utilisateur;
import java.util.Date;
import java.util.List;

public interface IUtilisateurService {
    Utilisateur ajouterUtilisateur(Utilisateur u);
    void affecterProdAUser(List<String> nomProduit, String email);

}
