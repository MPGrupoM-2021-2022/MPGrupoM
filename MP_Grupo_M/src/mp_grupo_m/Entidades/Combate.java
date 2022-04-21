package mp_grupo_m.Entidades;

import mp_grupo_m.Terminal;

import java.util.ArrayList;
import java.util.Date;

public class Combate {
    private Cliente desafiante;
    private Cliente contrincante;
    private ArrayList<Ronda> rondas;
    private Date fecha;
    private Cliente vencedor;
    private boolean esbirrosDesafiante;
    private boolean esbirrosContrincante;
    private int oro;
    private ArrayList<Modificador> modificadores;
    private String registro;
    private boolean visto;

    public Cliente getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Cliente desafiante) {
        this.desafiante = desafiante;
    }

    public Cliente getContrincante() {
        return contrincante;
    }

    public void setContrincante(Cliente contrincante) {
        this.contrincante = contrincante;
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(ArrayList<Ronda> rondas) {
        this.rondas = rondas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getVencedor() {
        return vencedor;
    }

    public void setVencedor(Cliente vencedor) {
        this.vencedor = vencedor;
    }

    public boolean isEsbirrosDesafiante() {
        return esbirrosDesafiante;
    }

    public void setEsbirrosDesafiante(boolean esbirrosDesafiante) {
        this.esbirrosDesafiante = esbirrosDesafiante;
    }

    public boolean isEsbirrosContrincante() {
        return esbirrosContrincante;
    }

    public void setEsbirrosContrincante(boolean esbirrosContrincante) {
        this.esbirrosContrincante = esbirrosContrincante;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public ArrayList<Modificador> getModificadores() {
        return modificadores;
    }

    public void setModificadores(ArrayList<Modificador> modificadores) {
        this.modificadores = modificadores;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public Combate inicializarCombate(Cliente desafiante, Cliente contrincante, int oro, ArrayList<Modificador> modificadores, String registro){
        setDesafiante(desafiante);
        setContrincante(contrincante);
        Date fechaHoy = new Date();
        setFecha(fechaHoy);
        setOro(oro);
        setModificadores(modificadores);
        setRegistro(registro);
        setVisto(false);
        return this;
    }

    public Combate empezarCombate(Combate combate){
        int hpDesafiante = combate.getDesafiante().getPersonaje().getHp();
        int hpContrincante = combate.getContrincante().getPersonaje().getHp();
        hpDesafiante = setearHPinicial(combate.getDesafiante().getPersonaje(), hpDesafiante);
        hpContrincante = setearHPinicial(combate.getDesafiante().getPersonaje(), hpContrincante);
        boolean finCombate = false;
        ArrayList<Ronda> rondas = new ArrayList<>();
        while (!finCombate){
            Ronda ronda = new Ronda();
            finCombate = ronda.iniciarRonda(hpDesafiante, hpContrincante, combate.getDesafiante(), combate.getContrincante(), combate.getModificadores());
            hpDesafiante = ronda.getHpDesafianteEnd();
            hpContrincante = ronda.getHpContrincanteEnd();
            rondas.add(ronda);
        }
        combate.setRondas(rondas);
        if (rondas.get(rondas.size() - 1).getHpDesafianteEnd() > 0){
            combate.setVencedor(combate.getDesafiante());
            if (rondas.get(rondas.size() - 1).getHpDesafianteEnd() > combate.getDesafiante().getPersonaje().getHp()){
                combate.setEsbirrosDesafiante(true);
            } else{
                combate.setEsbirrosDesafiante(false);
            }
        } else if (rondas.get(rondas.size() - 1).getHpContrincanteEnd() > 0) {
            combate.setVencedor(combate.getContrincante());
            if (rondas.get(rondas.size() - 1).getHpContrincanteEnd() > combate.getContrincante().getPersonaje().getHp()) {
                combate.setEsbirrosContrincante(true);
            } else{
                combate.setEsbirrosDesafiante(false);
            }
        }
        Terminal terminal = new Terminal();
        terminal.mostrarRondas(combate);
        return combate;
    }

    private int setearHPinicial(Personaje personaje, int hp) {
        for (int i = 0; i < personaje.getEsbirros().size(); i++){
            if (personaje.getEsbirros().get(i).getTipo().equals("Demonio")){
                hp += personaje.getEsbirros().get(i).getHp();
                hp += anadirHPesbirros((Demonio) personaje.getEsbirros().get(i), hp);
            } else {
                hp += personaje.getEsbirros().get(i).getHp();
            }
        }
        return hp;
    }

    private int anadirHPesbirros(Demonio demonio, int hp) {
        for (int i = 0; i < demonio.getEsbirrosComposites().size(); i++){
            if (demonio.getEsbirrosComposites().get(i).getTipo().equals("Demonio")){
                hp += demonio.getEsbirrosComposites().get(i).getHp();
                hp += anadirHPesbirros((Demonio) demonio.getEsbirrosComposites().get(i), hp);
            } else {
                hp += demonio.getEsbirrosComposites().get(i).getHp();
            }
        }
        return hp;
    }
}
