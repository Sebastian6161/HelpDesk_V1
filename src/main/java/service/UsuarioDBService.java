package service;

import model.Usuario;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDBService {

    public void guardarUsuario(Usuario usuario) {

        try {

            Connection conexion =
                    ConexionBD.conectar();

            String sql =
                    "INSERT INTO usuarios(id,nombre,correo) VALUES(?,?,?)";

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setInt(
                    1,
                    usuario.getId()
            );

            ps.setString(
                    2,
                    usuario.getNombre()
            );

            ps.setString(
                    3,
                    usuario.getCorreo()
            );

            ps.executeUpdate();

            System.out.println(
                    "Usuario guardado en MySQL"
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