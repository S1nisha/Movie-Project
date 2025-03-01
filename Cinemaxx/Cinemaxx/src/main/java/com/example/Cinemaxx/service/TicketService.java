package com.example.Cinemaxx.service;

import com.example.Cinemaxx.entities.Projection;
import com.example.Cinemaxx.entities.Ticket;

import java.util.List;

public interface TicketService {

    Ticket findTicketById(int id);

    List<Ticket> findAllTickets();

    List<Ticket> findAllTicketsForProjection(Projection projection);

}
