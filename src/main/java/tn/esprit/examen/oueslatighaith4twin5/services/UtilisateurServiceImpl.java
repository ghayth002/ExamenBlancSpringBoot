package tn.esprit.examen.oueslatighaith4twin5.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.oueslatighaith4twin5.entities.Produit;
import tn.esprit.examen.oueslatighaith4twin5.entities.TypeUtilisateur;
import tn.esprit.examen.oueslatighaith4twin5.entities.Utilisateur;
import tn.esprit.examen.oueslatighaith4twin5.repositories.ProduitRepository;
import tn.esprit.examen.oueslatighaith4twin5.repositories.UtilisateurRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    private ProduitRepository produitRepository;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);
    }


    @Override
    public void affecterProdAUser(List<String> nomProduit, String email) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) {
            throw new IllegalArgumentException("Utilisateur with email " + email + " not found");
        }

        List<Produit> produits = produitRepository.findByNomProduitIn(nomProduit);
        utilisateur.setProduits(produits);
        utilisateurRepository.save(utilisateur);
    }
}




