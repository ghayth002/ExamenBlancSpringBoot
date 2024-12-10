package tn.esprit.examen.oueslatighaith4twin5.services;

import tn.esprit.examen.oueslatighaith4twin5.entities.Produit;
import java.util.List;

public interface IProduitService {
    Produit ajouterProditEtCategories(Produit p);
    boolean chercherProduit(String nomProduit);
    void afficherEtMettreAjourProduit();
}
