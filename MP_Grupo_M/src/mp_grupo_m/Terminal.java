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

    public void mostrarMenuOperador() {
        System.out.println("************MENU************");
        System.out.println("1. MODIFICAR PERSONAJE");
        System.out.println("2. VALIDAR DESAFIO");
        System.out.println("3. DESBANEAR USUARIO");
        System.out.println("4. SALIR");
        System.out.println("5. BORRAR CUENTA");
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
        for (int numArma = 0; numArma < armas.size(); numArma++) {
            System.out.println(numArma + 1 + ": " + armas.get(numArma).getNombre());
        }
    }

    public void armasPersonaje(List<Arma> armas) {
        System.out.println("Estas son las armas del personaje");
        for (int iterator = 0; iterator < armas.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + armas.get(iterator).getNombre());
        }
    }

    public void armadurasPersonaje(List<Armadura> armaduras) {
        System.out.println("Estas son las armas del personaje");
        for (int iterator = 0; iterator < armaduras.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + armaduras.get(iterator).getNombre());
        }
    }

    public void otroArma(List<Arma> armas, Arma arma) {
        System.out.println("Quiere equipar otro arma de una sola mano?");
        System.out.println("0: NO");
        for (int numArma = 0; numArma < armas.size(); numArma++) {
            if (armas.get(numArma).isSingleHand() && !armas.get(numArma).getNombre().equals(arma.getNombre())) {
                System.out.println(numArma + 1 + ": " + armas.get(numArma).getNombre());
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
        System.out.println("Que armadura quieres equipar?");
        for (int numArmadura = 0; numArmadura < armaduras.size(); numArmadura++) {
            System.out.println(numArmadura + 1 + ": " + armaduras.get(numArmadura).getNombre());
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

    public void
    preguntarRabiaHabilidad() {
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

    public void mostrarPosiblesContrincantes(ArrayList<Cliente> listaClientes, Cliente cliente) {
        System.out.println("0: Cancelar");
        for (int numCliente = 0; numCliente < listaClientes.size(); numCliente++) {
            if (listaClientes.get(numCliente).getPersonaje() != null && !listaClientes.get(numCliente).getNick().equals(cliente.getNick())) {
                System.out.println((numCliente + 1) + ": " + listaClientes.get(numCliente).getNick());
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

    public void preguntarNickAdmin() {
        System.out.println("Introduce el nick del cliente que desea modificar su personaje");
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
        int contador = 0;
        for (int numCliente = 0; numCliente < lista.size(); numCliente++) {
            if(lista.get(numCliente).getPersonaje()!=null){
                contador ++;
                System.out.println(contador + ": " + lista.get(numCliente).getNick() + "\t\t" + lista.get(numCliente).getPersonaje().getOro() + " Oro");
            }
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
        System.out.println("Nota: si no aceptas perderás " + desafio.getOro() / 10 + " de oro");
    }

    public void cambiarEquipo() {
        System.out.println("Quieres cambiar las armas y armaduras del personaje?");
        System.out.println("1. SI");
        System.out.println("2. NO");
    }

    public void validarDesafio() {
        System.out.println("¿Quieres validar este desafio?");
        System.out.println("1. SI");
        System.out.println("2. NO");
    }

    public void modificarCliente() {
        System.out.println("Introduce el nick del cliente que desea modificar su personaje");
    }
    public void menuModPersonaje() {
        System.out.println("SELECCIONE QUE DESEA MODIFICAR");
        System.out.println("******************************");
        System.out.println("1.  Nombre");
        System.out.println("2.  Habilidad");
        System.out.println("3.  Armas");
        System.out.println("4.  Armas activas");
        System.out.println("5.  Armaduras");
        System.out.println("6.  Armafuras activas");
        System.out.println("7.  Esbirros");
        System.out.println("8.  Oro");
        System.out.println("9.  Hp");
        System.out.println("10. Poder");
        System.out.println("11. Debilidades");
        System.out.println("12. Fortalezas");
        System.out.println("13. Tipo");
        System.out.println("14. Salir");
    }

    public void eleccionModificadores() {
        System.out.println("Introduce las modificaciones que creas convenientes para el combate, cuando acabes escribe 'salir':");
    }

    public void errorMod() {
        System.out.println("el modificador introducido es erroneo, por favor indique los modificadores mostrados anteriormente");
    }

    public void errorNick() {
        System.out.println("el nick introducido no corresponde con ningun cliente, intentelo otra vez");
    }

    public void introModificacion() {
        System.out.println("introduce el valor modificado:");
    }

    public void salir() {
        System.out.println("Saliendo...");
    }

    public void mostrarNombre(Personaje personaje) {
        System.out.println("Este es el nombre actual:");
        System.out.println(personaje.getNombre());
    }

    public void mostrarOro() {
        System.out.println("Este es el oro actual:");
    }

    public void mostrarHp() {
        System.out.println("Esta es la hp actual:");
    }

    public void mostrarPoder() {
        System.out.println("Este es el poder actual:");
    }


    public void mostrarTipo() {
        System.out.println("Este es el tipo de personaje actual:");
    }

    public void modificarArma() {
        System.out.println("¿Que desea realizar?");
        System.out.println("******************************");
        System.out.println("1.  añadir arma");
        System.out.println("2.  eliminar arma");
        System.out.println("3.  Volver");
    }

    public void modificarArmadura() {
        System.out.println("¿Que desea realizar?");
        System.out.println("******************************");
        System.out.println("1.  añadir armadura");
        System.out.println("2.  eliminar armadura");
        System.out.println("3.  Volver");
    }

    public void errorArmaActiva() {
        System.out.println("El arma esta activa y no se puede eliminar");
    }

    public void errorArmaduraActiva() {
        System.out.println("la armadura esta activa y no se puede eliminar");
    }

    public void preguntarArmaEliminar() {
        System.out.println("Introduce el arma que quiere eliminar");
    }
    public void preguntarArmaduraEliminar() {
        System.out.println("Introduce la armadura que quiere eliminar");
    }

    public void debilidadesPersonaje(ArrayList<Debilidad> debilidades) {
        System.out.println("Estas son las debilidades del personaje");
        for (int iterator = 0; iterator < debilidades.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + debilidades.get(iterator).getNombre());
        }
    }

    public void modificarDebilidades() {
        System.out.println("¿Que desea realizar?");
        System.out.println("******************************");
        System.out.println("1.  añadir debilidad");
        System.out.println("2.  eliminar debilidad");
        System.out.println("3.  Volver");
    }

    public void fortalezasPersonaje(ArrayList<Fortaleza> fortalezas) {
        System.out.println("Estas son las fortalezas del personaje");
        for (int iterator = 0; iterator < fortalezas.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + fortalezas.get(iterator).getNombre());
        }
    }

    public void modificarFortalezas() {
        System.out.println("¿Que desea realizar?");
        System.out.println("******************************");
        System.out.println("1.  añadir debilidad");
        System.out.println("2.  eliminar debilidad");
        System.out.println("3.  Volver");
    }

    public void seleccionarTipo() {
        System.out.println("¿de cual tipo quiere que sea el personaje?");
        System.out.println("******************************");
        System.out.println("1.  vampiro");
        System.out.println("2.  cazador");
        System.out.println("3.  licantropo");
    }

    public void esbirrosPersonajes(ArrayList<EsbirrosComposite> esbirros) {
        System.out.println("Estas son las fortalezas del personaje");
        for (int iterator = 0; iterator < esbirros.size(); iterator++) {
            System.out.println(iterator + 1 + ": " + esbirros.get(iterator).getNombre());
        }
    }

    public void preguntarEsbirroEliminar() {
        System.out.println("Introduce el esbirro que quiere eliminar");
    }

    public void modificarEsbirros() {
        System.out.println("¿Que desea realizar?");
        System.out.println("******************************");
        System.out.println("1.  añadir esbirro");
        System.out.println("2.  eliminar esbirro");
        System.out.println("3.  Volver");
    }

    public void mostrarCombate(Combate combate) {
        System.out.println("Combate: " + combate.getRegistro());
        System.out.println("Desafiante: " + combate.getDesafiante().getNick());
        System.out.println("Contrincante: " + combate.getContrincante().getNick());
        System.out.println("Fecha: " + combate.getFecha());
        if (combate.isEsbirrosDesafiante()) {
            System.out.println("Esbirros de " + combate.getDesafiante().getNick() + " : vivos");
        } else {
            System.out.println("Esbirros de " + combate.getDesafiante().getNick() + " : muertos");
        }
        if (combate.isEsbirrosContrincante()) {
            System.out.println("Esbirros de " + combate.getContrincante().getNick() + " : vivos");
        } else {
            System.out.println("Esbirros de " + combate.getContrincante().getNick() + " : muertos");
        }
        System.out.println("Oro apostado: " + combate.getOro());
        System.out.println("Modificadores:");
        for (int numModificador = 0; numModificador < combate.getModificadores().size(); numModificador++) {
            System.out.println(combate.getModificadores().get(numModificador).getNombre());
        }
        System.out.println("RONDAS:");
        mostrarRondas(combate);
    }

    public void mostrarRondas(Combate combate) {
        for (int numRonda = 0; numRonda < combate.getRondas().size(); numRonda++) {
            System.out.println("Ronda " + (numRonda+1) + " :");
            System.out.println("Vida de " + combate.getDesafiante().getPersonaje().getNombre() + " al final de la ronda: " + combate.getRondas().get(numRonda).getHpDesafianteEnd());
            System.out.println("Vida de " + combate.getContrincante().getPersonaje().getNombre() + " al final de la ronda: " + combate.getRondas().get(numRonda).getHpContrincanteEnd());
        }
        System.out.println("FIN DEL COMBATE");
        if (combate.getVencedor() != null) {
            System.out.println("Vencedor: " + combate.getVencedor().getNick());
        } else {
            System.out.println("Vencedor: empate");
        }
    }

    public void cuentaBaneada() {
        System.out.println("Esta cuenta ha sido baneada, acceso denegado...");
    }

    public void mostrarClientes(ArrayList<String> listaClientes) {
        for (int numCliente = 0; numCliente < listaClientes.size(); numCliente++) {
            System.out.println(numCliente + 1 + ": " + listaClientes.get(numCliente));
        }
    }

    public void preguntarBan(String desafiante, String contrincante) {
        System.out.println("El desafiante " + desafiante + " ha incumplido las normas de desafio, desafiando a " + contrincante + ", ¿Desea banearle?");
        System.out.println("1:  Si");
        System.out.println("2:  No");
    }

    public ArrayList<Modificador> mostrarModificadoresDesafio(Cliente desafiante, Cliente contrincante, int i) {
        //fortalezas del desafiante y del contrincante
        ArrayList<Modificador> lista = new ArrayList<>();
        for (int j = 0; j < desafiante.getPersonaje().getFortalezas().size(); j++) {
            System.out.println(desafiante.getPersonaje().getFortalezas().get(j).getNombre());
            lista.add(desafiante.getPersonaje().getFortalezas().get(j));
        }
        for (int j = 0; j < contrincante.getPersonaje().getFortalezas().size(); j++) {
            System.out.println(contrincante.getPersonaje().getFortalezas().get(j).getNombre());
            lista.add(contrincante.getPersonaje().getFortalezas().get(j));
        }
        //debilidades del contrincante y del contrincante
        for (int j = 0; j < desafiante.getPersonaje().getDebilidades().size(); j++) {
            System.out.println(desafiante.getPersonaje().getDebilidades().get(j).getNombre());
            lista.add(desafiante.getPersonaje().getDebilidades().get(j));
        }
        for (int j = 0; j < contrincante.getPersonaje().getDebilidades().size(); j++) {
            System.out.println(contrincante.getPersonaje().getDebilidades().get(j).getNombre());
            lista.add(contrincante.getPersonaje().getDebilidades().get(j));
        }
        return  lista;
    }

    public void mostrarDon(Don don) {
        System.out.println("nombre de habilidad: " + don.getNombre());
        System.out.println("ataque de habilidad: " + don.getAtaque());
        System.out.println("defensa de habilidad: " + don.getDefensa());
        System.out.println("edad de habilidad: " + don.getValorMinimo());
    }

    public void mostrarTalento(Talento talento) {
        System.out.println("nombre de habilidad: " + talento.getNombre());
        System.out.println("ataque de habilidad: " + talento.getAtaque());
        System.out.println("defensa de habilidad: " + talento.getDefensa());
        System.out.println("edad de habilidad: " + talento.getEdad());
    }

    public void mostrarDisciplina(Disciplina disciplina) {
        System.out.println("nombre de habilidad: " + disciplina.getNombre());
        System.out.println("ataque de habilidad: " + disciplina.getAtaque());
        System.out.println("defensa de habilidad: " + disciplina.getDefensa());
        System.out.println("coste de habilidad: " + disciplina.getCoste());
    }

    public void mostrarNicks(ArrayList<Cliente> listaClientes) {
        for (Cliente listaCliente : listaClientes) {
            System.out.println(listaCliente.getNick());
        }
    }

    public void noDesafiosParaValidar() {
        System.out.println("No hay desafios a validar");
    }

    public void mostrarRonda(int numRonda) {
        System.out.println("Ronda " + numRonda + ":");
    }

    public void usoHabilidadDefensa(String nombrePersonaje, String nombreHabilidad) {
        System.out.println(nombrePersonaje + " usa " + nombreHabilidad + " para potenciar su defensa");
    }
    public void usoHabilidadAtaque(String nombrePersonaje, String nombreHabilidad) {
        System.out.println(nombrePersonaje + " usa " + nombreHabilidad + " para potenciar su ataque");
    }

    public void noHayPersonaje() {
        System.out.println("No has creado personaje");
    }

    public void noExisteUsuario() {
        System.out.println("El usuario no se ha encontrado o no existe");
    }

    public void noHayCombates() {
        System.out.println("No hay combates en tu registro");
    }
}