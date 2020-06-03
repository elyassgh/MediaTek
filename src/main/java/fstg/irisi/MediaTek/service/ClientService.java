package fstg.irisi.MediaTek.service;

import fstg.irisi.MediaTek.bean.Client;

import java.util.List;

public interface ClientService {

    public void deleteByCne(String cne);
    public void save(Client client);
    public List<Client> findAll();
    public Client findByCne(String cne);
    public String ClientCat (Long id);
    public double chiffreAffaire (Long id);

}
