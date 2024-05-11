import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/*
  Añadir Valoracion:
   Descripción de la función:
       La función lo que realiza es una operación de añadir la valoración
       a las valoraciones del capítulo si la fecha es posterior a la de valoración.
       precondiciones:
           -   Capitulo existe
           -   valoración entre 0 y 10
           -   fecha en formato válido
       postcondiciones:
           - Valoración añadida con los datos proporcionados a el arraylist de
           valoraciones del capítulo y tiene que devolver true y que la fecha es posterior a la de emision del capítulo
 */
public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Streaming> streamings = new ArrayList<>();
            streamings.add(new Pelicula("Torrente","Di caprio",TipoClasificacion.MAYORES,1990));
            FileOutputStream file = new FileOutputStream("miMediateca.sup");
            ObjectOutputStream archivo = new ObjectOutputStream(file);
            archivo.writeObject(streamings);
            archivo.close();
        } catch (Exception e){
            System.out.println("Error con el archivo");
        }

    }
}

