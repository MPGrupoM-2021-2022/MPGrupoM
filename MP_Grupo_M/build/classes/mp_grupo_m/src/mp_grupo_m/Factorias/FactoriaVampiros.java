package mp_grupo_m.Factorias;

import mp_grupo_m.Entidades.*;


import java.util.ArrayList;
import java.util.Scanner;

public class FactoriaVampiros {

    public void inicializarNombre(Vampiro vampiro) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        vampiro.setNombre(nombre);
    }

    public void inicializarNombreHabilidad(Disciplina disciplina) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        disciplina.setNombre(nombre);
    }

    public boolean inicializarAtaqueHabilidad(Disciplina disciplina) {
        Scanner sc = new Scanner(System.in);
        int ataque = sc.nextInt();
        if ((ataque < 1) || (ataque > 3)) {
            return false;
        }
        disciplina.setAtaque(ataque);
        return true;
    }

    public boolean inicializarDefensaHabilidad(Disciplina disciplina) {
        Scanner sc = new Scanner(System.in);
        int defensa = sc.nextInt();
        if ((defensa < 1) || (defensa > 3)) {
            return false;
        }
        disciplina.setDefensa(defensa);
        return true;
    }

    public boolean inicializarCosteHabilidad(Disciplina disciplina) {
        Scanner sc = new Scanner(System.in);
        int coste = sc.nextInt();
        if ((coste < 1) || (coste > 3)) {
            return false;
        }
        disciplina.setCoste(coste);
        return true;
    }

    public void setHabilidad(Vampiro vampiro, Disciplina disciplina) {
        vampiro.setHabilidad(disciplina);
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

    public void setArmas(Vampiro vampiro, ArrayList<Arma> armas) {
        vampiro.setArmas(armas);
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

    public void setArmasActivas(Vampiro vampiro, ArrayList<Arma> armasActivas) {
        vampiro.setArmasActivas(armasActivas);
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

    public void setArmaduras(Vampiro vampiro, ArrayList<Armadura> armaduras) {
        vampiro.setArmaduras(armaduras);
    }

    public boolean addArmaduraActiva(Vampiro vampiro, Armadura armadura, ArrayList<Armadura> armaduras) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armaduras.size() + 1)) {
            return false;
        }
        armadura = armaduras.get(opcion - 1);
        vampiro.setArmaduraActiva(armadura);
        return true;
    }

    public boolean inicializarOro(Vampiro vampiro) {
        Scanner sc = new Scanner(System.in);
        int oro = sc.nextInt();
        if (oro < 0) {
            return false;
        }
        vampiro.setOro(oro);
        return true;
    }

    public boolean inicializarHP(Vampiro vampiro) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        if (hp < 0 || hp > 5) {
            return false;
        }
        vampiro.setHp(hp);
        return true;
    }

    public boolean inicializarPoder(Vampiro vampiro) {
        Scanner sc = new Scanner(System.in);
        int poder = sc.nextInt();
        if (poder < 1 || poder > 5) {
            return false;
        }
        vampiro.setPoder(poder);
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

    public void setDebilidades(Vampiro vampiro, ArrayList<Debilidad> debilidades) {
        vampiro.setDebilidades(debilidades);
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

    public void setFortalezas(Vampiro vampiro, ArrayList fortalezas) {
        vampiro.setFortalezas(fortalezas);
    }

    public void setEdad(Vampiro vampiro) {
        Scanner sc = new Scanner(System.in);
        int edad = sc.nextInt();
        vampiro.setEdad(edad);
    }
}