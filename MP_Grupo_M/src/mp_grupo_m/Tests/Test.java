package mp_grupo_m.Tests;

import junit.framework.TestCase
import mp_grupo_m.Entidades.Cliente;
import mp_grupo_m.Entidades.Combate;
import mp_grupo_m.Entidades.Personaje;
import mp_grupo_m.Ficheros.LecturaFicheroCombate;
import mp_grupo_m.Ficheros.LecturaFicheroOperadores;
import mp_grupo_m.Ficheros.LecturaFicheroUsuarios;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



public class Test {

    public class TestSuma extends TestCase {

        //Comprobar clientes exixtentes
        @Test
        public void testComprobarClientes() {
            LecturaFicheroUsuarios lecturaFicheroOperadores = new LecturaFicheroUsuarios();
            List<Cliente> listaClientes = lecturaFicheroOperadores.lecturaFicheroUsuarios();
            int count = 0;
            for (int i = 0; i < listaClientes.size(); i++){
                count++;
            }
            return listaClientes;
        }

        @Test
        public void testComprobarCombates() {
            LecturaFicheroCombate lecturaFicheroCombate = new LecturaFicheroCombate();
            List<Combate> listaCombates = lecturaFicheroCombate.lecturaFicheroCombate();
            int count = 0;
            for (int i = 0; i < listaCombates.size(); i++){
                count++;
            }
            return listaCombates;
        }


        assertNull(Cliente);
        assertNull(combates);
    }
}
