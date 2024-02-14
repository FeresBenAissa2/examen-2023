package com.esprit.examen23.restController;

import com.esprit.examen23.dao.entites.Bibliotheque;
import com.esprit.examen23.dao.entites.Utilisateur;
import com.esprit.examen23.services.utilisateur.IUtilistateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("utilistateur")
public class UtilistateurRestController {
    IUtilistateurService iUtilistateurService;
    @PostMapping("addLecteurs")
    public List<Utilisateur> addLecteurs(@RequestBody List<Utilisateur> lecteurs ){
        return iUtilistateurService.ajouterLecteurs(lecteurs);
    }
    @PostMapping("affecterLivreALecteur")
    public String affecterLivreALecteur(@RequestParam long idLivre, @RequestParam long idLecteur){
        return iUtilistateurService.affecterLivreALecteur(idLivre,idLecteur);
    }

}
