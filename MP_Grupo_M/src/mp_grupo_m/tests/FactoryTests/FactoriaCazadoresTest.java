package tests.FactoryTests;

import mp_grupo_m.Entidades.*;
import mp_grupo_m.Factorias.FactoriaCazadores;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class FactoriaCazadoresTest {
    FactoriaCazadores factoriaCazadores;
    Cazador cazador;
    Talento talento;
    Arma arma;
    Armadura armadura;
    Debilidad debilidad;
    Fortaleza fortaleza;

    @Before
    public void onStart(){
        cazador = new Cazador();
        talento = new Talento();
        arma = new Arma();
        armadura = new Armadura();
        debilidad = new Debilidad();
        fortaleza = new Fortaleza();
    }

    @Test
    public void testInicializarNombre(){
        factoriaCazadores.inicializarNombre(cazador);
        assertNotNull(cazador.getNombre());
    }

    @Test
    public void testInicializarNombreHabilidad(){
        factoriaCazadores.inicializarNombreHabilidad(talento);
        assertNotNull(talento.getNombre());
    }

    @Test
    public void testInicializarAtaqueHabilidad(){
        factoriaCazadores.inicializarAtaqueHabilidad(talento);
        assertNotEquals(0, talento.getAtaque());
    }

    @Test
    public void testInicializarDefensaHabilidad(){
        factoriaCazadores.inicializarDefensaHabilidad(talento);
        assertNotEquals(0, talento.getDefensa());
    }

    @Test
    public void testInicializarNombreArma(){
        factoriaCazadores.inicializarnNombreArma(arma);
        assertNotNull(arma.getNombre());
    }

    @Test
    public void testInicializarAtaqueArma(){
        factoriaCazadores.inicializarAtaqueArma(arma);
        assertNotEquals(0, arma.getModAtaque());
    }

    @Test
    public void testInicializarNombreArmadura(){
        factoriaCazadores.inicializarnNombreArmadura(armadura);
        assertNotNull(armadura.getNombre());
    }

    @Test
    public void testInicializarAtaqueArmadura(){
        factoriaCazadores.inicializarDefensaArmadura(armadura);
        assertNotEquals(0, armadura.getModDefensa());
    }

    @Test
    public void testInicializarPoder(){
        factoriaCazadores.inicializarPoder(cazador);
        assertNotEquals(0, cazador.getPoder());
    }

    @Test
    public void testInicializarNombreDebilidad(){
        factoriaCazadores.inicializarNombreDebilidad(debilidad);
        assertNotNull(debilidad.getNombre());
    }

    @Test
    public void testInicializarNombreFortaleza(){
        factoriaCazadores.inicializarNombreFortaleza(fortaleza);
        assertNotNull(fortaleza.getNombre());
    }
}
