package tn.esprit.examen.oueslatighaith4twin5.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomProduit;
    
    @Enumerated(EnumType.STRING)
    private Etat etat;
    
    @ManyToMany
    private List<Categorie> categories;

    @ManyToOne
    private Utilisateur utilisateur;
}
