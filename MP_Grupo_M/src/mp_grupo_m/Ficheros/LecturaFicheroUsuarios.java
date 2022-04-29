package mp_grupo_m.Ficheros;

import java.io.*;
import java.util.ArrayList;
import mp_grupo_m.Entidades.*;

public class LecturaFicheroUsuarios {
    public ArrayList<Cliente> lecturaFicheroUsuarios() {

        FileReader fr = null;
        ArrayList<Cliente> listaCliente = new ArrayList<>();

        try {
            File archivo = new File("./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroUsuario.txt");
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            String alineados;
            String nombreUsuario;
            linea = br.readLine();

            linea = br.readLine();

            while (linea != null) {
                Cliente cliente = new Cliente();

                //NOMBRE
                String[] textoSeparado = linea.split(": ");
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

                //PERSONAJE
                linea = br.readLine();
                textoSeparado = linea.split(": ");

                if (!textoSeparado[1].equals("null")) {
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
                }
                listaCliente.add(cliente);
                br.readLine();
                br.readLine();
                linea = br.readLine();
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

    private Vampiro lecturaVampiro(BufferedReader br){
        Vampiro vampiro = new Vampiro();
        Disciplina disciplina = new Disciplina();

        FileReader fr = null;
        try {
            // Lectura del fichero
            String linea;
            linea = br.readLine();

            while (!linea.equals("FIN_USUARIO")) {
                //NOMBRE VAMPIRO
                String[] textoSeparado = linea.split(": ");
                vampiro.setTipo("VAMPIRO");
                vampiro.setNombre(textoSeparado[1]);

                //SANGRE VAMPIRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setSangre(Integer.parseInt(textoSeparado[1]));

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
                ArrayList<Arma> armas = new ArrayList<>();
                int tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {

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
                    arma.setSingleHand(textoSeparado[1].equals("true"));

                    armas.add(arma);
                }
                vampiro.setArmas(armas);

                ArrayList<Arma> armasActivas = new ArrayList<>();
                //NUMERO DE ARMAS ACTIVAS
                br.readLine();
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {

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
                    arma.setSingleHand(textoSeparado[1].equals("true"));
                    armasActivas.add(arma);
                }
                vampiro.setArmasActivas(armasActivas);

                //ARMADURAS
                br.readLine();
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                ArrayList<Armadura> armaduras = new ArrayList<>();
                tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {

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

                    armaduras.add(armadura);
                }
                vampiro.setArmaduras(armaduras);

                br.readLine();
                Armadura armadura = new Armadura();

                //NOMBRE ARMADURA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                armadura.setNombre(textoSeparado[1]);

                //DEFENSA ARMADURA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                armadura.setModDefensa((Integer.parseInt(textoSeparado[1])));

                //ATAQUE ARMADURA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                armadura.setModAtaque((Integer.parseInt(textoSeparado[1])));

                vampiro.setArmaduraActiva(armadura);

                br.readLine();
                //CANTIDAD ORO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setOro(Integer.parseInt(textoSeparado[1]));

                //EDAD VAMPIRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setEdad(Integer.parseInt(textoSeparado[1]));

                //CANTIDAD VIDA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setHp(Integer.parseInt(textoSeparado[1]));

                //PODER
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setPoder(Integer.parseInt(textoSeparado[1]));

                // FORTALEZAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                tope = Integer.parseInt(textoSeparado[1]);
                ArrayList<Fortaleza> fortalezas = new ArrayList<>();
                for (int i = 0; i < tope; i++) {

                    Fortaleza fortaleza = new Fortaleza();

                    //NOMBRE FORTALEZA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    fortaleza.setNombre(textoSeparado[1]);

                    //VALOR FORTALEZA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    fortaleza.setValor((Integer.parseInt(textoSeparado[1])));

                    fortalezas.add(fortaleza);
                }
                vampiro.setFortalezas(fortalezas);

                // NUMERO DE DEBILIDADES
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                tope = Integer.parseInt(textoSeparado[1]);
                ArrayList<Debilidad> debilidades = new ArrayList<>();
                for (int i = 0; i < tope; i++) {

                    Debilidad debilidad = new Debilidad();

                    //NOMBRE DE DEBILIADAD
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    debilidad.setNombre((textoSeparado[1]));

                    //VALOR DEBILIDAD
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    debilidad.setValor((Integer.parseInt(textoSeparado[1])));

                    debilidades.add(debilidad);
                }
                vampiro.setDebilidades(debilidades);

                //METODO ESBIRRO
                ArrayList<EsbirrosComposite> listaEsbirros = new ArrayList<>();
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {
                    EsbirrosComposite esbirro = esbirroFichero(linea, br, textoSeparado);
                    listaEsbirros.add(esbirro);
                }
                vampiro.setEsbirros(listaEsbirros);
                linea = "FIN_USUARIO";
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

    private Cazador lecturaCazador(BufferedReader br){
        Cazador cazador = new Cazador();
        Talento talento = new Talento();

        FileReader fr = null;
        ArrayList<Cliente> listaCazador = new ArrayList<>();
        try {
            // Lectura del fichero
            String linea;
            linea = br.readLine();

            while (!linea.equals("FIN_USUARIO")) {

                //TIPO PERSONAJE
                linea = br.readLine();
                System.out.println(linea);
                String[] textoSeparado = linea.split(": ");
                cazador.setTipo(textoSeparado[1]);

                //NOMBRE PERSONAJE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cazador.setNombre(textoSeparado[1]);

                //VOLUNTAD CAZADOR
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cazador.setNombre(textoSeparado[1]);

                //NOMBRE HABILIDAD
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                talento.setNombre(textoSeparado[1]);

                //VALOR ATAQUE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                talento.setAtaque(Integer.parseInt(textoSeparado[1]));

                //VALOR DEFENSA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                talento.setDefensa(Integer.parseInt(textoSeparado[1]));

                //EDAD HABILIDAD
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                talento.setEdad(Integer.parseInt(textoSeparado[1]));

                cazador.setHabilidad(talento);

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
                    arma.setSingleHand(textoSeparado[1].equals("true"));

                    cazador.getArmas().add(arma);
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
                    arma.setSingleHand(textoSeparado[1].equals("true"));
                    cazador.getArmasActivas().add(arma);
                }

                //ARMADURAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

                    Armadura armadura = new Armadura();

                    //NOMBRE ARMADURA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    armadura.setNombre(textoSeparado[1]);

                    //NIVEL DEFENSA ARMADURA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    armadura.setModDefensa((Integer.parseInt(textoSeparado[1])));

                    //NIVEL ATAQUE ARMADURA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    armadura.setModAtaque((Integer.parseInt(textoSeparado[1])));

                    cazador.getArmaduras().add(armadura);
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

                cazador.setArmaduraActiva(armadura);

                //CANTIDAD ORO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cazador.setOro(Integer.parseInt(textoSeparado[1]));

                //CANTIDAD VIDA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cazador.setHp(Integer.parseInt(textoSeparado[1]));

                //PODER
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cazador.setPoder(Integer.parseInt(textoSeparado[1]));

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

                    cazador.getDebilidades().add(debilidad);
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

                    cazador.getFortalezas().add(fortaleza);
                }

                //METODO ESBIRRO
                ArrayList<EsbirrosComposite> listaEsbirros = new ArrayList<>();

                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {
                    EsbirrosComposite esbirro = esbirroFichero(linea, br, textoSeparado);
                    listaEsbirros.add(esbirro);
                }
                cazador.setEsbirros(listaEsbirros);
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
        return cazador;
    }

    private Licantropo lecturaLicantropo(BufferedReader br) {
        Licantropo licantropo = new Licantropo();
        Don don = new Don();

        FileReader fr = null;
        ArrayList<Cliente> listaVampiro = new ArrayList<>();
        try {
            // Lectura del fichero
            String linea;

            linea = br.readLine();

            while (!linea.equals("FIN_USUARIO")) {

                //TIPO PERSONAJE
                linea = br.readLine();
                System.out.println(linea);
                String[] textoSeparado = linea.split(": ");
                licantropo.setTipo(textoSeparado[1]);

                //NOMBRE PERSONAJE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                licantropo.setNombre(textoSeparado[1]);

                //RABIA LICANTROPO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                licantropo.setRabia(Integer.parseInt(textoSeparado[1]));

                //NOMBRE HABILIDAD
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                don.setNombre(textoSeparado[1]);

                //VALOR ATAQUE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                don.setAtaque(Integer.parseInt(textoSeparado[1]));

                //VALOR DEFENSA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                don.setDefensa(Integer.parseInt(textoSeparado[1]));

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

                    licantropo.getArmas().add(arma);
                }

                //NUMERO DE ARMAS ACTIVAS
                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

                    Arma arma = new Arma();
                    //NOMBRE ARMA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setNombre(textoSeparado[1]);
                    //VALOR ATAQUE
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setModAtaque((Integer.parseInt(textoSeparado[1])));
                    //VALOR DEFENSA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setModDefensa((Integer.parseInt(textoSeparado[1])));
                    //EMPULADURA DE ARMA
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    arma.setSingleHand(textoSeparado[1].equals("true"));
                    licantropo.getArmasActivas().add(arma);
                }

                //ARMADURAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

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

                    licantropo.getArmaduras().add(armadura);
                }

                //ARMADURA ACTIVA
                Armadura armadura = new Armadura();
                linea = br.readLine();
                textoSeparado = linea.split(": ");

                //NOMBRE ARMADURA      *********MIRAR ESTO***** POSIBLEMENTE SE ME HAYA COLADO Y HAY QUE QUITARLO
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

                licantropo.setArmaduraActiva(armadura);

                //CANTIDAD ORO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                licantropo.setOro(Integer.parseInt(textoSeparado[1]));

                //CANTIDAD VIDA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                licantropo.setHp(Integer.parseInt(textoSeparado[1]));

                //PODER
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                licantropo.setPoder(Integer.parseInt(textoSeparado[1]));

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

                    licantropo.getDebilidades().add(debilidad);
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

                    licantropo.getFortalezas().add(fortaleza);
                }

                //METODO ESBIRRO
                ArrayList<EsbirrosComposite> listaEsbirros = new ArrayList<>();

                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {
                    EsbirrosComposite esbirro = esbirroFichero(linea, br, textoSeparado);
                    listaEsbirros.add(esbirro);
                }
                licantropo.setEsbirros(listaEsbirros);
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
        return licantropo;
    }

    private EsbirrosComposite esbirroFichero(String linea, BufferedReader br, String[] textoSeparado) throws NumberFormatException, IOException {
        // ESBIRROS
        int tope = Integer.parseInt(textoSeparado[1]);
        for (int i = 0; i < tope; i++) {
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            switch (textoSeparado[1]) {
                case "HUMANO" -> {  //BORRAR PARA VAMPIROS

                    Humano humano = new Humano();

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

                    //VALOR LEALTAD     TIPOS: ALTA, MEDIO, BAJO que coresponde a 0,1,2
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    if (textoSeparado[1].equals("ALTA")) {
                        humano.setLealtad(Humano.Lealtad.ALTA);
                    } else if (textoSeparado[1].equals("MEDIA")) {
                        humano.setLealtad(Humano.Lealtad.MEDIA);
                    } else {
                        humano.setLealtad(Humano.Lealtad.BAJA);
                    }
                    return humano;
                }
                case "GHOUL" -> {
                    Ghoul ghoul = new Ghoul();

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
                    return ghoul;
                }
                case "DEMONIO" -> {
                    Demonio demonio = new Demonio();

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
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    ArrayList<EsbirrosComposite> esbirrosDemonio = new ArrayList<>();
                    for (int j = 0; j < (Integer.parseInt(textoSeparado[1])); j++) {
                        EsbirrosComposite esbirro = esbirroFichero(linea, br, textoSeparado);
                        esbirrosDemonio.add(esbirro);
                    }
                    demonio.setEsbirrosComposites(esbirrosDemonio);
                    return demonio;
                }
            }
        }
        return null;
    }
}
