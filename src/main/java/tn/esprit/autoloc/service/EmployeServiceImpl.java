package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    EmployeRepository employeRepository;

    public List<Employe> retrieveAllEmployes() {
        return employeRepository.findAll();
    }

    public Employe retrieveEmploye(Long employeId) {
        return employeRepository.findById(employeId).get();
    }

    public Employe addEmploye(Employe c) {
        return employeRepository.save(c);
    }

    public void removeEmploye(Long employeId) {
        employeRepository.deleteById(employeId);
    }

    public Employe modifyEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

}
