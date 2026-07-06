package service;

import model.Ticket;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TicketDBService {

    public void guardarTicket(Ticket ticket) {

        try {

            Connection conexion =
                    ConexionBD.conectar();

            String sql =
                    "INSERT INTO tickets(id,problema,prioridad,estado,usuario_id) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setInt(
                    1,
                    ticket.getId()
            );

            ps.setString(
                    2,
                    ticket.getProblema()
            );

            ps.setString(
                    3,
                    ticket.getPrioridad()
            );

            ps.setString(
                    4,
                    ticket.getEstado()
            );

            ps.setInt(
                    5,
                    ticket.getUsuario().getId()
            );

            ps.executeUpdate();

            System.out.println(
                    "Ticket guardado en MySQL"
            );

            conexion.close();

        } catch(Exception e){

            System.out.println(
                    "Error: " +
                            e.getMessage()
            );
        }

    }
}

