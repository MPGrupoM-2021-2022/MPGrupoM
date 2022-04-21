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

    private void unsubscribeDesafio(Desafio desafio, ArrayList<Desafio> listaDesafios){
        listaDesafios.add(desafio);
        for (int i = 0; i < listaDesafios.size(); i++){
            if (desafio.getRegistro().equals(listaDesafios.get(i).getRegistro())){
                listaDesafios.remove(i);
                //sobreescribir fichero desafios
                break;
            }
        }
    }

    public void notifyDesafio(Cliente cliente, Terminal terminal, ArrayList<Desafio> listaDesafios, int i) {
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
            combate.inicializarCombate(listaDesafios.get(i).getDesafiante(), cliente, listaDesafios.get(i).getOro(), listaDesafios.get(i).getModificadores(), listaDesafios.get(i).getRegistro());
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
                            listaClientes.get(j).getPersonaje().setOro(listaClientes.get(j).getPersonaje().getOro() + listaDesafios.get(i).getOro()*2);
                            break;
                        }
                    }
                    cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() - listaDesafios.get(i).getOro());
                    //sobreescribir fichero clientes
                }
            }
        } else {
            cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() - (listaDesafios.get(i).getOro()/10));
            //leer fichero clientes
            ArrayList<Cliente> listaClientes = new ArrayList<>();
            listaClientes.add(cliente);
            for (int j = 0; j < listaClientes.size(); j++){
                if (listaClientes.get(j).getNick().equals(listaDesafios.get(i).getDesafiante().getNick())){
                    listaClientes.get(j).getPersonaje().setOro(listaClientes.get(j).getPersonaje().getOro() + listaDesafios.get(i).getOro() + (listaDesafios.get(i).getOro()/10));
                    break;
                }
            }
        }
        unsubscribeDesafio(listaDesafios.get(i), listaDesafios);
    }

    public int askNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void notifyCombate(Combate combate) {
        Terminal terminal = new Terminal();
        terminal.mostrarCombate(combate);
    }
}
