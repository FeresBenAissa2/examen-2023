package com.esprit.examen23.dao.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bibliotheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBiblio;
    String nom;
    String adresse;
    String telephone;
    @OneToMany(cascade = CascadeType.ALL)
    List<Livre> livreList =new ArrayList<>();
}
