package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Employe;

import java.util.List;

public interface IEmployeService {

    public List<Employe> retrieveAllEmployes();
    public Employe retrieveEmploye(Long employeId);
    public Employe addEmploye(Employe c);
    public void removeEmploye(Long employeId);
    public Employe modifyEmploye(Employe employe);

}
