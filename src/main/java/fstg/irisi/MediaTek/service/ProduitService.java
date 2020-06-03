package fstg.irisi.MediaTek.service;

import fstg.irisi.MediaTek.bean.Produit;

import java.util.List;

public interface ProduitService {

    public void deleteById(Long id);
    public void save(Produit produit);
    public List<Produit> findAll();
    public List<Produit> findAllByCategorie (String categorie);
    public List<Produit> findByQteStockLessThanEqual (int qte);
    public String degreDemande (Long id);

}
