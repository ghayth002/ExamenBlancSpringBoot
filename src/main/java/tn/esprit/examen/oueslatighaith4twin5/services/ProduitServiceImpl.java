package tn.esprit.examen.oueslatighaith4twin5.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.examen.oueslatighaith4twin5.entities.Categorie;
import tn.esprit.examen.oueslatighaith4twin5.entities.Etat;
import tn.esprit.examen.oueslatighaith4twin5.entities.Produit;
import tn.esprit.examen.oueslatighaith4twin5.entities.TypeUtilisateur;
import tn.esprit.examen.oueslatighaith4twin5.repositories.CategorieRepository;
import tn.esprit.examen.oueslatighaith4twin5.repositories.ProduitRepository;
import java.util.List;

@Service
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    @Transactional
    public Produit ajouterProditEtCategories(Produit p) {
        // Save categories first
        for (Categorie categorie : p.getCategories()) {
            if (categorie.getId() == null) {
                categorieRepository.save(categorie);
            }
        }
        // Save the product
        return produitRepository.save(p);
    }

    @Override
    public boolean chercherProduit(String nomProduit) {
        List<Produit> produits = produitRepository.findByNomProduitIn(List.of(nomProduit));
        if (!produits.isEmpty()) {
            return produits.get(0).getEtat() == Etat.BOYCOTT;
        }
        return false;
    }

    @Override

    @Scheduled(fixedDelay = 40000) // 40 seconds
    public void afficherEtMettreAjourProduit() {
        Logger logger = LoggerFactory.getLogger(ProduitServiceImpl.class);
        List<Produit> produits = produitRepository.findAll();
        for (Produit produit : produits) {
            if (produit.getUtilisateur() != null &&
                    produit.getUtilisateur().getTypeUtilisateur() == TypeUtilisateur.ADMIN) {
                produit.setEtat(Etat.BOYCOTT);
                produitRepository.save(produit);
            }
        }

        logger.info("Liste des produits mise à jour :");
        produits.forEach(p -> logger.info("Produit: " + p.getNomProduit() + ", Etat: " + p.getEtat()));
    }
}