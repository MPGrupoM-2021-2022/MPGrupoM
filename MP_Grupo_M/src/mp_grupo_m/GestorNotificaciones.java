package mp_grupo_m;

import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Combate;
import mp_grupo_m.Entidades.Desafio;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorNotificaciones {

    public void subscribeDesafio(Desafio desafio) {
        Terminal terminal = new Terminal();
        terminal.WIP();
        //gurdar nuevo desafio en su fichero
    }

    private void unsubscribeDesafio(Desafio desafio, ArrayList<Desafio> listaDesafios) {
        listaDesafios.add(desafio);
        for (int numDesafio = 0; numDesafio < listaDesafios.size(); numDesafio++) {
            if (desafio.getRegistro().equals(listaDesafios.get(numDesafio).getRegistro())) {
                listaDesafios.remove(numDesafio);
                //sobreescribir fichero desafios
                break;
            }
        }
    }

    public void notifyDesafio(Cliente cliente, Terminal terminal, ArrayList<Desafio> listaDesafios, int numDesafio) {
        int opcion;
        do {
            terminal.preguntarDesafio(listaDesafios.get(numDesafio));
            opcion = askNum();
        } while (opcion < 1 || opcion > 2);
        if (opcion == 1) {
            int cambioEquipo;
            do {
                terminal.cambiarEquipo();
                cambioEquipo = askNum();
            } while (cambioEquipo < 1 || cambioEquipo > 2);
            if (cambioEquipo == 1) {
                cliente.seleccionarEquipo(cliente);
            }
            Combate combate = new Combate();
            combate = combate.inicializarCombate(listaDesafios.get(numDesafio).getDesafiante(), cliente, listaDesafios.get(numDesafio).getOro(), listaDesafios.get(numDesafio).getModificadores(), listaDesafios.get(numDesafio).getRegistro());
            combate = combate.empezarCombate(combate);
            if (combate.getVencedor() != null) {
                if (combate.getVencedor().getNick().equals(cliente.getNick())) {
                    cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() + listaDesafios.get(numDesafio).getOro());
                    //leer fichero usuarios y sobreescribir cliente
                } else {
                    //leer fichero clientes
                    ArrayList<Cliente> listaClientes = new ArrayList<>();
                    listaClientes.add(cliente);
                    for (int numCliente = 0; numCliente < listaClientes.size(); numCliente++) {
                        if (listaClientes.get(numCliente).getNick().equals(listaDesafios.get(numDesafio).getDesafiante().getNick())) {
                            listaClientes.get(numCliente).getPersonaje().setOro(listaClientes.get(numCliente).getPersonaje().getOro() + listaDesafios.get(numDesafio).getOro() * 2);
                            break;
                        }
                    }
                    cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() - listaDesafios.get(numDesafio).getOro());
                    //sobreescribir fichero clientes
                }
            }
        } else {
            cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() - (listaDesafios.get(numDesafio).getOro() / 10));
            //leer fichero clientes
            ArrayList<Cliente> listaClientes = new ArrayList<>();
            listaClientes.add(cliente);
            for (int numCliente = 0; numCliente < listaClientes.size(); numCliente++) {
                if (listaClientes.get(numCliente).getNick().equals(listaDesafios.get(numDesafio).getDesafiante().getNick())) {
                    listaClientes.get(numCliente).getPersonaje().setOro(listaClientes.get(numCliente).getPersonaje().getOro() + listaDesafios.get(numDesafio).getOro() + (listaDesafios.get(numDesafio).getOro() / 10));
                    break;
                }
            }
        }
        unsubscribeDesafio(listaDesafios.get(numDesafio), listaDesafios);
    }

    public int askNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void notifyCombate(Combate combate) {
        Terminal terminal = new Terminal();
        terminal.mostrarCombate(combate);
    }

    public void subscribeBan(Cliente cliente) {
        Terminal terminal = new Terminal();
        terminal.WIP();
        //escribir nick en el fichero de bans
    }

    public void unsubscribeBan(String nick) {
        //leer fichero bans
        ArrayList<String> listaBans = new ArrayList<>();
        listaBans.add("nick");
        for (int numCliente = 0; numCliente < listaBans.size(); numCliente++) {
            if (listaBans.get(numCliente).equals(nick)) {
                listaBans.remove(numCliente);
                break;
            }
        }
        //sobreescribir fichero bans
    }

    public void notifyBan() {
        Terminal terminal = new Terminal();
        terminal.cuentaBaneada();
    }
}