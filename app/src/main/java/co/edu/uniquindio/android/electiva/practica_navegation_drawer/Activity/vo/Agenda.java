package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo;


/**
 *
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 * La clase Agenda tiene los atributos que va a tener un número de la universidad
 */
public class Agenda {

    private String dependencia;
    private String numero;
    private String extencion;

    /**
     * Constructor de la clase Agend
     * @param dependencia dependencia a donde se va a llamar
     * @param numero numero que se va a marcar
     * @param extencion extension a la cual será dirigido
     */
    public Agenda(String dependencia, String numero, String extencion) {
        this.dependencia = dependencia;
        this.numero = numero;
        this.extencion = extencion;
    }

    /**
     * getters y setters de la clase Agenda
     */
    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getExtencion() {
        return extencion;
    }

    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }
}
