package mp_grupo_m.Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import mp_grupo_m.Entidades.*;

public class LecturaFicheroCombate {

    public ArrayList<Combate> lecturaFicheroCombate() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        ArrayList<Combate> listaCombate = new ArrayList<>();

        try {
            archivo = new File("./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroCombate.txt");
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            br.readLine();

            linea = br.readLine();

            while (linea != null) {
                Combate combate = new Combate();
                Cliente cliente = new Cliente();

                //NOMBRE
                String[] textoSeparado = linea.split(": ");
                cliente.setNombre((textoSeparado[1]));

                //NICK
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente.setNick((textoSeparado[1]));

                //PASSWORD
                linea = br.readLine();
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
                    switch (textoSeparado[1]) {
                        case "VAMPIRO" -> {
                            Vampiro vampiro = lecturaVampiroCombate(br);
                            cliente.setPersonaje(vampiro);
                        }
                        //LECTURA SI ES DE TIPO LICANTROPO
                        case "LICANTROPO" -> {
                            Licantropo licantropo = lecturaLicantropoCombate(br);
                            cliente.setPersonaje(licantropo);
                        }
                        //LECTURA SI ES DE TIPO CAZADOR
                        case "CAZADOR" -> {
                            Cazador cazador = lecturaCazadorCombate(br);
                            cliente.setPersonaje(cazador);
                        }
                    }
                }

                combate.setDesafiante(cliente);

                Cliente cliente2 = new Cliente();

                do {
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                } while (linea.equals("") || !textoSeparado[0].equals("CONTRINCANTE"));
                //NOMBRE
                textoSeparado = linea.split(": ");
                cliente2.setNombre((textoSeparado[1]));

                //NICK
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente2.setNick((textoSeparado[1]));

                //PASSWORD
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente2.setPassword((textoSeparado[1]));

                //NUMERO_REGISTRO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                cliente2.setRegistro(textoSeparado[1]);

                //PERSONAJE
                linea = br.readLine();
                textoSeparado = linea.split(": ");

                if (!textoSeparado[1].equals("null")) {
                    //LECTURA SI ES DE TIPO VAMPIRO
                    switch (textoSeparado[1]) {
                        case "VAMPIRO" -> {
                            Vampiro vampiro = lecturaVampiroCombate(br);
                            cliente2.setPersonaje(vampiro);
                        }
                        //LECTURA SI ES DE TIPO LICANTROPO
                        case "LICANTROPO" -> {
                            Licantropo licantropo = lecturaLicantropoCombate(br);
                            cliente2.setPersonaje(licantropo);
                        }
                        //LECTURA SI ES DE TIPO CAZADOR
                        case "CAZADOR" -> {
                            Cazador cazador = lecturaCazadorCombate(br);
                            cliente2.setPersonaje(cazador);
                        }
                    }
                }

                combate.setContrincante(cliente2);

                //RONDAS
                do {
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                } while (linea.equals("") || !textoSeparado[0].equals("RONDAS"));
                ArrayList<Ronda> rondas = new ArrayList<>();
                int tope = Integer.parseInt(textoSeparado[1]);
                for (int i = 0; i < tope; i++) {
                    Ronda ronda = new Ronda();
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    ronda.setHpContrincanteEnd(Integer.parseInt(textoSeparado[1]));
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    ronda.setHpDesafianteEnd(Integer.parseInt(textoSeparado[1]));
                    rondas.add(ronda);
                }
                combate.setRondas(rondas);

                br.readLine();
                //FECHA
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                Date fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(textoSeparado[1]);
                combate.setFecha(fecha);

                //VENCEDOR
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                if (!textoSeparado[1].equals("null")) {
                    cliente = new Cliente();
                    cliente.setNick(textoSeparado[1]);
                    combate.setVencedor(cliente);
                } else {
                    combate.setVencedor(null);
                }

                //ESBIRRO DESAFIANTE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setEsbirrosDesafiante(textoSeparado[1].equals("true"));

                //ESBIRRO CONTRINCANTE
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setEsbirrosContrincante(textoSeparado[1].equals("true"));

                //ORO
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setOro(Integer.parseInt(textoSeparado[1]));

                //MODIFICADOR
                linea = br.readLine();
                textoSeparado = linea.split(": ");
                tope = Integer.parseInt(textoSeparado[1]);
                ArrayList<Modificador> modificadores = new ArrayList<>();
                for (int i = 0; i < tope; i++) {

                    Modificador modificador = new Modificador();

                    //NOMBRE 
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    modificador.setNombre(textoSeparado[1]);

                    //VALOR
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                    modificador.setValor((Integer.parseInt(textoSeparado[1])));

                    modificadores.add(modificador);
                }
                combate.setModificadores(modificadores);
                br.readLine();

                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setRegistro(textoSeparado[1]);

                linea = br.readLine();
                textoSeparado = linea.split(": ");
                combate.setVisto(textoSeparado[1].equals("true"));

                listaCombate.add(combate);
                br.readLine();
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
        return listaCombate; //devolver la lista de cliente

    }

