package mp_grupo_m;

import mp_grupo_m.Entidades.*;
import mp_grupo_m.Ficheros.EscrituraFicheroUsuario;
import mp_grupo_m.Ficheros.LecturaFicheroCombate;
import mp_grupo_m.Ficheros.LecturaFicheroUsuarios;

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
                    if(cliente.getPersonaje()!=null) {
                        cliente.seleccionarEquipo(cliente);
                    }else{
                        terminal.noHayPersonaje();
                    }
                    break;
                case 4:
                    //Llamada a lectura del fichero de todos los clientes
                    cliente.desafiar(cliente);
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
            case 1 -> personaje = cliente.crearVampiro();
            case 2 -> personaje = cliente.crearLicantropo();
            case 3 -> personaje = cliente.crearCazador();
            default -> terminal.error();
        }
        cliente.setPersonaje(personaje);
        LecturaFicheroUsuarios lecturaFicheroUsuarios = new LecturaFicheroUsuarios();
        EscrituraFicheroUsuario escrituraFicheroUsuario = new EscrituraFicheroUsuario();
        ArrayList<Cliente> listaClientes = lecturaFicheroUsuarios.lecturaFicheroUsuarios();
        for (int numCliente = 0; numCliente < listaClientes.size(); numCliente++){
            if (cliente.getNick().equals(listaClientes.get(numCliente).getNick())){
                listaClientes.remove(numCliente);
                listaClientes.add(cliente);
                escrituraFicheroUsuario.sobreescribirFicheroUsuario(listaClientes);
                break;
            }
        }
    }

    public void selectorOperador(Operador operador, Sistema sistema) {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            terminal.mostrarMenuOperador();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> operador.modificarPersonaje();
                case 2 -> operador.validarDesafio();
                case 3 -> operador.desbanearUser();
                case 4 -> {
                    terminal.cerrarSesion();
                    sistema.selector();
                }
                case 5 -> operador.eliminarCuenta(operador, sistema);
                default -> terminal.error();
            }
        } while (opcion != 4 && opcion != 5);
    }

    private void consultarCombates(Cliente cliente) {
        Terminal terminal = new Terminal();
        LecturaFicheroCombate lecturaFicheroCombate = new LecturaFicheroCombate();
        ArrayList<Combate> listaCombates = lecturaFicheroCombate.lecturaFicheroCombate();
        boolean encontrado = false;
        for (Combate listaCombate : listaCombates) {
            if (listaCombate.getDesafiante().getNick().equals(cliente.getNick()) || listaCombate.getContrincante().getNick().equals(cliente.getNick())) {
                encontrado = true;
                terminal.mostrarCombate(listaCombate);
            }
        }
        if(!encontrado){
            terminal.noHayCombates();
        }
    }

    private void consultarRanking(Cliente cliente) {
        cliente.consultarRanking();
    }
}