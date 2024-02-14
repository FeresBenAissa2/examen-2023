package com.esprit.examen23.services.utilisateur;

import com.esprit.examen23.dao.entites.Utilisateur;
import org.apache.catalina.User;

import java.util.List;

public interface IUtilistateurService {
    List<Utilisateur> ajouterLecteurs(List<Utilisateur> lecteurs) ;
    String affecterLivreALecteur(long idLivre, long idLecteur);

}
