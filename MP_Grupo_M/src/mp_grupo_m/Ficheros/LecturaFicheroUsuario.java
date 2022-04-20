package mp_grupo_m.Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Arma;
import mp_grupo_m.Entidades.Armadura;
import mp_grupo_m.Entidades.Cazador;
import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Debilidad;
import mp_grupo_m.Entidades.Demonio;
import mp_grupo_m.Entidades.Disciplina;
import mp_grupo_m.Entidades.Esbirro;
import mp_grupo_m.Entidades.Fortaleza;
import mp_grupo_m.Entidades.Ghoul;
import mp_grupo_m.Entidades.Humano;
import mp_grupo_m.Entidades.Licantropo;
import mp_grupo_m.Entidades.Personaje;
import mp_grupo_m.Entidades.Vampiro;

/**
 *
 * @author octavio
 */
public class LecturaFicheroUsuario {

    public ArrayList<Cliente> lecturaFicheroUsuario() throws IOException {
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

                //NOMBRE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente.setNombre(textoSeparado[1]);

                //NICK
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente.setNick(textoSeparado[1]);

                //PASSWORD
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente.setPassword(textoSeparado[1]);

                //NUMERO_REGISTRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente.setRegistro(textoSeparado[1]);

                //NUMERO_REGISTRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");

                if (textoSeparado[1] != null) {
                    //LECTURA SI ES DE TIPO VAMPIRO
                    if (textoSeparado[1].equals("VAMPIRO")) {
                        Vampiro vampiro = lecturaVampiro(br);
                        cliente.setPersonaje(vampiro);
                        //LECTURA SI ES DE TIPO LICANTROPO
                    } else if (textoSeparado[1].equals("LICANTROPO")) {
                        Licantropo licantropo = lecturaLicantropo(br);
                        cliente.setPersonaje(licantropo);
                        //LECTURA SI ES DE TIPO CAZADOR
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
        return listaCliente; //devolver la lista de cliente

    }

    private Vampiro lecturaVampiro(BufferedReader br) throws FileNotFoundException, IOException {
        Vampiro vampiro = new Vampiro();
        Disciplina disciplina = new Disciplina();

        File archivo = null;
        FileReader fr = null;
        ArrayList<Cliente> listaVampiro = new ArrayList<>();
        try {
            // Lectura del fichero
            String linea;
            String alineados;
            String nombreUsuario;
            linea = br.readLine();

            while (!linea.equals("FIN_USUARIO")) {

                //TIPO USUARIO
                linea = br.readLine();
                System.out.println(linea);
                String[] textoSeparado = linea.split(": ");
                vampiro.setTipo(textoSeparado[1]);

                //NOMBRE VAMPIRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setNombre(textoSeparado[1]);

                //NOMBRE HABILIDAD
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                disciplina.setNombre(textoSeparado[1]);

                //VALOR ATAQUE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                disciplina.setAtaque(Integer.parseInt(textoSeparado[1]));

                //VALOR DEFENSA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                disciplina.setDefensa(Integer.parseInt(textoSeparado[1]));

                //COSTE HABILIDAD
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                disciplina.setCoste(Integer.parseInt(textoSeparado[1]));

                vampiro.setHabilidad(disciplina);

                //NUMERO DE ARMAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

                    Arma arma = new Arma();

                    //NOMBRE ARMA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setNombre(textoSeparado[1]);

                    //NIVEL ATAQUE ARMA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setModAtaque((Integer.parseInt(textoSeparado[1])));

                    //NIVEL DEFENSA ARMA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setModDefensa((Integer.parseInt(textoSeparado[1])));

                    //EMPUÑADURA DE ARMA: si es de 1 o 2 manos
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    if (textoSeparado[1].equals("true")) {
                        arma.setSingleHand(true);
                    } else {
                        arma.setSingleHand(false);
                    }

                    vampiro.getArmas().add(arma);
                }

                //NUMERO DE ARMAS ACTIVAS
                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

                    Arma arma = new Arma();

                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setNombre(textoSeparado[1]);

                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setModAtaque((Integer.parseInt(textoSeparado[1])));

                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setModDefensa((Integer.parseInt(textoSeparado[1])));

                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    if (textoSeparado[1].equals("true")) {
                        arma.setSingleHand(true);
                    } else {
                        arma.setSingleHand(false);
                    }
                    vampiro.getArmasActivas().add(arma);
                }

                //ARMADURAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

                    Armadura armadura = new Armadura();

                    //NOMBRE ARMA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    armadura.setNombre(textoSeparado[1]);

                    //NIVEL DEFENSA ARMA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    armadura.setModDefensa((Integer.parseInt(textoSeparado[1])));

                    //NIVEL ATAQUE ARMA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    armadura.setModAtaque((Integer.parseInt(textoSeparado[1])));

                    vampiro.getArmaduras().add(armadura);
                }

                //ARMADURA ACTIVA
                linea = br.readLine();
                textoSeparado = linea.split(": ");

                Armadura armadura = new Armadura();

                //NOMBRE ARMADURA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                armadura.setNombre(textoSeparado[1]);

                //NIVEL DEFENSA ARMA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                armadura.setModDefensa((Integer.parseInt(textoSeparado[1])));
                //NIVEL ATAQUE ARMA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                armadura.setModAtaque((Integer.parseInt(textoSeparado[1])));

                vampiro.setArmaduraActiva(armadura);

                //CANTIDAD ORO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setOro(Integer.parseInt(textoSeparado[1]));

                //CANTIDAD VIDA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setHp(Integer.parseInt(textoSeparado[1]));

                //PODER 
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setPoder(Integer.parseInt(textoSeparado[1]));

                // NUMERO DE DEBILIDADES
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

                    Debilidad debilidad = new Debilidad();

                    //NOMBRE DE DEBILIADAD
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    debilidad.setNombre((textoSeparado[1]));

                    //VALOR DEBILIDAD
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    debilidad.setValor((Integer.parseInt(textoSeparado[1])));

                    vampiro.getDebilidades().add(debilidad);
                }

                // FORTALEZAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

                    Fortaleza fortaleza = new Fortaleza();

                    //NOMBRE FORTALEZA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    fortaleza.setNombre(textoSeparado[1]);

                    //VALOR FORTALEZA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    fortaleza.setValor((Integer.parseInt(textoSeparado[1])));

                    vampiro.getFortalezas().add(fortaleza);
                }

