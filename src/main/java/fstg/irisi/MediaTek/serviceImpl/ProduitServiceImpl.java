package fstg.irisi.MediaTek.serviceImpl;

import fstg.irisi.MediaTek.bean.Produit;
import fstg.irisi.MediaTek.dao.ProduitDao;
import fstg.irisi.MediaTek.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitDao produitDao;


    public Optional<Produit> findById(Long id) {
        return produitDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        produitDao.deleteById(id);
    }

    @Override
    public void save(Produit produit) {
        produitDao.save(produit);
    }

    @Override
    public int update(Produit produit) {
        Produit prod = produitDao.getOne(produit.getId());
        if (prod != null) {
            prod.setCategorie(produit.getCategorie());
            prod.setDesignation(produit.getDesignation());
            prod.setPrixUnit(produit.getPrixUnit());
            prod.setQteStock(produit.getQteStock());
            try { produitDao.save(prod); return 1; }
            catch (Exception e) { return -1; }
        }
        return 0;
    }

    @Override
    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    @Override
    public List<Produit> findAllByCategorie(String categorie) {
        return produitDao.findAllByCategorie(categorie);
    }

    @Override
    public List<Produit> findByQteStockLessThanEqual(int qte) {
        return produitDao.findByQteStockLessThanEqual(qte) ;
    }

    @Override
    public String degreDemande(Long id) { return produitDao.degreDemande(id); }

    @Override
    public Produit findProduit(Long id) {
        return produitDao.getOne(id);
    }

    @Override
    public List<Produit> produitTrend() {
        return produitDao.produitTrend();
    }
}
