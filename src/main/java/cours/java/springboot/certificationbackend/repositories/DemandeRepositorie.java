package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepositorie extends JpaRepository<Demande,Long> {
    List<Demande> findByEtudiantId(Long id);
}
