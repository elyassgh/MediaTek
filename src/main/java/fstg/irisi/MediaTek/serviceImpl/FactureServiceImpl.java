package fstg.irisi.MediaTek.serviceImpl;

import fstg.irisi.MediaTek.bean.Facture;
import fstg.irisi.MediaTek.bean.Client;
import fstg.irisi.MediaTek.dao.FactureDao;
import fstg.irisi.MediaTek.service.ClientService;
import fstg.irisi.MediaTek.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    public FactureDao factureDao;
    @Autowired
    public ClientService clientService;

    @Override
    public Facture findByReference(String reference) {
        return factureDao.findByReference(reference);
    }

    @Override
    public int deleteByReference(String reference) {
        return factureDao.deleteByReference(reference);
    }

    @Override
    public int update(String reference , String adresseFact) {
        Facture fact = findByReference(reference);
        if (fact != null) {
            fact.setAdresseFact(adresseFact);
            try { factureDao.save(fact); return 1;
            } catch (Exception e) { return -1; }
        }
        return 0;
    }

    public String referenceGenerator(String ref) {
        double rnd = (int)(Math.random()*((9-1)+1))+1;
        int nextsequence = (int) (Integer.parseInt(ref.substring(3)) + rnd);
        String nextRef = "REF" + String.valueOf(nextsequence);
        return nextRef;
    }

    @Override
    public int save(String adresse, String cin) {
        Client client = clientService.findByCin(cin);
        if (client != null) {
            Facture facture = new Facture();
            facture.setClient(client);
            facture.setAdresseFact(adresse);
            facture.setDate(LocalDate.now());
            facture.setReference(referenceGenerator(factureDao.lastReference()));
            factureDao.save(facture);
            return 1;
        }
       return 0;
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

    @Override
    public String lastReference() {
        return factureDao.lastReference();
    }
}
