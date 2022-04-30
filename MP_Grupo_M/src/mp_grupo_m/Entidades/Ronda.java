package mp_grupo_m.Entidades;

import mp_grupo_m.Terminal;

import java.util.ArrayList;

public class Ronda {
    private int hpDesafianteEnd;
    private int hpContrincanteEnd;

    public int getHpDesafianteEnd() {
        return hpDesafianteEnd;
    }

    public void setHpDesafianteEnd(int hpDesafianteEnd) {
        this.hpDesafianteEnd = hpDesafianteEnd;
    }

    public int getHpContrincanteEnd() {
        return hpContrincanteEnd;
    }

    public void setHpContrincanteEnd(int hpContrincanteEnd) {
        this.hpContrincanteEnd = hpContrincanteEnd;
    }

    public boolean iniciarRonda(int hpDesafiante, int hpContrincante, Cliente desafiante, Cliente contrincante, ArrayList<Modificador> modificadores) {
        Terminal terminal = new Terminal();
        int ataqueEquipoDesafiante = 0;
        int ataqueEquipoContrincante = 0;
        ataqueEquipoDesafiante = getAtaqueEquipo(desafiante, ataqueEquipoDesafiante);
        ataqueEquipoContrincante = getAtaqueEquipo(contrincante, ataqueEquipoContrincante);
        int potencialAtaqueDesafiante = desafiante.getPersonaje().getPoder() + desafiante.getPersonaje().getHabilidad().getAtaque() + ataqueEquipoDesafiante;
        int potencialAtaqueContrincante = contrincante.getPersonaje().getPoder() + contrincante.getPersonaje().getHabilidad().getAtaque() + ataqueEquipoContrincante;
        potencialAtaqueDesafiante = getPotencialAtaque(desafiante, potencialAtaqueDesafiante);
        potencialAtaqueContrincante = getPotencialAtaque(contrincante, potencialAtaqueContrincante);
        int defensaEquipoDesafiante = 0;
        int defensaEquipoContrincante = 0;
        defensaEquipoDesafiante = getDefensaEquipo(desafiante, defensaEquipoDesafiante);
        defensaEquipoContrincante = getDefensaEquipo(contrincante, defensaEquipoContrincante);
        int potencialDefensaDesafiante = desafiante.getPersonaje().getPoder() + desafiante.getPersonaje().getHabilidad().getDefensa() + defensaEquipoDesafiante;
        int potencialDefensaContrincante = contrincante.getPersonaje().getPoder() + contrincante.getPersonaje().getHabilidad().getDefensa() + defensaEquipoContrincante;
        potencialDefensaDesafiante = getPotencialDefensa(desafiante, potencialDefensaDesafiante);
        potencialDefensaContrincante = getPotencialDefensa(contrincante, potencialDefensaContrincante);
        int valorModsDesafiante = 0;
        int valorModsContrincante = 0;
        valorModsDesafiante = getValorModsDesafiante(desafiante, modificadores, valorModsDesafiante);
        valorModsContrincante = getValorModsDesafiante(contrincante, modificadores, valorModsContrincante);
        if (valorModsDesafiante >= 0) {
            potencialAtaqueDesafiante += valorModsDesafiante;
            potencialDefensaDesafiante += valorModsDesafiante;
        } else {
            potencialAtaqueDesafiante -= valorModsDesafiante;
            potencialDefensaDesafiante -= valorModsDesafiante;
        }
        if (valorModsContrincante >= 0) {
            potencialAtaqueContrincante += valorModsContrincante;
            potencialDefensaContrincante += valorModsContrincante;
        } else {
            potencialAtaqueContrincante -= valorModsContrincante;
            potencialDefensaContrincante -= valorModsContrincante;
        }
        terminal.inicioRonda(hpDesafiante, hpContrincante, desafiante.getNick(), contrincante.getNick(), potencialAtaqueDesafiante, potencialDefensaDesafiante, potencialAtaqueContrincante, potencialDefensaContrincante);
        int ataqueDesafiante = hacerTiradas(potencialAtaqueDesafiante);
        int ataqueContrincante = hacerTiradas(potencialAtaqueContrincante);
        int defensaDesafiante = hacerTiradas(potencialDefensaDesafiante);
        int defensaContrincante = hacerTiradas(potencialDefensaContrincante);
        hpContrincante = getHp(ataqueDesafiante, defensaContrincante, hpContrincante, desafiante, contrincante);
        hpDesafiante = getHp(ataqueContrincante, defensaDesafiante, hpDesafiante, contrincante, desafiante);
        setHpDesafianteEnd(hpDesafiante);
        setHpContrincanteEnd(hpContrincante);
        return (getHpDesafianteEnd() == 0 || getHpContrincanteEnd() == 0);
    }

    private int getHp(int ataqueDesafiante, int defensaContrincante, int hpContrincante, Cliente desafiante, Cliente contrincante) {
        if (ataqueDesafiante >= defensaContrincante) {
            hpContrincante -= 1;
            modificarValores(desafiante, contrincante);
        }
        return hpContrincante;
    }

    private int hacerTiradas(int potencial) {
        int resultado = 0;
        for (int tirada = 1; tirada <= potencial; tirada++) {
            double numAleatorio = Math.random() * 6 + 1;
            if (numAleatorio >= 5) {
                resultado += 1;
            }
        }
        return resultado;
    }

