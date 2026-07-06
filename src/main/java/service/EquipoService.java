package service;

import model.Equipo;
import java.util.ArrayList;

public class EquipoService {

    private ArrayList<Equipo> listaEquipos = new ArrayList<>();

    public void agregarEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
        System.out.println("Equipo agregado correctamente.");
    }

    public Equipo buscarEquipo(int id) {

        for (Equipo equipo : listaEquipos) {

            if (equipo.getId() == id) {
                return equipo;
            }
        }

        return null;
    }

    public void mostrarEquipos() {

        if (listaEquipos.isEmpty()) {
            System.out.println("No existen equipos registrados.");
            return;
        }

        for (Equipo equipo : listaEquipos) {
            equipo.mostrarInfo();
        }
    }
}
