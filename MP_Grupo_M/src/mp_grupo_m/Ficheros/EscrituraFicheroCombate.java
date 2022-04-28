package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.Arma;
import mp_grupo_m.Entidades.Armadura;
import mp_grupo_m.Entidades.Cazador;
import mp_grupo_m.Entidades.Combate;
import mp_grupo_m.Entidades.Debilidad;
import mp_grupo_m.Entidades.Demonio;
import mp_grupo_m.Entidades.Desafio;
import mp_grupo_m.Entidades.Disciplina;
import mp_grupo_m.Entidades.Fortaleza;
import mp_grupo_m.Entidades.Ghoul;
import mp_grupo_m.Entidades.Humano;
import mp_grupo_m.Entidades.Licantropo;
import mp_grupo_m.Entidades.Modificador;
import mp_grupo_m.Entidades.Personaje;
import mp_grupo_m.Entidades.Ronda;
import mp_grupo_m.Entidades.Vampiro;
import mp_grupo_m.Sistema;

/**
 *
 * @author octavio
 */
public class EscrituraFicheroCombate {

    public void registroCombate(Combate combate) throws IOException {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroCombate.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("***** DESAFIO *****");
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
            bw.write(combate.getRondas().size());
            bw.newLine();
            for (int j = 0; j < (combate.getRondas().size()); j++) {
                Ronda ronda = (Ronda) combate.getRondas().get(j);
                bw.write("VIDA_CONTRINCANTE:");
                bw.write(ronda.getHpContrincanteEnd());
                bw.newLine();

                bw.write("VIDA_DESAFIANTE:");
                bw.write(ronda.getHpDesafianteEnd());
                bw.newLine();

            }
            bw.newLine();

            bw.write("FECHA: ");
            bw.write(combate.getFecha().toString());
            bw.newLine();

// INICIO VENCEDOR  ///////////
            bw.write("VENCEDOR: ");
            bw.write(combate.getVencedor().getNombre());
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
            bw.write(combate.getOro());
            bw.newLine();

//MODIFICADOR
            bw.write("CANTIDAD_MODIFICADORES: ");
            bw.write(combate.getModificadores().size());
            bw.newLine();
            for (int j = 0; j < (combate.getModificadores().size()); j++) {
                Modificador modificador = (Modificador) combate.getModificadores().get(j);
                bw.write("NOMBRE_MODIFICADOR:");
                bw.write(modificador.getNombre());
                bw.newLine();

                bw.write("VALOR_DEBILIDAD:");
                bw.write(modificador.getValor());
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

            bw.write("FIN USUARIO");
            bw.newLine();
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
        bw.write(combate.getDesafiante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(combate.getDesafiante().getPersonaje().getNombre());
        bw.newLine();
        //PUNTOS DE SANGRE
        bw.write("SANGRE: ");
        bw.write(vampiro.getSangre());
        bw.newLine();
        //NOMBRE DE HABILIDAD
        bw.write("NOMNRE_HABILIDAD: ");
        bw.write(disciplina.getNombre());
        bw.newLine();

        //VALOR ATAQUE
        bw.write("VALOR_ATAQUE: ");
        bw.write(disciplina.getAtaque());
        bw.newLine();

        //VALOR DEFENSA
        bw.write("VALOR_DEFENSA: ");
        bw.write(disciplina.getDefensa());
        bw.newLine();

        //COSTE HABILIDAD
        bw.write("COSATE_HABILIDAD: ");
        bw.write(disciplina.getCoste());
        bw.newLine();

        //ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(combate.getDesafiante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (combate.getDesafiante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = combate.getDesafiante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA:");
            bw.write(arma.getModDefensa());
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
        bw.write(combate.getDesafiante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (combate.getDesafiante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) vampiro.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(armaActiva.getModDefensa());
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
        bw.write(combate.getDesafiante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (combate.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) vampiro.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //EDAD VAMPIRO
        bw.write("EDAD_VAMPIRO: ");
        bw.write(vampiro.getEdad());
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(combate.getDesafiante().getPersonaje().getEsbirros().size());
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosDesafiante(combate, vampiro, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraLicantropoDesafiante(Combate combate, BufferedWriter bw) throws IOException {

        Licantropo licantropo = (Licantropo) combate.getDesafiante().getPersonaje();
        Disciplina disciplina = (Disciplina) licantropo.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(combate.getDesafiante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(combate.getDesafiante().getPersonaje().getNombre());
        bw.newLine();

        //PUNTOS DE SANGRE
        bw.write("RABIA: ");
        bw.write(licantropo.getRabia());
        bw.newLine();

        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(combate.getDesafiante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (combate.getDesafiante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = combate.getDesafiante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA: ");
            bw.write(arma.getModDefensa());
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
        bw.write(combate.getDesafiante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (desafio.getDesafiante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) licantropo.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(armaActiva.getModDefensa());
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
        bw.write(combate.getDesafiante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (combate.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) licantropo.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //ARMADURA ACTIVA / EQUIPADA
        bw.write("NOMBRE_ARMADURA_ACTIVA: ");
        bw.write(combate.getDesafiante().getPersonaje().getArmaduraActiva().getNombre());
        bw.newLine();

        //DEFENSA ARMADURA ACTIVA / EQUIPADA
        bw.write("DEFENSA_ARMADURA_ACTIVA: ");
        bw.write(combate.getDesafiante().getPersonaje().getArmaduraActiva().getModDefensa());
        bw.newLine();

        //ATAQUE ARMADURA ACTIVA / EQUIPADA
        bw.write("ATAQUE_ARMADURA_ACTIVA: ");
        bw.write(combate.getDesafiante().getPersonaje().getArmaduraActiva().getModAtaque());
        bw.newLine();

        //CANTIDAD ORO
        bw.write("ORO: ");
        bw.write(combate.getDesafiante().getPersonaje().getOro());
        bw.newLine();

        //DEBLIDADES
        //NUMERO DE DEBLIDADES
        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(combate.getDesafiante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (combate.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Debilidad debilidad = (Debilidad) licantropo.getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIADAD: ");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIADAD:");
            bw.write(debilidad.getValor());
            bw.newLine();
        }
        bw.newLine();

        //FORTALEZAS
        //NUMERO DE FORTALEZAS
        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(combate.getDesafiante().getPersonaje().getFortalezas().size());
        bw.newLine();
        for (int j = 0; j < (combate.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Fortaleza fortaleza = (Fortaleza) licantropo.getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA:");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA:");
            bw.write(fortaleza.getValor());
            bw.newLine();
        }
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(combate.getDesafiante().getPersonaje().getEsbirros().size());
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosDesafiante(combate, licantropo, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraCazadorDesafiante(Combate combate, BufferedWriter bw) throws IOException {

        Cazador cazador = (Cazador) combate.getDesafiante().getPersonaje();
        Disciplina disciplina = (Disciplina) cazador.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(combate.getDesafiante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(combate.getDesafiante().getPersonaje().getNombre());
        bw.newLine();

        //NOMBRE HABILDIAD
        bw.write("NOMBRE_HABILIDAD: ");
        bw.write(cazador.getNombre());
        bw.newLine();

        //ATAQUE HABILIDAD
        bw.write("ATAQUE_HABILIDAD: ");
        bw.write(cazador.getHabilidad().getAtaque());
        bw.newLine();

        //DEBILIDAD HABILIDAD
        bw.write("DEFENSA_HABILIDAD: ");
        bw.write(cazador.getHabilidad().getDefensa());
        bw.newLine();

        //EDAD CAZADOR
        bw.write("EDAD_CAZADOR: ");
        bw.write(cazador.getVoluntad());  //LA EDAD ES LA VOLUNTAD DEL CAZADOR
        bw.newLine();

        //ARMAS
        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(combate.getDesafiante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (combate.getDesafiante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = combate.getDesafiante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA:");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA:");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA:");
            bw.write(arma.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA:");
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
        bw.write(combate.getDesafiante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (combate.getDesafiante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) cazador.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS:");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA:");
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
        bw.write(combate.getDesafiante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (combate.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) cazador.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA:");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA:");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA:");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS EQUIPADA
        bw.write("NOMBRE_ARMADURA_ACTIVA:");
        bw.write(combate.getDesafiante().getPersonaje().getArmaduraActiva().getNombre());
        bw.newLine();

        bw.write("DEFENSA_ARMADURA_ACTIVA:");
        bw.write(combate.getDesafiante().getPersonaje().getArmaduraActiva().getModDefensa());
        bw.newLine();

        bw.write("ATAQUE_ARMADURA_ACTIVA:");
        bw.write(combate.getDesafiante().getPersonaje().getArmaduraActiva().getModAtaque());
        bw.newLine();

        bw.newLine();

        //CANTIDAD ORO
        bw.write("ORO: ");
        bw.write(cazador.getOro());
        bw.newLine();

        //CANTIDAD VDA
        bw.write("VIDA: ");
        bw.write(cazador.getHp());
        bw.newLine();

        //PODER
        bw.write("PODER: ");
        bw.write(cazador.getPoder());
        bw.newLine();

        //DEBILIDADES
        //NUMERO DE DEBILIDADES
        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(combate.getDesafiante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (combate.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Debilidad debilidad = (Debilidad) cazador.getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIDAD:");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIDAD:");
            bw.write(debilidad.getValor());
            bw.newLine();
        }
        bw.newLine();

        //FORTALEZAS
        //NUMERO DE FORTALEZAS
        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(combate.getDesafiante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (combate.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Fortaleza fortaleza = (Fortaleza) cazador.getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA:");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA:");
            bw.write(fortaleza.getValor());
            bw.newLine();
        }
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(combate.getDesafiante().getPersonaje().getEsbirros().size());
        bw.newLine();

        escrituraEsbirrosDesafiante(combate, cazador, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraEsbirrosDesafiante(Combate combate, Personaje personaje, BufferedWriter bw) throws IOException {
        for (int j = 0; j < (combate.getDesafiante().getPersonaje().getEsbirros().size()); j++) {
            if (personaje.getEsbirros().get(j).getTipo().equals("HUMANO")) {
                Humano humano = (Humano) personaje.getEsbirros().get(j);
                //NUMERO DE ESBIRROS
                bw.write("TIPO_ESBIRRO: ");

                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRROS
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(humano.getNombre());
                bw.newLine();

                //VIDA DE ESBIRROS
                bw.write("VIDA_ESBIRRO: ");
                bw.write(humano.getHp());
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
                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRRO
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(ghoul.getNombre());
                bw.newLine();

                //VIDA DE ESBIRRO
                bw.write("VIDA_ESBIRRO: ");
                bw.write(ghoul.getHp());
                bw.newLine();

                //DEPENDENCIA ESBIRRO
                bw.write("DEPENDENCIA: ");
                bw.write(ghoul.getDependencia());
                bw.newLine();

            } else if (personaje.getEsbirros().get(j).getTipo().equals("DEMONIO")) {
                Demonio demonio = (Demonio) personaje.getEsbirros().get(j);
                //TIPO DE ESBIRRO
                bw.write("TIPO_ESBIRRO: ");

                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRRO
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(demonio.getNombre());
                bw.newLine();

                //VIDA ESBIRRO
                bw.write("VIDA_ESBIRRO: ");
                bw.write(demonio.getHp());
                bw.newLine();

                //DESCRIPCION / PACTO
                bw.write("DESCRIPCION: ");
                bw.write(demonio.getDescripcion());
                bw.newLine();

                //ESBIRROS EXTRA
                //NUMERO DE ESBIRROS EXTRA
                bw.write("NUMERO_ESBIRROS_EXTRA: ");
                bw.write(combate.getDesafiante().getPersonaje().getEsbirros().size());
                bw.newLine();
                escrituraEsbirrosDesafiante(combate, personaje, bw);
            }
        }
    }

    private void escrituraVampiroContrincante(Combate combate, BufferedWriter bw) throws IOException {

        Vampiro vampiro = (Vampiro) combate.getContrincante().getPersonaje();
        Disciplina disciplina = (Disciplina) vampiro.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(combate.getContrincante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(combate.getContrincante().getPersonaje().getNombre());
        bw.newLine();
        //PUNTOS DE SANGRE
        bw.write("SANGRE: ");
        bw.write(vampiro.getSangre());
        bw.newLine();
        //NOMBRE DE HABILIDAD
        bw.write("NOMNRE_HABILIDAD: ");
        bw.write(disciplina.getNombre());
        bw.newLine();

        //VALOR ATAQUE
        bw.write("VALOR_ATAQUE: ");
        bw.write(disciplina.getAtaque());
        bw.newLine();

        //VALOR DEFENSA
        bw.write("VALOR_DEFENSA: ");
        bw.write(disciplina.getDefensa());
        bw.newLine();

        //COSTE HABILIDAD
        bw.write("COSATE_HABILIDAD: ");
        bw.write(disciplina.getCoste());
        bw.newLine();

        //ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(combate.getContrincante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (combate.getContrincante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = combate.getContrincante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA:");
            bw.write(arma.getModDefensa());
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
        bw.write(combate.getContrincante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (combate.getContrincante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) vampiro.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(armaActiva.getModDefensa());
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
        bw.write(combate.getContrincante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (combate.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) vampiro.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //EDAD VAMPIRO
        bw.write("EDAD_VAMPIRO: ");
        bw.write(vampiro.getEdad());
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(combate.getContrincante().getPersonaje().getEsbirros().size());
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosContrincante(combate, vampiro, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraLicantropoContrincante(Combate combate, BufferedWriter bw) throws IOException {

        Licantropo licantropo = (Licantropo) combate.getContrincante().getPersonaje();
        Disciplina disciplina = (Disciplina) licantropo.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(combate.getContrincante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(combate.getContrincante().getPersonaje().getNombre());
        bw.newLine();

        //PUNTOS DE SANGRE
        bw.write("RABIA: ");
        bw.write(licantropo.getRabia());
        bw.newLine();

        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(combate.getContrincante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (combate.getContrincante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = combate.getContrincante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA: ");
            bw.write(arma.getModDefensa());
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
        bw.write(combate.getContrincante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (combate.getContrincante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) licantropo.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(armaActiva.getModDefensa());
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
        bw.write(combate.getContrincante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (combate.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) licantropo.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //ARMADURA ACTIVA / EQUIPADA
        bw.write("NOMBRE_ARMADURA_ACTIVA: ");
        bw.write(combate.getContrincante().getPersonaje().getArmaduraActiva().getNombre());
        bw.newLine();

        //DEFENSA ARMADURA ACTIVA / EQUIPADA
        bw.write("DEFENSA_ARMADURA_ACTIVA: ");
        bw.write(combate.getContrincante().getPersonaje().getArmaduraActiva().getModDefensa());
        bw.newLine();

        //ATAQUE ARMADURA ACTIVA / EQUIPADA
        bw.write("ATAQUE_ARMADURA_ACTIVA: ");
        bw.write(combate.getContrincante().getPersonaje().getArmaduraActiva().getModAtaque());
        bw.newLine();

        //CANTIDAD ORO
        bw.write("ORO: ");
        bw.write(combate.getContrincante().getPersonaje().getOro());
        bw.newLine();

        //DEBLIDADES
        //NUMERO DE DEBLIDADES
        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(combate.getContrincante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (combate.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Debilidad debilidad = (Debilidad) licantropo.getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIADAD: ");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIADAD:");
            bw.write(debilidad.getValor());
            bw.newLine();
        }
        bw.newLine();

        //FORTALEZAS
        //NUMERO DE FORTALEZAS
        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(combate.getContrincante().getPersonaje().getFortalezas().size());
        bw.newLine();
        for (int j = 0; j < (combate.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Fortaleza fortaleza = (Fortaleza) licantropo.getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA:");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA:");
            bw.write(fortaleza.getValor());
            bw.newLine();
        }
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(combate.getContrincante().getPersonaje().getEsbirros().size());
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosContrincante(combate, licantropo, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraCazadorContrincante(Combate combate, BufferedWriter bw) throws IOException {

        Cazador cazador = (Cazador) combate.getContrincante().getPersonaje();
        Disciplina disciplina = (Disciplina) cazador.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(combate.getContrincante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(combate.getContrincante().getPersonaje().getNombre());
        bw.newLine();

        //NOMBRE HABILDIAD
        bw.write("NOMBRE_HABILIDAD: ");
        bw.write(cazador.getNombre());
        bw.newLine();

        //ATAQUE HABILIDAD
        bw.write("ATAQUE_HABILIDAD: ");
        bw.write(cazador.getHabilidad().getAtaque());
        bw.newLine();

        //DEBILIDAD HABILIDAD
        bw.write("DEFENSA_HABILIDAD: ");
        bw.write(cazador.getHabilidad().getDefensa());
        bw.newLine();

        //EDAD CAZADOR
        bw.write("EDAD_CAZADOR: ");
        bw.write(cazador.getVoluntad());  //LA EDAD ES LA VOLUNTAD DEL CAZADOR
        bw.newLine();

        //ARMAS
        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(combate.getContrincante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (combate.getContrincante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = combate.getContrincante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA:");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA:");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA:");
            bw.write(arma.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA:");
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
        bw.write(combate.getContrincante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (combate.getContrincante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) cazador.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS:");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA:");
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
        bw.write(combate.getContrincante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (combate.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) cazador.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA:");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA:");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA:");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS EQUIPADA
        bw.write("NOMBRE_ARMADURA_ACTIVA:");
        bw.write(combate.getContrincante().getPersonaje().getArmaduraActiva().getNombre());
        bw.newLine();

        bw.write("DEFENSA_ARMADURA_ACTIVA:");
        bw.write(combate.getContrincante().getPersonaje().getArmaduraActiva().getModDefensa());
        bw.newLine();

        bw.write("ATAQUE_ARMADURA_ACTIVA:");
        bw.write(combate.getContrincante().getPersonaje().getArmaduraActiva().getModAtaque());
        bw.newLine();

        bw.newLine();

        //CANTIDAD ORO
        bw.write("ORO: ");
        bw.write(cazador.getOro());
        bw.newLine();

        //CANTIDAD VDA
        bw.write("VIDA: ");
        bw.write(cazador.getHp());
        bw.newLine();

        //PODER
        bw.write("PODER: ");
        bw.write(cazador.getPoder());
        bw.newLine();

        //DEBILIDADES
        //NUMERO DE DEBILIDADES
        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(combate.getContrincante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (combate.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Debilidad debilidad = (Debilidad) cazador.getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIDAD:");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIDAD:");
            bw.write(debilidad.getValor());
            bw.newLine();
        }
        bw.newLine();

        //FORTALEZAS
        //NUMERO DE FORTALEZAS
        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(combate.getContrincante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (combate.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Fortaleza fortaleza = (Fortaleza) cazador.getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA:");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA:");
            bw.write(fortaleza.getValor());
            bw.newLine();
        }
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(combate.getContrincante().getPersonaje().getEsbirros().size());
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

                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRROS
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(humano.getNombre());
                bw.newLine();

                //VIDA DE ESBIRROS
                bw.write("VIDA_ESBIRRO: ");
                bw.write(humano.getHp());
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
                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRRO
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(ghoul.getNombre());
                bw.newLine();

                //VIDA DE ESBIRRO
                bw.write("VIDA_ESBIRRO: ");
                bw.write(ghoul.getHp());
                bw.newLine();

                //DEPENDENCIA ESBIRRO
                bw.write("DEPENDENCIA: ");
                bw.write(ghoul.getDependencia());
                bw.newLine();

            } else if (personaje.getEsbirros().get(j).getTipo().equals("DEMONIO")) {
                Demonio demonio = (Demonio) personaje.getEsbirros().get(j);
                //TIPO DE ESBIRRO
                bw.write("TIPO_ESBIRRO: ");

                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRRO
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(demonio.getNombre());
                bw.newLine();

                //VIDA ESBIRRO
                bw.write("VIDA_ESBIRRO: ");
                bw.write(demonio.getHp());
                bw.newLine();

                //DESCRIPCION / PACTO
                bw.write("DESCRIPCION: ");
                bw.write(demonio.getDescripcion());
                bw.newLine();

                //ESBIRROS EXTRA
                //NUMERO DE ESBIRROS EXTRA
                bw.write("NUMERO_ESBIRROS_EXTRA: ");
                bw.write(combate.getContrincante().getPersonaje().getEsbirros().size());
                bw.newLine();
                escrituraEsbirrosContrincante(combate, personaje, bw);
            }
        }
    }

}
