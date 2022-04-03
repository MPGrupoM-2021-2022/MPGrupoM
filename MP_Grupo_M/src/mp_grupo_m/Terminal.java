package mp_grupo_m;

import mp_grupo_m.Entidades.Arma;
import mp_grupo_m.Entidades.Armadura;

import java.util.List;

public class Terminal {

    public void mostrarMenu() {
        System.out.println("************MENU************");
        System.out.println("1. REGISTRAR PERSONAJE");
        System.out.println("2. ELIMINAR PERSONAJE");
        System.out.println("3. SELECCIONAR EQUIPO");
        System.out.println("4. DESAFIAR");
        System.out.println("5. CONSULTAR COMBATES");
        System.out.println("6. CONSULTAR RANKING GLOBAL");
        System.out.println("7. SALIR");
        System.out.println("****************************");
    }

    public void mostrarInicio() {
        System.out.println("1. REGISTRARSE");
        System.out.println("2. INICIAR SESION");
    }

    public void error(){
        System.out.println("ERROR");
    }

    public void WIP(){
        System.out.println("En desarrollo...");
    }

    public void mostrarFactorias() {
        System.out.println("Seleccione que tipo de personaje quiere crear:");
        System.out.println("1. Vampiro");
        System.out.println("2. Licantropo");
        System.out.println("3. Cazador");
    }

    public void preguntarNombre() {
        System.out.println("Introduce el nombre del personaje:");
    }

    public void preguntarNombreHabilidad() {
        System.out.println("Introduce el nombre de la habilidad:");
    }

    public void preguntarAtaqueHabilidad() {
        System.out.println("Introduce el valor de ataque de la habilidad (entre 1 y 3):");
    }

    public void preguntarDefensaHabilidad() {
        System.out.println("Introduce el valor de defensa de la habilidad (entre 1 y 3):");
    }

    public void preguntarCosteHabilidad(){
        System.out.println("Introduce el coste de la habilidad:");
    }

    public void preguntarNumArmas() {
        System.out.println("Introduce el numero de armas que vas a introducir:");
    }

    public void preguntarNombreArma() {
        System.out.println("Introduce el nombre de tu arma:");
    }

    public void preguntarAtaqueArma() {
        System.out.println("Introduce el ataque de tu arma:");
    }

    public void preguntarDefensaArma() {
        System.out.println("Introduce la defensa de tu arma (escribe 0 si no tiene):");
    }

    public void peguntarSingleHandArma() {
        System.out.println("El arma se puede usar con un sola mano?");
        System.out.println("1. Si");
        System.out.println("2. No");
    }

    public void mostrarArmas(List<Arma> armas) {
        System.out.println("Que arma quieres equipar?");
        for (int iterator = 0; iterator < armas.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + armas.get(iterator).getNombre());
        }
    }

    public void otroArma(List<Arma> armas) {
        System.out.println("Quiere equipar otro arma de una sola mano?");
        System.out.println("0: NO");
        for (int iterator = 0; iterator < armas.size(); iterator++) {
            if (armas.get(iterator).isSingleHand()) {
                System.out.println(iterator + 1 + ": " + armas.get(iterator).getNombre());
            }
        }
    }

    public void preguntarNumArmaduras() {
        System.out.println("Introduce el numero de armaduras que vas a introducir:");
    }

    public void preguntarNombreArmadura() {
        System.out.println("Introduce el nombre de tu armadura:");
    }

    public void preguntarDefensaArmadura() {
        System.out.println("Introduce la defensa de tu armadura:");
    }

    public void preguntarAtaqueArmadura() {
        System.out.println("Introduce el ataque de tu armadura (escribe 0 si no tiene):");
    }

    public void mostrarArmaduras(List<Armadura> armaduras) {
        System.out.println("Que armadura quieres equipar?");
        for (int iterator = 0; iterator < armaduras.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + armaduras.get(iterator).getNombre());
        }
    }

    public void preguntarOro(){
        System.out.println("Introduce su cantidad de oro  (>0):");
    }

    public void preguntarHP(){
        System.out.println("Introduce su cantidad de vida (0-5):");
    }

    public void preguntarPoder(){
        System.out.println("Introduce su poder (1-5):");
    }

    public void peguntarNumDebilidades(){
        System.out.println("Introduce el numero de debilidades que vas a sumar:");
    }

    public void preguntarNombreDebilidad(){
        System.out.println("Introduce el nombre de tu debilidad:");
    }

    public void preguntarValorDebilidad(){
        System.out.println("Introduce el valor de tu debilidad:");
    }

    public void peguntarNumFortalezas(){
        System.out.println("Introduce el numero de fortalezas que vas a sumar:");
    }

    public void preguntarNombreFortaleza(){
        System.out.println("Introduce el nombre de tu fortaleza:");
    }

    public void preguntarValorFortaleza(){
        System.out.println("Introduce el valor de tu fortaleza:");
    }

    public void preguntarRabiaHabilidad() {System.out.println("Introduce el valor minimo para activar la rabia:");
    }
}
