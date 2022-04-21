package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.*;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

/**
 *
 * @author octavio
 */
public class ControlFicheroUsuarios {

    Sistema sistema = new Sistema();
    Terminal terminal = new Terminal();
    LecturaFicheroUsuario lecturaFicheroUsuario = new LecturaFicheroUsuario();

    public void registroUsuario(Cliente cliente) throws IOException {

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

    public void registroPersonaje(ArrayList<Cliente> listaCliente) throws IOException {
        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroUsuario.txt";
            File file = new File(ruta);
            // Si el archivo no existe devuelve al menu de inicio para crear el usuario. 
            if (!file.exists()) {
                System.out.println("El fichero no existe.");
                System.out.println("No se permite el registro del nuevo personaje.");
                terminal.mostrarInicio();
                sistema.selector();
            }
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            //recorre la lista de clientes
            for (int i = 0; i < listaCliente.size(); i++) {

                bw.write("***** USUARIO *****");
                bw.newLine();
                bw.write("NOMBRE: ");
                bw.newLine();
                bw.write(listaCliente.get(i).getNombre());
                bw.newLine();
                bw.write("NICK: ");
                bw.newLine();
                bw.write(listaCliente.get(i).getNick());
                bw.newLine();
                bw.write("PASSWORD: ");
                bw.newLine();
                bw.write(listaCliente.get(i).getPassword());
                bw.newLine();
                bw.write("REGISTRO: ");
                bw.newLine();
                bw.write(listaCliente.get(i).getRegistro());
                bw.newLine();

                String tipoPersonaje = listaCliente.get(i).getPersonaje().getTipo();
                if (tipoPersonaje == null) {

                    bw.write("TIPO_PERSONAJE: null");
                    bw.newLine();

                } else if (tipoPersonaje.equals("VAMPIRO")) {
                    escrituraPersonajeVampiro(listaCliente, i, bw);
                }else if (tipoPersonaje.equals("LICANTROPO")) {
                    escrituraPersonajeLicantropo(listaCliente, i, bw);
                }else if (tipoPersonaje.equals("CAZADOR")) {
                    escrituraPersonajeCazador(listaCliente, i, bw);
                }
            }

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
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getTipo());
            bw.newLine();
            //NOMBRE PERSONAJE
            bw.write("NOMBRE_PERSONAJE: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getNombre());
            bw.newLine();
            //PUNTOS DE SANGRE
            bw.write("SANGRE: ");
            bw.newLine();
            bw.write(vampiro.getSangre());
            bw.newLine();
            //NOMBRE DE HABILIDAD
            bw.write("NOMNRE_HABILIDAD: ");
            bw.newLine();
            bw.write(disciplina.getNombre());
            bw.newLine();
            
            //VALOR ATAQUE
            bw.write("VALOR_ATAQUE: ");
            bw.newLine();
            bw.write(disciplina.getAtaque());
            bw.newLine();
            
            //VALOR DEFENSA
            bw.write("VALOR_DEFENSA: ");
            bw.newLine();
            bw.write(disciplina.getDefensa());
            bw.newLine();
            
            //COSTE HABILIDAD
            bw.write("COSATE_HABILIDAD: ");
            bw.newLine();
            bw.write(disciplina.getCoste());
            bw.newLine();
            
            //ARMAS
            bw.write("NUMERO_ARMAS: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getArmas().size());
            bw.newLine();
            
            for (int variableArma = 0; variableArma < (listaCliente.get(i).getPersonaje().getArmas().size()); variableArma++) {
                Arma arma = vampiro.getArmas().get(i);
                bw.write("NOMBRE_ARMA: ");
                bw.newLine();
                bw.write(arma.getNombre());
                bw.newLine();
                
                bw.write("ATAQUE_ARMA: ");
                bw.newLine();
                bw.write(arma.getModAtaque());
                bw.newLine();
                
                bw.write("DEFENSA_ARMA: ");
                bw.newLine();
                bw.write(arma.getModDefensa());
                bw.newLine();
                
                //si es true es de 1 mano, si es false es de dos manos
                bw.write("EMPUÑADURA: ");
                bw.newLine();
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
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getArmasActivas().size());
            bw.newLine();
            for (int variableArmaActiva = 0; variableArmaActiva < (listaCliente.get(i).getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
                Arma armaActiva = (Arma) vampiro.getArmasActivas().get(variableArmaActiva);
                
                bw.write("NOMBRE_ARMAS_ACTIVAS: ");
                bw.newLine();
                bw.write(armaActiva.getNombre());
                bw.newLine();
                
                bw.write("ATAQUE_ARMA_ACTIVAS: ");
                bw.newLine();
                bw.write(armaActiva.getModAtaque());
                bw.newLine();
                
                bw.write("DEFENSA_ARMA_ACTIVAS: ");
                bw.newLine();
                bw.write(armaActiva.getModDefensa());
                bw.newLine();
                
                //si es true es de 1 mano, si es false es de dos manos
                bw.write("EMPUÑADURA: ");
                bw.newLine();
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
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getArmaduras().size());
            bw.newLine();
            for (int j = 0; j < (listaCliente.get(i).getPersonaje().getArmaduras().size()); j++) {
                Armadura armadura = (Armadura) vampiro.getArmaduras().get(j);
                bw.write("NOMBRE_ARMADURA: ");
                bw.newLine();
                bw.write(armadura.getNombre());
                bw.newLine();
                
                bw.write("DEFENSA_ARMADURA: ");
                bw.newLine();
                bw.write(armadura.getModDefensa());
                bw.newLine();
                
                bw.write("ATAQUE_ARMADURA: ");
                bw.newLine();
                bw.write(armadura.getModAtaque());
                bw.newLine();
            }
            bw.newLine();
            
            //EDAD VAMPIRO
            bw.write("EDAD_VAMPIRO: ");
            bw.newLine();
            bw.write(vampiro.getEdad());
            bw.newLine();
            
            //ESBIRROS
            //NUMERO DE ESBIRROS
            bw.write("NUMERO_ESBIRROS: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getEsbirros().size());
            bw.newLine();
            for (int j = 0; j < (listaCliente.get(i).getPersonaje().getEsbirros().size()); j++) {
                
                if (vampiro.getEsbirros().get(j).getTipo().equals("HUMANO")) {
                    Humano humano = (Humano) vampiro.getEsbirros().get(j);
                    //NUMERO DE ESBIRROS
                    bw.write("TIPO_ESBIRRO: ");
                    bw.newLine();

                    bw.write(vampiro.getTipo());
                    bw.newLine();
                    
                    //NOMBRE DE ESBIRROS
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.newLine();
                    bw.write(humano.getNombre());
                    bw.newLine();
                    
                    //VIDA DE ESBIRROS
                    bw.write("VIDA_ESBIRRO: ");
                    bw.newLine();
                    bw.write(humano.getHp());
                    bw.newLine();
                    
                    //LEALTAD ESBIRRO HUMANO
                    bw.write("LELTAD: ");
                    bw.newLine();
                    if (humano.getLealtad().equals(0)) {
                        bw.write("0");
                    } else if (humano.getLealtad().equals(1)) {
                        bw.write("1");
                    } else if (humano.getLealtad().equals(2)) {
                        bw.write("2");
                    }
                    bw.newLine();
                    
                } else if (vampiro.getEsbirros().get(j).getTipo().equals("GHOUL")) {
                    Ghoul ghoul = (Ghoul) vampiro.getEsbirros().get(j);
                    //NUMERO DE ESBIRRO
                    bw.write("TIPO_ESBIRRO: ");
                    bw.newLine();
                    bw.write(vampiro.getTipo());
                    bw.newLine();
                    
                    //NOMBRE DE ESBIRRO
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.newLine();
                    bw.write(ghoul.getNombre());
                    bw.newLine();
                    
                    //VIDA DE ESBIRRO
                    bw.write("VIDA_ESBIRRO: ");
                    bw.newLine();
                    bw.write(ghoul.getHp());
                    bw.newLine();
                    
                    //DEPENDENCIA ESBIRRO
                    bw.write("DEPENDENCIA: ");
                    bw.newLine();
                    bw.write(ghoul.getDependencia());
                    bw.newLine();
                    
                } else if (vampiro.getEsbirros().get(j).getTipo().equals("DEMONIO")) {
                    Demonio demonio = (Demonio) vampiro.getEsbirros().get(j);
                    //TIPO DE ESBIRRO
                    bw.write("TIPO_ESBIRRO: ");
                    bw.newLine();
                    
                    bw.write(vampiro.getTipo());
                    bw.newLine();

                    //NOMBRE DE ESBIRRO
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.newLine();
                    bw.write(demonio.getNombre());
                    bw.newLine();
                    
                    //VIDA ESBIRRO
                    bw.write("VIDA_ESBIRRO: ");
                    bw.newLine();
                    bw.write(demonio.getHp());
                    bw.newLine();
                    
                    //DESCRIPCION / PACTO
                    bw.write("DESCRIPCION: ");
                    bw.newLine();
                    bw.write(demonio.getDescripcion());
                    bw.newLine();

                    //ESBIRROS EXTRA
                    //NUMERO DE ESBIRROS EXTRA
                    bw.write("NUMERO_ESBIRROS_EXTRA: ");
                    bw.newLine();
                    bw.write(listaCliente.get(i).getPersonaje().getEsbirros().size());
                    bw.newLine();
                    escrituraEsbirros();
                }
            }
            bw.write("FIN_USUARIO");
            bw.newLine();
        }
    

    private void escrituraPersonajeLicantropo(ArrayList<Cliente> listaCliente, int i, BufferedWriter bw) throws IOException {

            Vampiro vampiro = (Vampiro) listaCliente.get(i).getPersonaje();
            Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
            
            //TIPO PERSONAJE
            bw.write("TIPO_PERSONAJE: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getTipo());
            bw.newLine();
            //NOMBRE PERSONAJE
            bw.write("NOMBRE_PERSONAJE: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getNombre());
            bw.newLine();
            //PUNTOS DE SANGRE
            bw.write("SANGRE: ");
            bw.newLine();
            bw.write(vampiro.getSangre());
            bw.newLine();
            //NOMBRE DE HABILIDAD
            bw.write("NOMNRE_HABILIDAD: ");
            bw.newLine();
            bw.write(disciplina.getNombre());
            bw.newLine();
            
            //VALOR ATAQUE
            bw.write("VALOR_ATAQUE: ");
            bw.newLine();
            bw.write(disciplina.getAtaque());
            bw.newLine();
            
            //VALOR DEFENSA
            bw.write("VALOR_DEFENSA: ");
            bw.newLine();
            bw.write(disciplina.getDefensa());
            bw.newLine();
            
            //COSTE HABILIDAD
            bw.write("COSATE_HABILIDAD: ");
            bw.newLine();
            bw.write(disciplina.getCoste());
            bw.newLine();
            
            //ARMAS
            bw.write("NUMERO_ARMAS: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getArmas().size());
            bw.newLine();
            
            for (int variableArma = 0; variableArma < (listaCliente.get(i).getPersonaje().getArmas().size()); variableArma++) {
                Arma arma = vampiro.getArmas().get(i);
                bw.write("NOMBRE_ARMA: ");
                bw.newLine();
                bw.write(arma.getNombre());
                bw.newLine();
                
                bw.write("ATAQUE_ARMA: ");
                bw.newLine();
                bw.write(arma.getModAtaque());
                bw.newLine();
                
                bw.write("DEFENSA_ARMA: ");
                bw.newLine();
                bw.write(arma.getModDefensa());
                bw.newLine();
                
                //si es true es de 1 mano, si es false es de dos manos
                bw.write("EMPUÑADURA: ");
                bw.newLine();
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
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getArmasActivas().size());
            bw.newLine();
            for (int variableArmaActiva = 0; variableArmaActiva < (listaCliente.get(i).getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
                Arma armaActiva = (Arma) vampiro.getArmasActivas().get(variableArmaActiva);
                
                bw.write("NOMBRE_ARMAS_ACTIVAS: ");
                bw.newLine();
                bw.write(armaActiva.getNombre());
                bw.newLine();
                
                bw.write("ATAQUE_ARMA_ACTIVAS: ");
                bw.newLine();
                bw.write(armaActiva.getModAtaque());
                bw.newLine();
                
                bw.write("DEFENSA_ARMA_ACTIVAS: ");
                bw.newLine();
                bw.write(armaActiva.getModDefensa());
                bw.newLine();
                
                //si es true es de 1 mano, si es false es de dos manos
                bw.write("EMPUÑADURA: ");
                bw.newLine();
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
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getArmaduras().size());
            bw.newLine();
            for (int j = 0; j < (listaCliente.get(i).getPersonaje().getArmaduras().size()); j++) {
                Armadura armadura = (Armadura) vampiro.getArmaduras().get(j);
                bw.write("NOMBRE_ARMADURA: ");
                bw.newLine();
                bw.write(armadura.getNombre());
                bw.newLine();
                
                bw.write("DEFENSA_ARMADURA: ");
                bw.newLine();
                bw.write(armadura.getModDefensa());
                bw.newLine();
                
                bw.write("ATAQUE_ARMADURA: ");
                bw.newLine();
                bw.write(armadura.getModAtaque());
                bw.newLine();
            }
            bw.newLine();
            
            //EDAD VAMPIRO
            bw.write("EDAD_VAMPIRO: ");
            bw.newLine();
            bw.write(vampiro.getEdad());
            bw.newLine();
            
            //ESBIRROS
            //NUMERO DE ESBIRROS
            bw.write("NUMERO_ESBIRROS: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getEsbirros().size());
            bw.newLine();
            for (int j = 0; j < (listaCliente.get(i).getPersonaje().getEsbirros().size()); j++) {
                
                if (vampiro.getEsbirros().get(j).getTipo().equals("HUMANO")) {
                    Humano humano = (Humano) vampiro.getEsbirros().get(j);
                    //NUMERO DE ESBIRROS
                    bw.write("TIPO_ESBIRRO: ");
                    bw.newLine();

                    bw.write(vampiro.getTipo());
                    bw.newLine();
                    
                    //NOMBRE DE ESBIRROS
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.newLine();
                    bw.write(humano.getNombre());
                    bw.newLine();
                    
                    //VIDA DE ESBIRROS
                    bw.write("VIDA_ESBIRRO: ");
                    bw.newLine();
                    bw.write(humano.getHp());
                    bw.newLine();
                    
                    //LEALTAD ESBIRRO HUMANO
                    bw.write("LELTAD: ");
                    bw.newLine();
                    if (humano.getLealtad().equals(0)) {
                        bw.write("0");
                    } else if (humano.getLealtad().equals(1)) {
                        bw.write("1");
                    } else if (humano.getLealtad().equals(2)) {
                        bw.write("2");
                    }
                    bw.newLine();
                    
                } else if (vampiro.getEsbirros().get(j).getTipo().equals("GHOUL")) {
                    Ghoul ghoul = (Ghoul) vampiro.getEsbirros().get(j);
                    //NUMERO DE ESBIRRO
                    bw.write("TIPO_ESBIRRO: ");
                    bw.newLine();
                    bw.write(vampiro.getTipo());
                    bw.newLine();
                    
                    //NOMBRE DE ESBIRRO
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.newLine();
                    bw.write(ghoul.getNombre());
                    bw.newLine();
                    
                    //VIDA DE ESBIRRO
                    bw.write("VIDA_ESBIRRO: ");
                    bw.newLine();
                    bw.write(ghoul.getHp());
                    bw.newLine();
                    
                    //DEPENDENCIA ESBIRRO
                    bw.write("DEPENDENCIA: ");
                    bw.newLine();
                    bw.write(ghoul.getDependencia());
                    bw.newLine();
                    
                } else if (vampiro.getEsbirros().get(j).getTipo().equals("DEMONIO")) {
                    Demonio demonio = (Demonio) vampiro.getEsbirros().get(j);
                    //TIPO DE ESBIRRO
                    bw.write("TIPO_ESBIRRO: ");
                    bw.newLine();
                    
                    bw.write(vampiro.getTipo());
                    bw.newLine();

                    //NOMBRE DE ESBIRRO
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.newLine();
                    bw.write(demonio.getNombre());
                    bw.newLine();
                    
                    //VIDA ESBIRRO
                    bw.write("VIDA_ESBIRRO: ");
                    bw.newLine();
                    bw.write(demonio.getHp());
                    bw.newLine();
                    
                    //DESCRIPCION / PACTO
                    bw.write("DESCRIPCION: ");
                    bw.newLine();
                    bw.write(demonio.getDescripcion());
                    bw.newLine();

                    //ESBIRROS EXTRA
                    //NUMERO DE ESBIRROS EXTRA
                    bw.write("NUMERO_ESBIRROS_EXTRA: ");
                    bw.newLine();
                    bw.write(listaCliente.get(i).getPersonaje().getEsbirros().size());
                    bw.newLine();
                    escrituraEsbirros();
                }
            }
            bw.write("FIN_USUARIO");
            bw.newLine();
        }
    
  
    private void escrituraPersonajeCazador(ArrayList<Cliente> listaCliente, int i, BufferedWriter bw) throws IOException {

            Vampiro vampiro = (Vampiro) listaCliente.get(i).getPersonaje();
            Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
            
            //TIPO PERSONAJE
            bw.write("TIPO_PERSONAJE: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getTipo());
            bw.newLine();
            //NOMBRE PERSONAJE
            bw.write("NOMBRE_PERSONAJE: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getNombre());
            bw.newLine();
            //PUNTOS DE SANGRE
            bw.write("SANGRE: ");
            bw.newLine();
            bw.write(vampiro.getSangre());
            bw.newLine();
            //NOMBRE DE HABILIDAD
            bw.write("NOMNRE_HABILIDAD: ");
            bw.newLine();
            bw.write(disciplina.getNombre());
            bw.newLine();
            
            //VALOR ATAQUE
            bw.write("VALOR_ATAQUE: ");
            bw.newLine();
            bw.write(disciplina.getAtaque());
            bw.newLine();
            
            //VALOR DEFENSA
            bw.write("VALOR_DEFENSA: ");
            bw.newLine();
            bw.write(disciplina.getDefensa());
            bw.newLine();
            
            //COSTE HABILIDAD
            bw.write("COSATE_HABILIDAD: ");
            bw.newLine();
            bw.write(disciplina.getCoste());
            bw.newLine();
            
            //ARMAS
            bw.write("NUMERO_ARMAS: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getArmas().size());
            bw.newLine();
            
            for (int variableArma = 0; variableArma < (listaCliente.get(i).getPersonaje().getArmas().size()); variableArma++) {
                Arma arma = vampiro.getArmas().get(i);
                bw.write("NOMBRE_ARMA: ");
                bw.newLine();
                bw.write(arma.getNombre());
                bw.newLine();
                
                bw.write("ATAQUE_ARMA: ");
                bw.newLine();
                bw.write(arma.getModAtaque());
                bw.newLine();
                
                bw.write("DEFENSA_ARMA: ");
                bw.newLine();
                bw.write(arma.getModDefensa());
                bw.newLine();
                
                //si es true es de 1 mano, si es false es de dos manos
                bw.write("EMPUÑADURA: ");
                bw.newLine();
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
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getArmasActivas().size());
            bw.newLine();
            for (int variableArmaActiva = 0; variableArmaActiva < (listaCliente.get(i).getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
                Arma armaActiva = (Arma) vampiro.getArmasActivas().get(variableArmaActiva);
                
                bw.write("NOMBRE_ARMAS_ACTIVAS: ");
                bw.newLine();
                bw.write(armaActiva.getNombre());
                bw.newLine();
                
                bw.write("ATAQUE_ARMA_ACTIVAS: ");
                bw.newLine();
                bw.write(armaActiva.getModAtaque());
                bw.newLine();
                
                bw.write("DEFENSA_ARMA_ACTIVAS: ");
                bw.newLine();
                bw.write(armaActiva.getModDefensa());
                bw.newLine();
                
                //si es true es de 1 mano, si es false es de dos manos
                bw.write("EMPUÑADURA: ");
                bw.newLine();
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
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getArmaduras().size());
            bw.newLine();
            for (int j = 0; j < (listaCliente.get(i).getPersonaje().getArmaduras().size()); j++) {
                Armadura armadura = (Armadura) vampiro.getArmaduras().get(j);
                bw.write("NOMBRE_ARMADURA: ");
                bw.newLine();
                bw.write(armadura.getNombre());
                bw.newLine();
                
                bw.write("DEFENSA_ARMADURA: ");
                bw.newLine();
                bw.write(armadura.getModDefensa());
                bw.newLine();
                
                bw.write("ATAQUE_ARMADURA: ");
                bw.newLine();
                bw.write(armadura.getModAtaque());
                bw.newLine();
            }
            bw.newLine();
            
            //EDAD VAMPIRO
            bw.write("EDAD_VAMPIRO: ");
            bw.newLine();
            bw.write(vampiro.getEdad());
            bw.newLine();
            
            //ESBIRROS
            //NUMERO DE ESBIRROS
            bw.write("NUMERO_ESBIRROS: ");
            bw.newLine();
            bw.write(listaCliente.get(i).getPersonaje().getEsbirros().size());
            bw.newLine();
            for (int j = 0; j < (listaCliente.get(i).getPersonaje().getEsbirros().size()); j++) {
                
                if (vampiro.getEsbirros().get(j).getTipo().equals("HUMANO")) {
                    Humano humano = (Humano) vampiro.getEsbirros().get(j);
                    //NUMERO DE ESBIRROS
                    bw.write("TIPO_ESBIRRO: ");
                    bw.newLine();

                    bw.write(vampiro.getTipo());
                    bw.newLine();
                    
                    //NOMBRE DE ESBIRROS
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.newLine();
                    bw.write(humano.getNombre());
                    bw.newLine();
                    
                    //VIDA DE ESBIRROS
                    bw.write("VIDA_ESBIRRO: ");
                    bw.newLine();
                    bw.write(humano.getHp());
                    bw.newLine();
                    
                    //LEALTAD ESBIRRO HUMANO
                    bw.write("LELTAD: ");
                    bw.newLine();
                    if (humano.getLealtad().equals(0)) {
                        bw.write("0");
                    } else if (humano.getLealtad().equals(1)) {
                        bw.write("1");
                    } else if (humano.getLealtad().equals(2)) {
                        bw.write("2");
                    }
                    bw.newLine();
                    
                } else if (vampiro.getEsbirros().get(j).getTipo().equals("GHOUL")) {
                    Ghoul ghoul = (Ghoul) vampiro.getEsbirros().get(j);
                    //NUMERO DE ESBIRRO
                    bw.write("TIPO_ESBIRRO: ");
                    bw.newLine();
                    bw.write(vampiro.getTipo());
                    bw.newLine();
                    
                    //NOMBRE DE ESBIRRO
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.newLine();
                    bw.write(ghoul.getNombre());
                    bw.newLine();
                    
                    //VIDA DE ESBIRRO
                    bw.write("VIDA_ESBIRRO: ");
                    bw.newLine();
                    bw.write(ghoul.getHp());
                    bw.newLine();
                    
                    //DEPENDENCIA ESBIRRO
                    bw.write("DEPENDENCIA: ");
                    bw.newLine();
                    bw.write(ghoul.getDependencia());
                    bw.newLine();
                    
                } else if (vampiro.getEsbirros().get(j).getTipo().equals("DEMONIO")) {
                    Demonio demonio = (Demonio) vampiro.getEsbirros().get(j);
                    //TIPO DE ESBIRRO
                    bw.write("TIPO_ESBIRRO: ");
                    bw.newLine();
                    
                    bw.write(vampiro.getTipo());
                    bw.newLine();

                    //NOMBRE DE ESBIRRO
                    bw.write("NOMBRE_ESBIRRO: ");
                    bw.newLine();
                    bw.write(demonio.getNombre());
                    bw.newLine();
                    
                    //VIDA ESBIRRO
                    bw.write("VIDA_ESBIRRO: ");
                    bw.newLine();
                    bw.write(demonio.getHp());
                    bw.newLine();
                    
                    //DESCRIPCION / PACTO
                    bw.write("DESCRIPCION: ");
                    bw.newLine();
                    bw.write(demonio.getDescripcion());
                    bw.newLine();

                    //ESBIRROS EXTRA
                    //NUMERO DE ESBIRROS EXTRA
                    bw.write("NUMERO_ESBIRROS_EXTRA: ");
                    bw.newLine();
                    bw.write(listaCliente.get(i).getPersonaje().getEsbirros().size());
                    bw.newLine();
                    escrituraEsbirros();
                }
            }
            bw.write("FIN_USUARIO");
            bw.newLine();
        }
    

    public void sobreescribirFichero(ArrayList<Cliente> listaClientes) {

        Cliente cliente = new Cliente();
        cliente.getPersonaje().getArmas().size(); //para saber la cantidad de armas que hay
        cliente.getPersonaje().getArmas().get(0).getNombre(); //para obtener el nombre del fichero 

        //hacer varios metodos para escibir los tipos de personajes 
        //leer a partir de una linea y palabra:
    }

}