    private Vampiro lecturaVampiroCombate(BufferedReader br) {
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
                vampiro.setTipo("VAMPIRO");

                //NOMBRE VAMPIRO
                vampiro.setNombre(textoSeparado[1]);

                //SANGRE
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
                do {
                    linea = br.readLine();
                    textoSeparado = linea.split(": ");
                } while (!textoSeparado[0].equals("CANTIDAD_ORO"));
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
                br.readLine();
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
        return vampiro;
    }

    private Cazador lecturaCazadorCombate(BufferedReader br) {
        Cazador cazador = new Cazador();
        Talento talento = new Talento();

        FileReader fr = null;
        try {
            // Lectura del fichero
            String linea;
            linea = br.readLine();


            //TIPO PERSONAJE
            String[] textoSeparado = linea.split(": ");
            cazador.setTipo("CAZADOR");

            //NOMBRE PERSONAJE
            cazador.setNombre(textoSeparado[1]);

            //NOMBRE HABILIDAD
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            talento.setNombre(textoSeparado[1]);

            //VOLUNTAD CAZADOR
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            cazador.setVoluntad(Integer.parseInt(textoSeparado[1]));

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
            ArrayList<Arma> armas = new ArrayList<>();
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
            cazador.setArmas(armas);
            br.readLine();
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            //NUMERO DE ARMAS ACTIVAS
            tope = Integer.parseInt(textoSeparado[1]);
            ArrayList<Arma> armasActivas = new ArrayList<>();
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
            cazador.setArmasActivas(armasActivas);

            //ARMADURAS
            br.readLine();
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            tope = Integer.parseInt(textoSeparado[1]);
            ArrayList<Armadura> armaduras = new ArrayList<>();
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
                armaduras.add(armadura);
            }
            cazador.setArmaduras(armaduras);

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
            br.readLine();
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
            cazador.setFortalezas(fortalezas);

            // NUMERO DE DEBILIDADES
            br.readLine();
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
            cazador.setDebilidades(debilidades);

            //METODO ESBIRRO
            ArrayList<EsbirrosComposite> listaEsbirros = new ArrayList<>();
            br.readLine();
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            tope = Integer.parseInt(textoSeparado[1]);
            for (int i = 0; i < tope; i++) {
                EsbirrosComposite esbirro = esbirroFichero(linea, br, textoSeparado);
                listaEsbirros.add(esbirro);
            }
            cazador.setEsbirros(listaEsbirros);

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

    private Licantropo lecturaLicantropoCombate(BufferedReader br) {
        Licantropo licantropo = new Licantropo();
        Don don = new Don();

        FileReader fr = null;
        ArrayList<Cliente> listaVampiro = new ArrayList<>();
        try {
            // Lectura del fichero
            String linea;

            linea = br.readLine();


            //TIPO PERSONAJE
            String[] textoSeparado = linea.split(": ");
            licantropo.setTipo("LICANTROPO");

            //NOMBRE PERSONAJE
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

            //COSTE MINIMO
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            don.setValorMinimo(Integer.parseInt(textoSeparado[1]));

            licantropo.setHabilidad(don);

            //NUMERO DE ARMAS
            br.readLine();
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            int tope = Integer.parseInt(textoSeparado[1]);
            ArrayList<Arma> armas = new ArrayList<>();
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
            licantropo.setArmas(armas);
            br.readLine();
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            //NUMERO DE ARMAS ACTIVAS
            tope = Integer.parseInt(textoSeparado[1]);
            ArrayList<Arma> armasActivas = new ArrayList<>();
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
                armasActivas.add(arma);
            }
            licantropo.setArmasActivas(armasActivas);

            //ARMADURAS
            br.readLine();
            linea = br.readLine();
            textoSeparado = linea.split(": ");
            tope = Integer.parseInt(textoSeparado[1]);
            ArrayList<Armadura> armaduras = new ArrayList<>();
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
                armaduras.add(armadura);
            }
            licantropo.setArmaduras(armaduras);

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
            br.readLine();
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
            licantropo.setFortalezas(fortalezas);

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
            licantropo.setDebilidades(debilidades);

            //METODO ESBIRRO
            ArrayList<EsbirrosComposite> listaEsbirros = new ArrayList<>();

            linea = br.readLine();
            textoSeparado = linea.split(": ");
            tope = Integer.parseInt(textoSeparado[1]);
            for (int i = 0; i < tope; i++) {
                EsbirrosComposite esbirro = esbirroFichero(linea, br, textoSeparado);
                listaEsbirros.add(esbirro);
            }
            licantropo.setEsbirros(listaEsbirros);

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
                case "DEMONIOS" -> {
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
        }
        return null;
    }

}
