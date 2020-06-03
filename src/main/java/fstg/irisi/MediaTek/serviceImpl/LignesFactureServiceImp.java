package fstg.irisi.MediaTek.serviceImpl;

import fstg.irisi.MediaTek.bean.Facture;
import fstg.irisi.MediaTek.bean.LignesFact;
import fstg.irisi.MediaTek.dao.LignesFactureDao;
import fstg.irisi.MediaTek.service.FactureService;
import fstg.irisi.MediaTek.service.LignesFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LignesFactureServiceImp implements LignesFactureService {

    @Autowired
    public LignesFactureDao lignesFactureDao;
    @Autowired
    public FactureService factureService;

    @Override
    public void save(LignesFact lignesFact) {
        lignesFactureDao.save(lignesFact);
    }

    @Override
    public List<LignesFact> findAll() {
        return lignesFactureDao.findAll();
    }

    @Override
    public List<LignesFact> findByIdFacture_Num(Long num) {
        Facture facture = factureService.findByNum(num);
        return lignesFactureDao.findByIdFacture(facture);
    }


}
