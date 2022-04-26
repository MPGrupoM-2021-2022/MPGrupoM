package mp_grupo_m.Entidades;

import java.util.ArrayList;


public class Demonio extends EsbirrosComposite {
    private String descripcion;
    private ArrayList<EsbirrosComposite> esbirrosComposites;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<EsbirrosComposite> getEsbirrosComposites() {
        return esbirrosComposites;
    }

    public void setEsbirrosComposites(ArrayList<EsbirrosComposite> esbirrosComposites) {
        this.esbirrosComposites = esbirrosComposites;
    }
}
