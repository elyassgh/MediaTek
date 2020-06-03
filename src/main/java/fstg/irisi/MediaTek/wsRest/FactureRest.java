package fstg.irisi.MediaTek.wsRest;

import fstg.irisi.MediaTek.bean.Facture;
import fstg.irisi.MediaTek.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/MediaTek/Facture")
public class FactureRest {

    @Autowired
    FactureService factureService;

    @PostMapping("/")
    public void save(@RequestBody Facture facture) {
        factureService.save(facture);
    }

    @GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @GetMapping("/num/{num}")
    public Facture findByNum(Long num) {
        return factureService.findByNum(num);
    }

    @GetMapping("/date/{date}")
    public List<Facture> findByDate(@PathVariable LocalDate date) {
        return factureService.findByDate(date);
    }

    @GetMapping("/all/{id}")
    public List<Facture> findAllByClient_Id(@PathVariable Long id) {
        return factureService.findAllByClient_Id(id);
    }

    @GetMapping("/all/{id}/date/{date}")
    public List<Facture> findByDateAndClient_Id(@PathVariable LocalDate date, @PathVariable Long id) {
        return factureService.findByDateAndClient_Id(date, id);
    }

    @GetMapping("/adresse/{adresseFact}")
    public List<Facture> findAllByAdresseFact(@PathVariable String adresseFact) {
        return factureService.findAllByAdresseFact(adresseFact);
    }

    @GetMapping("/adresse/{adresseFact}/date/{date}")
    public List<Facture> findAllByAdresseFactAndDate(@PathVariable String adresseFact, @PathVariable LocalDate date) {
        return factureService.findAllByAdresseFactAndDate(adresseFact, date);
    }
}

