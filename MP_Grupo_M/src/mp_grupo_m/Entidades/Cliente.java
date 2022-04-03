package mp_grupo_m.Entidades;

import mp_grupo_m.Factorias.FactoriaVampiros;
import mp_grupo_m.Terminal;

import java.util.ArrayList;
import java.util.Arrays;

public class Cliente extends User{

    private String registro;

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void crearVampiro() {

        boolean rightValue;
        boolean[] rightWeapon;
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
        Arma arma = new Arma();
        ArrayList<EsbirrosComposite> esbirros = new ArrayList<>();

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
        int numArmas;
        do {
            terminal.preguntarNumArmas();
            numArmas = factoriaVampiros.askNum();
        } while (numArmas < 1);
        for (int iterator = 1; iterator <= numArmas; iterator++) {
            arma = new Arma();
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
            rightWeapon = factoriaVampiros.addArmaActiva(arma, armas, armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(armas);
                rightValue = factoriaVampiros.addArmaActiva2(arma, armas, armasActivas);
            } while (!rightValue);
        }
        factoriaVampiros.setArmasActivas(vampiro, armasActivas);
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
        terminal.preguntarEdadVampiro();
        factoriaVampiros.setEdad(vampiro);
        vampiro.setSangre(0);
        terminal.preguntarNumEsbirros();
        int numEsbirros = factoriaVampiros.askNum();
        for (int iterator = 1; iterator <= numEsbirros; iterator++){
            EsbirrosComposite esbirro = new EsbirrosComposite();
            esbirro = esbirro.crearEsbirro(true);
            esbirros.add(esbirro);
        }
        vampiro.setEsbirros(esbirros);
    }

    public void eliminarPersonaje() {
        Terminal terminal = new Terminal();
        terminal.WIP();
    }

    public void seleccionarEquipo() {
        Terminal terminal = new Terminal();
        terminal.WIP();
    }

    public void desafiar() {
        Terminal terminal = new Terminal();
        terminal.WIP();
    }

    public void eliminarCuenta() {
        Terminal terminal = new Terminal();
        terminal.WIP();
    }
}