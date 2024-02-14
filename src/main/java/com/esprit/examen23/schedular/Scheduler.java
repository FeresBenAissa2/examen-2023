package com.esprit.examen23.schedular;

import com.esprit.examen23.dao.entites.Livre;
import com.esprit.examen23.dao.entites.Utilisateur;
import com.esprit.examen23.services.livre.LivreService;
import com.esprit.examen23.services.utilisateur.UtilistateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class Scheduler {
    UtilistateurService utilistateurService;

    @Scheduled(cron = "0/5 * * * * *" )
    public String afficher() {
        List<Utilisateur> utilisateurs= utilistateurService.getAllLecteurs();
        String userString = "\n List des Lecteurs : \n ";
        for(Utilisateur u : utilisateurs){
           if(calculateDayDifference(u.getDateFinAbonnement(),LocalDate.now())<2)
               userString+=u.getNom()+" "+u.getPrenom()+"\n";
        }
        log.info(userString);
        return userString;
    }
    public static long calculateDayDifference(LocalDate date1, LocalDate date2) {
        return ChronoUnit.DAYS.between(date1, date2);
    }
}
