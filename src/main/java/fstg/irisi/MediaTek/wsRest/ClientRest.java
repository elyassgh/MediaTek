package fstg.irisi.MediaTek.wsRest;

import fstg.irisi.MediaTek.bean.Client;
import fstg.irisi.MediaTek.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("MediaTek/Client")
public class ClientRest {

    @Autowired
    ClientService clientService;

    @PostMapping("/")
    public void save(@RequestBody Client client) { clientService.save(client); }

    @DeleteMapping("/delete/{cin}")
    public void deleteByCin(@PathVariable String cin) { clientService.deleteByCin(cin); }

    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/cin/{cin}")
    public Client findByCin(@PathVariable String cin) {
        return clientService.findByCin(cin);
    }

    @GetMapping("/categorie/{Id}")
    public String ClientCat(@PathVariable Long id) {
        return clientService.ClientCat(id);
    }

    @GetMapping("/ca/{id}")
    public double chiffreAffaire(@PathVariable Long id) { return clientService.chiffreAffaire(id); }

    @GetMapping("/nbrFact/{id}")
    public Long nbrFactures(@PathVariable Long id) {
        return clientService.nbrFactures(id);
    }


}
