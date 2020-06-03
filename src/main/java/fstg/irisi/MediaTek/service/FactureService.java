package fstg.irisi.MediaTek.service;

import fstg.irisi.MediaTek.bean.Facture;

import java.time.LocalDate;
import java.util.List;

public interface FactureService {

    Facture findByNum (Long num);
    public void save(Facture facture);
    public List<Facture> findAll();
    public List<Facture> findByDate (LocalDate date);
    public List<Facture> findAllByClient_Id (Long id);
    public List<Facture> findByDateAndClient_Id (LocalDate date, Long id);
    public List<Facture> findAllByAdresseFact (String adresseFact);
    public List<Facture> findAllByAdresseFactAndDate (String adresseFact, LocalDate date);

}
