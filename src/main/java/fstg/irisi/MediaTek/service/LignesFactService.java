package fstg.irisi.MediaTek.service;

import fstg.irisi.MediaTek.bean.LignesFact;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LignesFactService {

    public void save(LignesFact lignesFact);
    public List<LignesFact> findAll();
    public List<LignesFact> findByIdFacture_Reference (String reference);
    public int deleteByIdFacture_Reference (String reference);

}
