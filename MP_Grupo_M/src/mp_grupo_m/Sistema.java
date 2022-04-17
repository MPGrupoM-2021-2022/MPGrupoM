package mp_grupo_m;

import java.io.IOException;
import mp_grupo_m.Entidades.Personaje;

import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Desafio;

import java.util.Scanner;
import mp_grupo_m.Entidades.User;

public class Sistema {

    RegistroFichero ficheroUsuario = new RegistroFichero();
    Terminal terminal = new Terminal();
    Cliente cliente = new Cliente();
    Personaje personaje = new Personaje();
    Menu menu = new Menu();

    public void selector() throws IOException{
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1: {//REGISTRO DE SESION
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

    private void selectorRegistro(Cliente cliente, Personaje personaje) throws IOException  {

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                //REGISTRO DE USUARIO
                cliente.setNumeroUsuario(1);
                cliente.setNombre("SERGIO");
                cliente.setNick("NICK_SERGIO");
                cliente.setPassword("CONTRASEÑA_SERGIO");
                cliente.setRegistro("REGISTRO_SERGIO");
                personaje.setNombre("Nombre Personaje");
                ficheroUsuario.registroUsuario(cliente, personaje);
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
