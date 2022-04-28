package mp_grupo_m;

import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Combate;
import mp_grupo_m.Entidades.Operador;
import mp_grupo_m.Entidades.Desafio;
import mp_grupo_m.Ficheros.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    public void selector() {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        terminal.mostrarInicio();
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> {
                //REGISTRO DE USUARIO
                terminal.menuRegistroUsuario();
                int user = sc.nextInt();
                registrarUsuario(user);
            }
            case 2 -> {
                //INICIO DE SESION COMO CLIENTE
                Cliente cliente = new Cliente();
                cliente = loginCliente(cliente);
                if (cliente != null) {
                    Menu menu = new Menu();

                    LecturaFicheroCombate lecturaFicheroCombate = new LecturaFicheroCombate();
                    ArrayList<Combate> listaCombates = lecturaFicheroCombate.lecturaFicheroCombate();
                    for (Combate listaCombate : listaCombates) {
                        if (!listaCombate.isVisto() && listaCombate.getDesafiante().getNick().equals(cliente.getNick())) {
                            GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
                            gestorNotificaciones.notifyCombate(listaCombate);
                            listaCombate.setVisto(true);
                        }
                        EscrituraFicheroCombate escrituraFicheroCombate = new EscrituraFicheroCombate();
                        //********************************FALTA SOBREESCIBIR********************************************
                    }

                    LecturaFicheroDesafio lecturaFicheroDesafio = new LecturaFicheroDesafio();
                    ArrayList<Desafio> listaDesafios = lecturaFicheroDesafio.lecturaFicheroDesafio();
                    for (int i = 0; i < listaDesafios.size(); i++) {
                        if (listaDesafios.get(i).isValidated() && listaDesafios.get(i).getContrincante().getNick().equals(cliente.getNick())) {
                            GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
                            gestorNotificaciones.notifyDesafio(cliente, terminal, listaDesafios, i);
                        }
                    }
                    menu.selector(cliente, this);
                }
            }
            case 3 -> {
                //INICIO DE SESION COMO ADMIN
                Operador operador = new Operador();
                operador = loginOperador(operador);
                if (operador != null) {
                    Menu menu = new Menu();
                    menu.selectorOperador(operador, this);
                }
            }
            default -> terminal.error();
        }
    }

    public void registrarUsuario(int opcion) {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        switch (opcion) {
            case 1 -> {
                Cliente cliente = new Cliente();
                LecturaFicheroUsuarios lecturaFicheroUsuarios = new LecturaFicheroUsuarios();
                ArrayList<Cliente> lista = lecturaFicheroUsuarios.lecturaFicheroUsuarios();
                terminal.preguntarNombreUser();
                String nombre = sc.nextLine();
                cliente.setNombre(nombre);
                terminal.preguntarNick();
                String nick = sc.nextLine();
                boolean encontrado = false;
                if (!lista.isEmpty()) {
                    for (Cliente value : lista) {
                        if ((value.getNick().equals(nick))) {
                            terminal.nickExistente();
                            encontrado = true;
                            break;
                        }
                    }
                }
                if (!encontrado) {
                    cliente.setNick(nick);
                    terminal.preguntarPassword();
                    String password = sc.nextLine();
                    terminal.confirmarPassword();
                    String confirm = sc.nextLine();
                    //poner if para verificar si la contraseña es la misma, si no break;
                    if (!password.equals(confirm)) {
                        terminal.error();
                        break;
                    }
                    cliente.setPassword(password);
                    String registro = cliente.generarNumerRegistro();
                    cliente.setRegistro(registro);
                    cliente.setPersonaje(null);
                    EscrituraFicheroUsuario escrituraFicheroUsuario = new EscrituraFicheroUsuario();
                    escrituraFicheroUsuario.registroUsuario(cliente);
                }
            }
            case 2 -> {
                Operador operador = new Operador();
                LecturaFicheroOperadores lecturaFicheroOperadores = new LecturaFicheroOperadores();
                ArrayList<Operador> lista = lecturaFicheroOperadores.lecturaFicheroOperador();
                terminal.preguntarNombreUser();
                String nombre = sc.nextLine();
                operador.setNombre(nombre);
                terminal.preguntarNick();
                String nick = sc.nextLine();
                for (Operador value : lista) {
                    if ((value.getNick().equals(nick))) {
                        terminal.nickExistente();
                        break;
                    }
                }
                operador.setNick(nick);
                terminal.preguntarPassword();
                String password = sc.nextLine();
                terminal.confirmarPassword();
                String confirm = sc.nextLine();
                //poner if para verificar si la contraseña es la misma, si no break;
                if (!password.equals(confirm)) {
                    terminal.error();
                    break;
                }
                operador.setPassword(password);
                EscrituraFicheroOperadores escrituraFicheroOperadores = new EscrituraFicheroOperadores();
                escrituraFicheroOperadores.registroOperadores(operador);
            }
            case 3 -> {
            }
            default -> terminal.error();
        }
    }

    public Cliente loginCliente(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        int aux = -1;
        LecturaFicheroUsuarios lecturaFicheroUsuarios = new LecturaFicheroUsuarios();
        ArrayList<Cliente> lista = lecturaFicheroUsuarios.lecturaFicheroUsuarios();
        terminal.preguntarNick();
        String nick = sc.nextLine();
        boolean encontrado = false;
        //comparar nick con lista clientes ficheros
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNick().equals(nick)) {
                encontrado = true;
                aux = i;
                i = lista.size();
            }
        }
        if (!encontrado) {
            return null;
        }
        LecturaFicheroBans lecturaFicheroBans = new LecturaFicheroBans();
        ArrayList<String> clientesBaneados = lecturaFicheroBans.lecturaFicheroBaneados();
        if (!clientesBaneados.isEmpty()) {
            for (String clienteBaneado : clientesBaneados) {
                if (nick.equals(clienteBaneado)) {
                    GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
                    gestorNotificaciones.notifyBan();
                    return null;
                }
            }
        }
        boolean passCorrect;
        do {
            terminal.preguntarPassword();
            String password = sc.nextLine();
            //comparar password asociada al nick
            passCorrect = lista.get(aux).getPassword().equals(password);
            if (!passCorrect) {
                terminal.errorPassword();
            }
        } while (!passCorrect);
        cliente = lista.get(aux);
        return cliente;
    }

    public Operador loginOperador(Operador operador) {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        LecturaFicheroOperadores lecturaFicheroOperadores = new LecturaFicheroOperadores();
        ArrayList<Operador> lista = lecturaFicheroOperadores.lecturaFicheroOperador();
        terminal.preguntarNick();
        String nick = sc.nextLine();
        boolean encontrado = false;
        int aux = -1;
        //comparar nick con lista operadores ficheros
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNick().equals(nick)) {
                encontrado = true;
                aux = i;
                i = lista.size();
            }
        }
        if (!encontrado) {
            return null;
        }
        boolean passCorrect = false;
        do {
            terminal.preguntarPassword();
            String password = sc.nextLine();
            //comparar password asociada al nick
            passCorrect = lista.get(aux).getPassword().equals(password);
            if (!passCorrect) {
                terminal.errorPassword();
            }
        } while (!passCorrect);
        return operador;
    }
    //devolver el valor de la password (se que hay intentos infinitos pero por si se quitan y se limitan los intentos)
//        if(passCorrect){
//            return true;
//        }else{
//            return false;
//        }
}
