package fstg.irisi.MediaTek.dao;

import fstg.irisi.MediaTek.bean.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {

    Facture findByReference (String reference);
    List<Facture> findByDate (LocalDate date);
    List<Facture> findAllByClient_Id (Long id);
    List<Facture> findByDateAndClient_Id (LocalDate date, Long id);
    List<Facture> findAllByAdresseFact (String adresseFact);
    List<Facture> findAllByAdresseFactAndDate (String adresseFact, LocalDate date);

    @Transactional
    int deleteByReference (String reference);

    @Query(value ="Select Total from Total_cmd where ref = ?1", nativeQuery = true)
    double total_fact (String reference);
}
