import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pelicula extends Streaming implements Serializable {
    private int ano;
    private ArrayList<Valoracion> valoracion;

    public Pelicula(String titulo, String director, TipoClasificacion clasificacion, int ano) throws Exception {
        super(titulo, director, clasificacion);
        if(ano<0)throw new Exception();
        this.ano = ano;
        this.valoracion = new ArrayList<>();
    }

    public void annadirValoracion(LocalDate fecha, int valoracion) throws Exception {
        Valoracion val = new Valoracion(fecha,valoracion);
        this.valoracion.add(val);
    }
}
