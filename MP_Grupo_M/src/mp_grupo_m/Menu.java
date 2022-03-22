package mp_grupo_m;

import java.util.Scanner;

public class Menu {

    public void mostrar() {
        System.out.println("************MENU************");
        System.out.println("1. REGISTRAR PERSONAJE");
        System.out.println("2. ELIMINAR PERSONAJE");
        System.out.println("3. SELECCIONAR EQUIPO");
        System.out.println("4. DESAFIAR");
        System.out.println("5. CONSULTAR COMBATES");
        System.out.println("6. CONSULTAR RANKING GLOBAL");
        System.out.println("7. SALIR");
        System.out.println("****************************");
        selector();
    }

    public void selector() {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 ->
                System.out.println("En desarrollo...");
            case 2 ->
                System.out.println("En desarrollo...");
            case 3 ->
                System.out.println("En desarrollo...");
            case 4 ->
                System.out.println("En desarrollo...");
            case 5 ->
                System.out.println("En desarrollo...");
            case 6 ->
                System.out.println("En desarrollo...");
            case 7 ->
                System.out.println("Saliendo...");
            default ->
                System.out.println("ERROR");
        }
    }
}