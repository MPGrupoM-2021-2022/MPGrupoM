package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import mp_grupo_m.Entidades.*;
import mp_grupo_m.Sistema;

public class EscrituraFicheroUsuario {

    public void registroUsuario(Cliente cliente) {

        try {
            String ruta = "./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroUsuario.txt";
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
            bw.write(cliente.getNombre());
            bw.newLine();
            bw.write("NICK: ");
            bw.write(cliente.getNick());
            bw.newLine();
            bw.write("PASSWORD: ");
            bw.write(cliente.getPassword());
            bw.newLine();
            bw.write("REGISTRO: ");
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

    public void sobreescribirFicheroUsuario(ArrayList<Cliente> listaCliente) {
        try {
            String ruta = "./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroUsuario.txt";
            File file = new File(ruta);
            // Si el archivo no existe devuelve al menu de inicio para crear el usuario.
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            //recorre la lista de clientes
            for (int i = 0; i < listaCliente.size(); i++) {

                bw.write("***** USUARIO *****");
                bw.newLine();
                bw.write("NOMBRE: ");
                bw.write(listaCliente.get(i).getNombre());
                bw.newLine();
                bw.write("NICK: ");
                bw.write(listaCliente.get(i).getNick());
                bw.newLine();
                bw.write("PASSWORD: ");
                bw.write(listaCliente.get(i).getPassword());
                bw.newLine();
                bw.write("REGISTRO: ");
                bw.write(listaCliente.get(i).getRegistro());
                bw.newLine();

                if (listaCliente.get(i).getPersonaje() == null) {
                    bw.write("TIPO_PERSONAJE: null");
                    bw.newLine();
                } else {
                    String tipoPersonaje = listaCliente.get(i).getPersonaje().getTipo();
                    switch (tipoPersonaje) {
                        case "VAMPIRO" -> escrituraPersonajeVampiro(listaCliente, i, bw);
                        case "LICANTROPO" -> escrituraPersonajeLicantropo(listaCliente, i, bw);
                        case "CAZADOR" -> escrituraPersonajeCazador(listaCliente, i, bw);
                    }
                }
            }
            bw.close();
        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }

    private void escrituraPersonajeVampiro(ArrayList<Cliente> listaCliente, int i, BufferedWriter bw) throws IOException {

        Vampiro vampiro = (Vampiro) listaCliente.get(i).getPersonaje();
        Disciplina disciplina = (Disciplina) vampiro.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(listaCliente.get(i).getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(listaCliente.get(i).getPersonaje().getNombre());
        bw.newLine();
        //PUNTOS DE SANGRE
        bw.write("SANGRE: ");
        bw.write("0");
        bw.newLine();
        //NOMBRE DE HABILIDAD
        bw.write("NOMNRE_HABILIDAD: ");
        bw.write(disciplina.getNombre());
        bw.newLine();

        //VALOR ATAQUE
        bw.write("VALOR_ATAQUE: ");
        bw.write(String.valueOf(disciplina.getAtaque()));
        bw.newLine();

        //VALOR DEFENSA
        bw.write("VALOR_DEFENSA: ");
        bw.write(String.valueOf(disciplina.getDefensa()));
        bw.newLine();

        //COSTE HABILIDAD
        bw.write("COSTE_HABILIDAD: ");
        bw.write(String.valueOf(disciplina.getCoste()));
        bw.newLine();

        //ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmas().size()));
        bw.newLine();

        for (int variableArma = 0; variableArma < (listaCliente.get(i).getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = vampiro.getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(String.valueOf(arma.getModAtaque()));
            bw.newLine();

            bw.write("DEFENSA_ARMA: ");
            bw.write(String.valueOf(arma.getModDefensa()));
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (arma.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

        }
        bw.newLine();

        //NUMERO DE ARMAS ACTIVAS
        bw.write("NUMERO_ARMAS_ACTIVAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmasActivas().size()));
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (listaCliente.get(i).getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = vampiro.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS: ");
            bw.write(String.valueOf(armaActiva.getModAtaque()));
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(String.valueOf(armaActiva.getModDefensa()));
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (armaActiva.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS
        //NUMERO DE ARMADURAS
        bw.write("NUMERO_ARMADURAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmaduras().size()));
        bw.newLine();
        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) vampiro.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(String.valueOf(armadura.getModDefensa()));
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(String.valueOf(armadura.getModAtaque()));
            bw.newLine();
        }
        bw.newLine();

        bw.write("NOMBRE_ARMADURA_ACTIVA: ");
        bw.write(vampiro.getArmaduraActiva().getNombre());
        bw.newLine();

        bw.write("DEFENSA_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(vampiro.getArmaduraActiva().getModDefensa()));
        bw.newLine();

        bw.write("ATAQUE_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(vampiro.getArmaduraActiva().getModAtaque()));
        bw.newLine();

        bw.newLine();

        //ORO
        bw.write("ORO: ");
        bw.write(String.valueOf(vampiro.getOro()));
        bw.newLine();

        //EDAD VAMPIRO
        bw.write("EDAD_VAMPIRO: ");
        bw.write(String.valueOf(vampiro.getEdad()));
        bw.newLine();

        bw.write("HP: ");
        bw.write(String.valueOf(vampiro.getHp()));
        bw.newLine();

        bw.write("PODER: ");
        bw.write(String.valueOf(vampiro.getPoder()));
        bw.newLine();

        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(String.valueOf(vampiro.getFortalezas().size()));
        bw.newLine();

        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getFortalezas().size()); j++) {
            Fortaleza fortaleza = listaCliente.get(i).getPersonaje().getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA: ");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA: ");
            bw.write(String.valueOf(fortaleza.getValor()));
            bw.newLine();
        }

        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(String.valueOf(vampiro.getDebilidades().size()));
        bw.newLine();

        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getDebilidades().size()); j++) {
            Debilidad debilidad = listaCliente.get(i).getPersonaje().getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIDAD: ");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIDAD: ");
            bw.write(String.valueOf(debilidad.getValor()));
            bw.newLine();
        }

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getEsbirros().size()));
        bw.newLine();

        //ESBIRROS
        escrituraEsbirros(listaCliente, i, vampiro, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraPersonajeLicantropo(ArrayList<Cliente> listaCliente, int i, BufferedWriter bw) throws IOException {

        Licantropo licantropo = (Licantropo) listaCliente.get(i).getPersonaje();
        Don don = (Don) licantropo.getHabilidad();


        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(listaCliente.get(i).getPersonaje().getTipo());
        bw.newLine();

        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(listaCliente.get(i).getPersonaje().getNombre());
        bw.newLine();



        //PUNTOS DE RABIA
        bw.write("RABIA: ");
        bw.write("0");
        bw.newLine();


        //NOMBRE DE HABILIDAD
        bw.write("NOMBRE_HABILIDAD: ");
        bw.write(don.getNombre());
        bw.newLine();

        bw.write("ATAQUE_HABILIDAD: ");
        bw.write(String.valueOf(don.getAtaque()));
        bw.newLine();

        bw.write("DEFENSA_HABILIADAD: ");
        bw.write(String.valueOf(don.getDefensa()));
        bw.newLine();

        bw.write("COSTE_MINIMO_HABILIDAD: ");
        bw.write(String.valueOf(don.getValorMinimo()));
        bw.newLine();

        //ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmas().size()));
        bw.newLine();

        for (int variableArma = 0; variableArma < (listaCliente.get(i).getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = licantropo.getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(String.valueOf(arma.getModAtaque()));
            bw.newLine();

            bw.write("DEFENSA_ARMA: ");
            bw.write(String.valueOf(arma.getModDefensa()));
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (arma.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

        }
        bw.newLine();

        //NUMERO DE ARMAS ACTIVAS
        bw.write("NUMERO_ARMAS_ACTIVAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmasActivas().size()));
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (listaCliente.get(i).getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = licantropo.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS: ");
            bw.write(String.valueOf(armaActiva.getModAtaque()));
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(String.valueOf(armaActiva.getModDefensa()));
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (armaActiva.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS
        //NUMERO DE ARMADURAS
        bw.write("NUMERO_ARMADURAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmaduras().size()));
        bw.newLine();
        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) licantropo.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(String.valueOf(armadura.getModDefensa()));
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(String.valueOf(armadura.getModAtaque()));
            bw.newLine();
        }
        bw.newLine();

        bw.write("NOMBRE_ARMADURA_ACTIVA: ");
        bw.write(licantropo.getArmaduraActiva().getNombre());
        bw.newLine();

        bw.write("DEFENSA_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(licantropo.getArmaduraActiva().getModDefensa()));
        bw.newLine();

        bw.write("ATAQUE_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(licantropo.getArmaduraActiva().getModAtaque()));
        bw.newLine();

        bw.newLine();

        //ORO
        bw.write("ORO: ");
        bw.write(String.valueOf(licantropo.getOro()));
        bw.newLine();

        bw.write("HP: ");
        bw.write(String.valueOf(licantropo.getHp()));
        bw.newLine();

        bw.write("PODER: ");
        bw.write(String.valueOf(licantropo.getPoder()));
        bw.newLine();

        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(String.valueOf(licantropo.getFortalezas().size()));
        bw.newLine();

        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getFortalezas().size()); j++) {
            Fortaleza fortaleza = listaCliente.get(i).getPersonaje().getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA: ");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA: ");
            bw.write(String.valueOf(fortaleza.getValor()));
            bw.newLine();
        }

        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(String.valueOf(licantropo.getDebilidades().size()));
        bw.newLine();

        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getDebilidades().size()); j++) {
            Debilidad debilidad = listaCliente.get(i).getPersonaje().getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIDAD: ");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIDAD: ");
            bw.write(String.valueOf(debilidad.getValor()));
            bw.newLine();
        }

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getEsbirros().size()));
        bw.newLine();

        //ESBIRROS
        escrituraEsbirros(listaCliente, i, licantropo, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();

    }

    private void escrituraPersonajeCazador(ArrayList<Cliente> listaCliente, int i, BufferedWriter bw) throws IOException {

        Cazador cazador = (Cazador) listaCliente.get(i).getPersonaje();
        Talento talento = (Talento) cazador.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(listaCliente.get(i).getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(listaCliente.get(i).getPersonaje().getNombre());
        bw.newLine();

        //NOMBRE HABILDIAD
        bw.write("NOMBRE_HABILIDAD: ");
        bw.write(cazador.getHabilidad().getNombre());
        bw.newLine();

        //VOLUNTAD CAZADOR
        bw.write("VOLUNTAD: ");
        bw.write("3");
        bw.newLine();


        //ATAQUE HABILIDAD
        bw.write("ATAQUE_HABILIDAD: ");
        bw.write(String.valueOf(cazador.getHabilidad().getAtaque()));
        bw.newLine();

        //DEBILIDAD HABILIDAD
        bw.write("DEFENSA_HABILIDAD: ");
        bw.write(String.valueOf(cazador.getHabilidad().getDefensa()));
        bw.newLine();

        //EDAD CAZADOR
        bw.write("EDAD_CAZADOR: ");
        bw.write(String.valueOf(talento.getEdad()));
        bw.newLine();

        //ARMAS
        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmas().size()));
        bw.newLine();

        for (int variableArma = 0; variableArma < (listaCliente.get(i).getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = cazador.getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(String.valueOf(arma.getModAtaque()));
            bw.newLine();

            bw.write("DEFENSA_ARMA: ");
            bw.write(String.valueOf(arma.getModDefensa()));
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (arma.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

        }
        bw.newLine();


        //ARMAS ACTIVAS
        //NUMERO DE ARMAS ACTIVAS
        bw.write("NUMERO_ARMAS_ACTIVAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmasActivas().size()));
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (listaCliente.get(i).getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = cazador.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS: ");
            bw.write(String.valueOf(armaActiva.getModAtaque()));
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(String.valueOf(armaActiva.getModDefensa()));
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (armaActiva.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS
        //NUMERO DE ARMADURAS
        bw.write("NUMERO_ARMADURAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmaduras().size()));
        bw.newLine();
        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = cazador.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(String.valueOf(armadura.getModDefensa()));
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(String.valueOf(armadura.getModAtaque()));
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS EQUIPADA

        bw.write("NOMBRE_ARMADURA_ACTIVA: ");
        bw.write(listaCliente.get(i).getPersonaje().getArmaduraActiva().getNombre());
        bw.newLine();

        bw.write("DEFENSA_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmaduraActiva().getModDefensa()));
        bw.newLine();

        bw.write("ATAQUE_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getArmaduraActiva().getModAtaque()));
        bw.newLine();

        bw.newLine();


        //CANTIDAD ORO
        bw.write("ORO: ");
        bw.write(String.valueOf(cazador.getOro()));
        bw.newLine();

        //CANTIDAD VDA
        bw.write("VIDA: ");
        bw.write(String.valueOf(cazador.getHp()));
        bw.newLine();

        //PODER
        bw.write("PODER: ");
        bw.write(String.valueOf(cazador.getPoder()));
        bw.newLine();


        //FORTALEZAS
        //NUMERO DE FORTALEZAS
        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getFortalezas().size()));
        bw.newLine();
        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getFortalezas().size()); j++) {
            Fortaleza fortaleza = cazador.getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA: ");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA: ");
            bw.write(String.valueOf(fortaleza.getValor()));
            bw.newLine();
        }
        bw.newLine();

        //DEBILIDADES
        //NUMERO DE DEBILIDADES
        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getDebilidades().size()));
        bw.newLine();
        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getArmaduras().size()); j++) {
            Debilidad debilidad = cazador.getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIDAD: ");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIDAD: ");
            bw.write(String.valueOf(debilidad.getValor()));
            bw.newLine();
        }
        bw.newLine();


        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getEsbirros().size()));
        bw.newLine();
        escrituraEsbirros(listaCliente, i, cazador, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraEsbirros(ArrayList<Cliente> listaCliente, int i, Personaje persona, BufferedWriter bw) throws IOException {
        for (int j = 0; j < (listaCliente.get(i).getPersonaje().getEsbirros().size()); j++) {
            switch (persona.getEsbirros().get(j).getTipo()) {
                case "HUMANO" -> {
                    Humano humano = (Humano) persona.getEsbirros().get(j);
                    //NUMERO DE ESBIRROS
                    bw.write("TIPO_ESBIRRO: ");
                    bw.write(humano.getTipo());
                    bw.newLine();

                    //NOMBRE DE ESBIRROS
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.write(humano.getNombre());
                    bw.newLine();

                    //VIDA DE ESBIRROS
                    bw.write("VIDA_ESBIRRO: ");
                    bw.write(String.valueOf(humano.getHp()));
                    bw.newLine();

                    //LEALTAD ESBIRRO HUMANO
                    bw.write("LELTAD: ");
                    if (humano.getLealtad() == Humano.Lealtad.ALTA) {
                        bw.write("ALTA");
                    } else if (humano.getLealtad() == Humano.Lealtad.MEDIA) {
                        bw.write("MEDIA");
                    } else if (humano.getLealtad() == Humano.Lealtad.BAJA) {
                        bw.write("BAJA");
                    }
                    bw.newLine();
                }
                case "GHOUL" -> {
                    Ghoul ghoul = (Ghoul) persona.getEsbirros().get(j);
                    //NUMERO DE ESBIRRO
                    bw.write("TIPO_ESBIRRO: ");
                    bw.write(ghoul.getTipo());
                    bw.newLine();

                    //NOMBRE DE ESBIRRO
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.write(ghoul.getNombre());
                    bw.newLine();

                    //VIDA DE ESBIRRO
                    bw.write("VIDA_ESBIRRO: ");
                    bw.write(String.valueOf(ghoul.getHp()));
                    bw.newLine();

                    //DEPENDENCIA ESBIRRO
                    bw.write("DEPENDENCIA: ");
                    bw.write(String.valueOf(ghoul.getDependencia()));
                    bw.newLine();
                }
                case "DEMONIO" -> {
                    Demonio demonio = (Demonio) persona.getEsbirros().get(j);
                    //TIPO DE ESBIRRO
                    bw.write("TIPO_ESBIRRO: ");
                    bw.write(demonio.getTipo());
                    bw.newLine();

                    //NOMBRE DE ESBIRRO
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.write(demonio.getNombre());
                    bw.newLine();

                    //VIDA ESBIRRO
                    bw.write("VIDA_ESBIRRO: ");
                    bw.write(String.valueOf(demonio.getHp()));
                    bw.newLine();

                    //DESCRIPCION / PACTO
                    bw.write("DESCRIPCION: ");
                    bw.write(demonio.getDescripcion());
                    bw.newLine();

                    //ESBIRROS EXTRA
                    //NUMERO DE ESBIRROS EXTRA
                    bw.write("NUMERO_ESBIRROS_EXTRA: ");
                    bw.write(String.valueOf(listaCliente.get(i).getPersonaje().getEsbirros().size()));
                    bw.newLine();
                    escrituraEsbirros(listaCliente, i, persona, bw);
                }
            }
        }
    }


}
