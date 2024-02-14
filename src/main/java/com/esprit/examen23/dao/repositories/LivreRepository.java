package com.esprit.examen23.dao.repositories;

import com.esprit.examen23.dao.entites.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre,Long> {
}
