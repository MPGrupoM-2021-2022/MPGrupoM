package mp_grupo_m.Factorias;

import mp_grupo_m.Entidades.*;

import java.util.ArrayList;
import java.util.Scanner;

public class FactoriaLicantropos {

    public void inicializarNombre(Licantropo licantropo){
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        licantropo.setNombre(nombre);
    }

    public void inicializarNombreHabilidad(Don don) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        don.setNombre(nombre);
    }

    public boolean inicializarRabiaHabilidad(Don don) {
        Scanner sc = new Scanner(System.in);
        int rabia = sc.nextInt();
        if (rabia < 0)  {
            return false;
        }
        don.setValorMinimo(rabia);
        return true;
    }

    public void setHabilidad(Licantropo licantropo, Don don) {
        licantropo.setHabilidad(don);
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

    public void setArmas(Licantropo licantropo, ArrayList<Arma> armas) {
        licantropo.setArmas(armas);
    }

    public boolean[] addArmaActiva(ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armas.size() + 1)) {
            return new boolean[]{false, false};
        }
        armasActivas.add(armas.get(opcion - 1));
        return new boolean[]{true, armas.get(opcion - 1).isSingleHand()};
    }

    public boolean addArmaActiva2(ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 0) || (opcion > armas.size() + 1)) {
            return false;
        }
        if (opcion == 0) {
            return true;
        }
        if (armas.get(opcion - 1) != armasActivas.get(0) && armas.get(opcion - 1).isSingleHand()) {
            armasActivas.add(armas.get(opcion - 1));
            return true;
        }
        return false;
    }

    public void setArmasActivas(Licantropo licantropo, ArrayList<Arma> armasActivas) {
        licantropo.setArmasActivas(armasActivas);
    }

    public void inicializarNombreArmadura(Armadura armadura) {
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

    public boolean inicializarAtaqueArmadura(Arma arma) {
        Scanner sc = new Scanner(System.in);
        int ataque = sc.nextInt();
        if ((ataque < 0) || (ataque > 3)) {
            return false;
        }
        arma.setModAtaque(ataque);
        return true;
    }

    public void addArmadura(Armadura armadura, ArrayList<Armadura> armaduras) {
        armaduras.add(armadura);
    }

    public void setArmaduras(Licantropo licantropo, ArrayList<Armadura> armaduras) {
        licantropo.setArmaduras(armaduras);
    }

    public boolean addArmaduraActiva(Licantropo licantropo, Armadura armadura, ArrayList<Armadura> armaduras) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armaduras.size() + 1)) {
            return false;
        }
        armadura = armaduras.get(opcion - 1);
        licantropo.setArmaduraActiva(armadura);
        return true;
    }

    public boolean inicializarOro(Licantropo licantropo) {
        Scanner sc = new Scanner(System.in);
        int oro = sc.nextInt();
        if (oro < 0) {
            return false;
        }
        licantropo.setOro(oro);
        return true;
    }

    public boolean inicializarHP(Licantropo licantropo) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        if (hp < 0 || hp > 5) {
            return false;
        }
        licantropo.setHp(hp);
        return true;
    }

    public boolean inicializarPoder(Licantropo licantropo) {
        Scanner sc = new Scanner(System.in);
        int poder = sc.nextInt();
        if (poder < 1 || poder > 5) {
            return false;
        }
        licantropo.setPoder(poder);
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

    public void setDebilidades(Licantropo licantropo, ArrayList<Debilidad> debilidades) {
        licantropo.setDebilidades(debilidades);
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

    public void setFortalezas(Licantropo licantropo, ArrayList fortalezas) {
        licantropo.setFortalezas(fortalezas);
    }
}
