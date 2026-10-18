package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    public List<Maintenance> retrieveAllMaintenances();
    public Maintenance retrieveMaintenance(Long maintenanceId);
    public Maintenance addMaintenance(Maintenance c);
    public void removeMaintenance(Long maintenanceId);
    public Maintenance modifyMaintenance(Maintenance maintenance);

}
