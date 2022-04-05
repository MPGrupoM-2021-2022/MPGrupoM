package mp_grupo_m;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import mp_grupo_m.Entidades.Cliente;

/**
 *
 * @author octavio
 */
public class FicheroUsuario {

   

    public void registroNuevo(Cliente cliente) {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroUsuario.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("***** USUARIO *****");
            bw.newLine();
            bw.write("NOMBRE: " + cliente.getNombre());
            bw.newLine();
            bw.write("NICK: " + cliente.getNick());
            bw.newLine();
            bw.write("PASSWORD: " + cliente.getPassword());
            bw.newLine();
            bw.write("NUMERO REGISTRO: " + cliente.getRegistro());
            bw.newLine();
            bw.close();
            
        } catch (Exception e) {
            Terminal terminal = new Terminal();
            terminal.exceptionTerminal();
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }
    
    public void leerFichero(){
        
    }
}
