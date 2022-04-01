package mp_grupo_m;

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
                terminal.WIP();
                terminal.mostrarMenu();
                menu.selector();

            }
            default ->
                terminal.error();
        }
    }

}
