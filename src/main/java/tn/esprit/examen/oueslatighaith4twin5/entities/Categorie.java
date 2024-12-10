package tn.esprit.examen.oueslatighaith4twin5.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomCategorie;
    
    @ManyToMany(mappedBy = "categories")
    private List<Produit> produits;
}
