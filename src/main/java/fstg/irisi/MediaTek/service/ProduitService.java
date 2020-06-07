package fstg.irisi.MediaTek.service;

import fstg.irisi.MediaTek.bean.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    public Optional<Produit> findById(Long id);
    public void deleteById(Long id);
    public void save(Produit produit);
    public int update(Produit produit);
    public List<Produit> findAll();
    public List<Produit> findAllByCategorie(String categorie);
    public List<Produit> findByQteStockLessThanEqual(int qte);
    public String degreDemande (Long id);
    public Produit findProduit(Long id);

}
