package tn.esprit.autoloc.control;

import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeRestController {

    IVehiculeService vehiculeService;

    // http://localhost:8081/autoloc/vehicule/retrieve-all-vehicules
    @GetMapping("/retrieve-all-vehicules")
    public List<Vehicule> getVehicules() {
        List<Vehicule> listVehicules = vehiculeService.retrieveAllVehicules();
        return listVehicules;
    }

    // http://localhost:8081/autoloc/vehicule/retrieve-vehicule/8
    @GetMapping("/retrieve-vehicule/{vehicule-id}")
    public Vehicule retrieveVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        Vehicule vehicule = vehiculeService.retrieveVehicule(vehiculeId);
        return vehicule;
    }

    // http://localhost:8081/autoloc/vehicule/add-vehicule
    @PostMapping("/add-vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule c) {
        Vehicule vehicule = vehiculeService.addVehicule(c);
        return vehicule;
    }

    // http://localhost:8081/autoloc/vehicule/remove-vehicule/{vehicule-id}
    @DeleteMapping("/remove-vehicule/{vehicule-id}")
    public void removeVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        vehiculeService.removeVehicule(vehiculeId);
    }

    // http://localhost:8081/autoloc/vehicule/modify-vehicule
    @PutMapping("/modify-vehicule")
    public Vehicule modifyVehicule(@RequestBody Vehicule c) {
        Vehicule vehicule = vehiculeService.modifyVehicule(c);
        return vehicule;
    }

}
