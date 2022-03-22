package mp_grupo_m;

import java.util.Scanner;

public class Inicio {

    public void mostrar() {
        System.out.println("1. REGISTRARSE");
        System.out.println("2. INICIAR SESION");
        selector();
    }

    private void selector() {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 ->
                System.out.println("En desarrollo...");
            case 2 -> {
                Menu menu = new Menu();
                menu.mostrar();
            }
            default ->
                System.out.println("ERROR");
        }
    }

}
