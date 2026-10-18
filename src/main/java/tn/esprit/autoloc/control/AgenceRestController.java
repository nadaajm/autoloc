package tn.esprit.autoloc.control;

import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.service.IAgenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceRestController {

    IAgenceService agenceService;

    // http://localhost:8081/autoloc/agence/retrieve-all-agences
    @GetMapping("/retrieve-all-agences")
    public List<Agence> getAgences() {
        List<Agence> listAgences = agenceService.retrieveAllAgences();
        return listAgences;
    }

    // http://localhost:8081/autoloc/agence/retrieve-agence/8
    @GetMapping("/retrieve-agence/{agence-id}")
    public Agence retrieveAgence(@PathVariable("agence-id") Long agenceId) {
        Agence agence = agenceService.retrieveAgence(agenceId);
        return agence;
    }

    // http://localhost:8081/autoloc/agence/add-agence
    @PostMapping("/add-agence")
    public Agence addAgence(@RequestBody Agence c) {
        Agence agence = agenceService.addAgence(c);
        return agence;
    }

    // http://localhost:8081/autoloc/agence/remove-agence/{agence-id}
    @DeleteMapping("/remove-agence/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") Long agenceId) {
        agenceService.removeAgence(agenceId);
    }

    // http://localhost:8081/autoloc/agence/modify-agence
    @PutMapping("/modify-agence")
    public Agence modifyAgence(@RequestBody Agence c) {
        Agence agence = agenceService.modifyAgence(c);
        return agence;
    }

}
