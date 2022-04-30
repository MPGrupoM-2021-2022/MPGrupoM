package mp_grupo_m;

import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Combate;
import mp_grupo_m.Entidades.Desafio;
import mp_grupo_m.Ficheros.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorNotificaciones {

    public void subscribeDesafio(Desafio desafio) {
        EscrituraFicheroDesafio escrituraFicheroDesafio = new EscrituraFicheroDesafio();
        escrituraFicheroDesafio.registroDesafio(desafio);
    }

    private void unsubscribeDesafio(Desafio desafio, ArrayList<Desafio> listaDesafios) {
        for (int numDesafio = 0; numDesafio < listaDesafios.size(); numDesafio++) {
            if (desafio.getRegistro().equals(listaDesafios.get(numDesafio).getRegistro())) {
                listaDesafios.remove(numDesafio);
                EscrituraFicheroDesafio escrituraFicheroDesafio = new EscrituraFicheroDesafio();
                escrituraFicheroDesafio.sobreescribirFicheroDesafio(listaDesafios);
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
            combatir(cliente, terminal, listaDesafios, numDesafio);
        } else {
            noCombatir(cliente, listaDesafios, numDesafio);
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
        EscrituraFicheroBans escrituraFicheroBans = new EscrituraFicheroBans();
        escrituraFicheroBans.registroBaneado(cliente.getNick());
    }

    public void unsubscribeBan(String nick) {
        LecturaFicheroBans lecturaFicheroBans = new LecturaFicheroBans();
        ArrayList<String> listaBans = lecturaFicheroBans.lecturaFicheroBaneados();
        for (int numCliente = 0; numCliente < listaBans.size(); numCliente++) {
            if (listaBans.get(numCliente).equals(nick)) {
                listaBans.remove(numCliente);
                break;
            }
        }
        EscrituraFicheroBans escrituraFicheroBans = new EscrituraFicheroBans();
        escrituraFicheroBans.sobreescribirFicheroBaneado(listaBans);
    }

    public void notifyBan() {
        Terminal terminal = new Terminal();
        terminal.cuentaBaneada();
    }

    private void noCombatir(Cliente cliente, ArrayList<Desafio> listaDesafios, int numDesafio) {
        cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() - (listaDesafios.get(numDesafio).getOro() / 10));
        LecturaFicheroUsuarios lecturaFicheroUsuarios = new LecturaFicheroUsuarios();
        ArrayList<Cliente> listaClientes = lecturaFicheroUsuarios.lecturaFicheroUsuarios();
        for (Cliente listaCliente : listaClientes) {
            if (listaCliente.getNick().equals(listaDesafios.get(numDesafio).getDesafiante().getNick())) {
                listaCliente.getPersonaje().setOro(listaCliente.getPersonaje().getOro() + listaDesafios.get(numDesafio).getOro() + (listaDesafios.get(numDesafio).getOro() / 10));
                break;
            }
        }
        for (int numCliente = 0; numCliente < listaClientes.size(); numCliente++){
            if (cliente.getNick().equals(listaClientes.get(numCliente).getNick())){
                listaClientes.remove(numCliente);
                listaClientes.add(cliente);
                break;
            }
        }
        EscrituraFicheroUsuario escrituraFicheroUsuario = new EscrituraFicheroUsuario();
        escrituraFicheroUsuario.sobreescribirFicheroUsuario(listaClientes);
    }

    private void combatir(Cliente cliente, Terminal terminal, ArrayList<Desafio> listaDesafios, int numDesafio) {
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
                LecturaFicheroUsuarios lecturaFicheroUsuarios = new LecturaFicheroUsuarios();
                ArrayList<Cliente> listaClientes = lecturaFicheroUsuarios.lecturaFicheroUsuarios();
                for (int numCliente = 0; numCliente < listaClientes.size(); numCliente++){
                    if (cliente.getNick().equals(listaClientes.get(numCliente).getNick())){
                        listaClientes.remove(numCliente);
                        listaClientes.add(cliente);
                        break;
                    }
                }
                EscrituraFicheroUsuario escrituraFicheroUsuario = new EscrituraFicheroUsuario();
                escrituraFicheroUsuario.sobreescribirFicheroUsuario(listaClientes);
            } else {
                LecturaFicheroUsuarios lecturaFicheroUsuarios = new LecturaFicheroUsuarios();
                ArrayList<Cliente> listaClientes = lecturaFicheroUsuarios.lecturaFicheroUsuarios();
                for (Cliente listaCliente : listaClientes) {
                    if (listaCliente.getNick().equals(listaDesafios.get(numDesafio).getDesafiante().getNick())) {
                        listaCliente.getPersonaje().setOro(listaCliente.getPersonaje().getOro() + listaDesafios.get(numDesafio).getOro() * 2);
                        break;
                    }
                }
                cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() - listaDesafios.get(numDesafio).getOro());
                if (cliente.getPersonaje().getOro() < 0){
                    cliente.getPersonaje().setOro(0);
                }
                for (int numCliente = 0; numCliente < listaClientes.size(); numCliente++){
                    if (cliente.getNick().equals(listaClientes.get(numCliente).getNick())){
                        listaClientes.remove(numCliente);
                        listaClientes.add(cliente);
                        break;
                    }
                }
                EscrituraFicheroUsuario escrituraFicheroUsuario = new EscrituraFicheroUsuario();
                escrituraFicheroUsuario.sobreescribirFicheroUsuario(listaClientes);
            }
        } else {
            LecturaFicheroUsuarios lecturaFicheroUsuarios = new LecturaFicheroUsuarios();
            ArrayList<Cliente> listaClientes = lecturaFicheroUsuarios.lecturaFicheroUsuarios();
            for (Cliente listaCliente : listaClientes) {
                if (listaCliente.getNick().equals(listaDesafios.get(numDesafio).getDesafiante().getNick())) {
                    listaCliente.getPersonaje().setOro(listaCliente.getPersonaje().getOro() + listaDesafios.get(numDesafio).getOro());
                    break;
                }
            }
            EscrituraFicheroUsuario escrituraFicheroUsuario = new EscrituraFicheroUsuario();
            escrituraFicheroUsuario.sobreescribirFicheroUsuario(listaClientes);
        }
        EscrituraFicheroCombate escrituraFicheroCombate = new EscrituraFicheroCombate();
        escrituraFicheroCombate.registroCombate(combate);
    }
}