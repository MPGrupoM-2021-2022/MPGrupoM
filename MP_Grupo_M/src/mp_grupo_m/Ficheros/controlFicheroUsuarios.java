package mp_grupo_m.Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import static javax.management.Query.lt;
import mp_grupo_m.Entidades.*;
import mp_grupo_m.Sistema;

/**
 *
 * @author octavio
 */
public class controlFicheroUsuarios {

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
            bw.write("FIN USUARIO");
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }

//    public ArrayList<Cliente> leerFichero() {
//        File archivo = null;
//        FileReader fr = null;
//        BufferedReader br = null;
//
//        try {
//            // Apertura del fichero y creacion de BufferedReader para poder
//            // hacer una lectura comoda (disponer del metodo readLine()).
//            String ruta = "src/mp_grupo_m/Ficheros/registroUsuario.txt";
//            File file = new File(ruta);
//            fr = new FileReader(file);
//            br = new BufferedReader(fr);
//
//            // Lectura del fichero
//            String linea;
//            ArrayList<Cliente> listaCliente = new ArrayList<>();
//            Cliente cliente = new Cliente();
//            while ((linea = br.readLine()) != null) {
//                if (linea.equals("***** USUARIO *****")) {
//                    linea = br.readLine();
//                    linea = br.readLine();
//                    cliente.setNombre(linea);
//                    linea = br.readLine();
//                    linea = br.readLine();
//                    cliente.setNick(linea);
//                    linea = br.readLine();
//                    linea = br.readLine();
//                    cliente.setPassword(linea);
//                    linea = br.readLine();
//                    linea = br.readLine();
//                    cliente.setRegistro(linea);
//                    //PERSONAJE
//
//                }
//                System.out.println(linea);
//            }
//
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
//        return null;
//
//    }
    public void escrituraPersonajeVampiro(Vampiro vampiro) throws IOException {
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

    public ArrayList<Cliente> lecturaFichero() {
        Cliente cliente = new Cliente();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        ArrayList<Cliente> listaCliente = new ArrayList<>();

        try {
            archivo = new File("src/mp_grupo_m/Ficheros/registroUsuario.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            String alineados;
            String nombreUsuario;

            linea = br.readLine();
            while (!linea.equals("FIN_USUARIO")) {
                linea = br.readLine();
                System.out.println(linea);
                String[] textoSeparado = linea.split(": ");

                if (textoSeparado[0].equals("NOMBRE")) {
                    cliente.setNombre(textoSeparado[1]);
                    System.out.println("HEMOS NOMBRE");
                } else if (textoSeparado[0].equals("NICK")) {
                    cliente.setNick(textoSeparado[1]);
                    System.out.println("HEMOS NICK");
                } else if (textoSeparado[0].equals("PASSWORD")) {
                    cliente.setPassword(textoSeparado[1]);
                    System.out.println("HEMOS PASSWORD");
                } else if (textoSeparado[0].equals("REGISTRO")) {
                    cliente.setRegistro(textoSeparado[1]);
                    System.out.println("HEMOS REGISTRO");
                } else if (textoSeparado[0].equals("TIPO_PERSONAJE")) {
                    if (textoSeparado[1] != null) {
                        if (textoSeparado[1].equals("VAMPIRO")) {
                            Vampiro vampiro = lecturaVampiro(br);
                            cliente.setPersonaje(vampiro);
                        } else if (textoSeparado[1].equals("LICANTROPO")) {
                            Licantropo licantropo = lecturaLicantropo(br);
                            cliente.setPersonaje(licantropo);
                        } else if (textoSeparado[1].equals("CAZADOR")) {
                            Cazador cazador = lecturaCazador(br);
                            cliente.setPersonaje(cazador);
                        }
                    } else if (textoSeparado[1] == null) {
                        System.out.println("HEMOS TERMINADO CON EL USUARIO");
                        System.out.println("AUN TE FALTA CREAR EL PERSONAJE");
                        listaCliente.add(cliente);
                    }

                }
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
        return null; //devolver la lista de cliente

    }

    private Cazador lecturaCazador(BufferedReader br) {

        return null;
    }

    private Vampiro lecturaVampiro(BufferedReader br) throws FileNotFoundException {
        Vampiro vampiro = new Vampiro();
        Disciplina disciplina = new Disciplina();
        Personaje personaje = new Personaje();
        Arma arma = new Arma();
        Armadura armadura = new Armadura();
        Fortaleza fortaleza = new Fortaleza();
        Esbirro esbirro = new Esbirro();

        File archivo = null;
        FileReader fr = null;
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        try {
            // Lectura del fichero
            String linea;
            String alineados;
            String nombreUsuario;
            linea = br.readLine();
            while (!linea.equals("FIN_USUARIO")) {
                System.out.println(linea);
                String[] textoSeparado = linea.split(": ");
                if (textoSeparado[0].equals("NOMBRE_PERSONAJE: ")) {
                    vampiro.setNombre(textoSeparado[1]);

                } else if (textoSeparado[0].equals("NOMBRE_HABILIDAD")) {
                    disciplina.setNombre(textoSeparado[1]);

                } else if (textoSeparado[0].equals("VALOR_ATAQUE")) {
                    disciplina.setAtaque(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("VALOR_DEFENSA")) {
                    disciplina.setDefensa(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("COSTE_HABILIDAD")) {
                    disciplina.setCosteSangre(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("NUMERO_ARMAS")) {
                    vampiro.getArmas().size(); //mirar esto

                } else if (textoSeparado[0].equals("NOMBRE_ARMA")) {
                    arma.setNombre(textoSeparado[1]);

                } else if (textoSeparado[0].equals("ATAQUE_ARMA")) {
                    arma.setModAtaque((textoSeparado[1]));

                } else if (textoSeparado[0].equals("DEFENSA_ARMA")) {
                    arma.setModDefensa((textoSeparado[1]));

                } else if (textoSeparado[0].equals("DEFENSA_ARMA")) {
                    arma.setModDefensa((textoSeparado[1]));

                } else if (textoSeparado[0].equals("EMPUÑADURA")) { //hay que ver esto
                    if (arma.isSingleHand() == true) {
                        textoSeparado[1] = "UNA_MANO";
                    }
                    textoSeparado[1] = "DOS_MANOS";

                } else if (textoSeparado[0].equals("NUMERO_ARMADURA")) {

                    vampiro.getArmaduras().size();

                } else if (textoSeparado[0].equals("NOMBRE_ARMADURA")) {
                    vampiro.getArmaduras().size();
                } else if (textoSeparado[0].equals("DEFENSA_ARMADURA")) {
                    armadura.setModDefensa(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("ATAQUE_ARMADURA")) {
                    armadura.setModAtaque(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("CANTIDAD_ORO")) {
                    vampiro.setOro(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("CANTIDAD_VIDA")) {
                    vampiro.setHp(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("PODER")) {
                    vampiro.setPoder(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("NUMERO_DEBILIDADES")) {
                    vampiro.getDebilidades().size();
                } else if (textoSeparado[0].equals("NOMBRE_DEBILIDADES")) {
                    vampiro.setDebilidades((textoSeparado[1]));
                } else if (textoSeparado[0].equals("VALOR_DEBILIDAD")) {
                    vampiro.getDebilidades().size();
                } else if (textoSeparado[0].equals("NUMERO_FORTALEZAS")) { //MIRAR LA DIFERENCIA CON VALOR_FORTALEZA
                    vampiro.getFortalezas().size();
                } else if (textoSeparado[0].equals("NOMBRE_FORTALEZA")) {
                    vampiro.setFortalezas((textoSeparado[1]));
                } else if (textoSeparado[0].equals("VALOR_FORTALEZA")) { //MIRAR LA DIFERENCIA CON NUMERO_FORTALEZAS
                    fortaleza.setValor(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("EDAD_VAMPIRO")) {
                    vampiro.setEdad(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("EDAD_VAMPIRO")) {
                    vampiro.setEdad(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("NUMERO_ESBIRROS")) {
                    vampiro.getEsbirros().size();
                } //FALTA METER EL TIPO DE ESBIRROS, NOMBRE ESBIRROS, VIDA ESBIRROS, DEPENDENCIA
                
                else if (textoSeparado[0].equals("TIPO_ESBIRRO")) {
                    vampiro.setTipoEsbirro((textoSeparado[1]));
                } else if (textoSeparado[0].equals("NOMBRE_ESBIRRO")) {
                    esbirro.setNombre((textoSeparado[1]));
                } else if (textoSeparado[0].equals("VIDA_ESBIRRO")) {
                    esbirro.setHp(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("DEPENDENCIA_ESBIRRO")) {
                    esbirro.setDisciplina((textoSeparado[1]));
                }
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

    private Licantropo lecturaLicantropo(BufferedReader br) {
        return null;
    }

    public void sobreescribirFichero(ArrayList<Cliente> listaClientes) {

        Cliente cliente = new Cliente();
        cliente.getPersonaje().getArmas().size(); //para saber la cantidad de armas que hay
        cliente.getPersonaje().getArmas().get(0).getNombre(); //para obtener el nombre del fichero 

        //hacer varios metodos para escibir los tipos de personajes 
        //leer a partir de una linea y palabra:
    }

}
