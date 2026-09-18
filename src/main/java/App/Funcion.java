package App;

public class Funcion {
    private Pelicula pelicula;
    private String horario;

    public Funcion(Pelicula pelicula, String horario) {
        this.pelicula = pelicula;
        this.horario = horario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }
}
