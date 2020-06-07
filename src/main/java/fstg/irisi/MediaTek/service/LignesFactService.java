package fstg.irisi.MediaTek.service;

import fstg.irisi.MediaTek.bean.LignesFact;


import java.util.List;

public interface LignesFactService {

    public void save(String reference, Long id, int qte);
    public List<LignesFact> findAll();
    public List<LignesFact> findByIdFacture_Reference (String reference);
    public int deleteByIdFacture_Reference (String reference);
}
