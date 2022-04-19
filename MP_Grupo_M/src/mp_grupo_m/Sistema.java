package mp_grupo_m;

import mp_grupo_m.Ficheros.controlFicheroUsuarios;
import java.io.IOException;
import mp_grupo_m.Entidades.Personaje;

import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Desafio;

import java.util.Scanner;
import mp_grupo_m.Entidades.Disciplina;
import mp_grupo_m.Entidades.Habilidad;
import mp_grupo_m.Entidades.User;
import mp_grupo_m.Entidades.Vampiro;

public class Sistema {

    controlFicheroUsuarios ficheroUsuario = new controlFicheroUsuarios();
    Terminal terminal = new Terminal();
    Cliente cliente = new Cliente();
    Personaje personaje = new Personaje();
    Vampiro vampiro = new Vampiro();
    Habilidad habilidad = new Habilidad();
    Disciplina disciplina = new Disciplina();
    Menu menu = new Menu();

    public void selector() throws IOException {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1: {//REGISTRO DE SESION
                
                cliente.setNombre("SERGIO");
                cliente.setNick("NICK");
                cliente.setPassword("passqrod");
                cliente.setRegistro("REGISTRO123123");
                personaje.setTipo("VAMPIRO");
                vampiro.setNombre("NOMBRE_VAMPIRO");
                habilidad.setAtaque(3);
                habilidad.setDefensa(3);
                disciplina.setCosteSangre(3);
                
                
                
                
                
                
                terminal.menuRegistroUsuario();
                selectorRegistro(cliente, personaje);
                terminal.menuRegistroUsuario();
                break;
            }
            case 2: {
                //INICIO DE SESION
                //terminal.inicioSesion(); le pregunta al usuario que inicie sesion con el nick y password
                //FALTA POR HACER
                terminal.WIP();
                terminal.mostrarMenu();
                menu.selector(cliente, this);
                break;
            }
            default:
                terminal.error();
        }
    }

    private void selectorRegistro(Cliente cliente, Personaje personaje) throws IOException {

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                //REGISTRO DE USUARIO
                ficheroUsuario.registroUsuario(cliente, personaje);
                ficheroUsuario.lecturaFichero();
                // ficheroUsuario.registroPersonaje(cliente, personaje);
                //mensaje de USUARIO NUEVO REGISTRADO
                //terminal.usuarioRegistrado();
                break;

            case 2:
                //VOLVER ATRÁS
                terminal.mostrarInicio();
                selector();
                break;

            default:
                terminal.WIP();

        }
    }

    public void avisarAdmin(Desafio desafio) {
        Terminal terminal = new Terminal();
        terminal.WIP();
    }

}