    private int getDefensaEquipo(Cliente cliente, int defensaEquipo) {
        for (int numArma = 0; numArma < cliente.getPersonaje().getArmasActivas().size(); numArma++) {
            defensaEquipo += cliente.getPersonaje().getArmasActivas().get(numArma).getModDefensa();
        }
        defensaEquipo += cliente.getPersonaje().getArmaduraActiva().getModDefensa();
        return defensaEquipo;
    }

    private int getAtaqueEquipo(Cliente cliente, int ataqueEquipo) {
        for (int numArma = 0; numArma < cliente.getPersonaje().getArmasActivas().size(); numArma++) {
            ataqueEquipo += cliente.getPersonaje().getArmasActivas().get(numArma).getModAtaque();
        }
        ataqueEquipo += cliente.getPersonaje().getArmaduraActiva().getModAtaque();
        return ataqueEquipo;
    }

    private void modificarValores(Cliente desafiante, Cliente contrincante) {
        if (desafiante.getPersonaje().getTipo().equals("VAMPIRO")) {
            Vampiro vampiro = (Vampiro) desafiante.getPersonaje();
            vampiro.setSangre(vampiro.getSangre() + 4);
            if (vampiro.getSangre() > 10) {
                vampiro.setSangre(10);
            }
        }
        if (contrincante.getPersonaje().getTipo().equals("LICANTROPO")) {
            Licantropo licantropo = (Licantropo) contrincante.getPersonaje();
            if (licantropo.getRabia() != 3) {
                licantropo.setRabia(licantropo.getRabia() + 1);
            }
        } else if (contrincante.getPersonaje().getTipo().equals("CAZADOR")) {
            Cazador cazador = (Cazador) contrincante.getPersonaje();
            if (cazador.getVoluntad() != 0) {
                cazador.setVoluntad(cazador.getVoluntad() - 1);
            }
        }
    }

    private int getValorModsDesafiante(Cliente cliente, ArrayList<Modificador> modificadores, int valorMods) {
        for (int numDebilidad = 0; numDebilidad < cliente.getPersonaje().getDebilidades().size(); numDebilidad++) {
            for (Modificador modificadore : modificadores) {
                if (cliente.getPersonaje().getDebilidades().get(numDebilidad).getNombre().equals(modificadore.getNombre())) {
                    valorMods -= cliente.getPersonaje().getDebilidades().get(numDebilidad).getValor();
                }
            }
        }

        for (int numFortaleza = 0; numFortaleza < cliente.getPersonaje().getFortalezas().size(); numFortaleza++) {
            for (Modificador modificadore : modificadores) {
                if (cliente.getPersonaje().getFortalezas().get(numFortaleza).getNombre().equals(modificadore.getNombre())) {
                    valorMods += cliente.getPersonaje().getFortalezas().get(numFortaleza).getValor();
                }
            }
        }
        return valorMods;
    }

    private int getPotencialDefensa(Cliente cliente, int potencialDefensa) {
        if (cliente.getPersonaje().getTipo().equals("VAMPIRO")) {
            Vampiro vampiro = (Vampiro) cliente.getPersonaje();
            Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
            Terminal terminal = new Terminal();
            if (vampiro.getSangre() >= 5 && vampiro.getSangre() >= disciplina.getCoste()) {
                terminal.usoHabilidadDefensa(vampiro.getNombre(), disciplina.getNombre());
                potencialDefensa += 2;
                vampiro.setSangre(vampiro.getSangre() - disciplina.getCoste());
            }
        } else if (cliente.getPersonaje().getTipo().equals("LICANTROPO")) {
            Licantropo licantropo = (Licantropo) cliente.getPersonaje();
            Don don = (Don) licantropo.getHabilidad();
            Terminal terminal = new Terminal();
            if (don.getValorMinimo() <= licantropo.getRabia()) {
                terminal.usoHabilidadDefensa(licantropo.getNombre(), don.getNombre());
                potencialDefensa += licantropo.getRabia();
            }
        } else {
            Terminal terminal = new Terminal();
            Cazador cazador = (Cazador) cliente.getPersonaje();
            Talento talento = (Talento) cazador.getHabilidad();
            terminal.usoHabilidadDefensa(cazador.getNombre(), talento.getNombre());
            potencialDefensa += talento.getDefensa();
        }
        return potencialDefensa;
    }

    private int getPotencialAtaque(Cliente cliente, int potencialAtaque) {
        if (cliente.getPersonaje().getTipo().equals("VAMPIRO")) {
            Vampiro vampiro = (Vampiro) cliente.getPersonaje();
            Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
            Terminal terminal = new Terminal();
            if (vampiro.getSangre() >= 5 && vampiro.getSangre() >= disciplina.getCoste()) {
                terminal.usoHabilidadAtaque(vampiro.getNombre(), disciplina.getNombre());
                potencialAtaque += 2;
                vampiro.setSangre(vampiro.getSangre() - disciplina.getCoste());
            }
        } else if (cliente.getPersonaje().getTipo().equals("LICANTROPO")) {
            Licantropo licantropo = (Licantropo) cliente.getPersonaje();
            Don don = (Don) licantropo.getHabilidad();
            Terminal terminal = new Terminal();
            if (don.getValorMinimo() <= licantropo.getRabia()) {
                terminal.usoHabilidadAtaque(licantropo.getNombre(), don.getNombre());
                potencialAtaque += licantropo.getRabia();
            }
        } else {
            Cazador cazador = (Cazador) cliente.getPersonaje();
            Talento talento = (Talento) cazador.getHabilidad();
            Terminal terminal = new Terminal();
            terminal.usoHabilidadAtaque(cazador.getNombre(), talento.getNombre());
            potencialAtaque += talento.getAtaque();
        }
        return potencialAtaque;
    }
}
