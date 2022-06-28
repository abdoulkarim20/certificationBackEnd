package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositorie extends JpaRepository<Administrateur,Long> {
}
