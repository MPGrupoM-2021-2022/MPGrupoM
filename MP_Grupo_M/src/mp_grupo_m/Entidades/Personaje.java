package mp_grupo_m.Entidades;

import java.util.List;

public class Personaje {
    private String nombre;
    private Habilidad habilidad;
    private List<Arma> armas;
    private List<Arma> armasActivas;
    private List<Armadura> armaduras;
    private Armadura armaduraActiva;
    private List<EsbirrosComposite> esbirrosComposites;
    private int oro;
    private int hp;
    private int poder;
    private List<Debilidad> debilidades;
    private List<Fortaleza> fortalezas;
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

    public List<Arma> getArmas() {
        return armas;
    }

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    public List<Arma> getArmasActivas() {
        return armasActivas;
    }

    public void setArmasActivas(List<Arma> armasActivas) {
        this.armasActivas = armasActivas;
    }

    public List<Armadura> getArmaduras() {
        return armaduras;
    }

    public void setArmaduras(List<Armadura> armaduras) {
        this.armaduras = armaduras;
    }

    public Armadura getArmaduraActiva() {
        return armaduraActiva;
    }

    public void setArmaduraActiva(Armadura armaduraActiva) {
        this.armaduraActiva = armaduraActiva;
    }

    public List<EsbirrosComposite> getEsbirros() {
        return esbirrosComposites;
    }

    public void setEsbirros(List<EsbirrosComposite> esbirrosComposites) {
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

    public List<Debilidad> getDebilidades() {
        return debilidades;
    }

    public void setDebilidades(List<Debilidad> debilidades) {
        this.debilidades = debilidades;
    }

    public List<Fortaleza> getFortalezas() {
        return fortalezas;
    }

    public void setFortalezas(List<Fortaleza> fortalezas) {
        this.fortalezas = fortalezas;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}
