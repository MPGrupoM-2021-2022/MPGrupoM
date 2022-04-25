
package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import mp_grupo_m.Entidades.Operador;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

/**
 *
 * @author octavio
 */
public class ControlFicheroOperador {
    
    Sistema sistema = new Sistema();
    Terminal terminal = new Terminal();
    LecturaFicheroOperador lecturaFicheroOperadores = new LecturaFicheroOperador();
    
       public void registroOperadores(Operador operador) throws IOException {
        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroOperador.txt";
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
            bw.write("NOMBRE: ");
            bw.write(operador.getNombre());
            bw.newLine();
            bw.write("NICK: ");
            bw.write(operador.getNick());
            bw.newLine();
            bw.write("PASSWORD: ");
            bw.write(operador.getPassword());
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
}
