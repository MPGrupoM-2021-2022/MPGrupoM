package tests.FactoryTests;

import mp_grupo_m.Entidades.*;
import mp_grupo_m.Factorias.FactoriaLicantropos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class FactoriaLicantroposTest {

    FactoriaLicantropos factoriaLicantropos;
    Licantropo licantropo;
    Don don;
    Arma arma;
    Armadura armadura;
    Debilidad debilidad;
    Fortaleza fortaleza;

    @Before
    public void onStart(){
        licantropo = new Licantropo();
        don = new Don();
        arma = new Arma();
        armadura = new Armadura();
        debilidad = new Debilidad();
        fortaleza = new Fortaleza();
    }

    @Test
    public void testInicializarNombre(){
        factoriaLicantropos.inicializarNombre(licantropo);
        assertNotNull(licantropo.getNombre());
    }

    @Test
    public void testInicializarNombreHabilidad(){
        factoriaLicantropos.inicializarNombreHabilidad(don);
        assertNotNull(don.getNombre());
    }

    @Test
    public void testInicializarAtaqueHabilidad(){
        factoriaLicantropos.inicializarAtaqueHabilidad(don);
        assertNotEquals(0, don.getAtaque());
    }

    @Test
    public void testInicializarDefensaHabilidad(){
        factoriaLicantropos.inicializarDefensaHabilidad(don);
        assertNotEquals(0, don.getDefensa());
    }

    @Test
    public void testInicializarValorMinimoHabilidad(){
        factoriaLicantropos.inicializarRabiaHabilidad(don);
        assertNotEquals(0, don.getValorMinimo());
    }

    @Test
    public void testInicializarNombreArma(){
        factoriaLicantropos.inicializarnNombreArma(arma);
        assertNotNull(arma.getNombre());
    }

    @Test
    public void testInicializarAtaqueArma(){
        factoriaLicantropos.inicializarAtaqueArma(arma);
        assertNotEquals(0, arma.getModAtaque());
    }

    @Test
    public void testInicializarNombreArmadura(){
        factoriaLicantropos.inicializarNombreArmadura(armadura);
        assertNotNull(armadura.getNombre());
    }

    @Test
    public void testInicializarAtaqueArmadura(){
        factoriaLicantropos.inicializarDefensaArmadura(armadura);
        assertNotEquals(0, armadura.getModDefensa());
    }

    @Test
    public void testInicializarPoder(){
        factoriaLicantropos.inicializarPoder(licantropo);
        assertNotEquals(0, licantropo.getPoder());
    }

    @Test
    public void testInicializarNombreDebilidad(){
        factoriaLicantropos.inicializarNombreDebilidad(debilidad);
        assertNotNull(debilidad.getNombre());
    }

    @Test
    public void testInicializarNombreFortaleza(){
        factoriaLicantropos.inicializarNombreFortaleza(fortaleza);
        assertNotNull(fortaleza.getNombre());
    }
}
