package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepositorie extends JpaRepository<Profile,Long> {
    public Profile getProfileByLibelleContains(String libelle);
    //public List<Profile> findByUtilisateursId(Long id);
}
