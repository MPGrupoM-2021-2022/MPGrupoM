package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import mp_grupo_m.Entidades.*;
import mp_grupo_m.Sistema;

public class EscrituraFicheroCombate {

    public void registroCombate(Combate combate) {


        try {
            String ruta = "./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroCombate.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("***** COMBATE *****");
            bw.newLine();

///////////  INICIO DESAFIANTE ///////////
            bw.write("DESAFIANTE: ");
            bw.write(combate.getDesafiante().getNombre());
            bw.newLine();

            bw.write("NICK: ");
            bw.write(combate.getDesafiante().getNick());
            bw.newLine();

            bw.write("PASSWORD: ");
            bw.write(combate.getDesafiante().getPassword());
            bw.newLine();

            bw.write("REGISTRO: ");
            bw.write(combate.getDesafiante().getRegistro());
            bw.newLine();

            String tipoPersonajeDesafiante = combate.getDesafiante().getPersonaje().getTipo();
            if (tipoPersonajeDesafiante == null) {
                bw.write("TIPO_PERSONAJE: null");
                bw.newLine();
            } else if (tipoPersonajeDesafiante.equals("VAMPIRO")) {
                escrituraVampiroDesafiante(combate, bw);
            } else if (tipoPersonajeDesafiante.equals("LICANTROPO")) {
                escrituraLicantropoDesafiante(combate, bw);
            } else if (tipoPersonajeDesafiante.equals("CAZADOR")) {
                escrituraCazadorDesafiante(combate, bw);
            }
/////////// FIN DESAFIANTE ///////////

/////////// INICIO CONTRINCANTE  ///////////
            bw.write("CONTRINCANTE: ");
            bw.write(combate.getContrincante().getNombre());
            bw.newLine();

            bw.write("NICK: ");
            bw.write(combate.getContrincante().getNick());
            bw.newLine();

            bw.write("PASSWORD: ");
            bw.write(combate.getContrincante().getPassword());
            bw.newLine();

            bw.write("REGISTRO: ");
            bw.write(combate.getContrincante().getRegistro());
            bw.newLine();

            String tipoPersonajeContrincante = combate.getContrincante().getPersonaje().getTipo();
            if (tipoPersonajeContrincante == null) {
                bw.write("TIPO_PERSONAJE: null");
                bw.newLine();
            } else if (tipoPersonajeContrincante.equals("VAMPIRO")) {
                escrituraVampiroContrincante(combate, bw);
            } else if (tipoPersonajeContrincante.equals("LICANTROPO")) {
                escrituraLicantropoContrincante(combate, bw);
            } else if (tipoPersonajeContrincante.equals("CAZADOR")) {
                escrituraCazadorContrincante(combate, bw);
            }
/////////// FIN CONTRINCANTE  ///////////

            //RONDAS
            bw.write("RONDAS: ");
            bw.write(String.valueOf(combate.getRondas().size()));
            bw.newLine();
            for (int j = 0; j < (combate.getRondas().size()); j++) {
                Ronda ronda = (Ronda) combate.getRondas().get(j);
                bw.write("VIDA_CONTRINCANTE: ");
                bw.write(String.valueOf(ronda.getHpContrincanteEnd()));
                bw.newLine();

                bw.write("VIDA_DESAFIANTE: ");
                bw.write(String.valueOf(ronda.getHpDesafianteEnd()));
                bw.newLine();

            }
            bw.newLine();

            String pattern = "dd-MM-yyyy HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(combate.getFecha());
            bw.write("FECHA: ");
            bw.write(date);
            bw.newLine();

// INICIO VENCEDOR  ///////////
            bw.write("VENCEDOR: ");
            if (combate.getVencedor()!= null) {
                bw.write(combate.getVencedor().getNick());
            } else {
                bw.write("null");
            }
            bw.newLine();
// FIN  VENCEDOR  ///////////
            //ESBIRRO DESAFIANTE
            bw.write("ESBIRRO_DESAFIANTE: ");
            if (combate.isEsbirrosDesafiante()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

            //ESBIRRO CONTRINCANTE
            bw.write("ESBIRRO_CONTRINCANTE: ");
            if (combate.isEsbirrosContrincante()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

            bw.write("ORO: ");
            bw.write(String.valueOf(combate.getOro()));
            bw.newLine();

//MODIFICADOR
            bw.write("CANTIDAD_MODIFICADORES: ");
            bw.write(String.valueOf(combate.getModificadores().size()));
            bw.newLine();
            for (int j = 0; j < (combate.getModificadores().size()); j++) {
                Modificador modificador = combate.getModificadores().get(j);
                bw.write("NOMBRE_MODIFICADOR: ");
                bw.write(modificador.getNombre());
                bw.newLine();

                bw.write("VALOR_DEBILIDAD: ");
                bw.write(String.valueOf(modificador.getValor()));
                bw.newLine();

            }
            bw.newLine();
// FIN MODIFICADOR
            bw.write("REGISTRO: ");
            bw.write(combate.getRegistro());
            bw.newLine();

            bw.write("VISTO: ");
            if (combate.isVisto()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

            bw.newLine();

            bw.write("FIN COMBATE");
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }
    public void sobreescribirFicheroCombate(ArrayList<Combate> listaCombate) {

        try {
            String ruta = "./MP_Grupo_M/src/mp_grupo_m/Ficheros/registroCombate.txt";
            File file = new File(ruta);
            // Si el archivo no existe devuelve al menu de inicio para crear el usuario.

            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            //recorre la lista de clientes
            for (Combate combate : listaCombate) {

                bw.write("***** COMBATE *****");
                bw.newLine();

                ///////////  INICIO DESAFIANTE ///////////
                bw.write("DESAFIANTE: ");
                bw.write(combate.getDesafiante().getNombre());
                bw.newLine();

                bw.write("NICK: ");
                bw.write(combate.getDesafiante().getNick());
                bw.newLine();

                bw.write("PASSWORD: ");
                bw.write(combate.getDesafiante().getPassword());
                bw.newLine();

                bw.write("REGISTRO: ");
                bw.write(combate.getDesafiante().getRegistro());
                bw.newLine();

                String tipoPersonajeDesafiante = combate.getDesafiante().getPersonaje().getTipo();
                if (tipoPersonajeDesafiante == null) {
                    bw.write("TIPO_PERSONAJE: null");
                    bw.newLine();
                } else if (tipoPersonajeDesafiante.equals("VAMPIRO")) {
                    escrituraVampiroDesafiante(combate, bw);
                } else if (tipoPersonajeDesafiante.equals("LICANTROPO")) {
                    escrituraLicantropoDesafiante(combate, bw);
                } else if (tipoPersonajeDesafiante.equals("CAZADOR")) {
                    escrituraCazadorDesafiante(combate, bw);
                }
                /////////// FIN DESAFIANTE ///////////

                /////////// INICIO CONTRINCANTE  ///////////
                bw.write("CONTRINCANTE: ");
                bw.write(combate.getContrincante().getNombre());
                bw.newLine();

                bw.write("NICK: ");
                bw.write(combate.getContrincante().getNick());
                bw.newLine();

                bw.write("PASSWORD: ");
                bw.write(combate.getContrincante().getPassword());
                bw.newLine();

                bw.write("REGISTRO: ");
                bw.write(combate.getContrincante().getRegistro());
                bw.newLine();

                String tipoPersonajeContrincante = combate.getContrincante().getPersonaje().getTipo();
                if (tipoPersonajeContrincante == null) {
                    bw.write("TIPO_PERSONAJE: null");
                    bw.newLine();
                } else if (tipoPersonajeContrincante.equals("VAMPIRO")) {
                    escrituraVampiroContrincante(combate, bw);
                } else if (tipoPersonajeContrincante.equals("LICANTROPO")) {
                    escrituraLicantropoContrincante(combate, bw);
                } else if (tipoPersonajeContrincante.equals("CAZADOR")) {
                    escrituraCazadorContrincante(combate, bw);
                }
                /////////// FIN CONTRINCANTE  ///////////

                //RONDAS
                bw.write("RONDAS: ");
                bw.write(String.valueOf(combate.getRondas().size()));
                bw.newLine();
                for (int j = 0; j < (combate.getRondas().size()); j++) {
                    Ronda ronda = combate.getRondas().get(j);
                    bw.write("VIDA_CONTRINCANTE: ");
                    bw.write(String.valueOf(ronda.getHpContrincanteEnd()));
                    bw.newLine();

                    bw.write("VIDA_DESAFIANTE: ");
                    bw.write(String.valueOf(ronda.getHpDesafianteEnd()));
                    bw.newLine();

                }
                bw.newLine();

                String pattern = "dd-MM-yyyy HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(combate.getFecha());
                bw.write("FECHA: ");
                bw.write(date);
                bw.newLine();

                // INICIO VENCEDOR  ///////////
                bw.write("VENCEDOR: ");
                if (combate.getVencedor()!= null) {
                    bw.write(combate.getVencedor().getNick());
                } else {
                    bw.write("null");
                }
                bw.newLine();
                // FIN  VENCEDOR  ///////////
                //ESBIRRO DESAFIANTE
                bw.write("ESBIRRO_DESAFIANTE: ");
                if (combate.isEsbirrosDesafiante()) {
                    bw.write("true");
                } else {
                    bw.write("false");
                }
                bw.newLine();

                //ESBIRRO CONTRINCANTE
                bw.write("ESBIRRO_CONTRINCANTE: ");
                if (combate.isEsbirrosContrincante()) {
                    bw.write("true");
                } else {
                    bw.write("false");
                }
                bw.newLine();

                bw.write("ORO: ");
                bw.write(String.valueOf(combate.getOro()));
                bw.newLine();

                //MODIFICADOR
                bw.write("CANTIDAD_MODIFICADORES: ");
                bw.write(String.valueOf(combate.getModificadores().size()));
                bw.newLine();
                for (int j = 0; j < (combate.getModificadores().size()); j++) {
                    Modificador modificador = combate.getModificadores().get(j);
                    bw.write("NOMBRE_MODIFICADOR: ");
                    bw.write(modificador.getNombre());
                    bw.newLine();

                    bw.write("VALOR_MODIFICADOR: ");
                    bw.write(String.valueOf(modificador.getValor()));
                    bw.newLine();
                }
                bw.newLine();
                // FIN MODIFICADOR
                bw.write("REGISTRO: ");
                bw.write(combate.getRegistro());
                bw.newLine();

                bw.write("VISTO: ");
                if (combate.isVisto()) {
                    bw.write("true");
                } else {
                    bw.write("false");
                }
                bw.newLine();

                bw.newLine();

                bw.write("FIN COMBATE");
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }

    private void escrituraVampiroDesafiante(Combate combate, BufferedWriter bw) throws IOException {



        Vampiro vampiro = (Vampiro) combate.getDesafiante().getPersonaje();
        Disciplina disciplina = (Disciplina) vampiro.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(vampiro.getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(vampiro.getNombre());
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
        bw.write(String.valueOf((disciplina.getAtaque())));
        bw.newLine();

        //VALOR DEFENSA
        bw.write("VALOR_DEFENSA: ");
        bw.write(String.valueOf((disciplina.getDefensa())));
        bw.newLine();

        //COSTE HABILIDAD
        bw.write("COSTE_HABILIDAD: ");
        bw.write(String.valueOf((disciplina.getCoste())));
        bw.newLine();

        //ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(String.valueOf(vampiro.getArmas().size()));
        bw.newLine();

        for (int variableArma = 0; variableArma < (vampiro.getArmas().size()); variableArma++) {
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
        bw.write(String.valueOf(vampiro.getArmasActivas().size()));
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (vampiro.getArmasActivas().size()); variableArmaActiva++) {
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
        bw.write(String.valueOf(vampiro.getArmaduras().size()));
        bw.newLine();
        for (int j = 0; j < (vampiro.getArmaduras().size()); j++) {
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
        bw.write(String.valueOf(((Vampiro) vampiro).getEdad()));
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

        for (int j = 0; j < (vampiro.getFortalezas().size()); j++) {
            Fortaleza fortaleza = vampiro.getFortalezas().get(j);
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

        for (int j = 0; j < (vampiro.getDebilidades().size()); j++) {
            Debilidad debilidad = vampiro.getDebilidades().get(j);
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
        bw.write(String.valueOf(vampiro.getEsbirros().size()));
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosDesafiante(combate, vampiro, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraLicantropoDesafiante(Combate combate, BufferedWriter bw) throws IOException {

        Licantropo licantropo = (Licantropo) combate.getDesafiante().getPersonaje();
        Don don = (Don) licantropo.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(licantropo.getTipo());
        bw.newLine();

        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(licantropo.getNombre());
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
        bw.write(String.valueOf(licantropo.getArmas().size()));
        bw.newLine();

        for (int variableArma = 0; variableArma < (licantropo.getArmas().size()); variableArma++) {
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
        bw.write(String.valueOf(licantropo.getArmasActivas().size()));
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (licantropo.getArmasActivas().size()); variableArmaActiva++) {
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
        bw.write(String.valueOf(licantropo.getArmaduras().size()));
        bw.newLine();
        for (int j = 0; j < (licantropo.getArmaduras().size()); j++) {
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

        for (int j = 0; j < (licantropo.getFortalezas().size()); j++) {
            Fortaleza fortaleza = licantropo.getFortalezas().get(j);
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

        for (int j = 0; j < (licantropo.getDebilidades().size()); j++) {
            Debilidad debilidad = licantropo.getDebilidades().get(j);
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
        bw.write(String.valueOf(licantropo.getEsbirros().size()));
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosDesafiante(combate, licantropo, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();

    }

    private void escrituraCazadorDesafiante(Combate combate, BufferedWriter bw) throws IOException {

        Cazador cazador = (Cazador) combate.getDesafiante().getPersonaje();
        Talento talento = (Talento) cazador.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(cazador.getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(cazador.getNombre());
        bw.newLine();

        //NOMBRE HABILDIAD
        bw.write("NOMBRE_HABILIDAD: ");
        bw.write(talento.getNombre());
        bw.newLine();

        //VOLUNTAD CAZADOR
        bw.write("VOLUNTAD: ");
        bw.write("3");
        bw.newLine();


        //ATAQUE HABILIDAD
        bw.write("ATAQUE_HABILIDAD: ");
        bw.write(String.valueOf(talento.getAtaque()));
        bw.newLine();

        //DEBILIDAD HABILIDAD
        bw.write("DEFENSA_HABILIDAD: ");
        bw.write(String.valueOf(talento.getDefensa()));
        bw.newLine();

        //EDAD CAZADOR
        bw.write("EDAD_CAZADOR: ");
        bw.write(String.valueOf(talento.getEdad()));
        bw.newLine();

        //ARMAS
        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(String.valueOf(cazador.getArmas().size()));
        bw.newLine();

        for (int variableArma = 0; variableArma < (cazador.getArmas().size()); variableArma++) {
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
        bw.write(String.valueOf(cazador.getArmasActivas().size()));
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (cazador.getArmasActivas().size()); variableArmaActiva++) {
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
        bw.write(String.valueOf(cazador.getArmaduras().size()));
        bw.newLine();
        for (int j = 0; j < (cazador.getArmaduras().size()); j++) {
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
        bw.write(cazador.getArmaduraActiva().getNombre());
        bw.newLine();

        bw.write("DEFENSA_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(cazador.getArmaduraActiva().getModDefensa()));
        bw.newLine();

        bw.write("ATAQUE_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(cazador.getArmaduraActiva().getModAtaque()));
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
        bw.write(String.valueOf(cazador.getFortalezas().size()));
        bw.newLine();
        for (int j = 0; j < (cazador.getArmaduras().size()); j++) {
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
        bw.write(String.valueOf(cazador.getDebilidades().size()));
        bw.newLine();
        for (int j = 0; j < (cazador.getArmaduras().size()); j++) {
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
        bw.write(String.valueOf(cazador.getEsbirros().size()));
        bw.newLine();
        escrituraEsbirrosDesafiante(combate, cazador, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraEsbirrosDesafiante(Combate combate, Personaje personaje, BufferedWriter bw) throws IOException {
        for (int j = 0; j < (combate.getDesafiante().getPersonaje().getEsbirros().size()); j++) {
            switch (personaje.getEsbirros().get(j).getTipo()) {
                case "HUMANO" -> {
                    Humano humano = (Humano) personaje.getEsbirros().get(j);
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
                    Ghoul ghoul = (Ghoul) personaje.getEsbirros().get(j);
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
                    Demonio demonio = (Demonio) personaje.getEsbirros().get(j);
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
                    bw.write(String.valueOf(combate.getDesafiante().getPersonaje().getEsbirros().size()));
                    bw.newLine();
                    escrituraEsbirrosComposite(demonio, bw);
                }
            }
        }
    }

    private void escrituraVampiroContrincante(Combate combate, BufferedWriter bw) throws IOException {

        Vampiro vampiro = (Vampiro) combate.getContrincante().getPersonaje();
        Disciplina disciplina = (Disciplina) vampiro.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(vampiro.getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(vampiro.getNombre());
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
        bw.write(String.valueOf((disciplina.getAtaque())));
        bw.newLine();

        //VALOR DEFENSA
        bw.write("VALOR_DEFENSA: ");
        bw.write(String.valueOf((disciplina.getDefensa())));
        bw.newLine();

        //COSTE HABILIDAD
        bw.write("COSTE_HABILIDAD: ");
        bw.write(String.valueOf((disciplina.getCoste())));
        bw.newLine();

        //ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(String.valueOf(vampiro.getArmas().size()));
        bw.newLine();

        for (int variableArma = 0; variableArma < (vampiro.getArmas().size()); variableArma++) {
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
        bw.write(String.valueOf(vampiro.getArmasActivas().size()));
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (vampiro.getArmasActivas().size()); variableArmaActiva++) {
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
        bw.write(String.valueOf(vampiro.getArmaduras().size()));
        bw.newLine();
        for (int j = 0; j < (vampiro.getArmaduras().size()); j++) {
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
        bw.write(String.valueOf(((Vampiro) vampiro).getEdad()));
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

        for (int j = 0; j < (vampiro.getFortalezas().size()); j++) {
            Fortaleza fortaleza = vampiro.getFortalezas().get(j);
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

        for (int j = 0; j < (vampiro.getDebilidades().size()); j++) {
            Debilidad debilidad = vampiro.getDebilidades().get(j);
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
        bw.write(String.valueOf(vampiro.getEsbirros().size()));
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosContrincante(combate, vampiro, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraLicantropoContrincante(Combate combate, BufferedWriter bw) throws IOException {

        Licantropo licantropo = (Licantropo) combate.getContrincante().getPersonaje();
        Don don = (Don) licantropo.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(licantropo.getTipo());
        bw.newLine();

        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(licantropo.getNombre());
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

        bw.write("COSTE_MINIMO_HABILIDAD: ");
        bw.write(String.valueOf(don.getValorMinimo()));
        bw.newLine();

        //ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(String.valueOf(licantropo.getArmas().size()));
        bw.newLine();

        for (int variableArma = 0; variableArma < (licantropo.getArmas().size()); variableArma++) {
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
        bw.write(String.valueOf(licantropo.getArmasActivas().size()));
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (licantropo.getArmasActivas().size()); variableArmaActiva++) {
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
        bw.write(String.valueOf(licantropo.getArmaduras().size()));
        bw.newLine();
        for (int j = 0; j < (licantropo.getArmaduras().size()); j++) {
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

        for (int j = 0; j < (licantropo.getFortalezas().size()); j++) {
            Fortaleza fortaleza = licantropo.getFortalezas().get(j);
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

        for (int j = 0; j < (licantropo.getDebilidades().size()); j++) {
            Debilidad debilidad = licantropo.getDebilidades().get(j);
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
        bw.write(String.valueOf(licantropo.getEsbirros().size()));
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosContrincante(combate, licantropo, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();

    }

    private void escrituraCazadorContrincante(Combate combate, BufferedWriter bw) throws IOException {

        Cazador cazador = (Cazador) combate.getContrincante().getPersonaje();
        Talento talento = (Talento) cazador.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(cazador.getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(cazador.getNombre());
        bw.newLine();

        //NOMBRE HABILDIAD
        bw.write("NOMBRE_HABILIDAD: ");
        bw.write(talento.getNombre());
        bw.newLine();

        //VOLUNTAD CAZADOR
        bw.write("VOLUNTAD: ");
        bw.write("3");
        bw.newLine();


        //ATAQUE HABILIDAD
        bw.write("ATAQUE_HABILIDAD: ");
        bw.write(String.valueOf(talento.getAtaque()));
        bw.newLine();

        //DEBILIDAD HABILIDAD
        bw.write("DEFENSA_HABILIDAD: ");
        bw.write(String.valueOf(talento.getDefensa()));
        bw.newLine();

        //EDAD CAZADOR
        bw.write("EDAD_CAZADOR: ");
        bw.write(String.valueOf(talento.getEdad()));
        bw.newLine();

        //ARMAS
        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(String.valueOf(cazador.getArmas().size()));
        bw.newLine();

        for (int variableArma = 0; variableArma < (cazador.getArmas().size()); variableArma++) {
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
        bw.write(String.valueOf(cazador.getArmasActivas().size()));
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (cazador.getArmasActivas().size()); variableArmaActiva++) {
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
        bw.write(String.valueOf(cazador.getArmaduras().size()));
        bw.newLine();
        for (int j = 0; j < (cazador.getArmaduras().size()); j++) {
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
        bw.write(cazador.getArmaduraActiva().getNombre());
        bw.newLine();

        bw.write("DEFENSA_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(cazador.getArmaduraActiva().getModDefensa()));
        bw.newLine();

        bw.write("ATAQUE_ARMADURA_ACTIVA: ");
        bw.write(String.valueOf(cazador.getArmaduraActiva().getModAtaque()));
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
        bw.write(String.valueOf(cazador.getFortalezas().size()));
        bw.newLine();
        for (int j = 0; j < (cazador.getArmaduras().size()); j++) {
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
        bw.write(String.valueOf(cazador.getDebilidades().size()));
        bw.newLine();
        for (int j = 0; j < (cazador.getArmaduras().size()); j++) {
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
        bw.write(String.valueOf(cazador.getEsbirros().size()));
        bw.newLine();
        escrituraEsbirrosContrincante(combate, cazador, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraEsbirrosContrincante(Combate combate, Personaje personaje, BufferedWriter bw) throws IOException {
        for (int j = 0; j < (combate.getContrincante().getPersonaje().getEsbirros().size()); j++) {
            if (personaje.getEsbirros().get(j).getTipo().equals("HUMANO")) {
                Humano humano = (Humano) personaje.getEsbirros().get(j);
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

            } else if (personaje.getEsbirros().get(j).getTipo().equals("GHOUL")) {
                Ghoul ghoul = (Ghoul) personaje.getEsbirros().get(j);
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

            } else if (personaje.getEsbirros().get(j).getTipo().equals("DEMONIO")) {
                Demonio demonio = (Demonio) personaje.getEsbirros().get(j);
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
                bw.write(String.valueOf(combate.getContrincante().getPersonaje().getEsbirros().size()));
                bw.newLine();
                escrituraEsbirrosComposite(demonio, bw);
            }
        }
    }
    private void escrituraEsbirrosComposite(Demonio demonioComposite, BufferedWriter bw) throws IOException {
        for (int j = 0; j < demonioComposite.getEsbirrosComposites().size(); j++) {
            switch (demonioComposite.getEsbirrosComposites().get(j).getTipo()) {
                case "HUMANO" -> {
                    Humano humano = (Humano) demonioComposite.getEsbirrosComposites().get(j);
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
                    Ghoul ghoul = (Ghoul) demonioComposite.getEsbirrosComposites().get(j);
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
                    Demonio demonio = (Demonio) demonioComposite.getEsbirrosComposites().get(j);
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
                    bw.write(String.valueOf(demonio.getEsbirrosComposites().size()));
                    bw.newLine();
                    escrituraEsbirrosComposite(demonio, bw);
                }
            }
        }
    }
}
