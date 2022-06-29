package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DepartementDTO;
import cours.java.springboot.certificationbackend.exceptions.DepartementNotFoundException;

import java.util.List;

public interface IDepartement {
    public List<DepartementDTO>departementDtoList();
    public DepartementDTO getOneDepartement(Long id) throws DepartementNotFoundException;
    public void getDepartementByNomDepartement(String nomDepartement) throws DepartementNotFoundException;
    public DepartementDTO saveDepartement(DepartementDTO departementDTO) throws DepartementNotFoundException;
}
