import java.io.Serializable;

public abstract class Streaming implements Serializable {
    private String titulo;
    private String director;
    private TipoClasificacion clasificacion;

    public Streaming(String titulo, String director, TipoClasificacion clasificacion) throws Exception {
        if(titulo.isEmpty()||director.isEmpty()||clasificacion==null){
            throw new Exception();
        }
        this.titulo = titulo;
        this.director = director;
        this.clasificacion = clasificacion;
    }
}
