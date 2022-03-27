package mp_grupo_m.Factorias;

import mp_grupo_m.Entidades.Arma;
import mp_grupo_m.Entidades.Disciplina;
import mp_grupo_m.Entidades.Vampiro;


import java.util.List;
import java.util.Scanner;

public class FactoriaVampiros {
    private Vampiro vampiro;
    private Disciplina disciplina;
    private List<Arma> armas;
    private Arma arma;
    private List<Arma> armasActivas;

    public Vampiro getVampiro() {
        return vampiro;
    }

    public void preguntarNombre() {
        System.out.println("Introduce el nombre del vampiro:");
    }

    public void inicializarNombre() {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        vampiro.setNombre(nombre);
    }

    public void preguntarNombreHabilidad() {
        System.out.println("Introduce el nombre de la disciplina:");
    }

    public void inicializarNombreHabilidad() {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        disciplina.setNombre(nombre);
    }

    public void preguntarAtaqueHabilidad() {
        System.out.println("Introduce el valor de ataque de la habilidad (entre 1 y 3):");
    }

    public boolean inicializarAtaqueHabilidad() {
        Scanner sc = new Scanner(System.in);
        int ataque = sc.nextInt();
        if ((ataque < 1) || (ataque > 3)) {
            return false;
        }
        disciplina.setAtaque(ataque);
        return true;
    }

    public void preguntarDefensaHabilidad() {
        System.out.println("Introduce el valor de defensa de la habilidad (entre 1 y 3):");
    }

    public boolean inicializarDefensaHabilidad() {
        Scanner sc = new Scanner(System.in);
        int defensa = sc.nextInt();
        if ((defensa < 1) || (defensa > 3)) {
            return false;
        }
        disciplina.setDefensa(defensa);
        return true;
    }

    public void preguntarNumArmas() {
        System.out.println("Introduce el numero de armas que vas a introducir:");
    }

    public int numArmas() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void preguntarNombreArma() {
        System.out.println("Introduce el nombre de tu arma:");
    }

    public void inicializarnNombreArma() {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        arma.setNombre(nombre);
    }

    public void preguntarAtaqueArma() {
        System.out.println("Introduce el ataque de tu arma:");
    }

    public boolean inicializarAtaqueArma() {
        Scanner sc = new Scanner(System.in);
        int ataque = sc.nextInt();
        if ((ataque < 1) || (ataque > 3)) {
            return false;
        }
        arma.setModAtaque(ataque);
        return true;
    }

    public void preguntarDefensaArma() {
        System.out.println("Introduce la defensa de tu arma (escribe 0 si no tiene):");
    }

    public boolean inicializarDefensaArma() {
        Scanner sc = new Scanner(System.in);
        int defensa = sc.nextInt();
        if ((defensa < 0) || (defensa > 3)) {
            return false;
        }
        arma.setModDefensa(defensa);
        return true;
    }

    public void peguntarSingleHandArma() {
        System.out.println("El arma se puede usar con un sola mano?");
        System.out.println("1. Si");
        System.out.println("2. No");
    }

    public boolean inicializarSingleHandArma() {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                arma.setSingleHand(true);
                return true;
            case 2:
                arma.setSingleHand(false);
            default:
                return false;
        }
    }

    public void addArma() {
        armas.add(arma);
    }

    public void mostrarArmas() {
        System.out.println("Que arma quieres equipar?");
        for (int iterator = 0; iterator < armas.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + armas.get(iterator).getNombre());
        }
    }

    public boolean[] addArmaActiva() {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armas.size() + 1)) {
            return new boolean[]{false, false};
        }
        armasActivas.add(armas.get(opcion - 1));
        arma = armas.get(opcion - 1);
        return new boolean[]{true, armas.get(opcion - 1).isSingleHand()};
    }

    public void otroArma() {
        System.out.println("Quiere equipar otro arma de una sola mano?");
        System.out.println("0: NO");
        for (int iterator = 0; iterator < armas.size(); iterator++) {
            if (armas.get(iterator).isSingleHand()) {
                System.out.println(iterator + 1 + ": " + armas.get(iterator).getNombre());
            }
        }
    }

    public boolean addArmaActiva2() {
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

}
