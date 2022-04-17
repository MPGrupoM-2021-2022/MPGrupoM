package mp_grupo_m;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Personaje;

/**
 *
 * @author octavio
 */
public class RegistroFichero {

    // METODO PARA LEER EL ARCHIVO Y HACER LA BUSQUEDA
//    public static void buscarPalabra() throws FileNotFoundException {
//
//        FileReader fr = new FileReader("src/mp_grupo_m/Ficheros/registroUsuario.txt");
//        BufferedReader br = new BufferedReader(fr);
//        String nombreUsuario = ("NOMBRE: ");
//        String nickUsuario = ("NICK: ");
//
//        try {
//            // Apertura del fichero y creacion de BufferedReader para poder hacer una lectura comoda (disponer del metodo readLine()).
//            File archivo = new File("src/mp_grupo_m/Ficheros/registroUsuario.txt");
//            fr = new FileReader(archivo);
//            br = new BufferedReader(fr);
//            Scanner entrada = new Scanner(archivo);
//
//            while ( // Lectura del fichero
//                    String   {
//                linea;
//            }
//            while ((linea = br.readLine()) != null) {
//                System.out.println(linea);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // En el finally cerramos el fichero, para asegurarnos
//            // que se cierra tanto si todo va bien como si salta 
//            // una excepcion.
//            try {
//                if (null != fr) {
//                    fr.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//    }

//        try {
//            do {
//                File file = new File("src/mp_grupo_m/Ficheros/registroUsuario.txt");
//                FileReader fr = new FileReader(file);
//                BufferedReader br = new BufferedReader(fr);
//                String linea = br.readLine();
//                
//                
//                String nombreUsuario = null;
//                String nickUsuario = null;
//                String passwordUsuario = null;
//                String registroUsuario = null;
//                
//                String [] nombreUsuario = fr.("NOMBRE: ");
//
//                String linea = "";
//                boolean encontrado = false;
//                while ((linea = fr.read()) != null) {
//
//                    if (linea.equalsIgnoreCase("NOMBRE: ")) {
//                        linea = nombreUsuario; 
//                        System.out.println(linea);
//
//                        for (int i = 0; i < 2; i++) {
//                            System.out.println(br.readLine());
//                        }
//                        encontrado = true;
//                        break;
//
//                    }
//
//                }
//
//                if (!encontrado) {
//                    System.out.println("El usuario no existe");
//                }
//
//                System.out.println("¿Quieres introducir otro nombre?");
//                respuesta = sc.nextLine();
//
//            } while (respuesta.equalsIgnoreCase("si"));
//        } catch (IOException e) {
//
//            System.out.println("Error");
//        }
//    }
    public static void registroPersonaje(Cliente cliente, Personaje personaje) throws IOException {

        String respuesta;

        FileReader fl = new FileReader("src/mp_grupo_m/Ficheros/registroUsuario.txt");
        String numeroUsuario = "***** USUARIO  " + fl.read() + " *****";
        System.out.println(numeroUsuario);
//        buscarPalabra();

    }

    public void registroUsuario(Cliente cliente, Personaje personaje) throws IOException {

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

            bw.write("***** USUARIO "+ cliente.getNumeroUsuario() +" *****");
            bw.newLine();

            bw.write("NOMBRE: " + cliente.getNombre());
            bw.newLine();
            
            bw.write("NICK: " + cliente.getNick());
            bw.newLine();
            
            bw.write("PASSWORD: " + cliente.getPassword());
            bw.newLine();
            
            bw.write("REGISTRO: " + cliente.getRegistro());
            bw.newLine();
            
            bw.write("NOMBRE PERSONAJE: " + personaje.getNombre());
            bw.newLine();

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

    public ArrayList<Cliente> leerFichero() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            String ruta = "src/mp_grupo_m/Ficheros/registroUsuario.txt";
            File file = new File(ruta);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            ArrayList<Cliente> listaCliente = new ArrayList<>();
            Cliente cliente = new Cliente();
            while ((linea = br.readLine()) != null) {
                if (linea.equals("***** USUARIO *****")) {
                    linea = br.readLine();
                    linea = br.readLine();
                    cliente.setNombre(linea);
                    linea = br.readLine();
                    linea = br.readLine();
                    cliente.setNick(linea);
                    linea = br.readLine();
                    linea = br.readLine();
                    cliente.setPassword(linea);
                    linea = br.readLine();
                    linea = br.readLine();
                    cliente.setRegistro(linea);
                    //PERSONAJE

                }
                System.out.println(linea);
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
        return null;

    }

    public void sobreescribirFichero(ArrayList<Cliente> listaClientes) {

        Cliente cliente = new Cliente();
        cliente.getPersonaje().getArmas().size(); //para saber la cantidad de armas que hay
        cliente.getPersonaje().getArmas().get(0).getNombre(); //para obtener el nombre del fichero 

        //hacer varios metodos para escibir los tipos de personajes 
        //leer a partir de una linea y palabra:
    }

    public void personajeVampiro(Cliente cliente, Personaje personaje) throws IOException {
        //hacer una copia entera del fichero y luego copiar con los datos del personaje

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

            bw.write("NUMERO REGISTRO: ");
            bw.newLine();
            bw.write(cliente.getRegistro());
            bw.newLine();

            bw.write("PERSONAJE: ");
            bw.newLine();
            bw.write("null");
            bw.newLine();

            bw.write("NOMBRE PERSONAJE: ");
            bw.newLine();
            bw.write(personaje.getNombre());
            bw.newLine();

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

    public void personajeCazador(Cliente cliente) {

    }

    public void personajeLicantropo(Cliente cliente) {

    }

}
