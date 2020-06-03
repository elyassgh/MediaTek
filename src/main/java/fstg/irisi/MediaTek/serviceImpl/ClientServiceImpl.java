package fstg.irisi.MediaTek.serviceImpl;

import fstg.irisi.MediaTek.bean.Client;
import fstg.irisi.MediaTek.dao.ClientDao;
import fstg.irisi.MediaTek.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
