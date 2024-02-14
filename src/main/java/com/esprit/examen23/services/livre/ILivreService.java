package com.esprit.examen23.services.livre;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

public interface ILivreService {
    void modifierDateReservation(LocalDate date, long idLecteur);
    String rendreLivre(String nom, String prenom);
    String afficher() ;

}
