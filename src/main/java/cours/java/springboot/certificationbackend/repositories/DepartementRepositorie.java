package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepositorie extends JpaRepository<Departement,Long> {
}
