package fstg.irisi.MediaTek.service;

import fstg.irisi.MediaTek.bean.Facture;

import java.time.LocalDate;
import java.util.List;

public interface FactureService {

    public Facture findByReference (String reference);
    public int deleteByReference (String reference);
    public int update (String reference , String adresseFact);
    public int save(String adresse, String cin);
    public List<Facture> findAll();
    public List<Facture> findByDate (LocalDate date);
    public List<Facture> findAllByClient_Id (Long id);
    public List<Facture> findByDateAndClient_Id (LocalDate date, Long id);
    public List<Facture> findAllByAdresseFact (String adresseFact);
    public List<Facture> findAllByAdresseFactAndDate (String adresseFact, LocalDate date);
    public double total_fact (String reference);
    public String lastReference();


}
