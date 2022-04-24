package mp_grupo_m;

import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Combate;
import mp_grupo_m.Entidades.Operador;
import mp_grupo_m.Entidades.Desafio;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema{

    public void selector() {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1: {
                //REGISTRO DE SESION
                terminal.menuRegistroUsuario();
                int user = sc.nextInt();
                registrarUsuario(user);
                break;
            }
            case 2: {
                //INICIO DE SESION COMO CLIENTE
                Cliente cliente = new Cliente();
                boolean login = loginCliente(cliente);
                if (login) {
                    Menu menu = new Menu();

                    //leer fichero de combates
//                    ArrayList<Combate> listaCombates = new ArrayList<>();
//                    Combate combate = new Combate();
//                    listaCombates.add(combate);
//                    for (int i = 0; i < listaCombates.size(); i++){
//                        if (!listaCombates.get(i).isVisto() && listaCombates.get(i).getDesafiante().getNick().equals(cliente.getNick())){
//                            GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
//                            gestorNotificaciones.notifyCombate(listaCombates.get(i));
//                            listaCombates.get(i).setVisto(true);
//                        }
//                        //sobreescribir fichero combates
//                    }

                    Desafio desafio = new Desafio();
                    ArrayList<Desafio> listaDesafios = new ArrayList<>(); //leerlo de fichero y meter observer
                    listaDesafios.add(desafio);
                    for (int i = 0; i < listaDesafios.size(); i++){
                        if (listaDesafios.get(i).isValidated() && listaDesafios.get(i).getContrincante().getNick().equals(cliente.getNick())){
                            GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
                            gestorNotificaciones.notifyDesafio(cliente, terminal, listaDesafios, i);
                        }
                    }

                    menu.selector(cliente, this);
                }
                break;
            }
            case 3:{
                //INICIO DE SESION COMO ADMIN
                Operador operador = new Operador();
                boolean login = loginOperador(operador);
                if (login) {
                    Menu menu = new Menu();
                    menu.selectorOperador(operador, this);
                }
                break;
            }
            default:
                terminal.error();
        }
    }

    public void avisarAdmin(Cliente cliente, int contrincante, int oro, ArrayList<Cliente> listaClientes) {
        Terminal terminal = new Terminal();
        terminal.WIP();
    }

    public void registrarUsuario(int opcion) {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        switch (opcion) {
            case 1: {
                Cliente cliente = new Cliente();
                ArrayList<Cliente> lista = new ArrayList<>();
                lista.add(cliente);
                terminal.preguntarNombreUser();
                String nombre = sc.nextLine();
                cliente.setNombre(nombre);
                terminal.preguntarNick();
                String nick = sc.nextLine();
                for (Cliente value : lista) {
                    if ((value.getNick().equals(nick))) {
                        terminal.nickExistente();
                        break;
                    }
                }
                cliente.setNick(nick);
                terminal.preguntarPassword();
                String password = sc.nextLine();
                terminal.confirmarPassword();
                String confirm = sc.nextLine();
                //poner if para verificar si la contraseña es la misma, si no break;
                if (!password.equals(confirm)){
                    terminal.error();
                    break;
                }
                cliente.setPassword(password);
                String registro = cliente.generarNumerRegistro();
                cliente.setRegistro(registro);
                cliente.setPersonaje(null);
                System.out.println(cliente.getNombre());
                System.out.println(cliente.getNick());
                System.out.println(cliente.getPassword());
                System.out.println(cliente.getRegistro());


                break;
            }
            case 2: {
                Operador operador = new Operador();
                ArrayList<Operador> lista = new ArrayList<>();
                lista.add(operador);
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
                if (!password.equals(confirm)){
                    terminal.error();
                    break;
                }
                operador.setPassword(password);
                System.out.println(operador.getNombre());
                System.out.println(operador.getNick());

                break;
            }
            case 3:{
                break;
            }
            default:
                terminal.error();
        }
    }

    public boolean loginCliente(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        int aux = -1;
        ArrayList<Cliente> lista = new ArrayList<>();
        cliente.setNombre("pepe viruela");
        cliente.setRegistro("lu12o");
        cliente.setNick("pepe");
        cliente.setPassword("123");
        lista.add(cliente);
        //coger lista clientes ficheros
        terminal.preguntarNick();
        String nick = sc.nextLine();
        boolean encontrado = false;
        //comparar nick con lista clientes ficheros
        for(int i = 0; i<lista.size(); i++)
        {
            if (lista.get(i).getNick().equals(nick)){
               encontrado = true;
               aux = i;
               i = lista.size();
            }
        }
        if (!encontrado){
            return false;
        }
        boolean passCorrect = false;
        do {
            terminal.preguntarPassword();
            String password = sc.nextLine();
            //comparar password asociada al nick
            passCorrect = lista.get(aux).getPassword().equals(password);
            if(!passCorrect) {
                terminal.errorPassword();
            }
        } while (!passCorrect);
        cliente = lista.get(aux);
        return passCorrect;
        //devolver el valor de la password (se que hay intentos infinitos pero por si se quitan y se limitan los intentos)
//        if(passCorrect){
//            return true;
//        }else{
//            return false;
//        }
    }

    public boolean loginOperador(Operador operador) {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        ArrayList<Operador> lista = new ArrayList<>();
        operador.setNick("pepe");
        operador.setPassword("123");
        lista.add(operador);
        //coger lista operadores ficheros
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
            return false;
        }
        boolean passCorrect = false;
        do {
            terminal.preguntarPassword();
            String password = sc.nextLine();
            //comparar password asociada al nick
            passCorrect = lista.get(aux).getPassword().equals(password);
            terminal.errorPassword();
        } while (!passCorrect);
        operador = lista.get(aux);
        return passCorrect;
    }
        //devolver el valor de la password (se que hay intentos infinitos pero por si se quitan y se limitan los intentos)
//        if(passCorrect){
//            return true;
//        }else{
//            return false;
//        }
}
