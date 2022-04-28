package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Operador;
import mp_grupo_m.Sistema;

public class EscrituraFicheroOperadores {

    public void registroOperadores(Operador operador){
        try {
            String ruta = "./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroOperador.txt";
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

    public void sobreescribirFicheroOperador(ArrayList<Operador> listaOperador){

        try {
            String ruta = "./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroOperador.txt";
            File file = new File(ruta);
            // Si el archivo no existe devuelve al menu de inicio para crear el usuario.
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            //recorre la lista de clientes
            for (int i = 0; i < listaOperador.size(); i++) {

                bw.write("***** USUARIO *****");
                bw.write("NOMBRE: ");
                bw.write(listaOperador.get(i).getNombre());
                bw.newLine();
                bw.write("NICK: ");
                bw.write(listaOperador.get(i).getNick());
                bw.newLine();
                bw.write("PASSWORD: ");
                bw.write(listaOperador.get(i).getPassword());
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
