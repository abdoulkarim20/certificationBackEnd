package cours.java.springboot.certificationbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "filieres")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @OneToMany(mappedBy = "filiere",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Etudiant>etudiants;
}
