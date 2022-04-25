package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

}
