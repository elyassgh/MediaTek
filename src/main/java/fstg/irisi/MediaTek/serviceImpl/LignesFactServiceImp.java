package fstg.irisi.MediaTek.serviceImpl;

import fstg.irisi.MediaTek.bean.Facture;
import fstg.irisi.MediaTek.bean.LignesFact;
import fstg.irisi.MediaTek.dao.LignesFactDao;
import fstg.irisi.MediaTek.service.FactureService;
import fstg.irisi.MediaTek.service.LignesFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LignesFactServiceImp implements LignesFactService {

    @Autowired
    public LignesFactDao lignesFactDao;
    @Autowired
    public FactureService factureService;

    @Override
    public void save(LignesFact lignesFact) {
        lignesFactDao.save(lignesFact);
    }

    @Override
    public List<LignesFact> findAll() {
        return lignesFactDao.findAll();
    }

    @Override
    public List<LignesFact> findByIdFacture_Num(Long num) {
        Facture facture = factureService.findByNum(num);
        return lignesFactDao.findByIdFacture(facture);
    }


}
