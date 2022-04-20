package mp_grupo_m;

import java.io.IOException;

public class MP_Grupo_M {

    public static void main(String[] args) throws IOException {
        Terminal terminal = new Terminal();
        Sistema sistema = new Sistema();
        while (true) {
            terminal.mostrarInicio();
            sistema.selector();
        }
    }
}

