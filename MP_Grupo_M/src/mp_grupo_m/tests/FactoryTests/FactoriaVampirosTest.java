package tests.FactoryTests;

import mp_grupo_m.Entidades.*;
import mp_grupo_m.Factorias.FactoriaVampiros;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoriaVampirosTest {
    FactoriaVampiros factoriaVampiros;
    Vampiro vampiro;
    Disciplina disciplina;
    Arma arma;
    Armadura armadura;
    Debilidad debilidad;
    Fortaleza fortaleza;

    @Before
    public void onStart(){
        vampiro = new Vampiro();
        disciplina = new Disciplina();
        arma = new Arma();
        armadura = new Armadura();
        debilidad = new Debilidad();
        fortaleza = new Fortaleza();
    }

    @Test
    public void testInicializarNombre(){
        factoriaVampiros.inicializarNombre(vampiro);
        assertNotNull(vampiro.getNombre());
    }

    @Test
    public void testInicializarNombreHabilidad(){
        factoriaVampiros.inicializarNombreHabilidad(disciplina);
        assertNotNull(disciplina.getNombre());
    }

    @Test
    public void testInicializarAtaqueHabilidad(){
        factoriaVampiros.inicializarAtaqueHabilidad(disciplina);
        assertNotEquals(0, disciplina.getAtaque());
    }

    @Test
    public void testInicializarDefensaHabilidad(){
        factoriaVampiros.inicializarDefensaHabilidad(disciplina);
        assertNotEquals(0, disciplina.getDefensa());
    }

    @Test
    public void testInicializarCosteHabilidad(){
        factoriaVampiros.inicializarCosteHabilidad(disciplina);
        assertNotEquals(0, disciplina.getCoste());
    }

    @Test
    public void testInicializarNombreArma(){
        factoriaVampiros.inicializarnNombreArma(arma);
        assertNotNull(arma.getNombre());
    }

    @Test
    public void testInicializarAtaqueArma(){
        factoriaVampiros.inicializarAtaqueArma(arma);
        assertNotEquals(0, arma.getModAtaque());
    }

    @Test
    public void testInicializarNombreArmadura(){
        factoriaVampiros.inicializarnNombreArmadura(armadura);
        assertNotNull(armadura.getNombre());
    }

    @Test
    public void testInicializarAtaqueArmadura(){
        factoriaVampiros.inicializarDefensaArmadura(armadura);
        assertNotEquals(0, armadura.getModDefensa());
    }

    @Test
    public void testInicializarPoder(){
        factoriaVampiros.inicializarPoder(vampiro);
        assertNotEquals(0, vampiro.getPoder());
    }

    @Test
    public void testInicializarNombreDebilidad(){
        factoriaVampiros.inicializarNombreDebilidad(debilidad);
        assertNotNull(debilidad.getNombre());
    }

    @Test
    public void testInicializarNombreFortaleza(){
        factoriaVampiros.inicializarNombreFortaleza(fortaleza);
        assertNotNull(fortaleza.getNombre());
    }

}
