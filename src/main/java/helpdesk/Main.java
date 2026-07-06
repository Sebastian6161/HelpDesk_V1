package helpdesk;

import model.Equipo;
import model.Ticket;
import model.Usuario;

import service.EquipoDBService;
import service.EquipoService;
import service.TicketDBService;
import service.TicketService;
import service.UsuarioDBService;
import service.UsuarioService;

import util.ArchivoUtil;
import util.ConexionBD;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (ConexionBD.conectar() != null) {
            System.out.println("Conexión exitosa a MySQL");
        } else {
            System.out.println("No se pudo conectar a MySQL");
            return;
        }

        Scanner teclado = new Scanner(System.in);

        UsuarioService usuarioService = new UsuarioService();
        UsuarioDBService usuarioDBService = new UsuarioDBService();

        EquipoService equipoService = new EquipoService();
        EquipoDBService equipoDBService = new EquipoDBService();

        TicketService ticketService =
                new TicketService(
                        ArchivoUtil.cargarTickets()
                );

        TicketDBService ticketDBService = new TicketDBService();

        int opcion;

        do {

            System.out.println("\n===== HELP DESK PRO =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Ver usuarios");
            System.out.println("3. Registrar equipo");
            System.out.println("4. Ver equipos");
            System.out.println("5. Crear ticket");
            System.out.println("6. Ver tickets");
            System.out.println("7. Cerrar ticket");
            System.out.println("8. Exportar tickets CSV");
            System.out.println("9. Salir");

            System.out.print("Seleccione opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("ID usuario: ");
                    int idUsuario = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Correo: ");
                    String correo = teclado.nextLine();

                    Usuario usuario = new Usuario(idUsuario, nombre, correo);

                    usuarioService.agregarUsuario(usuario);
                    usuarioDBService.guardarUsuario(usuario);

                    break;

                case 2:

                    usuarioService.mostrarUsuarios();

                    break;

                case 3:

                    System.out.print("ID equipo: ");
                    int idEquipo = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nombre equipo: ");
                    String nombreEquipo = teclado.nextLine();

                    System.out.print("Tipo (Notebook/PC): ");
                    String tipo = teclado.nextLine();

                    System.out.print("Estado: ");
                    String estado = teclado.nextLine();

                    Equipo equipo = new Equipo(
                            idEquipo,
                            nombreEquipo,
                            tipo,
                            estado
                    );

                    equipoService.agregarEquipo(equipo);
                    equipoDBService.guardarEquipo(equipo);

                    break;

                case 4:

                    equipoService.mostrarEquipos();

                    break;

                case 5:

                    System.out.print("ID Ticket: ");
                    int idTicket = teclado.nextInt();

                    System.out.print("ID usuario asociado: ");
                    int usuarioId = teclado.nextInt();
                    teclado.nextLine();

                    Usuario usuarioEncontrado =
                            usuarioService.buscarUsuario(usuarioId);

                    if (usuarioEncontrado == null) {

                        System.out.println("Usuario no encontrado");
                        break;
                    }

                    System.out.print("Problema: ");
                    String problema = teclado.nextLine();

                    System.out.print("Prioridad (Alta/Media/Baja): ");
                    String prioridad = teclado.nextLine();

                    Ticket ticket = new Ticket(
                            idTicket,
                            problema,
                            prioridad,
                            usuarioEncontrado
                    );

                    ticketService.agregarTicket(ticket);
                    ticketDBService.guardarTicket(ticket);

                    break;

                case 6:

                    ticketService.mostrarTickets();

                    break;

                case 7:

                    System.out.print("ID Ticket: ");
                    int cerrar = teclado.nextInt();

                    ticketService.cerrarTicket(cerrar);

                    break;

                case 8:

                    ArchivoUtil.guardarTickets(
                            ticketService.obtenerTickets()
                    );

                    System.out.println("CSV exportado correctamente.");

                    break;

                case 9:

                    ArchivoUtil.guardarTickets(
                            ticketService.obtenerTickets()
                    );

                    System.out.println("Datos guardados.");
                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 9);

        teclado.close();
    }
}