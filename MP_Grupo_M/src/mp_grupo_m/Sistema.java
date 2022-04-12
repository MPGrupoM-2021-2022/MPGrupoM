package mp_grupo_m;

import mp_grupo_m.Entidades.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema{

    public void selector() {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1: {
                //REGISTRO DE SESION
                User user = new User();
                terminal.menuRegistroUsuario();
                user.selector();
                terminal.menuRegistroUsuario();
            }
            case 2: {
                //INICIO DE SESION
                Menu menu = new Menu();
                terminal.WIP();
                Cliente cliente = new Cliente();
                menu.selector(cliente, this);

            }
            default:
                terminal.error();
        }
    }

    public void avisarAdmin(Cliente cliente, int contrincante, int oro, ArrayList<Cliente> listaClientes) {
        Terminal terminal = new Terminal();
        terminal.WIP();
    }
}
