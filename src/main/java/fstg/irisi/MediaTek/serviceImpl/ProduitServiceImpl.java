package fstg.irisi.MediaTek.serviceImpl;

import fstg.irisi.MediaTek.bean.Produit;
import fstg.irisi.MediaTek.dao.ProduitDao;
import fstg.irisi.MediaTek.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
