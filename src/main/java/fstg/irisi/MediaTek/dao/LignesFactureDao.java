package fstg.irisi.MediaTek.dao;

import fstg.irisi.MediaTek.bean.Facture;
import fstg.irisi.MediaTek.bean.LignesFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LignesFactureDao extends JpaRepository<LignesFact, Long> {

    List<LignesFact> findByIdFacture (Facture facture);

}
