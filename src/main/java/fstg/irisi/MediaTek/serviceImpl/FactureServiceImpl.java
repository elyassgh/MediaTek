package fstg.irisi.MediaTek.serviceImpl;

import fstg.irisi.MediaTek.bean.Facture;
import fstg.irisi.MediaTek.dao.FactureDao;
import fstg.irisi.MediaTek.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    public FactureDao factureDao;

    @Override
    public Facture findByReference(String reference) {
        return factureDao.findByReference(reference);
    }

    @Override
    public int deleteByReference(String reference) {
        return factureDao.deleteByReference(reference);
    }

    @Override
    public int update(Facture facture) {
        Facture fact = findByReference(facture.getReference());
        if (fact != null) {
            fact.setAdresseFact(facture.getAdresseFact());
            try { factureDao.save(fact); return 1;
            } catch (Exception e) { return -1; }
        }
        return 0;
    }

    @Override
    public void save(Facture facture) {
        factureDao.save(facture);
    }

    @Override
    public List<Facture> findAll() {
        return factureDao.findAll();
    }

    @Override
    public List<Facture> findByDate(LocalDate date) {
        return factureDao.findByDate(date);
    }

    @Override
    public List<Facture> findAllByClient_Id(Long id) {
        return factureDao.findAllByClient_Id(id);
    }

    @Override
    public List<Facture> findByDateAndClient_Id(LocalDate date, Long id) {
        return factureDao.findByDateAndClient_Id(date, id);
    }

    @Override
    public List<Facture> findAllByAdresseFact(String adresseFact) {
        return factureDao.findAllByAdresseFact(adresseFact);
    }

    @Override
    public List<Facture> findAllByAdresseFactAndDate(String adresseFact, LocalDate date) {
        return factureDao.findAllByAdresseFactAndDate(adresseFact, date);
    }

    @Override
    public double total_fact(String reference) {
        return factureDao.total_fact(reference);
    }
}
