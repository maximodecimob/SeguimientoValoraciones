import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Serie extends Streaming implements Serializable {
    private ArrayList<Capitulo> capitulos;

    public Serie(String titulo, String director, TipoClasificacion clasificacion) throws Exception {
        super(titulo, director, clasificacion);
        this.capitulos = new ArrayList<>();
    }

    public void annadirCapitulo(int temporada, int numCapitulo, int anno, String titulo){
        try {
            Capitulo cap = new Capitulo(temporada,numCapitulo,anno,titulo);
            if(!capitulos.contains(cap)){
                if(annoInicio()<anno)capitulos.add(cap);
            }
        } catch (Exception e) {
            return;
        }
    }
    public boolean annadirValoracion(int temporada, int numCapitulos, LocalDate fecha,int valoracion){
        for(Capitulo cap:capitulos){
            if(cap.getTemporada()==temporada&&cap.getNumCapitulo()==numCapitulos&&fecha.getYear()>=cap.getAnno()){
                try {
                    cap.annadirValoracion(fecha,valoracion);
                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
    public int annoInicio(){
        Capitulo capituloBajo;
        if(!capitulos.isEmpty()) {
            capituloBajo = capitulos.getFirst();
            for (int i = 0; i < capitulos.size(); i++) {
                if(capituloBajo.getTemporada()==capitulos.get(i).getTemporada()){
                    if(capituloBajo.getNumCapitulo() >capitulos.get(i).getNumCapitulo()){
                        capituloBajo=capitulos.get(i);
                    }
                }else if (capituloBajo.getTemporada() >capitulos.get(i).getTemporada()){
                    capituloBajo=capitulos.get(i);
                }
            }
            return capituloBajo.getAnno();
        }else {
            return 0;
        }
    }
    public int numeroDeCapitulos(){
        return capitulos.size();
    }
    public double valoracionMediaTemporada(int temporada){
        int numCapitulos=0;
        double val=0;
        if(!capitulos.isEmpty()) {
            for (Capitulo cap : capitulos) {
                if (cap.getTemporada() == temporada) {
                    numCapitulos += 1;
                    if(cap.valoracionMedia()!=-1) {
                        val += cap.valoracionMedia();
                    }
                }
            }
            return val/numCapitulos;
        }
        return 0;
    }
    public ArrayList<Capitulo> capitulosValoricionMayor(int num){//Para que salga 6 tengo que poner 7
        ArrayList<Capitulo> caps = new ArrayList<>();
        for (Capitulo cap:capitulos){
            if(cap.valoracionMedia()>num){
                caps.add(cap);
            }
        }
        return caps;
    }
}
