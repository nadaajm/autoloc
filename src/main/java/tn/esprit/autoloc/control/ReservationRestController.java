package tn.esprit.autoloc.control;

import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.service.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    IReservationService reservationService;

    // http://localhost:8081/autoloc/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        return listReservations;
    }

    // http://localhost:8081/autoloc/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long reservationId) {
        Reservation reservation = reservationService.retrieveReservation(reservationId);
        return reservation;
    }

    // http://localhost:8081/autoloc/reservation/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.addReservation(c);
        return reservation;
    }

    // http://localhost:8081/autoloc/reservation/remove-reservation/{reservation-id}
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    // http://localhost:8081/autoloc/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.modifyReservation(c);
        return reservation;
    }

}
