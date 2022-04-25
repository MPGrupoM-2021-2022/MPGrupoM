/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Sistema;

/**
 *
 * @author octavio
 */
class LecturaFicheroOperadores {
    
    public void registroOperadores (Cliente cliente) throws IOException {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroOperadores.txt";
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
            bw.write(cliente.getNombre());
            bw.newLine();
            
            bw.write("NICK: ");
            bw.write(cliente.getNick());
            bw.newLine();
            
            bw.write("PASSWORD: ");
            bw.write(cliente.getPassword());
            bw.newLine();
            
            bw.write("FIN USUARIO");
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            Sistema sistema = new Sistema();
            e.printStackTrace();
        }
    }
    
}
