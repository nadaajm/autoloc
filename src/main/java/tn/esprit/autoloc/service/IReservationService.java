package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Reservation;

import java.util.List;

public interface IReservationService {

    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(Long reservationId);
    public Reservation addReservation(Reservation c);
    public void removeReservation(Long reservationId);
    public Reservation modifyReservation(Reservation reservation);

}
