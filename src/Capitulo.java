import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Capitulo implements Serializable {
    private int temporada;
    private int numCapitulo;
    private int anno;
    private String titulo;
    private ArrayList<Valoracion> valoracion;

    public Capitulo(int temporada, int numCapitulo, int anno, String titulo) throws Exception {
        if(titulo.isEmpty()||temporada<1||numCapitulo<1||anno<0)throw new Exception();
        this.temporada = temporada;
        this.numCapitulo = numCapitulo;
        this.anno = anno;
        this.titulo = titulo;
    }

    public int getTemporada() {
        return temporada;
    }

    public int getAnno() {
        return anno;
    }

    public int getNumCapitulo() {
        return numCapitulo;
    }
    public void annadirValoracion(LocalDate fecha, int valoracion) throws Exception {
            Valoracion val = new Valoracion(fecha,valoracion);
            this.valoracion.add(val);
    }
    public double valoracionMedia(){
        double valMedia=0;
        if(!valoracion.isEmpty()) {
            for (Valoracion val : valoracion) {
                valMedia += val.getValoracion();
            }
            valMedia /= valoracion.size();
        }else{
            return -1;
        }
        return valMedia;
    }
    public double valoracionMax(){
        double valMax=0;
        if(!valoracion.isEmpty()) {
            for (Valoracion val : valoracion) {
                if(valMax<val.getValoracion())
                valMax = val.getValoracion();
            }
        }
        return valMax;
    }
}
