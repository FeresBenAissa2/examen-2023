package com.esprit.examen23.restController;

import com.esprit.examen23.dao.entites.Bibliotheque;
import com.esprit.examen23.dao.entites.Livre;
import com.esprit.examen23.services.bibliotheque.IBibliothequeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("bibliotheque")

public class BibliothequeRestController {
    IBibliothequeService iBibliothequeService;
    @PostMapping("addBibliotheque")
    public Bibliotheque addBloc(@RequestBody Bibliotheque bib ){
        return iBibliothequeService.ajouterBibliotheque(bib);
    }
   @PostMapping("affectLivreEtAuteurToBib")
    public Bibliotheque ajouterLivreEtAuteurEtAffecterABiblio(@RequestBody Livre l,@RequestParam String nomBibliotheque ){
        return iBibliothequeService.ajouterLivreEtAuteurEtAffecterABiblio(l,nomBibliotheque);
    }

}
