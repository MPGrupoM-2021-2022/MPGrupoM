package mp_grupo_m;

public class MP_Grupo_M {

    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        Sistema sistema = new Sistema();
        while (true) {
            terminal.mostrarInicio();
            sistema.selector();
        }
    }
}

