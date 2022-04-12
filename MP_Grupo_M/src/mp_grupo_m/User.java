package mp_grupo_m;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import static java.lang.Math.random;
import java.util.Random;

// link tutorial uso de ficheros
// https://www.ecodeup.com/como-escribir-y-leer-archivos-de-texto-plano-en-java/
import static java.lang.Math.random;
import mp_grupo_m.Entidades.Cliente;

public class User {

    Terminal terminal = new Terminal();

    public void selector() {

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                Cliente cliente = new Cliente();
                cliente.setNombre("Pepe");
                String nombre = cliente.getNombre();
                
                //crear un nuevo registro
                crearFichero(cliente);

            case 2:
                //VOLVER ATRÁS
                System.out.println("segunda opcion de crear usuario");
                terminal.WIP();

            default:
                terminal.WIP();

        }
    }

    private void crearFichero(Cliente cliente)  {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroUsuario.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            String nombreUsuario;
            String nick;
            String password;
            //comprobar el numero de usuario para crearlo justo debajo
            // IDEA: con length() y el numero de linea.
            int numeroUsuario = 0;

            bw.write("***** USUARIO Nº" + numeroUsuario + 1 + " *****");
            System.out.println("USUARIO Nº" + numeroUsuario);
            bw.newLine();
            
            Scanner scannerNombre = new Scanner(System.in);
            System.out.println("Nombre: ");
            nombreUsuario = scannerNombre.nextLine();
            bw.write("Nombre: " + cliente.getNombre());
            bw.newLine();

            scannerNombre = new Scanner(System.in);
            System.out.println("Nombre: ");
            nombreUsuario = scannerNombre.nextLine();
            bw.write("Nombre: " + nombreUsuario);
            bw.newLine();

            Scanner scannerNick = new Scanner(System.in);
            System.out.println("Nick: ");
            nick = scannerNick.nextLine();
            bw.write("Nick: " + nick);
            bw.newLine();

            Scanner scannerPassword = new Scanner(System.in);
            System.out.println("Password: ");
            password = scannerPassword.nextLine();
            bw.write("Password: " + password);
            System.out.println("Password:");
            bw.newLine();

            bw.write("Registro: " + generarNumerRegistro());
            bw.newLine();

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// LNNLL
    private char[] generarNumerRegistro() {
        char[] cadena = new char[5];
        cadena[0] = (getLetra());
        cadena[1] = (getNumber());
        cadena[2] = (getNumber());
        cadena[3] = (getLetra());
        cadena[4] = (getLetra());
        return cadena;
    }

    public char getLetra() {
        char paramChar = (char) (Math.random() * 26 + 'a');
        System.out.print(paramChar);
        return paramChar;
    }

    public char getNumber() {
        int N = (int) (Math.random() * 10);
        return (char) N;
    }

}
