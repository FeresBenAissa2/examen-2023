package com.esprit.examen23.restController;

import com.esprit.examen23.services.livre.ILivreService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("livre")
public class LivreRestController {
    ILivreService iLivreService;
    @PostMapping("updateDateReservation")
    void method(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate d, @RequestBody long idLecteur){
        iLivreService.modifierDateReservation(d,idLecteur);
    }

    @PostMapping("rendreLivre")
    String rendreLivre(@RequestParam  String nom, @RequestParam String prenom){
        return iLivreService.rendreLivre(nom,prenom);
    }
}
