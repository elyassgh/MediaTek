package fstg.irisi.MediaTek.wsRest;

import fstg.irisi.MediaTek.bean.Client;
import fstg.irisi.MediaTek.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("L'api de la gestion des clients")
@RequestMapping("/MediaTek-Api/Client")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClientRest {

    @Autowired
    ClientService clientService;

    @ApiOperation("Modifier un client")
    @PutMapping("/")
    public int update(@RequestBody Client client) {
        return clientService.update(client);
    }

    @ApiOperation("Ajouter un client dans la bd")
    @PostMapping("/")
    public void save(@RequestBody Client client) { clientService.save(client); }

    @ApiOperation("Supprimer un client par son cin")
    @DeleteMapping("/delete/{cin}")
    public void deleteByCin(@PathVariable String cin) { clientService.deleteByCin(cin); }

    @ApiOperation("Trouver tous les clients")
    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @ApiOperation("Trouver un client via son cin")
    @GetMapping("/cin/{cin}")
    public Client findByCin(@PathVariable String cin) {
        return clientService.findByCin(cin);
    }

    @ApiOperation("Trouver la catégorie d'un client via son id")
    @GetMapping("/categorie/{id}")
    public String clientCat(@PathVariable Long id) { return clientService.clientCat(id); }

    @ApiOperation("Trouver le chiffre d'affaire d'un client via son id")
    @GetMapping("/ca/{id}")
    public double chiffreAffaire(@PathVariable Long id) { return clientService.chiffreAffaire(id); }

    @ApiOperation("Trouver le nombre de facture d'un client par son id")
    @GetMapping("/nbrFact/{id}")
    public Long nbrFactures(@PathVariable Long id) {
        return clientService.nbrFactures(id);
    }

}
