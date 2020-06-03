package fstg.irisi.MediaTek.wsRest;

import fstg.irisi.MediaTek.bean.LignesFact;
import fstg.irisi.MediaTek.service.LignesFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MediaTek/LignesFacture")
public class LignesFactRest {

    @Autowired
    LignesFactService lignesFactService;

    @PostMapping("/")
    public void save(@RequestBody LignesFact lignesFact) {
        lignesFactService.save(lignesFact);
    }

    @GetMapping("/")
    public List<LignesFact> findAll() {
        return lignesFactService.findAll();
    }

    @GetMapping("/num/{num}")
    public List<LignesFact> findByIdFacture_Num(@PathVariable Long num) {
        return lignesFactService.findByIdFacture_Num(num);
    }
}
