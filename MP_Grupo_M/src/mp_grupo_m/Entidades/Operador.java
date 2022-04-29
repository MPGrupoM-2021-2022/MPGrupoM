package mp_grupo_m.Entidades;

import mp_grupo_m.Factorias.FactoriaCazadores;
import mp_grupo_m.Factorias.FactoriaVampiros;
import mp_grupo_m.Factorias.FactoriaLicantropos;
import mp_grupo_m.Ficheros.*;
import mp_grupo_m.GestorNotificaciones;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Operador extends User {

    public void modificarPersonaje() {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        LecturaFicheroUsuarios lecturaFicheroUsuarios = new LecturaFicheroUsuarios();
        ArrayList<Cliente> listaClientes = lecturaFicheroUsuarios.lecturaFicheroUsuarios(); //coger fichero lista clientes
        Cliente cliente = new Cliente();
        boolean encontrado = false;
        do {
            terminal.mostrarNicks(listaClientes);
            terminal.preguntarNickAdmin();
            String nick = sc.nextLine();
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).getNick().equals(nick)) {
                    encontrado = true;
                    cliente = listaClientes.get(i);
                    i = listaClientes.size();
                }
            }
            if (!encontrado) {
                terminal.errorNick();
            }
        } while (!encontrado);
        FactoriaVampiros factoriaVampiros = new FactoriaVampiros();
        FactoriaCazadores factoriaCazadores = new FactoriaCazadores();
        FactoriaLicantropos factoriaLicantropos = new FactoriaLicantropos();
        int opcion;
        do {
            terminal.menuModPersonaje();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> cambiarNombre(terminal, cliente);
                case 2 -> cambiarHabilidad(terminal, cliente, factoriaVampiros, factoriaCazadores, factoriaLicantropos);
                case 3 -> cambiarArmas(sc, terminal, cliente, factoriaCazadores);
                case 4 -> cambiarArmasActivas(terminal, cliente, factoriaVampiros, factoriaCazadores, factoriaLicantropos);
                case 5 -> cambiarArmaduras(sc, terminal, cliente, factoriaCazadores);
                case 6 -> cambiarArmaduraActiva(terminal, cliente);
                case 7 -> cambiarEsbirros(sc, terminal, cliente);
                case 8 -> cambiarOro(sc, terminal, cliente);
                case 9 -> cambiarHP(sc, terminal, cliente);
                case 10 -> cambiarPoder(sc, terminal, cliente);
                case 11 -> cambiarDebilidades(sc, terminal, cliente, factoriaCazadores);
                case 12 -> cambiarFortalezas(sc, terminal, cliente, factoriaCazadores);
                case 13 -> cambiarTipo(sc, terminal, cliente, factoriaVampiros, factoriaCazadores, factoriaLicantropos);
                case 14 -> terminal.salir();
                default -> terminal.error();
            }
        } while (opcion != 14);
        EscrituraFicheroUsuario escrituraFicheroUsuario = new EscrituraFicheroUsuario();
        for (int numCliente = 0; numCliente < listaClientes.size(); numCliente++){
            if (cliente.getNick().equals(listaClientes.get(numCliente).getNick())){
                listaClientes.remove(numCliente);
                listaClientes.add(cliente);
                escrituraFicheroUsuario.sobreescribirFicheroUsuario(listaClientes);
                break;
            }
        }
        terminal.modificarCliente();
    }

    public void validarDesafio() {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        Cliente desafiante, contrincante = new Cliente();
        LecturaFicheroDesafio lecturaFicheroDesafio = new LecturaFicheroDesafio();
        ArrayList<Desafio> listaDesafios = lecturaFicheroDesafio.lecturaFicheroDesafio();

        for (int i = 0; i < listaDesafios.size(); i++) {
            if (!listaDesafios.get(i).isValidated()) {
                desafiante = listaDesafios.get(i).getDesafiante();
                contrincante = listaDesafios.get(i).getContrincante();
                Date fechaDesafio = listaDesafios.get(i).getFecha();
                boolean banear = comprobarBan(fechaDesafio, contrincante);
                if (banear) {
                    banearUser(desafiante);
                } else {
                    terminal.mostrarModificadoresDesafio(desafiante, contrincante, i);
                    int opcion;
                    do {
                        terminal.validarDesafio();
                        opcion = sc.nextInt();
                        if (opcion != 0 && opcion != 1) {
                            terminal.numValido();
                        }
                    } while (opcion != 0 && opcion != 1);
                    if (opcion == 0) {
                        listaDesafios.get(i).setValidated(true);
                        ArrayList<Modificador> listaMods = new ArrayList<>();
                        String modificacion;
                        terminal.eleccionFortalezas();
                        do {
                            modificacion = sc.nextLine();
                            boolean encontrado = false;
                            for (int j = 0; j < desafiante.getPersonaje().getFortalezas().size(); j++) {
                                if (desafiante.getPersonaje().getFortalezas().get(j).getNombre().equals(modificacion)) {
                                    listaMods.add(desafiante.getPersonaje().getFortalezas().get(j));
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                for (int j = 0; j < contrincante.getPersonaje().getFortalezas().size(); j++) {
                                    if (contrincante.getPersonaje().getFortalezas().get(j).getNombre().equals(modificacion)) {
                                        listaMods.add(contrincante.getPersonaje().getFortalezas().get(j));
                                        encontrado = true;
                                    }
                                }
                            }
                            if (!encontrado) {
                                terminal.errorMod();
                            }
                        } while (!modificacion.equals("continuar"));

                        terminal.eleccionDebilidades();
                        do {
                            modificacion = sc.nextLine();
                            boolean encontrado = false;
                            for (int j = 0; j < desafiante.getPersonaje().getDebilidades().size(); j++) {
                                if (desafiante.getPersonaje().getDebilidades().get(j).getNombre().equals(modificacion)) {
                                    listaMods.add(desafiante.getPersonaje().getDebilidades().get(j));
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                for (int j = 0; j < contrincante.getPersonaje().getDebilidades().size(); j++) {
                                    if (contrincante.getPersonaje().getDebilidades().get(j).getNombre().equals(modificacion)) {
                                        listaMods.add(contrincante.getPersonaje().getDebilidades().get(j));
                                        encontrado = true;
                                    }
                                }
                            }
                            if (!encontrado) {
                                terminal.errorMod();
                            }
                        } while (!modificacion.equals("salir"));
                        listaDesafios.get(i).setModificadores(listaMods);
                    } else {
                        listaDesafios.remove(i);
                    }
                }
            }
        }
    }

    private boolean comprobarBan(Date fechaDesafio, Cliente cliente) {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        LecturaFicheroCombate lecturaFicheroCombate = new LecturaFicheroCombate();
        ArrayList<Combate> listaCombates = lecturaFicheroCombate.lecturaFicheroCombate();
        boolean sugerirBan = false;
        boolean banear = false;
        for (Combate listaCombate : listaCombates) {
            if (listaCombate.getDesafiante().equals(cliente) ||
                    listaCombate.getContrincante().equals(cliente)) {
                Date fechaDesafioAnterior = listaCombate.getFecha();
                long diferencia = fechaDesafio.getTime() - fechaDesafioAnterior.getTime();
                long horas = TimeUnit.MILLISECONDS.toHours(diferencia);
                if (horas <= 24 && (!listaCombate.getVencedor().getNick().equals(cliente.getNick())
                        || listaCombate.getVencedor() != null)) {
                    sugerirBan = true;
                    break;
                }
            }
        }
        if (sugerirBan) {
            int opcion;
            do {
                terminal.preguntarBan();
                opcion = sc.nextInt();
            } while (opcion != 1 && opcion != 2);
            if (opcion == 1) {
                banear = true;
            }
        }
        return banear;
    }

    public void banearUser(Cliente cliente) {
        GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
        gestorNotificaciones.subscribeBan(cliente);
    }

    public void desbanearUser() {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
        LecturaFicheroBans lecturaFicheroBans = new LecturaFicheroBans();
        ArrayList<String> listaClientes = lecturaFicheroBans.lecturaFicheroBaneados();
        terminal.mostrarClientes(listaClientes);
        if (!listaClientes.isEmpty()) {
            int opcion = sc.nextInt();
            String nick = listaClientes.get(opcion - 1);
            gestorNotificaciones.unsubscribeBan(nick);
        }
    }


    public void eliminarCuenta(Operador operador, Sistema sistema) {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        terminal.confirmarDelete();
        boolean delete = sc.nextInt() == 1;
        if (delete) {
            LecturaFicheroOperadores lecturaFicheroOperadores = new LecturaFicheroOperadores();
            ArrayList<Operador> listaOperadores = lecturaFicheroOperadores.lecturaFicheroOperador();
            for (int i = 0; i <= listaOperadores.size(); i++) {
                if (listaOperadores.get(i).getNick().equals(operador.getNick())) {
                    listaOperadores.remove(i);
                    break;
                }
            }
            EscrituraFicheroOperadores escrituraFicheroOperadores = new EscrituraFicheroOperadores();
            escrituraFicheroOperadores.sobreescribirFicheroOperador(listaOperadores);
            terminal.cerrarSesion();
            sistema.selector();
        }
    }

    private boolean addArmaduraActiva(Personaje personaje, ArrayList<Armadura> armaduras) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armaduras.size() + 1)) {
            return false;
        }
        Armadura armadura = armaduras.get(opcion - 1);
        personaje.setArmaduraActiva(armadura);
        return true;
    }

    private void cambiarNombre(Terminal terminal, Cliente cliente) {
        //modificar nombre
        Scanner sc = new Scanner(System.in);
        terminal.mostrarNombre(cliente.getPersonaje());
        terminal.introModificacion();
        String nombre = sc.nextLine();
        cliente.getPersonaje().setNombre(nombre);
    }

    private void cambiarHabilidad(Terminal terminal, Cliente cliente, FactoriaVampiros factoriaVampiros, FactoriaCazadores factoriaCazadores, FactoriaLicantropos factoriaLicantropos) {
        //modificar habilidad
        boolean rightValue;
        terminal.mostrarTipo();
        System.out.println(cliente.getPersonaje().getTipo());
        switch (cliente.getPersonaje().getTipo()) {
            case "VAMPIRO" -> {
                cambiarDisciplina(terminal, cliente, factoriaVampiros);
            }
            case "CAZADOR" -> {
                cambiarTalento(terminal, cliente, factoriaCazadores);
            }
            case "LICANTROPO" -> {
                cambiarDon(terminal, cliente, factoriaLicantropos);
            }
        }
    }

    private void cambiarDon(Terminal terminal, Cliente cliente, FactoriaLicantropos factoriaLicantropos) {
        boolean rightValue;
        Licantropo licantropo = (Licantropo) cliente.getPersonaje();
        Don don = (Don) licantropo.getHabilidad();
        terminal.mostrarDon(don);
        terminal.preguntarNombreHabilidad();
        factoriaLicantropos.inicializarNombreHabilidad(don);
        licantropo.setRabia(0);
        do {
            terminal.preguntarRabiaHabilidad();
            rightValue = factoriaLicantropos.inicializarRabiaHabilidad(don);
        } while (!rightValue);
        factoriaLicantropos.setHabilidad(licantropo, don);
    }

    private void cambiarTalento(Terminal terminal, Cliente cliente, FactoriaCazadores factoriaCazadores) {
        boolean rightValue;
        Cazador cazador = (Cazador) cliente.getPersonaje();
        Talento talento = (Talento) cazador.getHabilidad();
        terminal.mostrarTalento(talento);
        terminal.preguntarNombreHabilidad();
        factoriaCazadores.inicializarNombreHabilidad(talento);
        do {
            terminal.preguntarAtaqueHabilidad();
            rightValue = factoriaCazadores.inicializarAtaqueHabilidad(talento);
        } while (!rightValue);
        do {
            terminal.preguntarDefensaHabilidad();
            rightValue = factoriaCazadores.inicializarDefensaHabilidad(talento);
        } while (!rightValue);
        terminal.preguntarEdadHabilidad();
        factoriaCazadores.inicializarEdadHabilidad(talento);
        factoriaCazadores.setHabilidad(cazador, talento);
    }

    private void cambiarDisciplina(Terminal terminal, Cliente cliente, FactoriaVampiros factoriaVampiros) {
        boolean rightValue;
        Vampiro vampiro = (Vampiro) cliente.getPersonaje();
        Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
        terminal.mostrarDisciplina(disciplina);
        terminal.preguntarNombreHabilidad();
        factoriaVampiros.inicializarNombreHabilidad(disciplina);
        do {
            terminal.preguntarAtaqueHabilidad();
            rightValue = factoriaVampiros.inicializarAtaqueHabilidad(disciplina);
        } while (!rightValue);
        do {
            terminal.preguntarDefensaHabilidad();
            rightValue = factoriaVampiros.inicializarDefensaHabilidad(disciplina);
        } while (!rightValue);
        do {
            terminal.preguntarCosteHabilidad();
            rightValue = factoriaVampiros.inicializarCosteHabilidad(disciplina);
        } while (!rightValue);
        factoriaVampiros.setHabilidad(vampiro, disciplina);
    }

    private void cambiarArmas(Scanner sc, Terminal terminal, Cliente cliente, FactoriaCazadores factoriaCazadores) {
        int opcion;
        boolean rightValue;
        //modificar armas
        ArrayList<Arma> armas = cliente.getPersonaje().getArmas();
        ArrayList<Arma> armasActivas = cliente.getPersonaje().getArmasActivas();
        terminal.armasPersonaje(armas);
        boolean salir = false;
        do {
            terminal.modificarArma();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    //aÃ±adir armas
                    int numArmas;
                    do {
                        terminal.preguntarNumArmas();
                        numArmas = sc.nextInt();
                    } while (numArmas < 1);
                    for (int iterator = 1; iterator <= numArmas; iterator++) {
                        Arma arma = new Arma();
                        terminal.preguntarNombreArma();
                        factoriaCazadores.inicializarnNombreArma(arma);
                        do {
                            terminal.preguntarAtaqueArma();
                            rightValue = factoriaCazadores.inicializarAtaqueArma(arma);
                        } while (!rightValue);
                        do {
                            terminal.preguntarDefensaArma();
                            rightValue = factoriaCazadores.inicializarDefensaArma(arma);
                        } while (!rightValue);
                        do {
                            terminal.peguntarSingleHandArma();
                            rightValue = factoriaCazadores.inicializarSingleHandArma(arma);
                        } while (!rightValue);
                        factoriaCazadores.addArma(armas, arma);
                    }
                }
                case 2 -> {
                    //eliminar arma
                    int arma;
                    do {
                        terminal.preguntarArmaEliminar();
                        arma = sc.nextInt();
                    } while (arma < 1 && arma > armas.size() + 1);
                    if (armas.get(arma - 1).getNombre().equals(armasActivas.get(0).getNombre()) ||
                            armas.get(arma - 1).getNombre().equals(armasActivas.get(1).getNombre())) {
                        terminal.errorArmaActiva();
                    } else {
                        armas.remove(arma - 1);
                    }
                }
                case 3 -> {
                    //salir
                    terminal.salir();
                    salir = true;
                }
            }
        } while (!salir);
    }

    private void cambiarArmasActivas(Terminal terminal, Cliente cliente, FactoriaVampiros factoriaVampiros, FactoriaCazadores factoriaCazadores, FactoriaLicantropos factoriaLicantropos) {
        ArrayList<Arma> armas;
        ArrayList<Arma> armasActivas;
        boolean rightValue;
        //modificar armas activas
        boolean[] rightWeapon;
        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};
        armas = cliente.getPersonaje().getArmas();
        armasActivas = new ArrayList<>();
        do {
            terminal.mostrarArmas(armas);
            rightWeapon = factoriaCazadores.addArmaActiva(armas, armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(armas, armasActivas.get(0));
                rightValue = factoriaCazadores.addArmaActiva2(armas, armasActivas);
                if (!rightValue) {
                    terminal.ErrNumSelec();
                }
            } while (!rightValue);
        }
        switch (cliente.getPersonaje().getTipo()) {
            case "VAMPIRO" -> {
                Vampiro vampiro = (Vampiro) cliente.getPersonaje();
                factoriaVampiros.setArmasActivas(vampiro, armasActivas);
            }
            case "CAZADOR" -> {
                Cazador cazador = (Cazador) cliente.getPersonaje();
                factoriaCazadores.setArmasActivas(cazador, armasActivas);
            }
            case "LICANTROPO" -> {
                Licantropo licantropo = (Licantropo) cliente.getPersonaje();
                factoriaLicantropos.setArmasActivas(licantropo, armasActivas);
            }
        }
    }

    private void cambiarArmaduras(Scanner sc, Terminal terminal, Cliente cliente, FactoriaCazadores factoriaCazadores) {
        int opcion;
        boolean rightValue;
        boolean salir;
        //modificar armaduras
        ArrayList<Armadura> armaduras = cliente.getPersonaje().getArmaduras();
        Armadura armadurasActivas = cliente.getPersonaje().getArmaduraActiva();
        terminal.armadurasPersonaje(armaduras);
        salir = false;
        do {
            terminal.modificarArmadura();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    //aÃ±adir armaduras
                    int numArmaduras;
                    do {
                        terminal.preguntarNumArmaduras();
                        numArmaduras = sc.nextInt();
                    } while (numArmaduras < 1);
                    for (int iterator = 1; iterator <= numArmaduras; iterator++) {
                        Armadura armadura = new Armadura();
                        terminal.preguntarNombreArmadura();
                        factoriaCazadores.inicializarnNombreArmadura(armadura);
                        do {
                            terminal.preguntarDefensaArmadura();
                            rightValue = factoriaCazadores.inicializarDefensaArmadura(armadura);
                        } while (!rightValue);
                        do {
                            terminal.preguntarAtaqueArmadura();
                            rightValue = factoriaCazadores.inicializarAtaqueArmadura(armadura);
                        } while (!rightValue);
                        factoriaCazadores.addArmadura(armadura, armaduras);
                    }
                }
                case 2 -> {
                    //eliminar armaduras
                    int armadura;
                    do {
                        terminal.preguntarArmaduraEliminar();
                        armadura = sc.nextInt();
                    } while (armadura < 1 && armadura > armaduras.size() + 1);
                    if (armaduras.get(armadura - 1).getNombre().equals(armadurasActivas.getNombre())) {
                        terminal.errorArmaduraActiva();
                    } else {
                        armaduras.remove(armadura - 1);
                    }
                }
                case 3 -> {
                    //salir
                    terminal.salir();
                    salir = true;
                }
            }
        } while (!salir);
    }

    private void cambiarArmaduraActiva(Terminal terminal, Cliente cliente) {
        boolean rightValue;
        //modificar armaduras activas
        do {
            terminal.mostrarArmaduras(cliente.getPersonaje().getArmaduras());
            rightValue = addArmaduraActiva(cliente.getPersonaje(), cliente.getPersonaje().getArmaduras());
        } while (!rightValue);
    }

    private void cambiarEsbirros(Scanner sc, Terminal terminal, Cliente cliente) {
        int opcion;
        boolean salir;
        //modificar esbirros
        ArrayList<EsbirrosComposite> esbirros = cliente.getPersonaje().getEsbirros();
        terminal.esbirrosPersonajes(esbirros);
        salir = false;
        do {
            terminal.modificarEsbirros();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    //aÃ±adir esbirros
                    int numEsbirros;
                    do {
                        terminal.preguntarNumEsbirros();
                        numEsbirros = sc.nextInt();
                    } while (numEsbirros < 1);
                    for (int iterator = 1; iterator <= numEsbirros; iterator++) {
                        EsbirrosComposite nuevoEsbirro = new EsbirrosComposite();
                        if (cliente.getPersonaje().getTipo().equals("VAMPIRO")) {
                            nuevoEsbirro = nuevoEsbirro.crearEsbirro(true);
                        } else {
                            nuevoEsbirro = nuevoEsbirro.crearEsbirro(false);
                        }
                        esbirros.add(nuevoEsbirro);
                    }
                }
                case 2 -> {
                    //eliminar esbirros
                    int esbirro;
                    do {
                        terminal.preguntarEsbirroEliminar();
                        esbirro = sc.nextInt();
                    } while (esbirro < 1 && esbirro > esbirros.size() + 1);
                    esbirros.remove(esbirro - 1);
                }
                case 3 -> {
                    //salir
                    terminal.salir();
                    salir = true;
                }
            }
        } while (!salir);
    }

    private void cambiarOro(Scanner sc, Terminal terminal, Cliente cliente) {
        //modificar oro
        terminal.mostrarOro();
        System.out.println(cliente.getPersonaje().getOro());
        terminal.introModificacion();
        int oro = sc.nextInt();
        cliente.getPersonaje().setOro(oro);
    }

    private void cambiarHP(Scanner sc, Terminal terminal, Cliente cliente) {
        //modificar hp
        terminal.mostrarHp();
        System.out.println(cliente.getPersonaje().getHp());
        terminal.introModificacion();
        int hp = sc.nextInt();
        cliente.getPersonaje().setHp(hp);
    }

    private void cambiarPoder(Scanner sc, Terminal terminal, Cliente cliente) {
        //modificar poder
        terminal.mostrarPoder();
        System.out.println(cliente.getPersonaje().getPoder());
        terminal.introModificacion();
        int poder = sc.nextInt();
        cliente.getPersonaje().setPoder(poder);
    }

    private void cambiarTipo(Scanner sc, Terminal terminal, Cliente cliente, FactoriaVampiros factoriaVampiros, FactoriaCazadores factoriaCazadores, FactoriaLicantropos factoriaLicantropos) {
        int opcion;
        boolean rightValue;
        //modificar tipo
        rightValue = false;
        terminal.mostrarTipo();
        System.out.println(cliente.getPersonaje().getTipo());
        terminal.seleccionarTipo();
        opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> {
                cliente.getPersonaje().setTipo("VAMPIRO");
                cambiarDisciplina(terminal, cliente, factoriaVampiros);
            }
            case 2 -> {
                cliente.getPersonaje().setTipo("CAZADOR");
                cambiarTalento(terminal, cliente, factoriaCazadores);
            }
            case 3 -> {
                cliente.getPersonaje().setTipo("LICANTROPO");
                cambiarDon(terminal, cliente, factoriaLicantropos);
            }
        }
    }

    private void cambiarFortalezas(Scanner sc, Terminal terminal, Cliente cliente, FactoriaCazadores factoriaCazadores) {
        int opcion;
        boolean salir;
        //modificar fortalezas
        ArrayList<Fortaleza> fortalezas = cliente.getPersonaje().getFortalezas();
        salir = false;
        do {
            terminal.fortalezasPersonaje(fortalezas);
            terminal.modificarFortalezas();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    //aÃ±adir fortalezas
                    int numFortalezas;
                    do {
                        terminal.peguntarNumDebilidades();
                        numFortalezas = sc.nextInt();
                    } while (numFortalezas < 1);
                    for (int iterator = 1; iterator <= numFortalezas; iterator++) {
                        Fortaleza nuevaFortaleza = new Fortaleza();
                        terminal.preguntarNombreFortaleza();
                        factoriaCazadores.inicializarNombreFortaleza(nuevaFortaleza);
                        terminal.preguntarValorFortaleza();
                        factoriaCazadores.inicializarValorFortaleza(nuevaFortaleza);
                        factoriaCazadores.addFortaleza(fortalezas, nuevaFortaleza);
                    }
                }
                case 2 -> {
                    //eliminar fortalezas
                    int fortaleza;
                    do {
                        terminal.preguntarArmaduraEliminar();
                        fortaleza = sc.nextInt();
                    } while (fortaleza < 1 && fortaleza > fortalezas.size() + 1);
                    fortalezas.remove(fortaleza - 1);
                }
                case 3 -> {
                    //salir
                    terminal.salir();
                    salir = true;
                }
            }
        } while (!salir);
    }

    private void cambiarDebilidades(Scanner sc, Terminal terminal, Cliente cliente, FactoriaCazadores factoriaCazadores) {
        int opcion;
        boolean salir;
        //modificar debilidades
        ArrayList<Debilidad> debilidades = cliente.getPersonaje().getDebilidades();
        terminal.debilidadesPersonaje(debilidades);
        salir = false;
        do {
            terminal.modificarDebilidades();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    //aÃ±adir debilidades
                    int numDebilidades;
                    do {
                        terminal.peguntarNumDebilidades();
                        numDebilidades = sc.nextInt();
                    } while (numDebilidades < 1);
                    for (int iterator = 1; iterator <= numDebilidades; iterator++) {
                        Debilidad nuevaDebilidad = new Debilidad();
                        terminal.preguntarNombreDebilidad();
                        factoriaCazadores.inicializarNombreDebilidad(nuevaDebilidad);
                        terminal.preguntarValorDebilidad();
                        factoriaCazadores.inicializarValorDebilidad(nuevaDebilidad);
                        factoriaCazadores.addDebilidad(debilidades, nuevaDebilidad);
                    }
                }
                case 2 -> {
                    //eliminar debilidades
                    int debilidad;
                    do {
                        terminal.preguntarArmaduraEliminar();
                        debilidad = sc.nextInt();
                    } while (debilidad < 1 && debilidad > debilidades.size() + 1);
                    debilidades.remove(debilidad - 1);
                }
                case 3 -> {
                    //salir
                    terminal.salir();
                    salir = true;
                }
            }
        } while (!salir);
    }
}