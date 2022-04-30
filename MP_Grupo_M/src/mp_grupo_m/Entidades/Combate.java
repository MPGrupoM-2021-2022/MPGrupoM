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

    public Combate inicializarCombate(Cliente desafiante, Cliente contrincante, int oro, ArrayList<Modificador> modificadores, String registro) {
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

    public Combate empezarCombate(Combate combate) {
        int hpDesafiante = combate.getDesafiante().getPersonaje().getHp();
        int hpContrincante = combate.getContrincante().getPersonaje().getHp();
        hpDesafiante = setearHPinicial(combate.getDesafiante().getPersonaje(), hpDesafiante);
        hpContrincante = setearHPinicial(combate.getContrincante().getPersonaje(), hpContrincante);
        boolean finCombate = false;
        ArrayList<Ronda> rondas = new ArrayList<>();
        Terminal terminal = new Terminal();
        int numRonda = 1;
        while (!finCombate) {
            Ronda ronda = new Ronda();
            terminal.mostrarRonda(numRonda);
            finCombate = ronda.iniciarRonda(hpDesafiante, hpContrincante, combate.getDesafiante(), combate.getContrincante(), combate.getModificadores());
            hpDesafiante = ronda.getHpDesafianteEnd();
            hpContrincante = ronda.getHpContrincanteEnd();
            rondas.add(ronda);
            numRonda++;
        }
        combate.setRondas(rondas);
        if (rondas.get(rondas.size() - 1).getHpDesafianteEnd() > 0) {
            combate.setVencedor(combate.getDesafiante());
            combate.setEsbirrosDesafiante(rondas.get(rondas.size() - 1).getHpDesafianteEnd() > combate.getDesafiante().getPersonaje().getHp());
        } else if (rondas.get(rondas.size() - 1).getHpContrincanteEnd() > 0) {
            combate.setVencedor(combate.getContrincante());
            if (rondas.get(rondas.size() - 1).getHpContrincanteEnd() > combate.getContrincante().getPersonaje().getHp()) {
                combate.setEsbirrosContrincante(true);
            } else {
                combate.setEsbirrosDesafiante(false);
            }
        } else {
            combate.setVencedor(null);
        }
        terminal.mostrarRondas(combate);
        return combate;
    }

    private int setearHPinicial(Personaje personaje, int hp) {
        for (int numEsbirro = 0; numEsbirro < personaje.getEsbirros().size(); numEsbirro++) {
            if (personaje.getEsbirros().get(numEsbirro).getTipo().equals("DEMONIO")) {
                hp += personaje.getEsbirros().get(numEsbirro).getHp();
                hp += anadirHPesbirros((Demonio) personaje.getEsbirros().get(numEsbirro), hp);
            } else {
                hp += personaje.getEsbirros().get(numEsbirro).getHp();
            }
        }
        return hp;
    }

    private int anadirHPesbirros(Demonio demonio, int hp) {
        for (int numEsbirro = 0; numEsbirro < demonio.getEsbirrosComposites().size(); numEsbirro++) {
            if (demonio.getEsbirrosComposites().get(numEsbirro).getTipo().equals("DEMONIO")) {
                hp += demonio.getEsbirrosComposites().get(numEsbirro).getHp();
                hp += anadirHPesbirros((Demonio) demonio.getEsbirrosComposites().get(numEsbirro), hp);
            } else {
                hp += demonio.getEsbirrosComposites().get(numEsbirro).getHp();
            }
        }
        return hp;
    }
}
