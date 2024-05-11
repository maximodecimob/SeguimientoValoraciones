import java.io.Serializable;
import java.time.LocalDate;

public class Valoracion implements Serializable {
    private LocalDate fecha;
    private int valoracion;

    public int getValoracion() {
        return valoracion;
    }

    public Valoracion(LocalDate fecha, int valoracion) throws Exception {
        if(fecha == null||valoracion<0||valoracion>10){
            throw new Exception();
        }
        this.fecha = fecha;
        this.valoracion = valoracion;
    }
}
