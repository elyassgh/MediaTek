package fstg.irisi.MediaTek.wsRest;

import fstg.irisi.MediaTek.bean.LignesFact;
import fstg.irisi.MediaTek.service.LignesFactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("Api de la gestion des lignes de factures")
@RequestMapping("/MediaTek-Api/LignesFacture")
@CrossOrigin(origins = {"http://localhost:4200"})
public class LignesFactRest {

    @Autowired
    LignesFactService lignesFactService;


    @ApiOperation("Ajouter un ligne de facture")
    @PostMapping("/ref/{reference},{id}/qte/{qte}")
    public void save(@PathVariable String reference, @PathVariable Long id, @PathVariable int qte) {
        lignesFactService.save(reference, id, qte);
    }

    @ApiOperation("Trouver tous les lignes de facture de tous les les factures")
    @GetMapping("/")
    public List<LignesFact> findAll() {
        return lignesFactService.findAll();
    }

    @ApiOperation("Trouver les lignes de facture d'une facture via sa reference")
    @GetMapping("/reference/{reference}")
    public List<LignesFact> findByIdFacture_Reference(@PathVariable String reference) {
        return lignesFactService.findByIdFacture_Reference(reference);
    }

    @ApiOperation("Supprimer tous les lignes de facture via la reference de la facture")
    @DeleteMapping("/delete/reference/{reference}")
    public int deleteByIdFacture_Reference(@PathVariable String reference) {
        return lignesFactService.deleteByIdFacture_Reference(reference);
    }
}
