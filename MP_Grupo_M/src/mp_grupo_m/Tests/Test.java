package mp_grupo_m.Tests;

import junit.framework.TestCase
import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Personaje;
import mp_grupo_m.Ficheros.LecturaFicheroOperadores;
import mp_grupo_m.Ficheros.LecturaFicheroUsuarios;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



public class Test {
    @Test
    //comprobar la cantidad de personajes
    public class TestSuma extends TestCase {
        LecturaFicheroUsuarios lecturaFicheroOperadores = new LecturaFicheroUsuarios();
        List<Cliente> listaClientes = lecturaFicheroOperadores.lecturaFicheroUsuarios();
        List<String> lista = new ArrayList<>();
        count = 0;
        for (int i = 0; i<listaCliente.size, i++){
            count++;
            return count;

        }

    }
}
