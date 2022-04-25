package mp_grupo_m.Entidades;

import mp_grupo_m.Factorias.FactoriaCazadores;
import mp_grupo_m.Factorias.FactoriaVampiros;
import mp_grupo_m.Factorias.FactoriaLicantropos;
import mp_grupo_m.GestorNotificaciones;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Operador extends User{

    public void modificarPersonaje() {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        ArrayList<Cliente> listaClientes = new ArrayList<>(); //coger fichero lista clientes
        Cliente cliente = new Cliente();
        listaClientes.add(cliente);
        boolean encontrado = false;
        do {
            terminal.preguntarNickAdmin();
            String nick = sc.nextLine();
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).getNick().equals(nick)) {
                    encontrado = true;
                    cliente = listaClientes.get(i);
                    i = listaClientes.size();
                }
            }
            if(!encontrado){
                terminal.errorNick();
            }
        }while(!encontrado);
        FactoriaVampiros factoriaVampiros = new FactoriaVampiros();
        FactoriaCazadores factoriaCazadores = new FactoriaCazadores();
        FactoriaLicantropos factoriaLicantropos = new FactoriaLicantropos();
        int opcion;
        do {
            terminal.menuModPersonaje();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    //modificar nombre
                    terminal.mostrarNombre();
                    System.out.println(cliente.getPersonaje().getNombre());
                    terminal.introModificacion();
                    String nombre = sc.nextLine();
                    cliente.getPersonaje().setNombre(nombre);
                    break;
                case 2:
                    //modificar habilidad
                    boolean rightValue;
                    terminal.mostrarTipo();
                    System.out.println(cliente.getPersonaje().getTipo());
                    if (cliente.getPersonaje().getTipo().equals("VAMPIRO")){
                        Vampiro vampiro = (Vampiro) cliente.getPersonaje();
                        Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
                        System.out.println("nombre de habilidad: " + disciplina.getNombre());
                        System.out.println("ataque de habilidad: " + disciplina.getAtaque());
                        System.out.println("defensa de habilidad: " + disciplina.getDefensa());
                        System.out.println("coste de habilidad: " + disciplina.getCoste());
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
                    }else if(cliente.getPersonaje().getTipo().equals("CAZADOR")){
                        Cazador cazador = (Cazador) cliente.getPersonaje();
                        Talento talento = (Talento) cazador.getHabilidad();
                        System.out.println("nombre de habilidad: " + talento.getNombre());
                        System.out.println("ataque de habilidad: " + talento.getAtaque());
                        System.out.println("defensa de habilidad: " + talento.getDefensa());
                        System.out.println("edad de habilidad: " + talento.getEdad());
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
                    }else if(cliente.getPersonaje().getTipo().equals("LICANTROPO")){
                        Licantropo licantropo = (Licantropo) cliente.getPersonaje();
                        Don don = (Don) licantropo.getHabilidad();
                        System.out.println("nombre de habilidad: " + don.getNombre());
                        System.out.println("ataque de habilidad: " + don.getAtaque());
                        System.out.println("defensa de habilidad: " + don.getDefensa());
                        System.out.println("edad de habilidad: " + don.getValorMinimo());
                        terminal.preguntarNombreHabilidad();
                        factoriaLicantropos.inicializarNombreHabilidad(don);
                        licantropo.setRabia(0);
                        do {
                            terminal.preguntarRabiaHabilidad();
                            rightValue = factoriaLicantropos.inicializarRabiaHabilidad(don);
                        } while (!rightValue);
                        factoriaLicantropos.setHabilidad(licantropo, don);
                    }
                    break;
                case 3:
                    //modificar armas
                    ArrayList<Arma> armas = cliente.getPersonaje().getArmas();
                    ArrayList<Arma> armasActivas = cliente.getPersonaje().getArmasActivas();
                    terminal.armasPersonaje(armas);
                    boolean salir = false;
                    do {
                        terminal.modificarArma();
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                //añadir armas
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
                                break;

                            case 2:
                                //eliminar arma
                                int arma;
                                do {
                                    terminal.preguntarArmaEliminar();
                                    arma = sc.nextInt();
                                } while (arma < 1 && arma > armas.size()+1);
                                if (armas.get(arma - 1).getNombre().equals(armasActivas.get(0).getNombre()) ||
                                        armas.get(arma - 1).getNombre().equals(armasActivas.get(1).getNombre())) {
                                    terminal.errorArmaActiva();
                                } else {
                                    armas.remove(arma);
                                }
                                break;

                            case 3:
                                //salir
                                terminal.salir();
                                salir = true;
                                break;

                        }
                    }while(!salir);
                    break;
                case 4:
                    //modificar armas activas
                    boolean[] rightWeapon;
                    boolean[] aux1 = new boolean[]{true, true};
                    boolean[] aux2 = new boolean[]{true, false};
                    armas = cliente.getPersonaje().getArmas();
                    armasActivas = cliente.getPersonaje().getArmasActivas();
                    do {
                        terminal.mostrarArmas(armas);
                        rightWeapon = factoriaCazadores.addArmaActiva(armas, armasActivas);
                    } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
                    if (Arrays.equals(rightWeapon, aux1)) {
                        do {
                            terminal.otroArma(armas, armasActivas.get(0));
                            rightValue = factoriaCazadores.addArmaActiva2(armas, armasActivas);
                            if (!rightValue){
                                terminal.ErrNumSelec();
                            }
                        } while (!rightValue);
                    }
                    if (cliente.getPersonaje().getTipo().equals("VAMPIRO")){
                        Vampiro vampiro = (Vampiro) cliente.getPersonaje();
                        factoriaVampiros.setArmasActivas(vampiro, armasActivas);
                    }else if(cliente.getPersonaje().getTipo().equals("CAZADOR")){
                        Cazador cazador = (Cazador) cliente.getPersonaje();
                        factoriaCazadores.setArmasActivas(cazador, armasActivas);
                    }else if(cliente.getPersonaje().getTipo().equals("LICANTROPO")){
                        Licantropo licantropo = (Licantropo) cliente.getPersonaje();
                        factoriaLicantropos.setArmasActivas(licantropo, armasActivas);
                    }
                    break;
                case 5:
                    //modificar armaduras
                    ArrayList<Armadura> armaduras = cliente.getPersonaje().getArmaduras();
                    Armadura armadurasActivas = cliente.getPersonaje().getArmaduraActiva();
                    terminal.armadurasPersonaje(armaduras);
                    salir = false;
                    do {
                        terminal.modificarArmadura();
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                //añadir armaduras
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
                                break;

                            case 2:
                                //eliminar armaduras
                                int armadura;
                                do {
                                    terminal.preguntarArmaduraEliminar();
                                    armadura = sc.nextInt();
                                } while (armadura < 1 && armadura > armaduras.size()+1);
                                if (armaduras.get(armadura - 1).getNombre().equals(armadurasActivas.getNombre())) {
                                    terminal.errorArmaduraActiva();
                                } else {
                                    armaduras.remove(armadura);
                                }
                                break;

                            case 3:
                                //salir
                                terminal.salir();
                                salir = true;
                                break;

                        }
                    }while(!salir);
                    break;
                case 6:
                    //modificar armaduras activas
                    do {
                        terminal.mostrarArmaduras(cliente.getPersonaje().getArmaduras());
                        rightValue = addArmaduraActiva(cliente.getPersonaje(), cliente.getPersonaje().getArmaduras());
                    } while (!rightValue);
                    break;
                case 7:
                    //modificar esbirros
                    ArrayList<EsbirrosComposite> esbirros = cliente.getPersonaje().getEsbirros();
                    terminal.esbirrosPersonajes(esbirros);
                    salir = false;
                    do {
                        terminal.modificarEsbirros();
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                //añadir esbirros
                                int numEsbirros;
                                do {
                                    terminal.peguntarNumDebilidades();
                                    numEsbirros = sc.nextInt();
                                } while (numEsbirros < 1);
                                for (int iterator = 1; iterator <= numEsbirros; iterator++) {
                                    EsbirrosComposite nuevoEsbirro = new EsbirrosComposite();
                                    if(cliente.getPersonaje().getTipo().equals("VAMPIRO")){
                                        nuevoEsbirro = nuevoEsbirro.crearEsbirro(true);
                                    }else {
                                        nuevoEsbirro = nuevoEsbirro.crearEsbirro(false);
                                    }
                                    esbirros.add(nuevoEsbirro);
                                }

                            case 2:
                                //eliminar esbirros
                                int esbirro;
                                do {
                                    terminal.preguntarEsbirroEliminar();
                                    esbirro = sc.nextInt();
                                } while (esbirro < 1 && esbirro > esbirros.size()+1);
                                esbirros.remove(esbirro-1);
                                break;

                            case 3:
                                //salir
                                terminal.salir();
                                salir = true;
                                break;

                        }
                    }while(!salir);
                    break;
                case 8:
                    //modificar oro
                    terminal.mostrarOro();
                    System.out.println(cliente.getPersonaje().getOro());
                    terminal.introModificacion();
                    int oro = sc.nextInt();
                    cliente.getPersonaje().setOro(oro);
                    break;
                case 9:
                    //modificar hp
                    terminal.mostrarHp();
                    System.out.println(cliente.getPersonaje().getHp());
                    terminal.introModificacion();
                    int hp = sc.nextInt();
                    cliente.getPersonaje().setHp(hp);
                    break;
                case 10:
                    //modificar poder
                    terminal.mostrarPoder();
                    System.out.println(cliente.getPersonaje().getPoder());
                    terminal.introModificacion();
                    int poder = sc.nextInt();
                    cliente.getPersonaje().setPoder(poder);
                    break;
                case 11:
                    //modificar debilidades
                    ArrayList<Debilidad> debilidades = cliente.getPersonaje().getDebilidades();
                    terminal.debilidadesPersonaje(debilidades);
                    salir = false;
                    do {
                        terminal.modificarDebilidades();
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                //añadir debilidades
                                int numDebilidades;
                                Debilidad nuevaDebilidad = new Debilidad();
                                do {
                                    terminal.peguntarNumDebilidades();
                                    numDebilidades = sc.nextInt();
                                } while (numDebilidades < 1);
                                for (int iterator = 1; iterator <= numDebilidades; iterator++) {
                                    terminal.preguntarNombreDebilidad();
                                    factoriaCazadores.inicializarNombreDebilidad(nuevaDebilidad);
                                    terminal.preguntarValorDebilidad();
                                    factoriaCazadores.inicializarValorDebilidad(nuevaDebilidad);
                                    factoriaCazadores.addDebilidad(debilidades, nuevaDebilidad);
                                }
                                break;

                            case 2:
                                //eliminar debilidades
                                int debilidad;
                                do {
                                    terminal.preguntarArmaduraEliminar();
                                    debilidad = sc.nextInt();
                                } while (debilidad < 1 && debilidad > debilidades.size()+1);
                                debilidades.remove(debilidad-1);
                                break;

                            case 3:
                                //salir
                                terminal.salir();
                                salir = true;
                                break;

                        }
                    }while(!salir);
                    break;
                case 12:
                    //modificar fortalezas
                    ArrayList<Fortaleza> fortalezas = cliente.getPersonaje().getFortalezas();
                    salir = false;
                    do {
                        terminal.fortalezasPersonaje(fortalezas);
                        terminal.modificarFortalezas();
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                //añadir fortalezas
                                int numFortalezas;
                                Fortaleza nuevaFortaleza = new Fortaleza();
                                do {
                                    terminal.peguntarNumDebilidades();
                                    numFortalezas = sc.nextInt();
                                } while (numFortalezas < 1);
                                for (int iterator = 1; iterator <= numFortalezas; iterator++) {
                                    terminal.preguntarNombreFortaleza();
                                    factoriaCazadores.inicializarNombreFortaleza(nuevaFortaleza);
                                    terminal.preguntarValorFortaleza();
                                    factoriaCazadores.inicializarValorFortaleza(nuevaFortaleza);
                                    factoriaCazadores.addFortaleza(fortalezas, nuevaFortaleza);
                                }
                                break;

                            case 2:
                                //eliminar fortalezas
                                int fortaleza;
                                do {
                                    terminal.preguntarArmaduraEliminar();
                                    fortaleza = sc.nextInt();
                                } while (fortaleza < 1 && fortaleza > fortalezas.size()+1);
                                fortalezas.remove(fortaleza);
                                break;

                            case 3:
                                //salir
                                terminal.salir();
                                salir = true;
                                break;

                        }
                    }while(!salir);
                    break;
                case 13:
                    //modificar tipo
                    rightValue = false;
                    terminal.mostrarTipo();
                    System.out.println(cliente.getPersonaje().getTipo());
                    terminal.seleccionarTipo();
                    opcion = sc.nextInt();
                    switch (opcion) {

                        case 1:
                            cliente.getPersonaje().setTipo("VAMPIRO");
                            Vampiro vampiro = (Vampiro) cliente.getPersonaje();
                            Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
                            System.out.println("nombre de habilidad: " + disciplina.getNombre());
                            System.out.println("ataque de habilidad: " + disciplina.getAtaque());
                            System.out.println("defensa de habilidad: " + disciplina.getDefensa());
                            System.out.println("coste de habilidad: " + disciplina.getCoste());
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
                            break;

                        case 2:
                            cliente.getPersonaje().setTipo("CAZADOR");
                            Cazador cazador = (Cazador) cliente.getPersonaje();
                            Talento talento = (Talento) cazador.getHabilidad();
                            System.out.println("nombre de habilidad: " + talento.getNombre());
                            System.out.println("ataque de habilidad: " + talento.getAtaque());
                            System.out.println("defensa de habilidad: " + talento.getDefensa());
                            System.out.println("edad de habilidad: " + talento.getEdad());
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
                            break;

                        case 3:
                            cliente.getPersonaje().setTipo("LICANTROPO");
                            Licantropo licantropo = (Licantropo) cliente.getPersonaje();
                            Don don = (Don) licantropo.getHabilidad();
                            System.out.println("nombre de habilidad: " + don.getNombre());
                            System.out.println("ataque de habilidad: " + don.getAtaque());
                            System.out.println("defensa de habilidad: " + don.getDefensa());
                            System.out.println("edad de habilidad: " + don.getValorMinimo());
                            terminal.preguntarNombreHabilidad();
                            factoriaLicantropos.inicializarNombreHabilidad(don);
                            licantropo.setRabia(0);
                            do {
                                terminal.preguntarRabiaHabilidad();
                                rightValue = factoriaLicantropos.inicializarRabiaHabilidad(don);
                            } while (!rightValue);
                            factoriaLicantropos.setHabilidad(licantropo, don);
                            break;
                    }
                    break;
                case 14:
                    terminal.salir();
                    break;
                default:
                    terminal.error();
                    break;
            }
        } while (opcion != 14);

        terminal.modificarCliente();
    }

    public void validarDesafio() {
        Scanner sc = new Scanner(System.in);
        Terminal terminal = new Terminal();
        Desafio desafio = new Desafio();
        Cliente desafiante, contrincante = new Cliente();
        ArrayList<Desafio> listaDesafios = new ArrayList<>(); //coger fichero lista desafios
        listaDesafios.add(desafio);

        for(int i = 0; i<listaDesafios.size(); i++)
        {
            if (!listaDesafios.get(i).isValidated()){
                desafiante = listaDesafios.get(i).getDesafiante();
                contrincante = listaDesafios.get(i).getContrincante();
                //fortalezas del desafiante y del contrincante
                for (int j = 0; j < desafiante.getPersonaje().getFortalezas().size(); j++) {
                    System.out.println(desafiante.getPersonaje().getFortalezas().get(i).getNombre());
                }
                for (int j = 0; j < contrincante.getPersonaje().getFortalezas().size(); j++) {
                    System.out.println(contrincante.getPersonaje().getFortalezas().get(i).getNombre());
                }
                //debilidades del contrincante y del contrincante
                for (int j = 0; j < desafiante.getPersonaje().getDebilidades().size(); j++) {
                    System.out.println(desafiante.getPersonaje().getDebilidades().get(i).getNombre());
                }
                for (int j = 0; j < contrincante.getPersonaje().getDebilidades().size(); j++) {
                    System.out.println(contrincante.getPersonaje().getDebilidades().get(i).getNombre());
                }
                int opcion;
                do {
                    terminal.validarDesafio();
                    opcion = sc.nextInt();
                    if (opcion !=0 && opcion !=1){
                        terminal.numValido();
                    }
                }while(opcion !=0 && opcion !=1);
                if (opcion==0){
                    listaDesafios.get(i).setValidated(true);
                    ArrayList<Modificador> listaMods = new ArrayList<>();
                    String modificacion;
                    terminal.eleccionFortalezas();
                    do{
                        modificacion = sc.nextLine();
                        boolean encontrado = false;
                        for (int j = 0; j < desafiante.getPersonaje().getFortalezas().size(); j++) {
                            if(desafiante.getPersonaje().getFortalezas().get(j).getNombre().equals(modificacion)){
                                listaMods.add(desafiante.getPersonaje().getFortalezas().get(j));
                                encontrado = true;
                            }
                        }
                        if(!encontrado) {
                            for (int j = 0; j < contrincante.getPersonaje().getFortalezas().size(); j++) {
                                if(contrincante.getPersonaje().getFortalezas().get(j).getNombre().equals(modificacion)){
                                    listaMods.add(contrincante.getPersonaje().getFortalezas().get(j));
                                    encontrado = true;
                                }
                            }
                        }
                        if(!encontrado) {
                            terminal.errorMod();
                        }
                    }while(!modificacion.equals("continuar"));

                    terminal.eleccionDebilidades();
                    do{
                        modificacion = sc.nextLine();
                        boolean encontrado = false;
                        for (int j = 0; j < desafiante.getPersonaje().getDebilidades().size(); j++) {
                            if(desafiante.getPersonaje().getDebilidades().get(j).getNombre().equals(modificacion)){
                                listaMods.add(desafiante.getPersonaje().getDebilidades().get(j));
                                encontrado = true;
                            }
                        }
                        if(!encontrado) {
                            for (int j = 0; j < contrincante.getPersonaje().getDebilidades().size(); j++) {
                                if(contrincante.getPersonaje().getDebilidades().get(j).getNombre().equals(modificacion)){
                                    listaMods.add(contrincante.getPersonaje().getDebilidades().get(j));
                                    encontrado = true;
                                }
                            }
                        }
                        if(!encontrado) {
                            terminal.errorMod();
                        }
                    }while(!modificacion.equals("salir"));
                    listaDesafios.get(i).setModificadores(listaMods);
                }else{
                    listaDesafios.remove(i);
                }
            }
        }
    }

    public void banearUser() {
        //pedir cliente a banear
        Cliente cliente = new Cliente();
        GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
        gestorNotificaciones.subscribeBan(cliente);
    }

    public void desbanearUser() {
        //pedir cliente a desbanear
        Cliente cliente = new Cliente();
        GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
        gestorNotificaciones.unsubscribeBan(cliente);
    }

    public void eliminarCuenta(Operador operador, Sistema sistema) {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        terminal.confirmarDelete();
        boolean delete = sc.nextInt() == 1;
        if (delete) {
            //leer fichero de operadores
            ArrayList<Operador> listaOperadores = new ArrayList<>();
            listaOperadores.add(operador);
            for (int i = 0; i <= listaOperadores.size(); i++) {
                if (listaOperadores.get(i).getNick().equals(operador.getNick())) {
                    listaOperadores.remove(i);
                }
            }
            //sobreescribir fichero
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
}
