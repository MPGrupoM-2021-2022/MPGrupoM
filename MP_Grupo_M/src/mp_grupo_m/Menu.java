package mp_grupo_m;

import mp_grupo_m.Entidades.Cliente;

import java.util.Scanner;

public class Menu {

    public void selector(Cliente cliente) {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            terminal.mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    //comprobar que el usuario no tiene un personaje ya creado, mandar un mensaje en dicho caso
                    terminal.mostrarFactorias();
                    selectorFactoria(cliente);
                    break;
                case 2:
                    cliente.eliminarPersonaje();
                    break;
                case 3:
                    cliente.seleccionarEquipo();
                    break;
                case 4:
                    cliente.desafiar();
                    break;
                case 5:
                    consultarCombates();
                    break;
                case 6:
                    consultarRanking();
                    break;
                case 7:
                    break;
                case 8:
                    cliente.eliminarCuenta();
                    break;
                default:
                    terminal.WIP();
                    break;
            }
        } while (opcion != 7 && opcion != 8);
    }

    private void selectorFactoria(Cliente cliente) {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                cliente.crearVampiro();
                break;
            case 2:
                cliente.crearLicantropo();
                break;
            case 3:
                terminal.WIP();
                break;
            default:
                terminal.error();
                break;
        }
    }

    private void consultarCombates() {
        Terminal terminal = new Terminal();
        terminal.WIP();
    }

    private void consultarRanking() {
        Terminal terminal = new Terminal();
        terminal.WIP();
    }
}