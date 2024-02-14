package com.esprit.examen23.dao.repositories;

import com.esprit.examen23.dao.entites.Role;
import com.esprit.examen23.dao.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByNomAndPrenom(String nom,String prenom);
    List<Utilisateur> findByRole(Role role);
}
