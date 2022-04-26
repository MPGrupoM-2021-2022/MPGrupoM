package mp_grupo_m.Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Operador;
import mp_grupo_m.Sistema;

/**
 *
 * @author octavio
 */
class LecturaFicheroBaneados {

    public ArrayList<Cliente> lecturaFicheroBaneados() throws IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        ArrayList<Cliente> listaBaneados = new ArrayList<>();

        try {
            archivo = new File("src/mp_grupo_m/Ficheros/registroBaneados.txt");
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
                Cliente cliente = new Cliente();

                //NOMBRE
                textoSeparado = linea.split(": ");
                cliente.setNombre(textoSeparado[1]);

                //NICK
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente.setNick(textoSeparado[1]);

                //PASSWORD
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente.setPassword(textoSeparado[1]);

                listaBaneados.add(cliente);
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
        return listaBaneados; //devuelve la lista del operador

    }
}

