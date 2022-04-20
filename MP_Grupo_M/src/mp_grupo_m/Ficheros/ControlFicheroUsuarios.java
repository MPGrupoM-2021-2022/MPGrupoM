package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.*;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

/**
 *
 * @author octavio
 */
public class ControlFicheroUsuarios {

    Sistema sistema = new Sistema();
    Terminal terminal = new Terminal();
    LecturaFicheroUsuario lecturaFicheroUsuario = new LecturaFicheroUsuario();

    public void registroUsuario(Cliente cliente) throws IOException {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroUsuario.txt";
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
            bw.newLine();
            bw.write(cliente.getNombre());
            bw.newLine();
            bw.write("NICK: ");
            bw.newLine();
            bw.write(cliente.getNick());
            bw.newLine();
            bw.write("PASSWORD: ");
            bw.newLine();
            bw.write(cliente.getPassword());
            bw.newLine();
            bw.write("REGISTRO: ");
            bw.newLine();
            bw.write(cliente.getRegistro());
            bw.newLine();
            bw.write("TIPO_PERSONAJE: null");
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

    public void registroPersonaje(ArrayList<Cliente> listaCliente) throws IOException {
        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroUsuario.txt";
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

            //sobreescribir el fichero
            //PRIMERO LEEMOS EL FICHERO
            //SELECCIONAMOS LA LINEA POR LA QUE DEBEMOS DE ESCRIBIR A PARTIR DE "TIPO_USUARIO"
            //numero de registro 
            //recorre la lista de clientes
            for (int i = 0; i < listaCliente.size(); i++) {

                bw.write("***** USUARIO *****");
                bw.newLine();
                bw.write("NOMBRE: ");
                bw.newLine();
                bw.write(listaCliente.get(i).getNombre());
                bw.newLine();
                bw.write("NICK: ");
                bw.newLine();
                bw.write(listaCliente.get(i).getNick());
                bw.newLine();
                bw.write("PASSWORD: ");
                bw.newLine();
                bw.write(listaCliente.get(i).getPassword());
                bw.newLine();
                bw.write("REGISTRO: ");
                bw.newLine();
                bw.write(listaCliente.get(i).getRegistro());
                bw.newLine();

                String tipoPersonaje = listaCliente.get(i).getPersonaje().getTipo();
                if (tipoPersonaje == null) {
                    
                    bw.write("TIPO_PERSONAJE: null");
                    bw.newLine();

                } else if (tipoPersonaje.equals("VAMPIRO")) {
                    Vampiro vampiro = (Vampiro) listaCliente.get(i).getPersonaje();
                    Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
                                        
                    bw.write("TIPO_PERSONAJE: ");
                    bw.newLine();
                    bw.write(listaCliente.get(i).getPersonaje().getTipo());
                    bw.newLine();
                    
                    bw.write("NOMBRE_PERSONAJE: ");
                    bw.newLine();
                    bw.write(listaCliente.get(i).getPersonaje().getNombre());
                    bw.newLine();
                    
                    bw.write("VALOR_ATAQUE: ");
                    bw.newLine();
                    bw.write(disciplina.getAtaque());
                    bw.newLine();
                    
                    bw.write("VALOR_DEFENSA: ");
                    bw.newLine();
                    bw.write(disciplina.getDefensa());
                    bw.newLine();
                    
                    bw.write("VALOR_ATAQUE: ");
                    bw.newLine();
                    bw.write(disciplina.getAtaque());
                    bw.newLine();
                    
                     bw.write("COSTE_HABILIDAD: ");
                    bw.newLine();
                    bw.write(disciplina.getCoste());
                    bw.newLine();
                    
                     bw.write("VALOR_ATAQUE: ");
                    bw.newLine();
                    bw.write(disciplina.getAtaque());
                    bw.newLine();
                    
                    
                    bw.newLine();
                }
            }

        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }

    public void escrituraPersonajeVampiro(Vampiro vampiro) throws IOException {
        //hacer una copia entera del fichero y luego copiar con los datos del personaje
        Personaje personaje = new Personaje();

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroUsuario.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("TIPO_PERSONAJE: ");
            bw.newLine();
            bw.write(vampiro.getTipo());
            bw.newLine();

            bw.write("NOMBRE PERSONAJE: ");
            bw.newLine();
            bw.write(personaje.getNombre());
            bw.newLine();

            bw.write("NOMBRE_HABILIDAD: ");
            bw.newLine();
            bw.write(habilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_ATAQUE: ");
            bw.newLine();
            bw.write(habilidad.getAtaque());
            bw.newLine();

            bw.write("NOMBRE_HABILIDAD: ");
            bw.newLine();
            bw.write(dis.getNombre());
            bw.newLine();

            bw.newLine();
            bw.close();

        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }

    }

    public void escrituraPersonajeCazador(Cliente cliente) {
    }

    public void escrituraPersonajeLicantropo(Cliente cliente) {
    }

    public void sobreescribirFichero(ArrayList<Cliente> listaClientes) {

        Cliente cliente = new Cliente();
        cliente.getPersonaje().getArmas().size(); //para saber la cantidad de armas que hay
        cliente.getPersonaje().getArmas().get(0).getNombre(); //para obtener el nombre del fichero 

        //hacer varios metodos para escibir los tipos de personajes 
        //leer a partir de una linea y palabra:
    }

}
