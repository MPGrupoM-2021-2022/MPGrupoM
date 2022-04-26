package mp_grupo_m.Entidades;

import mp_grupo_m.Factorias.FactoriaCazadores;
import mp_grupo_m.Factorias.FactoriaVampiros;
import mp_grupo_m.Factorias.FactoriaLicantropos;
import mp_grupo_m.Ficheros.LecturaFicheroUsuarios;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cliente extends User {

    private String registro;
    private Personaje personaje;

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Vampiro crearVampiro() {

        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};

        FactoriaVampiros factoriaVampiros = new FactoriaVampiros();
        Terminal terminal = new Terminal();
        Vampiro vampiro = new Vampiro();
        Disciplina disciplina = new Disciplina();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Arma> armasActivas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        Debilidad debilidad = new Debilidad();
        Fortaleza fortaleza = new Fortaleza();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        Armadura armadura = new Armadura();
        ArrayList<EsbirrosComposite> esbirros = new ArrayList<>();

        setNombreYHabilidadVampiro(factoriaVampiros, terminal, vampiro, disciplina);
        setAllArmasVampiro(aux1, aux2, factoriaVampiros, terminal, vampiro, armas, armasActivas);
        setAllAmadurasVampiro(factoriaVampiros, terminal, vampiro, armaduras, armadura);
        setOroHpPoderVampiro(factoriaVampiros, terminal, vampiro);
        setModificadoresVampiro(factoriaVampiros, terminal, vampiro, debilidad, fortaleza, debilidades, fortalezas);
        terminal.preguntarEdadVampiro();
        factoriaVampiros.setEdad(vampiro);
        vampiro.setSangre(0);
        setEsbirrosVampiro(factoriaVampiros, terminal, vampiro, esbirros);
        vampiro.setTipo("VAMPIRO");
        return vampiro;
    }

    public Cazador crearCazador() {

        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};

        FactoriaCazadores factoriaCazadores = new FactoriaCazadores();
        Terminal terminal = new Terminal();
        Cazador cazador = new Cazador();
        Talento talento = new Talento();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Arma> armasActivas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        Debilidad debilidad = new Debilidad();
        Fortaleza fortaleza = new Fortaleza();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        Armadura armadura = new Armadura();
        ArrayList<EsbirrosComposite> esbirros = new ArrayList<>();

        setNombreYHabilidadCazador(factoriaCazadores, terminal, cazador, talento);
        setAllArmasCazador(aux1, aux2, factoriaCazadores, terminal, cazador, armas, armasActivas);
        setAllArmadurasCazador(factoriaCazadores, terminal, cazador, armaduras, armadura);
        setOroHpPoderCazador(factoriaCazadores, terminal, cazador);
        setModificadoresCazador(factoriaCazadores, terminal, cazador, debilidad, fortaleza, debilidades, fortalezas);
        setEsbirrosCazador(factoriaCazadores, cazador, esbirros);
        cazador.setVoluntad(3);
        cazador.setTipo("CAZADOR");
        return cazador;
    }

    public Licantropo crearLicantropo() {

        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};

        FactoriaLicantropos factoriaLicantropo = new FactoriaLicantropos();
        Terminal terminal = new Terminal();
        Licantropo licantropo = new Licantropo();
        Don don = new Don();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Arma> armasActivas = new ArrayList<>();
        Armadura armadura = new Armadura();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        Debilidad debilidad = new Debilidad();
        Fortaleza fortaleza = new Fortaleza();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        ArrayList<EsbirrosComposite> esbirros = new ArrayList<>();

        setNombreYHabilidadLicantropo(factoriaLicantropo, terminal, licantropo, don);
        setAllArmasLicantropo(aux1, aux2, factoriaLicantropo, terminal, licantropo, armas, armasActivas);
        setAllArmadurasLicantropo(factoriaLicantropo, terminal, licantropo, armadura, armaduras);
        setOroHpPoderLicantropo(factoriaLicantropo, terminal, licantropo);
        setModificadoresLicantropo(factoriaLicantropo, terminal, licantropo, debilidad, fortaleza, debilidades, fortalezas, esbirros);
        setEsbirrosLicantropo(factoriaLicantropo, licantropo, esbirros);
        licantropo.setTipo("LICANTROPO");
        return licantropo;
    }

    public void eliminarPersonaje(Cliente cliente) {
        Terminal terminal = new Terminal();
        terminal.confirmarDeletePersonaje();
        Scanner sc = new Scanner(System.in);
        boolean delete = sc.nextInt() == 1;
        if (delete) {
            cliente.setPersonaje(null);
            terminal.personajeEliminado();
        }
    }

    public void seleccionarEquipo(Cliente cliente) {

        boolean rightValue;
        boolean[] rightWeapon;
        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};

        ArrayList<Arma> armasActivas = new ArrayList<>();
        Terminal terminal = new Terminal();
        do {
            terminal.mostrarArmas(cliente.getPersonaje().getArmas());
            rightWeapon = addArmaActiva(cliente.getPersonaje().getArmas(), armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(cliente.getPersonaje().getArmas(), cliente.getPersonaje().getArmasActivas().get(0));
                rightValue = addArmaActiva2(cliente.getPersonaje().getArmas(), armasActivas);
            } while (!rightValue);
        }
        cliente.getPersonaje().setArmasActivas(armasActivas);
        do {
            terminal.mostrarArmaduras(cliente.getPersonaje().getArmaduras());
            rightValue = addArmaduraActiva(cliente.getPersonaje(), cliente.getPersonaje().getArmaduras());
        } while (!rightValue);
        terminal.finishEquipar();
    }

    public void desafiar(ArrayList<Cliente> listaClientes, Cliente cliente, Sistema sistema) {
        Desafio desafio = new Desafio();
        desafio.crearDesafio(listaClientes, cliente, sistema);
    }

    public void eliminarCuenta(Cliente cliente, Sistema sistema) {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        terminal.confirmarDelete();
        boolean delete = sc.nextInt() == 1;
        if (delete) {
            //leer fichero de clientes
            ArrayList<Cliente> listaClientes = new ArrayList<>();
            listaClientes.add(cliente);
            for (int i = 0; i <= listaClientes.size(); i++) {
                if (listaClientes.get(i).getRegistro().equals(cliente.getRegistro())) {
                    listaClientes.remove(i);
                    break;
                }
            }
            //sobreescribir fichero
            terminal.cerrarSesion();
            sistema.selector();
        }
    }

    private boolean[] addArmaActiva(ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armas.size() + 1)) {
            return new boolean[]{false, false};
        }
        armasActivas.add(armas.get(opcion - 1));
        return new boolean[]{true, armas.get(opcion - 1).isSingleHand()};
    }

    private boolean addArmaActiva2(ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 0) || (opcion > armas.size() + 1)) {
            return false;
        }
        if (opcion == 0) {
            return true;
        }
        if (!armas.get(opcion + 1).getNombre().equals(armasActivas.get(0).getNombre()) && armas.get(opcion + 1).isSingleHand()) {
            armasActivas.add(armas.get(opcion - 1));
            return true;
        }
        return false;
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

    public String generarNumerRegistro() {
        boolean valido = false;
        LecturaFicheroUsuarios lecturaFicheroUsuarios = new LecturaFicheroUsuarios();
        ArrayList<Cliente> lista = lecturaFicheroUsuarios.lecturaFicheroUsuario();
        String strBuilder = null;
        //crear del fichero lista de clientes para coger sus registros y comparar
        while (!valido) {
            strBuilder = String.valueOf(getLetra()) +
                    getNumber() +
                    getNumber() +
                    getLetra() +
                    getLetra();
            if (!lista.isEmpty()) {
                for (Cliente value : lista) {
                    if (!(value.getRegistro().equals(strBuilder))) {
                        valido = true;
                    } else {
                        strBuilder = null;
                    }
                }
            } else {
                valido = true;
            }
        }
        return strBuilder;
    }

    public char getLetra() {
        return (char) (Math.random() * 26 + 'a');
    }

    public char getNumber() {
        int N = (int) (Math.random() * 10 + '0');
        return (char) N;
    }

    public void consultarRanking() {
        Terminal terminal = new Terminal();
        terminal.ranking();
        Cliente cliente = new Cliente();
        ArrayList<Cliente> lista = new ArrayList<>();
        lista.add(cliente);
        //coger lista clientes de ficheros y guardarlos en lista
        ArrayList<Cliente> listaAux = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            boolean encontrado = false;
            for (int j = 0; j < listaAux.size(); j++) {
                if (lista.get(i).getPersonaje() != null && lista.get(i).getPersonaje().getOro() > listaAux.get(j).getPersonaje().getOro()) {
                    encontrado = true;
                    listaAux.add(j, lista.get(i));
                    break;
                }
            }
            if (!encontrado) {
                listaAux.add(lista.get(i));
            }
        }
        terminal.mostrarRanking(listaAux);
    }

    private void setEsbirrosVampiro(FactoriaVampiros factoriaVampiros, Terminal terminal, Vampiro vampiro, ArrayList<EsbirrosComposite> esbirros) {
        terminal.preguntarNumEsbirros();
        int numEsbirros = factoriaVampiros.askNum();
        for (int iterator = 1; iterator <= numEsbirros; iterator++) {
            EsbirrosComposite esbirro = new EsbirrosComposite();
            esbirro = esbirro.crearEsbirro(true);
            esbirros.add(esbirro);
        }
        vampiro.setEsbirros(esbirros);
    }

    private void setModificadoresVampiro(FactoriaVampiros factoriaVampiros, Terminal terminal, Vampiro vampiro, Debilidad debilidad, Fortaleza fortaleza, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas) {
        terminal.peguntarNumDebilidades();
        int numDebilidades = factoriaVampiros.askNum();
        for (int iterator = 1; iterator <= numDebilidades; iterator++) {
            terminal.preguntarNombreDebilidad();
            factoriaVampiros.inicializarNombreDebilidad(debilidad);
            terminal.preguntarValorDebilidad();
            factoriaVampiros.inicializarValorDebilidad(debilidad);
            factoriaVampiros.addDebilidad(debilidades, debilidad);
        }
        factoriaVampiros.setDebilidades(vampiro, debilidades);
        terminal.peguntarNumFortalezas();
        int numFortalezas = factoriaVampiros.askNum();
        for (int iterator = 1; iterator <= numFortalezas; iterator++) {
            terminal.preguntarNombreFortaleza();
            factoriaVampiros.inicializarNombreFortaleza(fortaleza);
            terminal.preguntarValorFortaleza();
            factoriaVampiros.inicializarValorFortaleza(fortaleza);
            factoriaVampiros.addFortaleza(fortalezas, fortaleza);
        }
        factoriaVampiros.setFortalezas(vampiro, fortalezas);
    }

    private void setOroHpPoderVampiro(FactoriaVampiros factoriaVampiros, Terminal terminal, Vampiro vampiro) {
        boolean rightValue;
        do {
            terminal.preguntarOro();
            rightValue = factoriaVampiros.inicializarOro(vampiro);
        } while (!rightValue);
        do {
            terminal.preguntarHP();
            rightValue = factoriaVampiros.inicializarHP(vampiro);
        } while (!rightValue);
        do {
            terminal.preguntarPoder();
            rightValue = factoriaVampiros.inicializarPoder(vampiro);
        } while (!rightValue);
    }

    private void setAllAmadurasVampiro(FactoriaVampiros factoriaVampiros, Terminal terminal, Vampiro vampiro, ArrayList<Armadura> armaduras, Armadura armadura) {
        boolean rightValue;
        int numArmaduras;
        do {
            terminal.preguntarNumArmaduras();
            numArmaduras = factoriaVampiros.askNum();
        } while (numArmaduras < 1);
        for (int iterator = 1; iterator <= numArmaduras; iterator++) {
            armadura = new Armadura();
            terminal.preguntarNombreArmadura();
            factoriaVampiros.inicializarnNombreArmadura(armadura);
            do {
                terminal.preguntarDefensaArmadura();
                rightValue = factoriaVampiros.inicializarDefensaArmadura(armadura);
            } while (!rightValue);
            do {
                terminal.preguntarAtaqueArmadura();
                rightValue = factoriaVampiros.inicializarAtaqueArmadura(armadura);
            } while (!rightValue);
            factoriaVampiros.addArmadura(armadura, armaduras);
        }
        factoriaVampiros.setArmaduras(vampiro, armaduras);
        do {
            terminal.mostrarArmaduras(armaduras);
            rightValue = factoriaVampiros.addArmaduraActiva(vampiro, armadura, armaduras);
        } while (!rightValue);
    }

    private void setAllArmasVampiro(boolean[] aux1, boolean[] aux2, FactoriaVampiros factoriaVampiros, Terminal terminal, Vampiro vampiro, ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        boolean[] rightWeapon;
        boolean rightValue;
        int numArmas;
        do {
            terminal.preguntarNumArmas();
            numArmas = factoriaVampiros.askNum();
        } while (numArmas < 1);
        for (int iterator = 1; iterator <= numArmas; iterator++) {
            Arma arma = new Arma();
            terminal.preguntarNombreArma();
            factoriaVampiros.inicializarnNombreArma(arma);
            do {
                terminal.preguntarAtaqueArma();
                rightValue = factoriaVampiros.inicializarAtaqueArma(arma);
            } while (!rightValue);
            do {
                terminal.preguntarDefensaArma();
                rightValue = factoriaVampiros.inicializarDefensaArma(arma);
            } while (!rightValue);
            do {
                terminal.peguntarSingleHandArma();
                rightValue = factoriaVampiros.inicializarSingleHandArma(arma);
            } while (!rightValue);
            factoriaVampiros.addArma(armas, arma);
        }
        factoriaVampiros.setArmas(vampiro, armas);
        do {
            terminal.mostrarArmas(armas);
            rightWeapon = factoriaVampiros.addArmaActiva(armas, armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(armas, armasActivas.get(0));
                rightValue = factoriaVampiros.addArmaActiva2(armas, armasActivas);
                if (!rightValue) {
                    terminal.ErrNumSelec();
                }
            } while (!rightValue);
        }
        factoriaVampiros.setArmasActivas(vampiro, armasActivas);
    }

    private void setNombreYHabilidadVampiro(FactoriaVampiros factoriaVampiros, Terminal terminal, Vampiro vampiro, Disciplina disciplina) {
        boolean rightValue;
        terminal.preguntarNombre();
        factoriaVampiros.inicializarNombre(vampiro);
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

    private void setEsbirrosCazador(FactoriaCazadores factoriaCazadores, Cazador cazador, ArrayList<EsbirrosComposite> esbirros) {
        int numEsbirros = factoriaCazadores.askNum();
        for (int iterator = 1; iterator <= numEsbirros; iterator++) {
            EsbirrosComposite esbirro = new EsbirrosComposite();
            esbirro = esbirro.crearEsbirro(false);
            esbirros.add(esbirro);
        }
        cazador.setEsbirros(esbirros);
    }

    private void setModificadoresCazador(FactoriaCazadores factoriaCazadores, Terminal terminal, Cazador cazador, Debilidad debilidad, Fortaleza fortaleza, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas) {
        terminal.peguntarNumDebilidades();
        int numDebilidades = factoriaCazadores.askNum();
        for (int iterator = 1; iterator <= numDebilidades; iterator++) {
            terminal.preguntarNombreDebilidad();
            factoriaCazadores.inicializarNombreDebilidad(debilidad);
            terminal.preguntarValorDebilidad();
            factoriaCazadores.inicializarValorDebilidad(debilidad);
            factoriaCazadores.addDebilidad(debilidades, debilidad);
        }
        factoriaCazadores.setDebilidades(cazador, debilidades);
        terminal.peguntarNumFortalezas();
        int numFortalezas = factoriaCazadores.askNum();
        for (int iterator = 1; iterator <= numFortalezas; iterator++) {
            terminal.preguntarNombreFortaleza();
            factoriaCazadores.inicializarNombreFortaleza(fortaleza);
            terminal.preguntarValorFortaleza();
            factoriaCazadores.inicializarValorFortaleza(fortaleza);
            factoriaCazadores.addFortaleza(fortalezas, fortaleza);
        }
        factoriaCazadores.setFortalezas(cazador, fortalezas);
        terminal.preguntarNumEsbirros();
    }

    private void setOroHpPoderCazador(FactoriaCazadores factoriaCazadores, Terminal terminal, Cazador cazador) {
        boolean rightValue;
        do {
            terminal.preguntarOro();
            rightValue = factoriaCazadores.inicializarOro(cazador);
        } while (!rightValue);
        do {
            terminal.preguntarHP();
            rightValue = factoriaCazadores.inicializarHP(cazador);
        } while (!rightValue);
        do {
            terminal.preguntarPoder();
            rightValue = factoriaCazadores.inicializarPoder(cazador);
        } while (!rightValue);
    }

    private void setAllArmadurasCazador(FactoriaCazadores factoriaCazadores, Terminal terminal, Cazador cazador, ArrayList<Armadura> armaduras, Armadura armadura) {
        boolean rightValue;
        int numArmaduras;
        do {
            terminal.preguntarNumArmaduras();
            numArmaduras = factoriaCazadores.askNum();
        } while (numArmaduras < 1);
        for (int iterator = 1; iterator <= numArmaduras; iterator++) {
            armadura = new Armadura();
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
        factoriaCazadores.setArmaduras(cazador, armaduras);
        do {
            terminal.mostrarArmaduras(armaduras);
            rightValue = factoriaCazadores.addArmaduraActiva(cazador, armadura, armaduras);
        } while (!rightValue);
    }

    private void setAllArmasCazador(boolean[] aux1, boolean[] aux2, FactoriaCazadores factoriaCazadores, Terminal terminal, Cazador cazador, ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        boolean rightValue;
        boolean[] rightWeapon;
        Arma arma;
        int numArmas;
        do {
            terminal.preguntarNumArmas();
            numArmas = factoriaCazadores.askNum();
        } while (numArmas < 1);
        for (int iterator = 1; iterator <= numArmas; iterator++) {
            arma = new Arma();
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
        factoriaCazadores.setArmas(cazador, armas);
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
        factoriaCazadores.setArmasActivas(cazador, armasActivas);
    }

    private void setNombreYHabilidadCazador(FactoriaCazadores factoriaCazadores, Terminal terminal, Cazador cazador, Talento talento) {
        boolean rightValue;
        terminal.preguntarNombre();
        factoriaCazadores.inicializarNombre(cazador);
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

    private void setEsbirrosLicantropo(FactoriaLicantropos factoriaLicantropo, Licantropo licantropo, ArrayList<EsbirrosComposite> esbirros) {
        int numEsbirros = factoriaLicantropo.askNum();
        for (int iterator = 1; iterator <= numEsbirros; iterator++) {
            EsbirrosComposite esbirro = new EsbirrosComposite();
            esbirro = esbirro.crearEsbirro(false);
            esbirros.add(esbirro);
        }
        licantropo.setEsbirros(esbirros);
    }

    private void setModificadoresLicantropo(FactoriaLicantropos factoriaLicantropo, Terminal terminal, Licantropo licantropo, Debilidad debilidad, Fortaleza fortaleza, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, ArrayList<EsbirrosComposite> esbirros) {
        terminal.peguntarNumDebilidades();
        int numDebilidades = factoriaLicantropo.askNum();
        for (int iterator = 1; iterator <= numDebilidades; iterator++) {
            terminal.preguntarNombreDebilidad();
            factoriaLicantropo.inicializarNombreDebilidad(debilidad);
            terminal.preguntarValorDebilidad();
            factoriaLicantropo.inicializarValorDebilidad(debilidad);
            factoriaLicantropo.addDebilidad(debilidades, debilidad);
        }
        factoriaLicantropo.setDebilidades(licantropo, debilidades);
        terminal.peguntarNumFortalezas();
        int numFortalezas = factoriaLicantropo.askNum();
        for (int iterator = 1; iterator <= numFortalezas; iterator++) {
            terminal.preguntarNombreFortaleza();
            factoriaLicantropo.inicializarNombreFortaleza(fortaleza);
            terminal.preguntarValorFortaleza();
            factoriaLicantropo.inicializarValorFortaleza(fortaleza);
            factoriaLicantropo.addFortaleza(fortalezas, fortaleza);
        }
        factoriaLicantropo.setFortalezas(licantropo, fortalezas);
        terminal.preguntarNumEsbirros();
        int numEsbirros = factoriaLicantropo.askNum();
        for (int iterator = 1; iterator <= numEsbirros; iterator++) {
            EsbirrosComposite esbirro = new EsbirrosComposite();
            esbirro = esbirro.crearEsbirro(false);
            esbirros.add(esbirro);
        }
    }

    private void setOroHpPoderLicantropo(FactoriaLicantropos factoriaLicantropo, Terminal terminal, Licantropo licantropo) {
        boolean rightValue;
        do {
            terminal.preguntarOro();
            rightValue = factoriaLicantropo.inicializarOro(licantropo);
        } while (!rightValue);
        do {
            terminal.preguntarHP();
            rightValue = factoriaLicantropo.inicializarHP(licantropo);
        } while (!rightValue);
        do {
            terminal.preguntarPoder();
            rightValue = factoriaLicantropo.inicializarPoder(licantropo);
        } while (!rightValue);
    }

    private void setAllArmadurasLicantropo(FactoriaLicantropos factoriaLicantropo, Terminal terminal, Licantropo licantropo, Armadura armadura, ArrayList<Armadura> armaduras) {
        boolean rightValue;
        terminal.preguntarNumArmaduras();
        int numArmaduras = factoriaLicantropo.askNum();
        for (int iterator = 1; iterator <= numArmaduras; iterator++) {
            armadura = new Armadura();
            terminal.preguntarNombreArmadura();
            factoriaLicantropo.inicializarNombreArmadura(armadura);
            do {
                terminal.preguntarDefensaArmadura();
                rightValue = factoriaLicantropo.inicializarDefensaArmadura(armadura);
            } while (!rightValue);
            do {
                terminal.preguntarAtaqueArmadura();
                rightValue = factoriaLicantropo.inicializarAtaqueArmadura(armadura);
            } while (!rightValue);
            factoriaLicantropo.addArmadura(armadura, armaduras);
        }
        factoriaLicantropo.setArmaduras(licantropo, armaduras);
        do {
            terminal.mostrarArmaduras(armaduras);
            rightValue = factoriaLicantropo.addArmaduraActiva(licantropo, armadura, armaduras);
        } while (!rightValue);
    }

    private void setAllArmasLicantropo(boolean[] aux1, boolean[] aux2, FactoriaLicantropos factoriaLicantropo, Terminal terminal, Licantropo licantropo, ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        boolean[] rightWeapon;
        boolean rightValue;
        int numArmas = factoriaLicantropo.askNum();
        for (int iterator = 1; iterator <= numArmas; iterator++) {
            Arma arma = new Arma();
            terminal.preguntarNombreArma();
            factoriaLicantropo.inicializarnNombreArma(arma);
            do {
                terminal.preguntarAtaqueArma();
                rightValue = factoriaLicantropo.inicializarAtaqueArma(arma);
            } while (!rightValue);
            do {
                terminal.preguntarDefensaArma();
                rightValue = factoriaLicantropo.inicializarDefensaArma(arma);
            } while (!rightValue);
            do {
                terminal.peguntarSingleHandArma();
                rightValue = factoriaLicantropo.inicializarSingleHandArma(arma);
            } while (!rightValue);
            factoriaLicantropo.addArma(armas, arma);
        }
        factoriaLicantropo.setArmas(licantropo, armas);
        do {
            terminal.mostrarArmas(armas);
            rightWeapon = factoriaLicantropo.addArmaActiva(armas, armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(armas, armasActivas.get(0));
                rightValue = factoriaLicantropo.addArmaActiva2(armas, armasActivas);
                if (!rightValue) {
                    terminal.ErrNumSelec();
                }
            } while (!rightValue);
        }
    }

    private void setNombreYHabilidadLicantropo(FactoriaLicantropos factoriaLicantropo, Terminal terminal, Licantropo licantropo, Don don) {
        boolean rightValue;
        terminal.preguntarNombre();
        factoriaLicantropo.inicializarNombre(licantropo);
        terminal.preguntarNombreHabilidad();
        factoriaLicantropo.inicializarNombreHabilidad(don);
        licantropo.setRabia(0);
        do {
            terminal.preguntarRabiaHabilidad();
            rightValue = factoriaLicantropo.inicializarRabiaHabilidad(don);
        } while (!rightValue);
        factoriaLicantropo.setHabilidad(licantropo, don);
        terminal.preguntarNumArmas();
    }
}

