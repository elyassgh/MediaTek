package fstg.irisi.MediaTek.wsRest;

import fstg.irisi.MediaTek.bean.Produit;
import fstg.irisi.MediaTek.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MediaTek/Produit")
public class ProduitRest {

    @Autowired
    ProduitService produitService;

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        produitService.deleteById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody Produit produit) {
        produitService.save(produit);
    }

    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @GetMapping("/Categorie/{categorie}")
    public List<Produit> findAllByCategorie(@PathVariable String categorie) {
        return produitService.findAllByCategorie(categorie);
    }

    @GetMapping("/QteStockMin/{qte}")
    public List<Produit> findByQteStockLessThanEqual(@PathVariable int qte) {
        return produitService.findByQteStockLessThanEqual(qte);
    }

    @GetMapping("/degreDemande/{id}")
    public String degreDemande(@PathVariable Long id) {
        return produitService.degreDemande(id);
    }
}
