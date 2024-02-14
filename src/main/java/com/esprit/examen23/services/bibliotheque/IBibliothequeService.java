package com.esprit.examen23.services.bibliotheque;

import com.esprit.examen23.dao.entites.Bibliotheque;
import com.esprit.examen23.dao.entites.Livre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface IBibliothequeService {
    Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque);
    Bibliotheque ajouterLivreEtAuteurEtAffecterABiblio(Livre l, String nomBibliotheque);
}
