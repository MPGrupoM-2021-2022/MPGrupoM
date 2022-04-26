package mp_grupo_m.Entidades;

public class Humano extends EsbirrosComposite {
    private Lealtad lealtad;

    public enum Lealtad{
        ALTA, MEDIA, BAJA
    }

    public Lealtad getLealtad() {
        return lealtad;
    }

    public void setLealtad(Lealtad lealtad) {
        this.lealtad = lealtad;
    }
}
