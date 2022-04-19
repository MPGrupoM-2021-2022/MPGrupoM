package mp_grupo_m.Entidades;

import mp_grupo_m.Terminal;

import java.util.ArrayList;
import java.util.Scanner;

public class EsbirrosComposite {
    private String nombre;
    private int hp;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public EsbirrosComposite crearEsbirro(boolean isVampiro) {
        Terminal terminal = new Terminal();
        terminal.preguntarTipoEsbirro();
        EsbirrosComposite esbirro = selectorEsbirro(isVampiro);
        return esbirro;
    }

    private EsbirrosComposite selectorEsbirro(boolean isVampiro) {

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        Terminal terminal = new Terminal();
        switch (opcion) {
            case 1: {
                if (!isVampiro) {
                    Humano humano = crearHumano();
                    return humano;
                } else {
                    terminal.errorHumano();
                    crearEsbirro(true);
                    break;
                }
            }
            case 2: {
                Ghoul ghoul = crearGhoul();
                return ghoul;
            }
            case 3: {
                ArrayList<EsbirrosComposite> esbirros = new ArrayList<>();
                Demonio demonio = crearDemonio(esbirros, isVampiro);
                return demonio;
            }
            default: {
                terminal.error();
                crearEsbirro(isVampiro);
            }
        }
        return null;
    }

    private Humano crearHumano() {
        Terminal terminal = new Terminal();
        Humano humano = new Humano();
        Scanner sc = new Scanner(System.in);
        int hp;
        int opcionLealtad;
        Humano.Lealtad lealtad;

        terminal.preguntarNombreEsbirro();
        String nombre = sc.nextLine();
        humano.setNombre(nombre);
        do {
            terminal.preguntarHP();
            hp = sc.nextInt();
        } while (hp < 1 || hp > 3);
        humano.setHp(hp);
        do {
            terminal.preguntarLealtad();
            opcionLealtad = sc.nextInt();
        } while(opcionLealtad < 1 || opcionLealtad > 3);
        if (opcionLealtad == 1){
            lealtad = Humano.Lealtad.ALTA;
        }
        else if (opcionLealtad == 2){
            lealtad = Humano.Lealtad.MEDIA;
        }
        else {
            lealtad = Humano.Lealtad.BAJA;
        }
        humano.setLealtad(lealtad);
        return humano;
    }

    private Ghoul crearGhoul() {
        Terminal terminal = new Terminal();
        Ghoul ghoul = new Ghoul();
        Scanner sc = new Scanner(System.in);
        int hp;
        int dependencia;

        terminal.preguntarNombreEsbirro();
        String nombre = sc.nextLine();
        ghoul.setNombre(nombre);
        do {
            terminal.preguntarHP();
            hp = sc.nextInt();
        } while (hp < 1 || hp > 3);
        ghoul.setHp(hp);
        do{
            terminal.preguntarDependencia();
            dependencia = sc.nextInt();
        }while(dependencia < 1 || dependencia > 5);
        ghoul.setDependencia(dependencia);
        return  ghoul;
    }

    private Demonio crearDemonio(ArrayList<EsbirrosComposite> esbirros, boolean isVampiro) {
        Terminal terminal = new Terminal();
        Demonio demonio = new Demonio();
        Scanner sc = new Scanner(System.in);
        int hp;

        terminal.preguntarNombreEsbirro();
        String nombre = sc.nextLine();
        demonio.setNombre(nombre);
        do {
            terminal.preguntarHP();
            hp = sc.nextInt();
        } while (hp < 1 || hp > 3);
        demonio.setHp(hp);
        terminal.preguntarPacto();
        Scanner sc2 = new Scanner(System.in);
        String pacto = sc2.nextLine();
        demonio.setDescripcion(pacto);
        terminal.preguntarNumEsbirros();
        int numEsbirros = askNum();
        for (int iterator = 1; iterator <= numEsbirros; iterator++) {
            EsbirrosComposite esbirro = new EsbirrosComposite();
            esbirro = esbirro.crearEsbirro(isVampiro);
            esbirros.add(esbirro);
        }
        demonio.setEsbirrosComposites(esbirros);
        return demonio;
    }

    public int askNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
