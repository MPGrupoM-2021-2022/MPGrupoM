package mp_grupo_m;

import mp_grupo_m.Factorias.FactoriaVampiros;

import java.util.Arrays;
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
        boolean rightValue;
        boolean[] rightWeapon;
        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};
        FactoriaVampiros FV = new FactoriaVampiros();
        FV.preguntarNombre();
        FV.inicializarNombre();
        FV.preguntarNombreHabilidad();
        FV.inicializarNombreHabilidad();
        do {
            FV.preguntarAtaqueHabilidad();
            rightValue = FV.inicializarAtaqueHabilidad();
        } while (!rightValue);
        do {
            FV.preguntarDefensaHabilidad();
            rightValue = FV.inicializarDefensaHabilidad();
        } while (!rightValue);
        do {
            FV.preguntarCosteHabilidad();
            rightValue = FV.inicializarCosteHabilidad();
        } while (!rightValue);
        FV.setHabilidad();
        FV.preguntarNumArmas();
        int numArmas = FV.askNum();
        for (int iterator = 1; iterator <= numArmas; iterator++){
            FV.preguntarNombreArma();
            FV.inicializarnNombreArma();
            do {
                FV.preguntarAtaqueArma();
                rightValue = FV.inicializarAtaqueArma();
            } while (!rightValue);
            do {
                FV.preguntarDefensaArma();
                rightValue = FV.inicializarDefensaArma();
            } while (!rightValue);
            do {
                FV.peguntarSingleHandArma();
                rightValue = FV.inicializarSingleHandArma();
            } while (!rightValue);
            FV.addArma();
        }
        FV.setArmas();
        do {
            FV.mostrarArmas();
            rightWeapon = FV.addArmaActiva();
        } while (!Arrays.equals(rightWeapon,aux1) && !Arrays.equals(rightWeapon,aux2));
        if (Arrays.equals(rightWeapon,aux1)){
            do {
                FV.otroArma();
                rightValue = FV.addArmaActiva2();
            } while(!rightValue);
        }
        FV.setArmasActivas();

        FV.preguntarNumArmaduras();
        int numArmaduras = FV.askNum();
        for (int iterator = 1; iterator <= numArmaduras; iterator++){
            FV.preguntarNombreArmadura();
            FV.inicializarnNombreArmadura();
            do {
                FV.preguntarDefensaArmadura();
                rightValue = FV.inicializarDefensaArmadura();
            } while (!rightValue);
            do {
                FV.preguntarAtaqueArmadura();
                rightValue = FV.inicializarAtaqueArmadura();
            } while (!rightValue);
            FV.addArmadura();
        }
        FV.setArmaduras();
        do {
            FV.mostrarArmaduras();
            rightValue = FV.addArmaduraActiva();
        } while (!rightValue);
        do{
            FV.preguntarOro();
            rightValue = FV.inicializarOro();
        } while (!rightValue);
        do{
            FV.preguntarHP();
            rightValue = FV.inicializarHP();
        } while (!rightValue);
        do{
            FV.preguntarPoder();
            rightValue = FV.inicializarPoder();
        } while (!rightValue);
        FV.peguntarNumDebilidades();
        int numDebilidades = FV.askNum();
        for (int iterator = 1; iterator <= numDebilidades; iterator++){
            FV.preguntarNombreDebilidad();
            FV.inicializarNombreDebilidad();
            FV.preguntarValorDebilidad();
            FV.inicializarValorDebilidad();
            FV.addDebilidad();
        }
        FV.setDebilidades();
        FV.peguntarNumFortalezas();
        int numFortalezas = FV.askNum();
        for (int iterator = 1; iterator <= numFortalezas; iterator++){
            FV.preguntarNombreFortaleza();
            FV.inicializarNombreFortaleza();
            FV.preguntarValorFortaleza();
            FV.inicializarValorFortaleza();
            FV.addFortaleza();
        }
        FV.setFortalezas();
    }
}