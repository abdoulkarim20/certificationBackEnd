package cours.java.springboot.certificationbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "departements")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomDepartement;
    @OneToMany(mappedBy = "departement",fetch = FetchType.LAZY)
    private List<Administrateur> administrateurs;
    @OneToMany(mappedBy = "departement",fetch = FetchType.LAZY)
    private List<Demande>demandes;
}
