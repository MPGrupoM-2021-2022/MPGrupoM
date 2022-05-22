package tests;

import mp_grupo_m.Entidades.*;
import mp_grupo_m.GestorNotificaciones;
import mp_grupo_m.Terminal;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class GestorNotificacionesTest {
    GestorNotificaciones gestorNotificaciones;
    Desafio desafio;
    ArrayList<Desafio> listaDesafios;
    Cliente clienteConVampiro, clienteConLicantropo;
    Terminal terminal;

    @Before
    public void onStart(){

        terminal = new Terminal();

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

        desafio.setDesafiante(clienteConVampiro);
        desafio.setContrincante(clienteConLicantropo);
        desafio.setOro(100);
        desafio.setValidated(true);
        Date fechaHoy = new Date();
        desafio.setFecha(fechaHoy);
        desafio.setRegistro("b22bb");
        ArrayList<Modificador> modificadores = new ArrayList<>();
        modificadores.add(debilidad);
        desafio.setModificadores(modificadores);

        listaDesafios.add(desafio);
    }

    @Test
    public void testNotifyDesafio(){
        gestorNotificaciones.notifyDesafio(clienteConLicantropo, terminal, listaDesafios, 0);
        assertEquals(0, listaDesafios.size());
    }
}
