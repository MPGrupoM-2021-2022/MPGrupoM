package mp_grupo_m.Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Operador;

public class LecturaFicheroOperadores {

    public ArrayList<Operador> lecturaFicheroOperador() {

        FileReader fr = null;
        ArrayList<Operador> listaOperador = new ArrayList<>();

        try {
            File archivo = new File("src/mp_grupo_m/Ficheros/registroOperador.txt");
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            // Lectura del fichero
            String linea = br.readLine();
            String[] textoSeparado;

            linea = br.readLine();

            while (linea != null) {
                Operador operador = new Operador();

                //NOMBRE
                textoSeparado = linea.split(": ");
                operador.setNombre(textoSeparado[1]);

                //NICK
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                operador.setNick(textoSeparado[1]);

                //PASSWORD
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                operador.setPassword(textoSeparado[1]);

                listaOperador.add(operador);
                linea = br.readLine();
                linea = br.readLine();
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
        return listaOperador; //devolver la lista de cliente

    }


}
