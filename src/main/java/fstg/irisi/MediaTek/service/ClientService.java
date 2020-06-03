package fstg.irisi.MediaTek.service;

import fstg.irisi.MediaTek.bean.Client;

import java.util.List;

public interface ClientService {

    public void deleteByCin(String cin);
    public void save(Client client);
    public List<Client> findAll();
    public Client findByCin(String cin);
    public String ClientCat (Long id);
    public double chiffreAffaire (Long id);
    public Long nbrFactures (Long id);

}
