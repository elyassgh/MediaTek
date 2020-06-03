package fstg.irisi.MediaTek.service;


import fstg.irisi.MediaTek.bean.LignesFact;

import java.util.List;

public interface LignesFactureService {

    public void save(LignesFact lignesFact);
    public List<LignesFact> findAll();
    public List<LignesFact> findByIdFacture_Num (Long id);

}