                //EDAD VAMPIRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setEdad(Integer.parseInt(textoSeparado[1]));

                // ESBIRROS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {
                    Esbirro esbirro = new Esbirro();
                    Humano humano = new Humano();
                    Ghoul ghoul = new Ghoul();
                    Demonio demonio = new Demonio();

                    if (textoSeparado[1].equals("HUMANO")) { //BORRAR PARA VAMPIROS

                        //TIPO ESBIRRO
                        humano.setTipo(textoSeparado[1]);

                        //NOMBRE ESBIRRO
                        linea = br.readLine();
                        textoSeparado = linea.split(": ");
                        humano.setNombre(textoSeparado[1]);

                        //VIDA ESBIRRO
                        linea = br.readLine();
                        textoSeparado = linea.split(": ");
                        humano.setHp((Integer.parseInt(textoSeparado[1])));

                        //VALOR LEALTAD     SE HARIA CON UN STRING PORQUE PUEDE SER DE TRES TIPOS ALTA, MEDIO, BAJO
                        linea = br.readLine();
                        textoSeparado = linea.split(": ");
                        humano.setLealtad(((textoSeparado[1])));

                    } else if (textoSeparado[1].equals("GHOULS")) {
                        //TIPO ESBIRRO
                        ghoul.setTipo(textoSeparado[1]);

                        //NOMBRE ESBIRRO
                        linea = br.readLine();
                        textoSeparado = linea.split(": ");
                        ghoul.setNombre(textoSeparado[1]);

                        //VIDA ESBIRRO
                        linea = br.readLine();
                        textoSeparado = linea.split(": ");
                        ghoul.setHp((Integer.parseInt(textoSeparado[1])));

                        //DEPENDENCIA
                        linea = br.readLine();
                        textoSeparado = linea.split(": ");
                        ghoul.setDependencia((Integer.parseInt(textoSeparado[1])));

                    } else if (textoSeparado[1].equals("DEMONIOS")) {
                        //TIPO ESBIRRO
                        demonio.setTipo(textoSeparado[1]);

                        //NOMBRE ESBIRRO
                        linea = br.readLine();
                        textoSeparado = linea.split(": ");
                        demonio.setNombre(textoSeparado[1]);

                        //VIDA ESBIRRO
                        linea = br.readLine();
                        textoSeparado = linea.split(": ");
                        demonio.setHp((Integer.parseInt(textoSeparado[1])));

                        //DESCRIPCION
                        linea = br.readLine();
                        textoSeparado = linea.split(": ");
                        demonio.setDescripcion(textoSeparado[1]);
                    }
                }
                vampiro.getEsbirros();
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
        return vampiro;

    }

    private Cazador lecturaCazador(BufferedReader br) throws FileNotFoundException {
        Cazador cazador = new Cazador();
        Disciplina disciplina = new Disciplina();
        Personaje personaje = new Personaje();
        Arma arma = new Arma();
        Armadura armadura = new Armadura();
        Fortaleza fortaleza = new Fortaleza();
        Esbirro esbirro = new Esbirro();

        File archivo = null;
        FileReader fr = null;
        ArrayList<Cliente> listaCazador = new ArrayList<>();
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
                    cazador.setNombre(textoSeparado[1]);

                } else if (textoSeparado[0].equals("NOMBRE_HABILIDAD")) {
                    disciplina.setNombre(textoSeparado[1]);

                } else if (textoSeparado[0].equals("VALOR_ATAQUE")) {
                    disciplina.setAtaque(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("VALOR_DEFENSA")) {
                    disciplina.setDefensa(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("COSTE_HABILIDAD")) {
                    disciplina.setCosteSangre(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("NUMERO_ARMAS")) {
                    cazador.getArmas().size(); //mirar esto

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
                    cazador.getArmaduras().size();
                } else if (textoSeparado[0].equals("NOMBRE_ARMADURA")) {
                    cazador.getArmaduras().size();
                } else if (textoSeparado[0].equals("DEFENSA_ARMADURA")) {
                    armadura.setModDefensa(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("ATAQUE_ARMADURA")) {
                    armadura.setModAtaque(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("CANTIDAD_ORO")) {
                    cazador.setOro(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("CANTIDAD_VIDA")) {
                    cazador.setHp(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("PODER")) {
                    cazador.setPoder(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("NUMERO_DEBILIDADES")) {
                    cazador.getDebilidades().size();
                } else if (textoSeparado[0].equals("NOMBRE_DEBILIDADES")) {
                    cazador.setDebilidades((textoSeparado[1]));
                } else if (textoSeparado[0].equals("VALOR_DEBILIDAD")) {
                    cazador.getDebilidades().size();
                } else if (textoSeparado[0].equals("NUMERO_FORTALEZAS")) { //MIRAR LA DIFERENCIA CON VALOR_FORTALEZA
                    cazador.getFortalezas().size();
                } else if (textoSeparado[0].equals("NOMBRE_FORTALEZA")) {
                    cazador.setFortalezas((textoSeparado[1]));
                } else if (textoSeparado[0].equals("VALOR_FORTALEZA")) { //MIRAR LA DIFERENCIA CON NUMERO_FORTALEZAS
                    fortaleza.setValor(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("EDAD_VAMPIRO")) {
                    cazador.setEdad(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("EDAD_VAMPIRO")) {
                    cazador.setEdad(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("NUMERO_ESBIRROS")) {
                    cazador.getEsbirros().size();
                } //FALTA METER EL TIPO DE ESBIRROS, NOMBRE ESBIRROS, VIDA ESBIRROS, DEPENDENCIA
                else if (textoSeparado[0].equals("TIPO_ESBIRRO")) {
                    cazador.setTipoEsbirro((textoSeparado[1]));
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

        return listaCazador;
    }

    private Licantropo lecturaLicantropo(BufferedReader br) throws FileNotFoundException {
        Licantropo licantropo = new Licantropo();
        Disciplina disciplina = new Disciplina();
        Personaje personaje = new Personaje();
        Arma arma = new Arma();
        Armadura armadura = new Armadura();
        Fortaleza fortaleza = new Fortaleza();
        Esbirro esbirro = new Esbirro();

        File archivo = null;
        FileReader fr = null;
        ArrayList<Cliente> listaLicantropo = new ArrayList<>();
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
                    licantropo.setNombre(textoSeparado[1]);

                } else if (textoSeparado[0].equals("NOMBRE_HABILIDAD")) {
                    disciplina.setNombre(textoSeparado[1]);

                } else if (textoSeparado[0].equals("VALOR_ATAQUE")) {
                    disciplina.setAtaque(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("VALOR_DEFENSA")) {
                    disciplina.setDefensa(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("COSTE_HABILIDAD")) {
                    disciplina.setCosteSangre(Integer.parseInt(textoSeparado[1]));

                } else if (textoSeparado[0].equals("NUMERO_ARMAS")) {
                    licantropo.getArmas().size(); //mirar esto

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
                    licantropo.getArmaduras().size();
                } else if (textoSeparado[0].equals("NOMBRE_ARMADURA")) {
                    licantropo.getArmaduras().size();
                } else if (textoSeparado[0].equals("DEFENSA_ARMADURA")) {
                    armadura.setModDefensa(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("ATAQUE_ARMADURA")) {
                    armadura.setModAtaque(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("CANTIDAD_ORO")) {
                    licantropo.setOro(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("CANTIDAD_VIDA")) {
                    licantropo.setHp(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("PODER")) {
                    licantropo.setPoder(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("NUMERO_DEBILIDADES")) {
                    licantropo.getDebilidades().size();
                } else if (textoSeparado[0].equals("NOMBRE_DEBILIDADES")) {
                    licantropo.setDebilidades((textoSeparado[1]));
                } else if (textoSeparado[0].equals("VALOR_DEBILIDAD")) {
                    licantropo.getDebilidades().size();
                } else if (textoSeparado[0].equals("NUMERO_FORTALEZAS")) { //MIRAR LA DIFERENCIA CON VALOR_FORTALEZA
                    licantropo.getFortalezas().size();
                } else if (textoSeparado[0].equals("NOMBRE_FORTALEZA")) {
                    licantropo.setFortalezas((textoSeparado[1]));
                } else if (textoSeparado[0].equals("VALOR_FORTALEZA")) { //MIRAR LA DIFERENCIA CON NUMERO_FORTALEZAS
                    fortaleza.setValor(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("EDAD_VAMPIRO")) {
                    licantropo.setEdad(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("EDAD_VAMPIRO")) {
                    licantropo.setEdad(Integer.parseInt(textoSeparado[1]));
                } else if (textoSeparado[0].equals("NUMERO_ESBIRROS")) {
                    cazador.getEsbirros().size();
                } //FALTA METER EL TIPO DE ESBIRROS, NOMBRE ESBIRROS, VIDA ESBIRROS, DEPENDENCIA
                else if (textoSeparado[0].equals("TIPO_ESBIRRO")) {
                    cazador.setTipoEsbirro((textoSeparado[1]));
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

        return listaLicantropo;
    }

}
