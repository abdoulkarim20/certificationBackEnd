package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DepartementDTO;
import cours.java.springboot.certificationbackend.exceptions.DepartementNotFoundException;

public interface IDepartement {
    public void getDepartementByNomDepartement(String nomDepartement) throws DepartementNotFoundException;
    public DepartementDTO saveDepartement(DepartementDTO departementDTO) throws DepartementNotFoundException;
}
