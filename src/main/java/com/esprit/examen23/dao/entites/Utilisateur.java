package com.esprit.examen23.dao.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUser;
    String nom ;
    String prenom ;
    String nationalite ;
    @Enumerated(EnumType.STRING)
    Role role;
    @Enumerated(EnumType.STRING)
    Etat etat;
    LocalDate dateDebutAbonnement;
    LocalDate dateFinAbonnement;

    @OneToOne
    Livre livre;

    @OneToMany(mappedBy = "auteur")
    List<Livre> listLivre=new ArrayList<>();

}
