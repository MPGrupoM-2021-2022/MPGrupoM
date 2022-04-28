package mp_grupo_m.Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Combate;
import mp_grupo_m.Entidades.Modificador;

/**
 *
 * @author octavio
 */
class LecturaFicheroCombate {

    public ArrayList<Combate> lecturaFicheroCombate() throws IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        ArrayList<Combate> listaCombate = new ArrayList<>();

        try {
            archivo = new File("src/mp_grupo_m/Ficheros/registroCombate.txt");
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
                Combate combate = new Combate();
                Cliente cliente = new Cliente();

                //DESAFIANTE
                textoSeparado = linea.split(": ");
                combate.setDesafiante((textoSeparado[1]));
                
                

                //CONTRINCANTE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setContrincante((textoSeparado[1]));

                //RONDAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setRondas((textoSeparado[1]));

                //FECHA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setFecha((textoSeparado[1]));

                //VENCEDOR
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setVencedor((textoSeparado[1]));

                //ESBIRRO DESAFIANTE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setEsbirrosDesafiante((textoSeparado[1]));

                //ESBIRRO CONTRINCANTE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setEsbirrosContrincante((textoSeparado[1]));

                //ORO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setOro((textoSeparado[1]));

               //MODIFICADOR
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setModificadores((textoSeparado[1]));

                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

                    Modificador modificador = new Modificador();

                    //NOMBRE 
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    modificador.setNombre(textoSeparado[1]);

                    //VALOR
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    modificador.setValor((Integer.parseInt(textoSeparado[1])));

                    combate.getModificadores().add(modificador);
                }
                listaCombate.add(combate);
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
        return listaCombate; //devolver la lista de cliente

    }
}
