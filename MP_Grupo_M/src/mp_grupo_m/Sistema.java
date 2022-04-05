package mp_grupo_m;

import java.util.Scanner;
import mp_grupo_m.Entidades.Cliente;

public class Sistema extends Terminal {

    FicheroUsuario ficheroUsuario = new FicheroUsuario();
    Terminal terminal = new Terminal();
    Cliente cliente = new Cliente();
    Menu menu = new Menu();

    public void selector() {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1: {
                //REGISTRO DE SESION
                terminal.menuRegistroUsuario();
                selectorRegistro(cliente);
                terminal.menuRegistroUsuario();
            }
            case 2: {
                //INICIO DE SESION
                terminal.WIP();
                terminal.mostrarMenu();
                menu.selector(cliente);

            }
            default:
                terminal.error();
        }
    }

    private void selectorRegistro(Cliente cliente) {

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                //REGISTRO DE USUARIO
                ficheroUsuario.registroNuevo(cliente);
                terminal.usuarioRegistrado();

            case 2:
                //VOLVER ATRÁS
                terminal.mostrarInicio();
                selector();

            default:
                terminal.WIP();

        }
    }

}
