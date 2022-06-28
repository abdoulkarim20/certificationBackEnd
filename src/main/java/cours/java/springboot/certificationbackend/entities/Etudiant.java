package cours.java.springboot.certificationbackend.entities;

import cours.java.springboot.certificationbackend.enums.Niveau;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "etudiants")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Etudiant extends Utilisateur {
    private String matricule;
    private Niveau niveauEtude;
    private String photo;
    @ManyToOne
    private Filiere filiere;
    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    private List<Demande>demandes;
}
