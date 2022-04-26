package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Operador;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

/**
 *
 * @author octavio
 */
public class ControlFicheroBaneados {

    Sistema sistema = new Sistema();
    Terminal terminal = new Terminal();
    LecturaFicheroOperador lecturaFicheroOperadores = new LecturaFicheroOperador();

    public void registroBaneado(Cliente cliente) throws IOException {
        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroBaneos.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("***** USUARIO *****");
            bw.newLine();
            bw.write("NICK: ");
            bw.write(cliente.getNick());
            bw.newLine();
            bw.write("FIN USUARIO");
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }

    public void sobreescribirFicheroBaneado (ArrayList<Operador> listaBaneados) throws IOException {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroBaneos.txt";
            File file = new File(ruta);
            // Si el archivo no existe devuelve al menu de inicio para crear el usuario. 
            if (!file.exists()) {
                System.out.println("El fichero no existe.");
                System.out.println("No se permite el registro del nuevo personaje.");
                terminal.mostrarInicio();
                sistema.selector();
            }
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            //recorre la lista de clientes
            for (int i = 0; i < listaBaneados.size(); i++) {

                bw.write("***** USUARIO *****");
                bw.write("NICK: ");
                bw.write(listaBaneados.get(i).getNick());
                bw.newLine();
                bw.write("FIN USUARIO");
                bw.newLine();
                bw.close();
            }
        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }

}
