package tn.esprit.examen.oueslatighaith4twin5.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.oueslatighaith4twin5.entities.TypeUtilisateur;
import tn.esprit.examen.oueslatighaith4twin5.entities.Utilisateur;
import tn.esprit.examen.oueslatighaith4twin5.services.IUtilisateurService;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurController {
    
    private IUtilisateurService utilisateurService;

    @PostMapping("/add")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur u) {
        return utilisateurService.ajouterUtilisateur(u);
    }

    @PutMapping("/affecter-produits/{email}")
    public void affecterProdAUser(@RequestBody List<String> nomProduit, @PathVariable String email) {
        utilisateurService.affecterProdAUser(nomProduit, email);
    }

}


