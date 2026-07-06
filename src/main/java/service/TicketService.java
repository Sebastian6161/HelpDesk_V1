package service;

import model.Ticket;

import java.util.ArrayList;

public class TicketService {

    private ArrayList<Ticket> listaTickets;

    public TicketService(ArrayList<Ticket> ticketsCargados) {
        this.listaTickets = ticketsCargados;
    }

    public void agregarTicket(Ticket ticket) {
        listaTickets.add(ticket);
        System.out.println("Ticket creado correctamente.");
    }

    public void mostrarTickets() {

        if (listaTickets.isEmpty()) {
            System.out.println("No existen tickets.");
            return;
        }

        for (Ticket ticket : listaTickets) {
            ticket.mostrarInfo();
        }
    }

    public void cerrarTicket(int id) {

        for (Ticket ticket : listaTickets) {

            if (ticket.getId() == id) {

                ticket.cerrarTicket();

                System.out.println("Ticket cerrado.");

                return;
            }
        }

        System.out.println("Ticket no encontrado.");
    }

    public ArrayList<Ticket> obtenerTickets() {
        return listaTickets;
    }

}
