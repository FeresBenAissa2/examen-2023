package com.esprit.examen23.services.bibliotheque;

import com.esprit.examen23.dao.entites.Bibliotheque;
import com.esprit.examen23.dao.entites.Livre;
import com.esprit.examen23.dao.repositories.BibliothequeRepository;
import com.esprit.examen23.dao.repositories.LivreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BibliothequeService implements IBibliothequeService {
    BibliothequeRepository bibliothequeRepository;
    LivreRepository livreRepository;
    @Override
    public Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque) {
        return bibliothequeRepository.save(bibliotheque);
    }

    @Override
    public Bibliotheque ajouterLivreEtAuteurEtAffecterABiblio(Livre l, String nomBibliotheque) {
        Livre livre = livreRepository.save(l);
        Bibliotheque bib = bibliothequeRepository.findByNom(nomBibliotheque);
        bib.getLivreList().add(livre);
        return bibliothequeRepository.save(bib);
    }


}
