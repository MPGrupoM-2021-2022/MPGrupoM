package tests.EntityTests;

import mp_grupo_m.Entidades.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DesafioTest {
    Cliente cliente;
    Desafio desafio;

    @Before
    public void onStart(){
        //Cliente con vampiro
        cliente.setNombre("NombreCCV");
        cliente.setNick("NickCCV");
        cliente.setRegistro("a11ab");
        cliente.setPassword("PassCCV");
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
        cliente.setPersonaje(vampiro);
    }

    @Test
    public void testCrearDesafio(){
        desafio.crearDesafio(cliente);
        assertNotNull(desafio);
    }
}
