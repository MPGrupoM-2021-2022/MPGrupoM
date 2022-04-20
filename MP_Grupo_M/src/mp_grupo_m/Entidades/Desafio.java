package mp_grupo_m.Entidades;

import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

import java.util.ArrayList;
import java.util.Scanner;

public class Desafio {

    private Cliente desafiante;
    private Cliente contrincante;
    private int oro;
    private ArrayList<Modificador> modificadores;
    private boolean validated;

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

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public void crearDesafio(ArrayList<Cliente> listaClientes, Cliente cliente, Sistema sistema) {
        Terminal terminal = new Terminal();
        terminal.bienvenidaDesafio();
        int numContrincante = -1;
        int cantidadOro = -1;
        if (listaClientes.size() == 1){         //Habría que indicar tambien que tienen que tener un personaje creado de alguna manera
            terminal.noHayContrincantes();
        } else{
            terminal.mostrarPosiblesContrincantes(listaClientes);
            do {
                terminal.numValido();
                numContrincante = askNum();
            } while(numContrincante < 0 || numContrincante > listaClientes.size() + 1 || listaClientes.get(numContrincante).getPersonaje() == null);
            setContrincante(listaClientes.get(numContrincante - 1));
            terminal.preguntarCantidadApostar();
            do {
                terminal.numValido();
                cantidadOro = askNum();
            } while(cantidadOro <= 0 && cantidadOro > cliente.getPersonaje().getOro());
            setOro(cantidadOro);
            cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() - cantidadOro);
            setDesafiante(cliente);
            setValidated(false);
            terminal.desafioCreado();
            sistema.avisarAdmin(this);
        }
    }

    private int askNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
