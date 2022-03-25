package mp_grupo_m.Factorias;

import mp_grupo_m.Entidades.*;

import java.util.List;
import java.util.Scanner;

public class FactoriaVampiros {
    private Vampiro vampiro;
    private Disciplina disciplina;

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
}
