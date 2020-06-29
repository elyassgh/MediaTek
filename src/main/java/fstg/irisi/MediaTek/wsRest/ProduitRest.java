package fstg.irisi.MediaTek.wsRest;

import fstg.irisi.MediaTek.bean.Produit;
import fstg.irisi.MediaTek.service.ProduitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api("Api de la gestion des produits")
@RequestMapping("/MediaTek-Api/Produit")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProduitRest {

    @Autowired
    ProduitService produitService;

    @ApiOperation("Ajouter un produit")
    @PostMapping("/")
    public void save(@RequestBody Produit produit) {
            produitService.save(produit);
    }

    @ApiOperation("Supprimer un produit via son id")
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        produitService.deleteById(id);
    }

    @ApiOperation("Modifier un produit")
    @PutMapping("/")
    public int update(@RequestBody Produit produit) {
        return produitService.update(produit);
    }

    @ApiOperation("Trouver tous les produits")
    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @ApiOperation("Trouver un produit via son id")
    @GetMapping("/id/{id}")
    public Optional<Produit> findById(@PathVariable Long id) {
        return produitService.findById(id);
    }

    @ApiOperation("Trouver la liste des produit d'une catégorie")
    @GetMapping("/Categorie/{categorie}")
    public List<Produit> findAllByCategorie(@PathVariable String categorie) {
        return produitService.findAllByCategorie(categorie);
    }

    @ApiOperation("Trouver les produit ayant une quantité dans le stock moins d'une seuil")
    @GetMapping("/QteStockMin/{qte}")
    public List<Produit> findByQteStockLessThanEqual(@PathVariable int qte) {
        return produitService.findByQteStockLessThanEqual(qte);
    }

    @ApiOperation("Trouver le degré de demande d'un produit via son id")
    @GetMapping("/degreDemande/{id}")
    public String degreDemande(@PathVariable Long id) {
        return produitService.degreDemande(id);
    }

    @ApiOperation("Trouver les produit ayant un degre de demande forte et une quantité en stock mois de 10")
    @GetMapping("/trendingProduit")
    public List<Produit> produitTrend() {
        return produitService.produitTrend();
    }
}
