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

    public boolean iniciarRonda(int hpDesafiante, int hpContrincante, Cliente desafiante, Cliente contrincante, ArrayList<Modificador> modificadores) { //falta aplicar fortlezas y debilidades
        Terminal terminal = new Terminal();

        int ataqueEquipoDesafiante = 0;
        int ataqueEquipoContrincante = 0;

        for (int i = 0; i < desafiante.getPersonaje().getArmasActivas().size(); i++){
            ataqueEquipoDesafiante += desafiante.getPersonaje().getArmasActivas().get(i).getModAtaque();
        }
        ataqueEquipoDesafiante += desafiante.getPersonaje().getArmaduraActiva().getModAtaque();
        for (int i = 0; i < contrincante.getPersonaje().getArmasActivas().size(); i++){
            ataqueEquipoContrincante += contrincante.getPersonaje().getArmasActivas().get(i).getModAtaque();
        }
        ataqueEquipoContrincante += contrincante.getPersonaje().getArmaduraActiva().getModAtaque();

        int potencialAtaqueDesafiante = desafiante.getPersonaje().getPoder() + desafiante.getPersonaje().getHabilidad().getAtaque() + ataqueEquipoDesafiante;
        int potencialAtaqueContrincante = contrincante.getPersonaje().getPoder() + contrincante.getPersonaje().getHabilidad().getAtaque() + ataqueEquipoContrincante;

        if (desafiante.getPersonaje().getTipo().equals("VAMPIRO")){
            Vampiro vampiro = (Vampiro) desafiante.getPersonaje();
            Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
            if (vampiro.getSangre() >= 5 && vampiro.getSangre() >= disciplina.getCoste()){
                potencialAtaqueDesafiante += 2;
                vampiro.setSangre(vampiro.getSangre() - disciplina.getCoste());
            }
        } else if (desafiante.getPersonaje().getTipo().equals("LICANTROPO")){
            Licantropo licantropo = (Licantropo) desafiante.getPersonaje();
            Don don = (Don) licantropo.getHabilidad();
            if (don.getValorMinimo() <= licantropo.getRabia()){
                potencialAtaqueDesafiante += licantropo.getRabia();
            }
        } else {
            Cazador cazador = (Cazador) desafiante.getPersonaje();
            Talento talento = (Talento) cazador.getHabilidad();
            potencialAtaqueDesafiante += talento.getAtaque();
        }

        if (contrincante.getPersonaje().getTipo().equals("VAMPIRO")){
            Vampiro vampiro = (Vampiro) contrincante.getPersonaje();
            Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
            if (vampiro.getSangre() >= 5 && vampiro.getSangre() >= disciplina.getCoste()){
                potencialAtaqueContrincante += 2;
                vampiro.setSangre(vampiro.getSangre() - disciplina.getCoste());
            }
        } else if (contrincante.getPersonaje().getTipo().equals("LICANTROPO")){
            Licantropo licantropo = (Licantropo) contrincante.getPersonaje();
            Don don = (Don) licantropo.getHabilidad();
            if (don.getValorMinimo() <= licantropo.getRabia()){
                potencialAtaqueContrincante += licantropo.getRabia();
            }
        } else {
            Cazador cazador = (Cazador) contrincante.getPersonaje();
            Talento talento = (Talento) cazador.getHabilidad();
            potencialAtaqueContrincante += talento.getAtaque();
        }

        int defensaEquipoDesafiante = 0;
        int defensaEquipoContrincante = 0;

        for (int i = 0; i < desafiante.getPersonaje().getArmasActivas().size(); i++){
            defensaEquipoDesafiante += desafiante.getPersonaje().getArmasActivas().get(i).getModDefensa();
        }
        defensaEquipoDesafiante += desafiante.getPersonaje().getArmaduraActiva().getModDefensa();
        for (int i = 0; i < contrincante.getPersonaje().getArmasActivas().size(); i++){
            defensaEquipoContrincante += contrincante.getPersonaje().getArmasActivas().get(i).getModDefensa();
        }
        defensaEquipoContrincante += contrincante.getPersonaje().getArmaduraActiva().getModDefensa();

        int potencialDefensaDesafiante = desafiante.getPersonaje().getPoder() + desafiante.getPersonaje().getHabilidad().getDefensa() + defensaEquipoDesafiante;
        int potencialDefensaContrincante = contrincante.getPersonaje().getPoder() + contrincante.getPersonaje().getHabilidad().getDefensa() + defensaEquipoContrincante;

        if (desafiante.getPersonaje().getTipo().equals("VAMPIRO")){
            Vampiro vampiro = (Vampiro) desafiante.getPersonaje();
            Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
            if (vampiro.getSangre() >= 5 && vampiro.getSangre() >= disciplina.getCoste()){
                potencialDefensaDesafiante += 2;
                vampiro.setSangre(vampiro.getSangre() - disciplina.getCoste());
            }
        } else if (desafiante.getPersonaje().getTipo().equals("LICANTROPO")){
            Licantropo licantropo = (Licantropo) desafiante.getPersonaje();
            Don don = (Don) licantropo.getHabilidad();
            if (don.getValorMinimo() <= licantropo.getRabia()){
                potencialDefensaDesafiante += licantropo.getRabia();
            }
        } else {
            Cazador cazador = (Cazador) desafiante.getPersonaje();
            Talento talento = (Talento) cazador.getHabilidad();
            potencialDefensaDesafiante += talento.getDefensa();
        }

        if (contrincante.getPersonaje().getTipo().equals("VAMPIRO")){
            Vampiro vampiro = (Vampiro) contrincante.getPersonaje();
            Disciplina disciplina = (Disciplina) vampiro.getHabilidad();
            if (vampiro.getSangre() >= 5 && vampiro.getSangre() >= disciplina.getCoste()){
                potencialDefensaContrincante += 2;
                vampiro.setSangre(vampiro.getSangre() - disciplina.getCoste());
            }
        } else if (contrincante.getPersonaje().getTipo().equals("LICANTROPO")){
            Licantropo licantropo = (Licantropo) contrincante.getPersonaje();
            Don don = (Don) licantropo.getHabilidad();
            if (don.getValorMinimo() <= licantropo.getRabia()){
                potencialDefensaContrincante += licantropo.getRabia();
            }
        } else {
            Cazador cazador = (Cazador) contrincante.getPersonaje();
            Talento talento = (Talento) cazador.getHabilidad();
            potencialDefensaContrincante += talento.getDefensa();
        }

        int valorModsDesafiante = 0;
        int valorModsContrincante = 0;

        for (int i = 0; i < desafiante.getPersonaje().getDebilidades().size(); i++){
            for (int j = 0; j < modificadores.size(); j++) {
                if (desafiante.getPersonaje().getDebilidades().get(i).getNombre().equals(modificadores.get(j).getNombre())){
                    valorModsDesafiante -= desafiante.getPersonaje().getDebilidades().get(i).getValor();
                }
            }
        }

        for (int i = 0; i < desafiante.getPersonaje().getFortalezas().size(); i++){
            for (int j = 0; j < modificadores.size(); j++) {
                if (desafiante.getPersonaje().getFortalezas().get(i).getNombre().equals(modificadores.get(j).getNombre())){
                    valorModsDesafiante += desafiante.getPersonaje().getFortalezas().get(i).getValor();
                }
            }
        }

        for (int i = 0; i < contrincante.getPersonaje().getDebilidades().size(); i++){
            for (int j = 0; j < modificadores.size(); j++) {
                if (contrincante.getPersonaje().getDebilidades().get(i).getNombre().equals(modificadores.get(j).getNombre())){
                    valorModsContrincante -= contrincante.getPersonaje().getDebilidades().get(i).getValor();
                }
            }
        }

        for (int i = 0; i < contrincante.getPersonaje().getFortalezas().size(); i++){
            for (int j = 0; j < modificadores.size(); j++) {
                if (contrincante.getPersonaje().getFortalezas().get(i).getNombre().equals(modificadores.get(j).getNombre())){
                    valorModsContrincante += contrincante.getPersonaje().getFortalezas().get(i).getValor();
                }
            }
        }

        if (valorModsDesafiante >= 0){
            potencialAtaqueDesafiante += valorModsDesafiante;
            potencialDefensaDesafiante += valorModsDesafiante;
        } else {
            potencialAtaqueDesafiante -= valorModsDesafiante;
            potencialDefensaDesafiante -= valorModsDesafiante;
        }

        if (valorModsContrincante >= 0){
            potencialAtaqueContrincante += valorModsContrincante;
            potencialDefensaContrincante += valorModsContrincante;
        } else {
            potencialAtaqueContrincante -= valorModsContrincante;
            potencialDefensaContrincante -= valorModsContrincante;
        }

        terminal.inicioRonda(hpDesafiante, hpContrincante, desafiante.getNick(), contrincante.getNick(), potencialAtaqueDesafiante, potencialDefensaDesafiante, potencialAtaqueContrincante, potencialDefensaContrincante);

        int ataqueDesafiante = 0;
        for (int tirada = 1; tirada <= potencialAtaqueDesafiante; tirada++){
            double resultado = Math.random()*6 + 1;
            if (resultado >= 5){
                ataqueDesafiante += 1;
            }
        }
        int ataqueContrincante = 0;
        for (int tirada = 1; tirada <= potencialAtaqueContrincante; tirada++){
            double resultado = Math.random()*6 + 1;
            if (resultado >= 5){
                ataqueContrincante += 1;
            }
        }
        int defensaDesafiante = 0;
        for (int tirada = 1; tirada <= potencialDefensaDesafiante; tirada++){
            double resultado = Math.random()*6 + 1;
            if (resultado >= 5){
                defensaDesafiante += 1;
            }
        }
        int defensaContrincante = 0;
        for (int tirada = 1; tirada <= potencialDefensaContrincante; tirada++){
            double resultado = Math.random()*6 + 1;
            if (resultado >= 5){
                defensaContrincante += 1;
            }
        }
        if (ataqueDesafiante >= defensaContrincante){
            hpContrincante -= 1;
        }
        if (ataqueContrincante >= defensaDesafiante){
            hpDesafiante -= 1;
        }
        setHpDesafianteEnd(hpDesafiante);
        setHpContrincanteEnd(hpContrincante);
        return (getHpDesafianteEnd() == 0 || getHpContrincanteEnd() == 0);
    }
}
