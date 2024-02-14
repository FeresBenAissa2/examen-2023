package com.esprit.examen23.dao.repositories;

import com.esprit.examen23.dao.entites.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Long> {
    Bibliotheque findByNom( String nomBibliotheque);
}
