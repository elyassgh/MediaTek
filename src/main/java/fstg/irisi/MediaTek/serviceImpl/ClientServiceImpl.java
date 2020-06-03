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
    public void deleteByCne(String cne) { clientDao.deleteByCne(cne); }

    @Override
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findByCne(String cne) { return clientDao.findByCne(cne); }

    @Override
    public String ClientCat(Long id) { return clientDao.ClientCat(id); }

    @Override
    public double chiffreAffaire(Long id) {return clientDao.chiffreAffaire(id);}
}
