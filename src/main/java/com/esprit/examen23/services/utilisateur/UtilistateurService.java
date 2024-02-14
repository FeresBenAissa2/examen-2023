package com.esprit.examen23.services.utilisateur;

import com.esprit.examen23.dao.entites.Livre;
import com.esprit.examen23.dao.entites.Utilisateur;
import com.esprit.examen23.dao.repositories.LivreRepository;
import com.esprit.examen23.dao.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilistateurService implements IUtilistateurService {
    UtilisateurRepository utilisateurRepository;
    LivreRepository livreRepository;

    @Override
    public List<Utilisateur> ajouterLecteurs(List<Utilisateur> lecteurs) {
        return utilisateurRepository.saveAll(lecteurs);
    }

    @Override
    public String affecterLivreALecteur(long idLivre, long idLecteur) {
        Livre livre = livreRepository.findById(idLivre).orElseThrow();
        Utilisateur lecteur = utilisateurRepository.findById(idLecteur).orElseThrow();
        if (lecteur.getLivre() != null) return "Le livre" + idLivre + " est déjà reservé !";
        else {
            //lecteur houwa el parent, lezem na3mel parent .set
            lecteur.setLivre(livre);
            utilisateurRepository.save(lecteur);
            return "L'affectation du livre "+idLivre+" au lecteur "+lecteur.getNom()+" est effectué avec succès !";
        }
    }


}
