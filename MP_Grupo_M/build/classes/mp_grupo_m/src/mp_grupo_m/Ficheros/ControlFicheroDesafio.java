package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Desafio;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

/**
 *
 * @author octavio
 */
public class ControlFicheroDesafio {

    Sistema sistema = new Sistema();
    Terminal terminal = new Terminal();
    LecturaFicheroDesafio lecturaFicheroDesafio = new LecturaFicheroDesafio();

    public void registroDesafio(Desafio desafio) throws IOException {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroDesafio.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("***** DESAFIO *****");
            bw.newLine();
            bw.write("DESAFIANTE: ");
            bw.write(desafio.getDesafiante().getNombre());
            bw.newLine();
            
            bw.write("CONTRINCANTE: ");
            bw.write(desafio.getContrincante().getNumber());
            bw.newLine();
            
            bw.write("ORO: ");
            bw.write(desafio.getOro());
            bw.newLine();

            bw.write("MODIFICADOR: ");
            bw.write(desafio.getModificadores().size());
            bw.newLine();
            
            bw.write("VALIDADO: ");
            if (desafio.isValidated()){
                bw.write("true");
            } else {
                bw.write("false");
            }
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
    
    
    public void sobreescribirFicheroDesafio (ArrayList<Desafio> listaDesafio) throws IOException {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroDesafio.txt";
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
            for (int i = 0; i < listaDesafio.size(); i++) {

               bw.write("***** DESAFIO *****");
            bw.newLine();
            bw.write("DESAFIANTE: ");
            bw.write(listaDesafio.get(i).getDesafiante().getNombre());
            bw.newLine();
            
            bw.write("CONTRINCANTE: ");
            bw.write(listaDesafio.get(i).getContrincante().getNumber());
            bw.newLine();
            
            bw.write("ORO: ");
            bw.write(listaDesafio.get(i).getOro());
            bw.newLine();

            bw.write("MODIFICADOR: ");
            bw.write(listaDesafio.get(i).getModificadores().size());
            bw.newLine();
            
            bw.write("VALIDADO: ");
            if (listaDesafio.get(i).isValidated()){
                bw.write("true");
            } else {
                bw.write("false");
            }
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
