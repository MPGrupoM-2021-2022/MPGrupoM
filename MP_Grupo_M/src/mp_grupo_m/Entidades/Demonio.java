package mp_grupo_m.Entidades;

import java.util.List;

public class Demonio extends Esbirro{
    private String descripcion;
    private List<Esbirro> esbirros;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Esbirro> getEsbirros() {
        return esbirros;
    }

    public void setEsbiros(List<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }
}
