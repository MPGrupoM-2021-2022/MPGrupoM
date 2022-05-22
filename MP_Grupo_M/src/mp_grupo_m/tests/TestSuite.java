package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.EntityTests.ClienteTest;
import tests.EntityTests.DesafioTest;
import tests.EntityTests.EsbirrosTest;
import tests.FactoryTests.FactoriaCazadoresTest;
import tests.FactoryTests.FactoriaLicantroposTest;
import tests.FactoryTests.FactoriaVampirosTest;

@RunWith(Suite.class)
@SuiteClasses({ClienteTest.class,
        DesafioTest.class,
        EsbirrosTest.class,
        FactoriaVampirosTest.class,
        FactoriaLicantroposTest.class,
        FactoriaCazadoresTest.class,
        GestorNotificacionesTest.class})

public class TestSuite {
}
