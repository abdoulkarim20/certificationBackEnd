package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Administrateur;
import cours.java.springboot.certificationbackend.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministrateurRepositorie extends JpaRepository<Administrateur,Long> {
    public Administrateur getAdministrateurByEmailOrTelephoneOrUsername(String email,String telephone,String username);
    public List<Administrateur> findByDepartementId(Long id);
}
