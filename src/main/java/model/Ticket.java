package model;

public class Ticket {

    private int id;
    private String problema;
    private String prioridad;
    private String estado;
    private Usuario usuario;

    public Ticket(int id,
                  String problema,
                  String prioridad,
                  Usuario usuario) {

        this.id = id;
        this.problema = problema;
        this.prioridad = prioridad;
        this.usuario = usuario;
        this.estado = "Abierto";
    }

    public int getId() {
        return id;
    }

    public String getProblema() {
        return problema;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void cerrarTicket() {
        estado = "Cerrado";
    }

    public void mostrarInfo() {

        System.out.println("ID Ticket: " + id);
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Problema: " + problema);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Estado: " + estado);

        System.out.println("-------------------");
    }
}