package tests.EntityTests;

import mp_grupo_m.Entidades.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class ClienteTest {
    Cliente clienteSinPersonaje, clienteConVampiro, clienteConLicantropo, clienteConCazador, cliente;

    @Before
    public void onStart() {
        //Cliente sin personaje
        clienteSinPersonaje.setNombre("NombreCSP");
        clienteSinPersonaje.setNick("NickCSP");
        clienteSinPersonaje.setRegistro("a11aa");
        clienteSinPersonaje.setPassword("PassCSP");
        clienteSinPersonaje.setPersonaje(null);

        //Cliente con vampiro
        clienteConVampiro.setNombre("NombreCCV");
        clienteConVampiro.setNick("NickCCV");
        clienteConVampiro.setRegistro("a11ab");
        clienteConVampiro.setPassword("PassCCV");
        Vampiro vampiro = new Vampiro();
        vampiro.setSangre(0);
        vampiro.setTipo("VAMPIRO");
        vampiro.setEdad(10);
        vampiro.setPoder(5);
        vampiro.setHp(5);
        vampiro.setOro(1000);
        vampiro.setNombre("NombreVampiro");
        ArrayList<Arma> armas = new ArrayList<>();
        Arma arma1 = new Arma();
        arma1.setNombre("NombreArma1");
        arma1.setModAtaque(3);
        arma1.setModDefensa(1);
        arma1.setSingleHand(false);
        armas.add(arma1);
        vampiro.setArmas(armas);
        vampiro.setArmasActivas(armas);
        ArrayList<Armadura> armaduras = new ArrayList<>();
        Armadura armadura1 = new Armadura();
        armadura1.setNombre("NombreArmadura1");
        armadura1.setModAtaque(1);
        armadura1.setModDefensa(3);
        armaduras.add(armadura1);
        vampiro.setArmaduras(armaduras);
        vampiro.setArmaduraActiva(armadura1);
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        Fortaleza fortaleza1 = new Fortaleza();
        fortaleza1.setNombre("NombreFortaleza1");
        fortaleza1.setValor(2);
        fortalezas.add(fortaleza1);
        vampiro.setFortalezas(fortalezas);
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        Debilidad debilidad = new Debilidad();
        debilidad.setNombre("NombreDebilidad1");
        debilidad.setValor(1);
        debilidades.add(debilidad);
        vampiro.setDebilidades(debilidades);
        ArrayList<EsbirrosComposite> esbirros = new ArrayList<>();
        Ghoul ghoul = new Ghoul();
        ghoul.setNombre("NombreGhoul");
        ghoul.setTipo("GHOUL");
        ghoul.setDependencia(5);
        ghoul.setHp(3);
        esbirros.add(ghoul);
        vampiro.setEsbirros(esbirros);
        Disciplina disciplina = new Disciplina();
        disciplina.setNombre("NombreDisciplina");
        disciplina.setCoste(3);
        disciplina.setAtaque(2);
        disciplina.setDefensa(1);
        vampiro.setHabilidad(disciplina);
        clienteConVampiro.setPersonaje(vampiro);

        //Cliente con licantropo
        clienteConLicantropo.setNombre("NombreCCL");
        clienteConLicantropo.setNick("NickCCL");
        clienteConLicantropo.setRegistro("a11ac");
        clienteConLicantropo.setPassword("PassCCL");
        Licantropo licantropo = new Licantropo();
        licantropo.setTipo("LICANTROPO");
        licantropo.setPoder(5);
        licantropo.setHp(5);
        licantropo.setOro(1000);
        licantropo.setNombre("NombreLicantropo");
        licantropo.setFortalezas(fortalezas);
        licantropo.setDebilidades(debilidades);
        licantropo.setArmaduras(armaduras);
        licantropo.setArmaduraActiva(armadura1);
        licantropo.setArmas(armas);
        licantropo.setArmasActivas(armas);
        licantropo.setRabia(0);
        licantropo.setTipo("LICANTROPO");
        licantropo.setEsbirros(esbirros);
        Don don = new Don();
        don.setNombre("NombreDon");
        don.setAtaque(3);
        don.setDefensa(1);
        don.setValorMinimo(2);
        licantropo.setHabilidad(don);
        clienteConLicantropo.setPersonaje(licantropo);

        //Cliente con cazador
        clienteConLicantropo.setNombre("NombreCCL");
        clienteConLicantropo.setNick("NickCCL");
        clienteConLicantropo.setRegistro("a11ac");
        clienteConLicantropo.setPassword("PassCCL");
        Cazador cazador = new Cazador();
        cazador.setPoder(5);
        cazador.setHp(5);
        cazador.setOro(1000);
        cazador.setNombre("NombreCazador");
        cazador.setFortalezas(fortalezas);
        cazador.setDebilidades(debilidades);
        cazador.setArmaduras(armaduras);
        cazador.setArmaduraActiva(armadura1);
        cazador.setArmas(armas);
        cazador.setArmasActivas(armas);
        cazador.setTipo("CAZADOR");
        cazador.setEsbirros(esbirros);
        cazador.setVoluntad(3);
        Talento talento = new Talento();
        talento.setNombre("NombreTalento");
        talento.setAtaque(1);
        talento.setDefensa(3);
        talento.setEdad(35);
        cazador.setHabilidad(talento);
        clienteConLicantropo.setPersonaje(cazador);
    }

    @Test
    public void testCrearVampiro(){
        assertEquals("VAMPIRO", cliente.crearVampiro().getTipo());
    }

    @Test
    public void testCrearCazador(){
        assertEquals("CAZADOR", cliente.crearCazador().getTipo());
    }

    @Test
    public void testCrearLicantropo(){
        assertEquals("LICANTROPO", cliente.crearLicantropo().getTipo());
    }

    @Test
    public void testEliminarPersonaje() {
        cliente.eliminarPersonaje(clienteConVampiro);
        cliente.eliminarPersonaje(clienteConLicantropo);
        cliente.eliminarPersonaje(clienteConCazador);
        assertNull(clienteConVampiro.getPersonaje());
        assertNull(clienteConLicantropo.getPersonaje());
        assertNull(clienteConCazador.getPersonaje());
    }

    @Test
    public void testSeleccionarEquipo(){
        cliente.seleccionarEquipo(clienteConLicantropo);
        assertNotNull(clienteConLicantropo.getPersonaje().getArmasActivas());
        assertNotNull(clienteConLicantropo.getPersonaje().getArmaduraActiva());
    }

}
