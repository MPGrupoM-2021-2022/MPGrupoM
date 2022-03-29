package mp_grupo_m.Factorias;

import mp_grupo_m.Entidades.*;


import java.util.List;
import java.util.Scanner;

public class FactoriaVampiros {
    private Vampiro vampiro;
    private Disciplina disciplina;
    private List<Arma> armas;
    private Arma arma;
    private List<Arma> armasActivas;
    private Armadura armadura;
    private List<Armadura> armaduras;
    private Debilidad debilidad;
    private Fortaleza fortaleza;
    private List<Debilidad> debilidades;
    private List<Fortaleza> fortalezas;

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

    public void preguntarCosteHabilidad(){
        System.out.println("Introduce el coste de la habilidad:");
    }

    public boolean inicializarCosteHabilidad(){
        Scanner sc = new Scanner(System.in);
        int coste = sc.nextInt();
        if ((coste < 1) || (coste > 3)) {
            return false;
        }
        disciplina.setCoste(coste);
        return true;
    }

    public void setHabilidad(){
        vampiro.setHabilidad(disciplina);
    }

    public void preguntarNumArmas() {
        System.out.println("Introduce el numero de armas que vas a introducir:");
    }

    public int askNum() {
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

    public void setArmas(){
        vampiro.setArmas(armas);
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

    public void setArmasActivas(){
        vampiro.setArmasActivas(armasActivas);
    }

    public void preguntarNumArmaduras() {
        System.out.println("Introduce el numero de armaduras que vas a introducir:");
    }

    public void preguntarNombreArmadura() {
        System.out.println("Introduce el nombre de tu armadura:");
    }

    public void inicializarnNombreArmadura() {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        armadura.setNombre(nombre);
    }

    public void preguntarDefensaArmadura() {
        System.out.println("Introduce la defensa de tu armadura:");
    }

    public boolean inicializarDefensaArmadura() {
        Scanner sc = new Scanner(System.in);
        int defensa = sc.nextInt();
        if ((defensa < 1) || (defensa > 3)) {
            return false;
        }
        armadura.setModDefensa(defensa);
        return true;
    }

    public void preguntarAtaqueArmadura() {
        System.out.println("Introduce el ataque de tu armadura (escribe 0 si no tiene):");
    }

    public boolean inicializarAtaqueArmadura() {
        Scanner sc = new Scanner(System.in);
        int ataque = sc.nextInt();
        if ((ataque < 0) || (ataque > 3)) {
            return false;
        }
        arma.setModAtaque(ataque);
        return true;
    }

    public void addArmadura() {
        armaduras.add(armadura);
    }

    public void setArmaduras(){
        vampiro.setArmaduras(armaduras);
    }

    public void mostrarArmaduras() {
        System.out.println("Que arma quieres equipar?");
        for (int iterator = 0; iterator < armaduras.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + armaduras.get(iterator).getNombre());
        }
    }

    public boolean addArmaduraActiva() {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armas.size() + 1)) {
            return false;
        }
        armadura = armaduras.get(opcion - 1);
        vampiro.setArmaduraActiva(armadura);
        return true;
    }

    public void preguntarOro(){
        System.out.println("Introduce su cantidad de oro  (>0):");
    }

    public boolean inicializarOro(){
        Scanner sc = new Scanner(System.in);
        int oro = sc.nextInt();
        if (oro < 0){
            return false;
        }
        vampiro.setOro(oro);
        return true;
    }

    public void preguntarHP(){
        System.out.println("Introduce su cantidad de vida (0-5):");
    }

    public boolean inicializarHP(){
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        if (hp < 0 || hp > 5) {
            return false;
        }
        vampiro.setHp(hp);
        return true;
    }

    public void preguntarPoder(){
        System.out.println("Introduce su poder (1-5):");
    }

    public boolean inicializarPoder(){
        Scanner sc = new Scanner(System.in);
        int poder = sc.nextInt();
        if (poder < 1 || poder > 5) {
            return false;
        }
        vampiro.setPoder(poder);
        return true;
    }

    public void peguntarNumDebilidades(){
        System.out.println("Introduce el numero de debilidades que vas a sumar:");
    }

    public void preguntarNombreDebilidad(){
        System.out.println("Introduce el nombre de tu debilidad:");
    }

    public void inicializarNombreDebilidad(){
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        debilidad.setNombre(nombre);
    }

    public void preguntarValorDebilidad(){
        System.out.println("Introduce el valor de tu debilidad:");
    }

    public void inicializarValorDebilidad(){
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        debilidad.setValor(valor);
    }

    public void addDebilidad(){
        debilidades.add(debilidad);
    }

    public void setDebilidades(){
        vampiro.setDebilidades(debilidades);
    }

    public void peguntarNumFortalezas(){
        System.out.println("Introduce el numero de fortalezas que vas a sumar:");
    }

    public void preguntarNombreFortaleza(){
        System.out.println("Introduce el nombre de tu fortaleza:");
    }

    public void inicializarNombreFortaleza(){
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        fortaleza.setNombre(nombre);
    }

    public void preguntarValorFortaleza(){
        System.out.println("Introduce el valor de tu fortaleza:");
    }

    public void inicializarValorFortaleza(){
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        fortaleza.setValor(valor);
    }

    public void addFortaleza(){
        fortalezas.add(fortaleza);
    }

    public void setFortalezas(){
        vampiro.setFortalezas(fortalezas);
    }

}
