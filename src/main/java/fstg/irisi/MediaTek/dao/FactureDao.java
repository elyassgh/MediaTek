package fstg.irisi.MediaTek.dao;

import fstg.irisi.MediaTek.bean.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {

    Facture findByNum (Long num);
    List<Facture> findByDate (LocalDate date);
    List<Facture> findAllByClient_Id (Long id);
    List<Facture> findByDateAndClient_Id (LocalDate date, Long id);
    List<Facture> findAllByAdresseFact (String adresseFact);
    List<Facture> findAllByAdresseFactAndDate (String adresseFact, LocalDate date);

}
