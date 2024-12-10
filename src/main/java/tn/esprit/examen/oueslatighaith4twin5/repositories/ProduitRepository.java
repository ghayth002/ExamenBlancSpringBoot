package tn.esprit.examen.oueslatighaith4twin5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examen.oueslatighaith4twin5.entities.Produit;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("SELECT p FROM Produit p WHERE p.nomProduit IN :nomProduits")
    List<Produit> findByNomProduitIn(@Param("nomProduits") List<String> nomProduits);
}