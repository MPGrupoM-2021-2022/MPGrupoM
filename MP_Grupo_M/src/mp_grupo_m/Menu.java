package mp_grupo_m;

import mp_grupo_m.Factorias.FactoriaVampiros;

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

    private void selector() {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                //comprobar que el usuario no tiene un personaje ya creado, mandar un mensaje en dicho caso
                mostrarFactorias();
            case 2:
                System.out.println("En desarrollo...");
            case 3:
                System.out.println("En desarrollo...");
            case 4:
                System.out.println("En desarrollo...");
            case 5:
                System.out.println("En desarrollo...");
            case 6:
                System.out.println("En desarrollo...");
            case 7:
                System.out.println("Saliendo...");
            default:
                System.out.println("ERROR");
        }
    }

    private void mostrarFactorias() {
        System.out.println("Seleccione que tipo de personaje quiere crear:");
        System.out.println("1. Vampiro");
        System.out.println("2. Licantropo");
        System.out.println("3. Cazador");
        selectorFactoria();
    }

    private void selectorFactoria() {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        boolean correctValue;
        switch (opcion) {
            case 1:
                crearVampiro();
            case 2:
                System.out.println("En desarrollo...");
            case 3:
                System.out.println("En desarrollo...");
            default:
                System.out.println("ERROR");
        }
    }

    private void crearVampiro() {
        boolean correctValue;
        FactoriaVampiros FV = new FactoriaVampiros();
        FV.preguntarNombre();
        FV.inicializarNombre();
        FV.preguntarNombreHabilidad();
        FV.inicializarNombreHabilidad();
        do {
            FV.preguntarAtaqueHabilidad();
            correctValue = FV.inicializarAtaqueHabilidad();
        } while (!correctValue);
        do {
            FV.preguntarDefensaHabilidad();
            correctValue = FV.inicializarDefensaHabilidad();
        } while (!correctValue);
    }
}