package mp_grupo_m.Factorias;

import mp_grupo_m.Entidades.*;

import java.util.ArrayList;
import java.util.Scanner;

public class FactoriaCazadores {

    public void inicializarNombre(Cazador cazador) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        cazador.setNombre(nombre);
    }

    public void inicializarNombreHabilidad(Talento talento) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        talento.setNombre(nombre);
    }

    public boolean inicializarAtaqueHabilidad(Talento talento) {
        Scanner sc = new Scanner(System.in);
        int ataque = sc.nextInt();
        if ((ataque < 1) || (ataque > 3)) {
            return false;
        }
        talento.setAtaque(ataque);
        return true;
    }

    public boolean inicializarDefensaHabilidad(Talento talento) {
        Scanner sc = new Scanner(System.in);
        int defensa = sc.nextInt();
        if ((defensa < 1) || (defensa > 3)) {
            return false;
        }
        talento.setDefensa(defensa);
        return true;
    }

    public void inicializarEdadHabilidad(Talento talento) {
        Scanner sc = new Scanner(System.in);
        int edad = sc.nextInt();
        talento.setEdad(edad);
    }

    public void setHabilidad(Cazador cazador, Talento talento) {
        cazador.setHabilidad(talento);
    }

    public int askNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void inicializarnNombreArma(Arma arma) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        arma.setNombre(nombre);
    }

    public boolean inicializarAtaqueArma(Arma arma) {
        Scanner sc = new Scanner(System.in);
        int ataque = sc.nextInt();
        if ((ataque < 1) || (ataque > 3)) {
            return false;
        }
        arma.setModAtaque(ataque);
        return true;
    }

    public boolean inicializarDefensaArma(Arma arma) {
        Scanner sc = new Scanner(System.in);
        int defensa = sc.nextInt();
        if ((defensa < 0) || (defensa > 3)) {
            return false;
        }
        arma.setModDefensa(defensa);
        return true;
    }

    public boolean inicializarSingleHandArma(Arma arma) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                arma.setSingleHand(true);
                return true;
            case 2:
                arma.setSingleHand(false);
                return true;
            default:
                return false;
        }
    }

    public void addArma(ArrayList<Arma> armas, Arma arma) {
        armas.add(arma);
    }

    public void setArmas(Cazador cazador, ArrayList<Arma> armas) {
        cazador.setArmas(armas);
    }

    public boolean[] addArmaActiva(Arma arma, ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armas.size() + 1)) {
            return new boolean[]{false, false};
        }
        armasActivas.add(armas.get(opcion - 1));
        arma = armas.get(opcion - 1);
        return new boolean[]{true, armas.get(opcion - 1).isSingleHand()};
    }

    public boolean addArmaActiva2(Arma arma, ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 0) || (opcion > armas.size() + 1)) {
            return false;
        }
        if (opcion == 0) {
            return true;
        }
        if (armas.get(opcion + 1) != arma && armas.get(opcion + 1).isSingleHand()) {
            armasActivas.add(armas.get(opcion - 1));
            return true;
        }
        return false;
    }

    public void setArmasActivas(Cazador cazador, ArrayList<Arma> armasActivas) {
        cazador.setArmasActivas(armasActivas);
    }

    public void inicializarnNombreArmadura(Armadura armadura) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        armadura.setNombre(nombre);
    }

    public boolean inicializarDefensaArmadura(Armadura armadura) {
        Scanner sc = new Scanner(System.in);
        int defensa = sc.nextInt();
        if ((defensa < 1) || (defensa > 3)) {
            return false;
        }
        armadura.setModDefensa(defensa);
        return true;
    }

    public boolean inicializarAtaqueArmadura(Armadura armadura) {
        Scanner sc = new Scanner(System.in);
        int ataque = sc.nextInt();
        if ((ataque < 0) || (ataque > 3)) {
            return false;
        }
        armadura.setModAtaque(ataque);
        return true;
    }

    public void addArmadura(Armadura armadura, ArrayList<Armadura> armaduras) {
        armaduras.add(armadura);
    }

    public void setArmaduras(Cazador cazador, ArrayList<Armadura> armaduras) {
        cazador.setArmaduras(armaduras);
    }

    public boolean addArmaduraActiva(Cazador cazador, Armadura armadura, ArrayList<Armadura> armaduras) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armaduras.size() + 1)) {
            return false;
        }
        armadura = armaduras.get(opcion - 1);
        cazador.setArmaduraActiva(armadura);
        return true;
    }

    public boolean inicializarOro(Cazador cazador) {
        Scanner sc = new Scanner(System.in);
        int oro = sc.nextInt();
        if (oro < 0) {
            return false;
        }
        cazador.setOro(oro);
        return true;
    }

    public boolean inicializarHP(Cazador cazador) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        if (hp < 0 || hp > 5) {
            return false;
        }
        cazador.setHp(hp);
        return true;
    }

    public boolean inicializarPoder(Cazador cazador) {
        Scanner sc = new Scanner(System.in);
        int poder = sc.nextInt();
        if (poder < 1 || poder > 5) {
            return false;
        }
        cazador.setPoder(poder);
        return true;
    }

    public void inicializarNombreDebilidad(Debilidad debilidad) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        debilidad.setNombre(nombre);
    }

    public void inicializarValorDebilidad(Debilidad debilidad) {
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        debilidad.setValor(valor);
    }

    public void addDebilidad(ArrayList<Debilidad> debilidades, Debilidad debilidad) {
        debilidades.add(debilidad);
    }

    public void setDebilidades(Cazador cazador, ArrayList<Debilidad> debilidades) {
        cazador.setDebilidades(debilidades);
    }

    public void inicializarNombreFortaleza(Fortaleza fortaleza) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        fortaleza.setNombre(nombre);
    }

    public void inicializarValorFortaleza(Fortaleza fortaleza) {
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        fortaleza.setValor(valor);
    }

    public void addFortaleza(ArrayList<Fortaleza> fortalezas, Fortaleza fortaleza) {
        fortalezas.add(fortaleza);
    }

    public void setFortalezas(Cazador cazador, ArrayList fortalezas) {
        cazador.setFortalezas(fortalezas);
    }

}
