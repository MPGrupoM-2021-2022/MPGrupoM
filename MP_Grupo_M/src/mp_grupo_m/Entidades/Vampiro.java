package mp_grupo_m.Entidades;

public class Vampiro extends Personaje{
    private int sangre;
    private int edad;
    private String nombreArma;

    public int getSangre() {
        return sangre;
    }

    public void setSangre(int sangre) {
        this.sangre = sangre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
