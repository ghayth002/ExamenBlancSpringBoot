package tn.esprit.examen.oueslatighaith4twin5.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date dateInscri;
    
    @Enumerated(EnumType.STRING)
    private TypeUtilisateur typeUtilisateur;
    
    @OneToMany
    private List<Produit> produits;
}
