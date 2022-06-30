package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliereRepositorie extends JpaRepository<Filiere,Long> {
    public Filiere getFiliereByLibelle(String libelle);
}
