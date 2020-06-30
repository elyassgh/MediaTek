package fstg.irisi.MediaTek.wsRest;

import fstg.irisi.MediaTek.bean.Facture;
import fstg.irisi.MediaTek.service.FactureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Api("L'api de la gestion des factures")
@RequestMapping("/MediaTek-Api/Facture")
@CrossOrigin(origins = {"http://localhost:4200"})
public class FactureRest {

    @Autowired
    FactureService factureService;

    @ApiOperation("Supprimer une facture via sa reference")
    @DeleteMapping("/delete/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return factureService.deleteByReference(reference);
    }


    @ApiOperation("Modifier l'adresse de facturation d'une facture")
    @PutMapping("/reference/{reference}/Adresse{adresseFact}")
    public int update(@PathVariable String reference, @PathVariable String adresseFact) {
        return factureService.update(reference, adresseFact);
    }


    @ApiOperation("Ajouter une facture ,Mentioner l'adresse de facturation et le cin du client (FK)!")
    @PostMapping("/AdresseFact/{adresse}/cin/{cin}")
    public int save(@PathVariable String adresse,@PathVariable String cin) {
       return factureService.save(adresse,cin);
    }

    @ApiOperation("Trouver tous les factures")
    @GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @ApiOperation("Trouver une facture via sa reference")
    @GetMapping("/find/reference/{reference}")
    public Facture findByReference(@PathVariable String reference) {
        return factureService.findByReference(reference);
    }

    @ApiOperation("Trouver la liste des factures d'une date")
    @GetMapping("/date/{date}")
    public List<Facture> findByDate(@PathVariable LocalDate date) {
        return factureService.findByDate(date);
    }

    @ApiOperation("Trouver la liste des factures d'un client via son id ")
    @GetMapping("/all/{id}")
    public List<Facture> findAllByClient_Id(@PathVariable Long id) {
        return factureService.findAllByClient_Id(id);
    }

    @ApiOperation("Trouver la liste des facture d'un client d'une date via son id et la date")
    @GetMapping("/all/{id}/date/{date}")
    public List<Facture> findByDateAndClient_Id(@PathVariable LocalDate date, @PathVariable Long id) {
        return factureService.findByDateAndClient_Id(date, id);
    }

    @ApiOperation("Trouver la liste des factures d'une adresse de facturation")
    @GetMapping("/adresse/{adresseFact}")
    public List<Facture> findAllByAdresseFact(@PathVariable String adresseFact) {
        return factureService.findAllByAdresseFact(adresseFact);
    }

    @ApiOperation("Trouver la liste des factures d'une adresse de facturation d'une date")
    @GetMapping("/adresse/{adresseFact}/date/{date}")
    public List<Facture> findAllByAdresseFactAndDate(@PathVariable String adresseFact, @PathVariable LocalDate date) {
        return factureService.findAllByAdresseFactAndDate(adresseFact, date);
    }

    @ApiOperation("Trouver le total d'une facture via sa reference")
    @GetMapping("/total/reference/{reference}")
    public double total_fact(@PathVariable String reference) {
        return factureService.total_fact(reference);
    }

    @ApiOperation("La ref du derniére facture")
    @GetMapping(value = "/lastFacture", produces = "application/json" )
    public String lastFacture() {
        return factureService.lastReference();
    }
}

