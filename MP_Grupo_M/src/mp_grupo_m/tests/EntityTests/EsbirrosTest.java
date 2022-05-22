package tests.EntityTests;

import mp_grupo_m.Entidades.EsbirrosComposite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EsbirrosTest {
    boolean isVampiro;
    EsbirrosComposite esbirros;

    @Before
    public void onStart(){
        isVampiro = false;
    }

    @Test
    public void testCrearEsbirro(){
        assertNotNull(esbirros.crearEsbirro(isVampiro));
    }
}
