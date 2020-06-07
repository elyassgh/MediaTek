package fstg.irisi.MediaTek.serviceImpl;

import fstg.irisi.MediaTek.bean.CleLignesFact;
import fstg.irisi.MediaTek.bean.Facture;
import fstg.irisi.MediaTek.bean.Produit;
import fstg.irisi.MediaTek.bean.LignesFact;
import fstg.irisi.MediaTek.dao.LignesFactDao;
import fstg.irisi.MediaTek.service.FactureService;
import fstg.irisi.MediaTek.service.LignesFactService;
import fstg.irisi.MediaTek.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class LignesFactServiceImp implements LignesFactService {

    @Autowired
    public LignesFactDao lignesFactDao;
    @Autowired
    public FactureService factureService;
    @Autowired
    public ProduitService produitService;

    @Override
    public void save(String reference, Long id, int qte) {
        Facture facture = factureService.findByReference(reference);
        Produit produit = produitService.findProduit(id);
        LignesFact lignesFact = new LignesFact();
        CleLignesFact cle = new CleLignesFact(facture, produit);
        lignesFact.setId(cle);
        lignesFact.setQteCom(qte);
        lignesFactDao.save(lignesFact);
    }

    @Override
    public List<LignesFact> findAll() {
        return lignesFactDao.findAll();
    }

    @Override
    @Transactional
    public int deleteByIdFacture_Reference(String reference) {
        Facture facture = factureService.findByReference(reference);
        if (facture != null){
            try { lignesFactDao.deleteByIdFacture(facture); return 1; }
            catch (Exception e) { return -1; }
        }
        return 0;
    }

    @Override
    public List<LignesFact> findByIdFacture_Reference(String reference) {
        Facture facture = factureService.findByReference(reference);
        return lignesFactDao.findByIdFacture(facture);
    }


}
