package util;

import model.Ticket;
import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUtil {

    public static void guardarTickets(ArrayList<Ticket> tickets) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("tickets_helpdesk.csv")
                    );

            writer.write("ID,Problema,Prioridad,Estado");
            writer.newLine();

            for (Ticket ticket : tickets) {

                writer.write(
                        ticket.getId() + "," +
                                ticket.getProblema() + "," +
                                ticket.getPrioridad() + "," +
                                ticket.getEstado()
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Tickets guardados correctamente.");

        } catch (IOException e) {

            System.out.println("Error al guardar archivo.");
        }
    }

    public static ArrayList<Ticket> cargarTickets() {

        ArrayList<Ticket> tickets = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("tickets_helpdesk.csv")
                    );

            reader.readLine();

            String linea;

            while((linea = reader.readLine()) != null){

                String[] datos = linea.split(",");

                int id =
                        Integer.parseInt(datos[0]);

                String problema =
                        datos[1];

                String prioridad =
                        datos[2];

                String estado =
                        datos[3];

                Usuario usuarioDummy =
                        new Usuario(
                                0,
                                "Sistema",
                                "sistema@email.com"
                        );

                Ticket ticket =
                        new Ticket(
                                id,
                                problema,
                                prioridad,
                                usuarioDummy
                        );

                if(estado.equals("Cerrado")){
                    ticket.cerrarTicket();
                }

                tickets.add(ticket);
            }

            reader.close();

        } catch (IOException e){

            System.out.println(
                    "No existe archivo previo."
            );
        }

        return tickets;
    }
}
