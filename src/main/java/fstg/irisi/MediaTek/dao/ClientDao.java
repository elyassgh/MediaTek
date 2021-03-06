package fstg.irisi.MediaTek.dao;

import fstg.irisi.MediaTek.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {

    Client findByCin(String cin);

    @Query(value = "Select Categorie from v_chiffre_affaire where id= ?1", nativeQuery = true)
    String clientCat (Long id);

    @Query(value = "Select Total from v_chiffre_affaire where id = ?1", nativeQuery = true)
    double chiffreAffaire (Long id);

    @Query(value ="Select count(*) from Facture where id_client = ?1", nativeQuery = true)
    Long nbrFactures (Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from client where cin =?1", nativeQuery =true)
    void deleteByCin(String cin);


}
