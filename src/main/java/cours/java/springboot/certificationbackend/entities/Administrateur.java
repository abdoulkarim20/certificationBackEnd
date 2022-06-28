package cours.java.springboot.certificationbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "administrateurs")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Administrateur extends Utilisateur{
    private String posteOccupe;
    @ManyToOne
    private Departement departement;
}
