package mp_grupo_m.Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Desafio;

/**
 *
 * @author octavio
 */
public class LecturaFicheroDesafio {

    public ArrayList<Desafio> lecturaFicheroDesafio() throws IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        ArrayList<Desafio> listaDesafio = new ArrayList<>();

        try {
            archivo = new File("src/mp_grupo_m/Ficheros/registroDesafio.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            String alineados;
            String nombreUsuario;
            linea = br.readLine();
            String[] textoSeparado = linea.split(": ");
            textoSeparado = linea.split(": ");

            linea = br.readLine();

            while (linea != null) {
                Desafio desafio = new Desafio();

                //DESAFIANTE
                textoSeparado = linea.split(": ");
                desafio.setDesafiante((textoSeparado[1]));

                //CONTRINCANTE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                desafio.setContrincante((textoSeparado[1]));

                //ORO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                desafio.setOro(Integer.parseInt(textoSeparado[1]));

                //MODIFICADOR
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                desafio.setModificadores((textoSeparado[1]));
                
                //VALIDADO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                if (textoSeparado[1].equals("true")) {
                        desafio.setValidated(true);
                    } else {
                        desafio.setValidated(false);
                    }

                listaDesafio.add(desafio);
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
        return listaDesafio; //devolver la lista de cliente

    }

}
