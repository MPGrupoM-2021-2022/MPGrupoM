package mp_grupo_m;

import java.io.IOException;
import mp_grupo_m.Entidades.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void selector(Cliente cliente, Sistema sistema) throws IOException {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);

        Desafio desafio = new Desafio();
        ArrayList<Desafio> listaDesafios = new ArrayList<>(); //leerlo de fichero y meter observer
        listaDesafios.add(desafio);
        for (int i = 0; i < listaDesafios.size(); i++){
            if (listaDesafios.get(i).isValidated() && listaDesafios.get(i).getContrincante().getNick().equals(cliente.getNick())){
                int opcion;
                do {
                    terminal.preguntarDesafio(listaDesafios.get(i));
                    opcion = askNum();
                } while (opcion < 1 || opcion > 2);
                if (opcion == 1) {
                    int cambioEquipo;
                    do {
                        terminal.cambiarEquipo();
                        cambioEquipo = askNum();
                    } while (cambioEquipo < 1 || cambioEquipo > 2);
                    if (cambioEquipo == 1){
                        cliente.seleccionarEquipo(cliente);
                    }
                    Combate combate = new Combate();
                    combate.inicializarCombate(listaDesafios.get(i).getDesafiante(), cliente, listaDesafios.get(i).getOro(), listaDesafios.get(i).getModificadores());
                    combate = combate.empezarCombate(combate);
                    if (combate.getVencedor() != null){
                        if (combate.getVencedor().getNick().equals(cliente.getNick())){
                            cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() + listaDesafios.get(i).getOro());
                            //leer fichero usuarios y sobreescribir cliente
                        } else {
                            //leer fichero clientes
                            ArrayList<Cliente> listaClientes = new ArrayList<>();
                            listaClientes.add(cliente);
                            for (int j = 0; j < listaClientes.size(); j++){
                                if (listaClientes.get(j).getNick().equals(listaDesafios.get(i).getDesafiante().getNick())){
                                    listaClientes.get(j).getPersonaje().setOro(listaClientes.get(j).getPersonaje().getOro() + listaDesafios.get(i).getOro());
                                }
                            }
                        }
                    }
                } else {
                    cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() - (listaDesafios.get(i).getOro()/10));
                }
            }
        }

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
                    consultarCombates();
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

    private void consultarRanking(Cliente cliente) {
        cliente.consultarRanking();
    }

    public int askNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}