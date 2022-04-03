package mp_grupo_m;

import mp_grupo_m.Entidades.Cliente;

import java.util.Scanner;

public class Sistema {

    public void selector() {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 ->
                terminal.WIP();
            case 2 -> {
                Menu menu = new Menu();
                //Cambiar todo esto
                terminal.WIP();
                Cliente cliente = new Cliente();
                //Hasta aqui
                menu.selector(cliente);

            }
            default ->
                terminal.error();
        }
    }

}
