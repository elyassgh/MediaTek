package fstg.irisi.MediaTek.dao;

import fstg.irisi.MediaTek.bean.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitDao extends JpaRepository<Produit ,Long> {

    List<Produit> findAllByCategorie (String categorie);
    List<Produit> findByQteStockLessThanEqual (int qte);

    @Query (value= "Select DegreDemande(?1) from dual" , nativeQuery = true)
    String degreDemande (Long id);

}
