package mp_grupo_m.Entidades;

public class Equipo {
    private String nombre;
    private int valor;
    private int modAtaque;
    private int modDefensa;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getModAtaque() {
        return modAtaque;
    }

    public void setModAtaque(int modAtaque) {
        this.modAtaque = modAtaque;
    }

    public int getModDefensa() {
        return modDefensa;
    }

    public void setModDefensa(int modDefensa) {
        this.modDefensa = modDefensa;
    }
}
