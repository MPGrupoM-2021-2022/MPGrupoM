package mp_grupo_m.Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import mp_grupo_m.Entidades.*;

public class LecturaFicheroDesafio {

    public ArrayList<Desafio> lecturaFicheroDesafio() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        ArrayList<Desafio> listaDesafio = new ArrayList<>();

        try {
            archivo = new File("./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroDesafio.txt");
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            linea = br.readLine();

            linea = br.readLine();

            while (linea != null) {
                Desafio desafio = new Desafio();
                Cliente cliente = new Cliente();

                //NICK
                String[] textoSeparado = linea.split(": ");
                cliente.setNombre(textoSeparado[1]);

                //PASSWORD
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
                        Vampiro vampiro = lecturaVampiroDesafio(br);
                        cliente.setPersonaje(vampiro);
                        //LECTURA SI ES DE TIPO LICANTROPO
                    } else if (textoSeparado[1].equals("LICANTROPO")) {
                        Licantropo licantropo = lecturaLicantropoDesafio(br);
                        cliente.setPersonaje(licantropo);
                        //LECTURA SI ES DE TIPO CAZADOR
                    } else if (textoSeparado[1].equals("CAZADOR")) {
                        Cazador cazador = lecturaCazadorDesafio(br);
                        cliente.setPersonaje(cazador);
                    }
                }

                desafio.setDesafiante(cliente);

                cliente = new Cliente();

                //NICK
                textoSeparado = linea.split(": ");
                cliente.setNombre((textoSeparado[1]));

                //PASSWORD
                textoSeparado = linea.split(": ");
                cliente.setPassword((textoSeparado[1]));

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
                        Vampiro vampiro = lecturaVampiroDesafio(br);
                        cliente.setPersonaje(vampiro);
                        //LECTURA SI ES DE TIPO LICANTROPO
                    } else if (textoSeparado[1].equals("LICANTROPO")) {
                        Licantropo licantropo = lecturaLicantropoDesafio(br);
                        cliente.setPersonaje(licantropo);
                        //LECTURA SI ES DE TIPO CAZADOR
                    } else if (textoSeparado[1].equals("CAZADOR")) {
                        Cazador cazador = lecturaCazadorDesafio(br);
                        cliente.setPersonaje(cazador);
                    }
                }

                desafio.setContrincante(cliente);

                //ORO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                desafio.setOro(Integer.parseInt(textoSeparado[1]));

                //MODIFICADOR
                linea = br.readLine();
                textoSeparado = linea.split(": ");

                for (int i = 0; i < (Integer.parseInt(textoSeparado[1])); i++) {

                    Modificador modificador = new Modificador();

                    //NOMBRE 
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    modificador.setNombre(textoSeparado[1]);

                    //VALOR
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    modificador.setValor((Integer.parseInt(textoSeparado[1])));

                    desafio.getModificadores().add(modificador);
                }

                //FECHA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                Date fecha = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(textoSeparado[1]);
                desafio.setFecha(fecha);

                //VALIDADO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                if (textoSeparado[1].equals("true")) {
                    desafio.setValidated(true);
                } else {
                    desafio.setValidated(false);
                }

                //REGISTRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                desafio.setRegistro((textoSeparado[1]));

                listaDesafio.add(desafio);
                linea = br.readLine();
                linea = br.readLine();
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
        return listaDesafio; //devolver la lista de cliente

    }

    private Vampiro lecturaVampiroDesafio(BufferedReader br) {
        Vampiro vampiro = new Vampiro();
        Disciplina disciplina = new Disciplina();

        FileReader fr = null;
        try {
            // Lectura del fichero
            String linea;
            linea = br.readLine();

            while (!linea.equals("FIN_USUARIO")) {

                //TIPO USUARIO
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
                br.readLine();
                linea = br.readLine();
                textoSeparado = linea.split(": ");

                //NUMERO DE ARMAS ACTIVAS
                ArrayList<Arma> armasActiva = new ArrayList<>();
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
                    armasActiva.add(arma);
                }
                vampiro.setArmasActivas(armasActiva);

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

                //ARMADURA ACTIVA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
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

                vampiro.setArmaduraActiva(armadura);
                br.readLine();

                //EDAD VAMPIRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                vampiro.setEdad(Integer.parseInt(textoSeparado[1]));

                //METODO ESBIRRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                ArrayList<EsbirrosComposite> listaEsbirros = new ArrayList<>();
                tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {
                    EsbirrosComposite esbirro = esbirroFichero(linea, br, textoSeparado);
                    listaEsbirros.add(esbirro);
                }
                vampiro.setEsbirros(listaEsbirros);

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
                tope = Integer.parseInt(textoSeparado[1]);
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

                    vampiro.getDebilidades().add(debilidad);
                }

                // FORTALEZAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                tope = Integer.parseInt(textoSeparado[1]);
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

                    vampiro.getFortalezas().add(fortaleza);
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
        return vampiro;
    }

    private Cazador lecturaCazadorDesafio(BufferedReader br) {
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

                    cazador.getArmas().add(arma);
                }

                //NUMERO DE ARMAS ACTIVAS
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
                    cazador.getArmasActivas().add(arma);
                }

                //ARMADURAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {
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
                tope = Integer.parseInt(textoSeparado[1]);
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

                    cazador.getDebilidades().add(debilidad);
                }

                // FORTALEZAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                tope = Integer.parseInt(textoSeparado[1]);
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

                    cazador.getFortalezas().add(fortaleza);
                }

                //METODO ESBIRRO
                ArrayList<EsbirrosComposite> listaEsbirros = new ArrayList<>();

                tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {
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

    private Licantropo lecturaLicantropoDesafio(BufferedReader br) {
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

                    licantropo.getArmas().add(arma);
                }

                //NUMERO DE ARMAS ACTIVAS
                tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {
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
                tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {
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
                tope = Integer.parseInt(textoSeparado[1]);
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

                    licantropo.getDebilidades().add(debilidad);
                }

                // FORTALEZAS
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                tope = Integer.parseInt(textoSeparado[1]);
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

                    licantropo.getFortalezas().add(fortaleza);
                }

                //METODO ESBIRRO
                ArrayList<EsbirrosComposite> listaEsbirros = new ArrayList<>();

                tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {
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

    private EsbirrosComposite esbirroFichero(String linea, BufferedReader br, String[] textoSeparado) throws IOException {
        // ESBIRROS
        int tope = Integer.parseInt(textoSeparado[1]);
        for (int i = 0; i < tope; i++) {
            if (textoSeparado[1].equals("HUMANO")) { //BORRAR PARA VAMPIROS

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

            } else if (textoSeparado[1].equals("GHOULS")) {

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

            } else if (textoSeparado[1].equals("DEMONIOS")) {

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
                tope = Integer.parseInt(textoSeparado[1]);
                for (int j = 0; j < tope; j++) {
                    EsbirrosComposite esbirro = esbirroFichero(linea, br, textoSeparado);
                    esbirrosDemonio.add(esbirro);
                }
                demonio.setEsbirrosComposites(esbirrosDemonio);

                return demonio;
            }
        }
        return null;
    }

}
