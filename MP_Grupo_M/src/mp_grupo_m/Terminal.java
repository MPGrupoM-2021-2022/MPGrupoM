package mp_grupo_m;

import mp_grupo_m.Entidades.*;

import java.util.ArrayList;
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
        System.out.println("8. BORRAR CUENTA");
        System.out.println("****************************");
    }

    public void mostrarInicio() {
        System.out.println("1. REGISTRARSE");
        System.out.println("2. INICIAR SESION CLIENTE");
        System.out.println("3. INICIAR SESION ADMIN");
    }

    public void error() {
        System.out.println("ERROR");
    }

    public void WIP() {
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

    public void preguntarCosteHabilidad() {
        System.out.println("Introduce el coste de la habilidad (entre 1 y 3):");
    }

    public void preguntarNumArmas() {
        System.out.println("Introduce el numero de armas que vas a introducir:");
    }

    public void preguntarNombreArma() {
        System.out.println("Introduce el nombre de tu arma:");
    }

    public void preguntarAtaqueArma() {
        System.out.println("Introduce el ataque de tu arma (entre 1 y 3):");
    }

    public void preguntarDefensaArma() {
        System.out.println("Introduce la defensa de tu arma (escribe 0 si no tiene, max 3):");
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

    public void otroArma(List<Arma> armas, Arma arma) {
        System.out.println("Quiere equipar otro arma de una sola mano?");
        System.out.println("0: NO");
        for (int iterator = 0; iterator < armas.size(); iterator++) {
            if (armas.get(iterator).isSingleHand() && armas.get(iterator) != arma) {
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
        System.out.println("Introduce la defensa de tu armadura (entre 1 y 3):");
    }

    public void preguntarAtaqueArmadura() {
        System.out.println("Introduce el ataque de tu armadura (escribe 0 si no tiene, max 3):");
    }

    public void mostrarArmaduras(List<Armadura> armaduras) {
        System.out.println("Que arma quieres equipar?");
        for (int iterator = 0; iterator < armaduras.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + armaduras.get(iterator).getNombre());
        }
    }

    public void preguntarOro() {
        System.out.println("Introduce su cantidad de oro  (>= 0):");
    }

    public void preguntarHP() {
        System.out.println("Introduce su cantidad de vida:");
    }

    public void preguntarPoder() {
        System.out.println("Introduce su poder (1-5):");
    }

    public void peguntarNumDebilidades() {
        System.out.println("Introduce el numero de debilidades que vas a sumar:");
    }

    public void preguntarNombreDebilidad() {
        System.out.println("Introduce el nombre de tu debilidad:");
    }

    public void preguntarValorDebilidad() {
        System.out.println("Introduce el valor de tu debilidad:");
    }

    public void peguntarNumFortalezas() {
        System.out.println("Introduce el numero de fortalezas que vas a sumar:");
    }

    public void preguntarNombreFortaleza() {
        System.out.println("Introduce el nombre de tu fortaleza:");
    }

    public void preguntarValorFortaleza() {
        System.out.println("Introduce el valor de tu fortaleza:");
    }

    public void preguntarEdadVampiro() {
        System.out.println("Introduce la edad de tu vampiro:");
    }

    public void preguntarTipoEsbirro() {
        System.out.println("Selecciona tu tipo de esbirro:");
        System.out.println("1. Humano");
        System.out.println("2. Ghoul");
        System.out.println("3. Demonio");
    }

    public void errorHumano() {
        System.out.println("Al ser un vampiro no puedes tener humanos esbirros, prueba con otro esbirro");
    }

    public void preguntarNombreEsbirro() {
        System.out.println("Introduce el nombre de tu esbirro:");
    }

    public void preguntarLealtad() {
        System.out.println("Introduce la lealtad de tu humano:");
        System.out.println("1. Alta");
        System.out.println("2. Media");
        System.out.println("3. Baja");
    }

    public void preguntarDependencia() {
        System.out.println("Introduce la dependencia de tu ghoul (1-5):");
    }

    public void preguntarPacto() {
        System.out.println("Introduce aqui el pacto del demonio:");
    }

    public void preguntarNumEsbirros() {
        System.out.println("Introduce el numero de esbirros que vas a querer:");
    }

    public void preguntarEdadHabilidad() {
        System.out.println("Introduce la edad a la que el cazador adquirio el talento:");
    }

    public void preguntarRabiaHabilidad() {
        System.out.println("Introduce el valor minimo para activar la rabia:");
    }

    public void menuRegistroUsuario() {
        System.out.println("REGISTRO DE USUARIO NUEVO: ");
        System.out.println("****************");
        System.out.println("¿Cómo se quiere registrar? ");
        System.out.println("1. Cliente ");
        System.out.println("2. Operador ");
        System.out.println("3. Salir");
    }

    public void bienvenidaDesafio() {
        System.out.println("Bienvenido al menu de desafios, elija a su contrincante:");
    }

    public void noHayContrincantes() {
        System.out.println("No hay contincantes disponibles, volviendo al menu...");
    }

    public void mostrarPosiblesContrincantes(ArrayList<Cliente> listaClientes) {
        System.out.println("0: Cancelar");
        for (int i = 0; i <= listaClientes.size(); i++) {
            if (listaClientes.get(i).getPersonaje() != null) {
                System.out.println((i + 1) + ": " + listaClientes.get(i).getNick());
            }
        }
    }

    public void numValido() {
        System.out.println("Escoge un numero valido");
    }

    public void preguntarCantidadApostar() {
        System.out.println("Introduce la cantidad de oro que quieres apostar:");
    }

    public void desafioCreado() {
        System.out.println("Desafio creado y pendiente de validacion por parte de un admin...");
        System.out.println("Volviendo al menu...");
    }

    public void preguntarNombreUser() {
        System.out.println("Introduce tu nombre y apellidos");
    }

    public void preguntarNick() {
        System.out.println("Introduce tu nick de usuario");
    }

    public void preguntarPassword() {
        System.out.println("Introduce la password de tu cuenta");
    }

    public void errorPassword() {
        System.out.println("Password incorrecta, pruebe de nuevo");
    }

    public void confirmarPassword() {
        System.out.println("Confirme la password introducida");
    }

    public void nickExistente() {
        System.out.println("El nick introducido ya existe");
    }

    public void confirmarDelete() {
        System.out.println("Seguro que desea eliminar la cuenta?");
        System.out.println("1. SI");
        System.out.println("2. NO");
    }

    public void eliminarPersonaje() {
        System.out.println("Para crear un personaje nuevo antes tienes que eliminar el existente");
    }

    public void cerrarSesion() {
        System.out.println("Cerrando sesion...");
    }

    public void confirmarDeletePersonaje() {
        System.out.println("Seguro que desea eliminar el personaje?");
        System.out.println("1. SI");
        System.out.println("2. NO");
    }

    public void personajeEliminado() {
        System.out.println("Personaje eliminado correctamente...");
    }

    public void finishEquipar() {
        System.out.println("Arma(s) y armadura equipadas correctamente...");
    }

    public void ranking() {
        System.out.println("Este es el ranking de oro actual");
    }

    public void mostrarRanking(ArrayList<Cliente> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + 1 + ": " + lista.get(i).getNick() + "\t\t" + lista.get(i).getPersonaje().getOro() + " Oro");
        }
    }

    public void ErrNumSelec() {
        System.out.println("El numero introducido no es correcto");
    }

    public void inicioRonda(int hpDesafiante, int hpContrincante, String nick, String nick1, int potencialAtaqueDesafiante, int potencialDefensaDesafiante, int potencialAtaqueContrincante, int potencialDefensaContrincante) {
        System.out.println(nick + ":");
        System.out.println("Vida: " + hpDesafiante);
        System.out.println("Potencial ataque: " + potencialAtaqueDesafiante);
        System.out.println("Potencial defensa: " + potencialDefensaDesafiante);
        System.out.println();
        System.out.println(nick1 + ":");
        System.out.println("Vida: " + hpContrincante);
        System.out.println("Potencial ataque: " + potencialAtaqueContrincante);
        System.out.println("Potencial defensa: " + potencialDefensaContrincante);
        System.out.println();
    }

    public void preguntarDesafio(Desafio desafio) {
        System.out.println("Te ha desfiado el usuario " + desafio.getDesafiante().getNick());
        System.out.println("Ha apostado " + desafio.getOro() + " oro");
        System.out.println("Quieres aceptar el desafio?");
        System.out.println("1. SI");
        System.out.println("2. NO");
        System.out.println("Nota: si no aceptas perderás " + desafio.getOro()/10 + " de oro");
    }

    public void cambiarEquipo() {
        System.out.println("Quieres cambiar las armas y armaduras del personaje?");
        System.out.println("1. SI");
        System.out.println("2. NO");
    }

    public void mostrarCombate(Combate combate) {
        System.out.println("Combate: " + combate.getRegistro());
        System.out.println("Desafiante: " + combate.getDesafiante().getNick());
        System.out.println("Contrincante: " + combate.getContrincante().getNick());
        System.out.println("Fecha: " + combate.getFecha());
        if (combate.isEsbirrosDesafiante()){
            System.out.println("Esbirros de " + combate.getDesafiante().getNick() + " : vivos");
        } else {
            System.out.println("Esbirros de " + combate.getDesafiante().getNick() + " : muertos");
        }
        if (combate.isEsbirrosContrincante()){
            System.out.println("Esbirros de " + combate.getContrincante().getNick() + " : vivos");
        } else {
            System.out.println("Esbirros de " + combate.getContrincante().getNick() + " : muertos");
        }
        System.out.println("Oro apostado: " + combate.getOro());
        System.out.println("Modificadores:");
        for (int i = 0; i < combate.getModificadores().size(); i++){
            System.out.println(combate.getModificadores().get(i).getNombre());
        }
        System.out.println("RONDAS:");
        mostrarRondas(combate);
    }

    public void mostrarRondas(Combate combate) {
        for (int i = 0; i < combate.getRondas().size(); i++){
            System.out.println("Ronda " + i+1 + " :");
            System.out.println("Vida de " + combate.getDesafiante().getPersonaje().getNombre() + " al final de la ronda: " + combate.getRondas().get(i).getHpDesafianteEnd());
            System.out.println("Vida de " + combate.getContrincante().getPersonaje().getNombre() + " al final de la ronda: " + combate.getRondas().get(i).getHpContrincanteEnd());
        }
        System.out.println("FIN DEL COMBATE");
        if (combate.getVencedor() != null) {
            System.out.println("Vencedor: " + combate.getVencedor().getNick());
        } else {
            System.out.println("Vencedor: empate");
        }
    }
}

