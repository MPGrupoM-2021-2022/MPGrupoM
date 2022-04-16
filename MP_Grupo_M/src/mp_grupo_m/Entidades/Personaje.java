package mp_grupo_m.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Personaje {
    private String nombre;
    private Habilidad habilidad;
    private ArrayList<Arma> armas;
    private ArrayList<Arma> armasActivas;
    private ArrayList<Armadura> armaduras;
    private Armadura armaduraActiva;
    private ArrayList<EsbirrosComposite> esbirrosComposites;
    private int oro;
    private int hp;
    private int poder;
    private ArrayList<Debilidad> debilidades;
    private ArrayList<Fortaleza> fortalezas;
    private String userNick;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void setArmas(ArrayList<Arma> armas) {
        this.armas = armas;
    }

    public ArrayList<Arma> getArmasActivas() {
        return armasActivas;
    }

    public void setArmasActivas(ArrayList<Arma> armasActivas) {
        this.armasActivas = armasActivas;
    }

    public ArrayList<Armadura> getArmaduras() {
        return armaduras;
    }

    public void setArmaduras(ArrayList<Armadura> armaduras) {
        this.armaduras = armaduras;
    }

    public Armadura getArmaduraActiva() {
        return armaduraActiva;
    }

    public void setArmaduraActiva(Armadura armaduraActiva) {
        this.armaduraActiva = armaduraActiva;
    }

    public ArrayList<EsbirrosComposite> getEsbirros() {
        return esbirrosComposites;
    }

    public void setEsbirros(ArrayList<EsbirrosComposite> esbirrosComposites) {
        this.esbirrosComposites = esbirrosComposites;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public ArrayList<Debilidad> getDebilidades() {
        return debilidades;
    }

    public void setDebilidades(ArrayList<Debilidad> debilidades) {
        this.debilidades = debilidades;
    }

    public ArrayList<Fortaleza> getFortalezas() {
        return fortalezas;
    }

    public void setFortalezas(ArrayList<Fortaleza> fortalezas) {
        this.fortalezas = fortalezas;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}
