package tn.esprit.examen.oueslatighaith4twin5.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.oueslatighaith4twin5.entities.Produit;
import tn.esprit.examen.oueslatighaith4twin5.services.IProduitService;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {
    
    private IProduitService produitService;

    @PostMapping("/add")
    public Produit ajouterProditEtCategories(@RequestBody Produit p) {
        return produitService.ajouterProditEtCategories(p);
    }

    @GetMapping("/chercher/{nomProduit}")
    public boolean chercherProduit(@PathVariable String nomProduit) {
        return produitService.chercherProduit(nomProduit);
    }
}
