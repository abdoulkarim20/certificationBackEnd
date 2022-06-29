package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DepartementDTO;
import cours.java.springboot.certificationbackend.entities.Departement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartementService implements IDepartement {


    @Override
    public DepartementDTO saveDepartement(DepartementDTO departementDTO) {
        return null;
    }
}
