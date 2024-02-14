package com.esprit.examen23.dao.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idLivre;
    String nom ;
    TypeLivre typeLivre;
    LocalDate localDate;
    Boolean reserve;
    LocalDate dateReservation;

    @OneToOne(mappedBy = "livre")
    Utilisateur lecteur;
    @ManyToOne(cascade = CascadeType.ALL)
    Utilisateur auteur;


}
