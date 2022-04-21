package mp_grupo_m.Entidades;

import mp_grupo_m.GestorNotificaciones;
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
    private String registro;

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

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void crearDesafio(ArrayList<Cliente> listaClientes, Cliente cliente, Sistema sistema) {
        Terminal terminal = new Terminal();
        terminal.bienvenidaDesafio();
        int numContrincante = -1;
        int cantidadOro = -1;
        if (listaClientes.size() == 1) {
            terminal.noHayContrincantes();
        } else {
            terminal.mostrarPosiblesContrincantes(listaClientes);
            do {
                terminal.numValido();
                numContrincante = askNum();
            } while (numContrincante < 0 || numContrincante > listaClientes.size() + 1 || listaClientes.get(numContrincante).getPersonaje() == null);
            setContrincante(listaClientes.get(numContrincante - 1));
            terminal.preguntarCantidadApostar();
            do {
                terminal.numValido();
                cantidadOro = askNum();
            } while (cantidadOro <= 0 && cantidadOro > cliente.getPersonaje().getOro());
            setOro(cantidadOro);
            cliente.getPersonaje().setOro(cliente.getPersonaje().getOro() - cantidadOro);
            setDesafiante(cliente);
            setValidated(false);
            String registro = generarNumerRegistro();
            setRegistro(registro);
            terminal.desafioCreado();
            GestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
            gestorNotificaciones.subscribeDesafio(this);
        }
    }

    private int askNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public String generarNumerRegistro() {
        boolean valido = false;
        Desafio desafio = new Desafio();
        ArrayList<Desafio> listaDesafios = new ArrayList<>();
        listaDesafios.add(desafio);
        String strBuilder = null;
        //crear del fichero lista de desafios para coger sus registros y comparar
        while (!valido) {
            strBuilder = String.valueOf(getLetra()) +
                    getNumber() +
                    getNumber() +
                    getLetra() +
                    getLetra();
            for (Desafio value : listaDesafios) {
                if (!(value.getRegistro().equals(strBuilder))) {
                    valido = true;
                } else {
                    strBuilder = null;
                }
            }
        }
        return strBuilder;
    }

    public char getLetra() {
        return (char) (Math.random() * 26 + 'a');
    }

    public char getNumber() {
        int N = (int) (Math.random() * 10 + '0');
        return (char) N;
    }
}
