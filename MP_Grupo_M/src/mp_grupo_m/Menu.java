package mp_grupo_m;

import mp_grupo_m.Entidades.*;

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
                    if (cliente.getPersonaje() != null) {
                        cliente.eliminarPersonaje(cliente);
                    } else
                        terminal.error();
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
                    consultarCombates(cliente);
                    break;
                case 6:
                    consultarRanking(cliente);
                    break;
                case 7:
                    terminal.cerrarSesion();
                    sistema.selector();
                    break;
                case 8:
                    cliente.eliminarCuenta(cliente, sistema);
                    break;
                default:
                    terminal.error();
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
        Scanner sc = new Scanner(System.in);
        terminal.WIP();

        int opcion;
        do {
            terminal.mostrarMenuOperador();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    operador.modificarPersonaje();
                    break;
                case 2:
                    operador.validarDesafio();
                    break;
                case 3:
                    operador.desbanearUser();
                    break;
                case 4:
                    terminal.cerrarSesion();
                    sistema.selector();
                    break;
                case 5:
                    operador.eliminarCuenta(operador, sistema);
                    break;
                default:
                    terminal.error();
                    break;
            }
        } while (opcion != 4 && opcion != 5);
    }

    private void consultarCombates(Cliente cliente) {
        Terminal terminal = new Terminal();
        terminal.WIP();
        //leer fichero combates
        ArrayList<Combate> listaCombates = new ArrayList<>();
        Combate combate = new Combate();
        listaCombates.add(combate);
        for (int i = 0; i < listaCombates.size(); i++){
            if (listaCombates.get(i).getDesafiante().getNick().equals(cliente.getNick()) || listaCombates.get(i).getContrincante().getNick().equals(cliente.getNick())){
                terminal.mostrarCombate(listaCombates.get(i));
            }
        }
    }

    private void consultarRanking(Cliente cliente) {
        cliente.consultarRanking();
    }
}