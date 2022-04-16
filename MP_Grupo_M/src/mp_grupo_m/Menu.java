package mp_grupo_m;

import mp_grupo_m.Entidades.Cliente;

import mp_grupo_m.Entidades.Operador;
import mp_grupo_m.Entidades.Personaje;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void selector(Cliente cliente, Sistema sistema) {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            terminal.mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (cliente.getPersonaje() == null) {
                        terminal.mostrarFactorias();
                        selectorFactoria(cliente);
                    } else {
                        terminal.eliminarPersonaje();
                    }
                    break;
                case 2:
                    cliente.eliminarPersonaje(cliente);
                    break;
                case 3:
                    cliente.seleccionarEquipo(cliente);
                    break;
                case 4:
                    //Llamada a lectura del fichero de todos los clientes
                    ArrayList<Cliente> listaClientes = new ArrayList<>();
                    cliente.desafiar(listaClientes, cliente, sistema);
                    break;
                case 5:
                    consultarCombates();
                    break;
                case 6:
                    consultarRanking();
                    break;
                case 7:
                    terminal.cerrarSesion();
                    sistema.selector();
                    break;
                case 8:
                    cliente.eliminarCuenta(cliente, sistema);
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
        Personaje personaje = null;
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                personaje = cliente.crearVampiro();
                break;
            case 2:
                personaje = cliente.crearLicantropo();
                break;
            case 3:
                personaje = cliente.crearCazador();
                break;
            default:
                terminal.error();
                break;
        }
        cliente.setPersonaje(personaje);
    }

    public void selectorOperador(Operador operador, Sistema sistema) {
        Terminal terminal = new Terminal();
        terminal.WIP();
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