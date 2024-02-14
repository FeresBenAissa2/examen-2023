package com.esprit.examen23.services.livre;

import com.esprit.examen23.dao.entites.Livre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ILivreService {
    void modifierDateReservation(LocalDate date, long idLecteur);
    String rendreLivre(String nom, String prenom);
    List<Livre> getAllLivre();
}
