package service;

import model.Equipo;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EquipoDBService {

    public void guardarEquipo(Equipo equipo) {

        try {

            Connection conexion = ConexionBD.conectar();

            String sql = "INSERT INTO equipos(id,nombre,tipo,estado) VALUES(?,?,?,?)";

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, equipo.getId());
            ps.setString(2, equipo.getNombre());
            ps.setString(3, equipo.getTipo());
            ps.setString(4, equipo.getEstado());

            ps.executeUpdate();

            System.out.println("Equipo guardado en MySQL.");

            conexion.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}