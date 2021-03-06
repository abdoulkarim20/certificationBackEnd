package cours.java.springboot.certificationbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "profiles")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @OneToMany(mappedBy = "profile",fetch = FetchType.LAZY)
    List<Utilisateur> utilisateurs;
}
