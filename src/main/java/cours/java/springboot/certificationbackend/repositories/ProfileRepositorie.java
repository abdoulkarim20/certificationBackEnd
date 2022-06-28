package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepositorie extends JpaRepository<Profile,Long> {
}
