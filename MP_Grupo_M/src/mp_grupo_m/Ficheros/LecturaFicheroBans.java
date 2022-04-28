package mp_grupo_m.Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LecturaFicheroBans {

    public ArrayList<String> lecturaFicheroBaneados(){

        FileReader fr = null;
        ArrayList<String> listaBaneados = new ArrayList<>();

        try {
            File archivo = new File("./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroBaneados.txt");
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            linea = br.readLine();

            while (linea != null) {
                listaBaneados.add(linea);
                linea = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return listaBaneados; //devuelve la lista del operador

    }
}
