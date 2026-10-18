package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Vehicule;

import java.util.List;

public interface IVehiculeService {

    public List<Vehicule> retrieveAllVehicules();
    public Vehicule retrieveVehicule(Long vehiculeId);
    public Vehicule addVehicule(Vehicule c);
    public void removeVehicule(Long vehiculeId);
    public Vehicule modifyVehicule(Vehicule vehicule);

}
