package com.esprit.examen23.services.livre;

import com.esprit.examen23.dao.entites.Livre;
import com.esprit.examen23.dao.entites.Utilisateur;
import com.esprit.examen23.dao.repositories.LivreRepository;
import com.esprit.examen23.dao.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LivreService implements ILivreService{

    UtilisateurRepository utilisateurRepository;
    LivreRepository livreRepository;


    @Override
    public void modifierDateReservation(LocalDate date, long idLecteur) {
        Utilisateur utilisateur = utilisateurRepository.findById(idLecteur).orElseThrow();
        Livre livre = utilisateur.getLivre();
        livre.setDateReservation(date);
        livreRepository.save(livre);
    }

    @Override
    public String rendreLivre(String nom, String prenom) {
        Utilisateur lecteur = utilisateurRepository.findByNomAndPrenom(nom,prenom);
        Livre livre = lecteur.getLivre();
        if(LocalDate.now().compareTo(livre.getDateReservation())>5){
            livre.setDateReservation(null);
            livre.setReserve(false);
            return "Le lecteur "+nom+" "+prenom+" est bloqué"+" La désaffectation est effectuée avec succès";
        }else {
            livre.setDateReservation(null);
            livre.setReserve(false);
            return "Le lecteur "+nom+" "+prenom+" a respecté la durée"+" La désaffectation est effectuée avec succès";
        }

    }
    @Scheduled(cron = "0 * * * * *" )
    @Override
    public String afficher() {
        List<Livre>livres = livreRepository.findAll();
        for (Livre l :livres){
            System.out.println(l);
            log.debug(l.getNom());
        }
        return "affichier";

    }
}
