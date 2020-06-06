package fstg.irisi.MediaTek.serviceImpl;

import fstg.irisi.MediaTek.bean.Client;
import fstg.irisi.MediaTek.dao.ClientDao;
import fstg.irisi.MediaTek.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    public ClientDao clientDao;

    @Override
    public void deleteByCin(String cin) { clientDao.deleteByCin(cin); }

    @Override
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    public int update(Client client) {
        Client cli = clientDao.findByCin(client.getCin());
        if(cli != null) {
            cli.setAdresse(client.getAdresse());
            cli.setCin(client.getCin());
            cli.setNom(client.getNom());
            cli.setPrenom(client.getPrenom());
            cli.setTele(client.getTele());
            try { clientDao.save(cli); return 1;
            } catch (Exception e) { return -1; }
        }
            return 0;
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findByCin(String cin) { return clientDao.findByCin(cin); }

    @Override
    public String clientCat(Long id) { return clientDao.clientCat(id); }

    @Override
    public double chiffreAffaire(Long id) {return clientDao.chiffreAffaire(id);}

    @Override
    public Long nbrFactures(Long id) {
        return clientDao.nbrFactures(id);
    }
}
