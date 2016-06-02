package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo;

/**package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo;


 /**
 *
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 * La clase Agenda tiene los atributos que va a tener un número de la universidad
 */
public class Sugerencias {

    private String id;
    private String titulo;
    private String descripcion;

    /**
     * Constructor de la clase Agend
     * @param titulo dependencia a donde se va a llamar
     * @param descripcion extension a la cual será dirigido
     */
    public Sugerencias(String id,String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id = id;
    }

    /**
     * getters y setters de la clase Sugerencias
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
