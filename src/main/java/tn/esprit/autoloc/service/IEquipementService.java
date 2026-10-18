package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Equipement;

import java.util.List;

public interface IEquipementService {

    public List<Equipement> retrieveAllEquipements();
    public Equipement retrieveEquipement(Long equipementId);
    public Equipement addEquipement(Equipement c);
    public void removeEquipement(Long equipementId);
    public Equipement modifyEquipement(Equipement equipement);

}
