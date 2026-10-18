package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    MaintenanceRepository maintenanceRepository;
    VehiculeRepository vehiculeRepository;

    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    public Maintenance retrieveMaintenance(Long maintenanceId) {
        return maintenanceRepository.findById(maintenanceId).get();
    }

    public Maintenance addMaintenance(Maintenance c) {
        if (c.getVehicule() != null && c.getVehicule().getIdVehicule() != null) {
            c.setVehicule(vehiculeRepository.findById(c.getVehicule().getIdVehicule()).get());
        }
        return maintenanceRepository.save(c);
    }

    public void removeMaintenance(Long maintenanceId) {
        maintenanceRepository.deleteById(maintenanceId);
    }

    public Maintenance modifyMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

}
