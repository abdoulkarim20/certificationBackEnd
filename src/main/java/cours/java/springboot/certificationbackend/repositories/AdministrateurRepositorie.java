package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdministrateurRepositorie extends JpaRepository<Administrateur,Long> {
    public Administrateur getAdministrateurByEmailOrTelephoneOrUsername(String email,String telephone,String username);
    public List<Administrateur> findByDepartementId(Long id);
    public List<Administrateur> findByPrenomsContains(String motCle);
    /*On peut aussi faire une requette specifique avec les requette querie*/
//    @Query("")

}
