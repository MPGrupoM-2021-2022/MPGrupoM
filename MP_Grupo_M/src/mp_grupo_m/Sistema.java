package mp_grupo_m;

import java.util.Scanner;

public class Sistema extends Terminal{

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
                terminal.mostrarMenu();
                menu.selector();

            }
            default:
                terminal.error();
        }
    }

}
