package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import mp_grupo_m.Entidades.Arma;
import mp_grupo_m.Entidades.Combate;
import mp_grupo_m.Sistema;

/**
 *
 * @author octavio
 */
public class EscrituraFicheroCombate {
    
    public void registroDesafio(Combate combate) throws IOException {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroCombate.txt";
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
            bw.write(combate.getDesafiante().getNombre());
            bw.newLine();
            
            //USUARIO
            escribirusuarioCombate();
           
            bw.write("CONTRINCANTE: ");
            bw.write(combate.getContrincante().getNombre());
            bw.newLine();
            escribirusuarioCombate();
            
            bw.write("RONDAS: ");
            bw.write(combate.getRondas().size());
            bw.newLine();
            
            bw.write("FECHA: ");
            bw.write(combate.getFecha().toString());
            bw.newLine();
            
            bw.write("VENCEDOR: ");
            bw.write(combate.getVencedor().getNombre());
            bw.newLine();
            
            //ESBIRRO DESAFIANTE
            bw.write("ESBIRRO_DESAFIANTE: ");
            if(combate.isEsbirrosDesafiante()){
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
            
            //ESBIRRO CONTRINCANTE
            bw.write("ESBIRRO_CONTRINCANTE: ");
            if(combate.isEsbirrosContrincante()){
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();            
            
            bw.write("ORO: ");
            bw.write(combate.getOro());
            bw.newLine();

            bw.write("MODIFICADOR: ");
            bw.write(combate.getModificadores().size());
            bw.newLine();
            
            bw.write("REGISTRO: ");
            bw.write(combate.getRegistro());
            bw.newLine();
            
            bw.write("VISTO: ");
            if(combate.isVisto()){
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
            
               
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

    private void escribirusuarioCombate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
