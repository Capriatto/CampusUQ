package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

/**
 *
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 * La clase noticia tiene los atributos que va a tener la noticia
 * implementamos Parcelable para que el conjunto de información pase de una actividad a otra.
 */
public class Noticia implements Parcelable {

    /**
     * Atributos de la clase Noticia
     */
    private String titulo, descripcion;
    private int imagen;


    /**
     * recibe como atributos:
     * @param titulo
     * @param descripcion
     * @param imagen
     */
    public Noticia(String titulo, String descripcion, int imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    protected Noticia(Parcel in) {
        titulo = in.readString();
        imagen = in.readInt();
        descripcion = in.readString();
    }

    /**
     * getters y setters de la clase Noticia
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    /**
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeInt(imagen);
        dest.writeString(descripcion);
    }

    public void readFromParcel(Parcel in) {
        titulo=in.readString();
        imagen=in.readInt();
        descripcion=in.readString();
    }

    public static final Creator<Noticia> CREATOR = new Creator<Noticia>() {


        /**
         * crea el parcelable
         * @param in
         * @return
         */
        @Override
        public Noticia createFromParcel(Parcel in) {
            return new Noticia(in);
        }

        /**
         * matriz de la noticia Parcelable
         * @param size
         * @return Noticias
         */
        @Override
        public Noticia[] newArray(int size) {
            return new Noticia[size];
        }
    };
}
