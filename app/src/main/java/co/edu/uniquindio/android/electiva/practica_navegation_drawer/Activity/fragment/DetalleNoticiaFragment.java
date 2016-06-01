package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo.Noticia;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;

/**
 *
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 *
 * Fragmento que contiene  el layout que contiene el detalle de la universidad
 * aquí se accede cuando se da click en una de las noticias
 *
 */
public class DetalleNoticiaFragment extends Fragment implements View.OnClickListener {
    private Noticia noticia;
    private TextView titulo;
    private ImageView imagen;
    private TextView descripcion;
    private Button boton;

    /**
     * Constructor del Fragmento DetalleNoticiaFragment
     */
    public DetalleNoticiaFragment() {
        // Required empty public constructor
    }

    /**
     * Este método infla el fragmento que vamos a utilizar
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle_noticia, container, false);
    }

    /**
     * Metodo que nos permite ver los detalles de la noticia
     * @param noticia, la noticia que se requiere ver los detalles
     */
    public void showDetail(Noticia noticia) {
        this.noticia= noticia;
        //toma el titulo de detalle de la noticia
        titulo = (TextView) getView().findViewById(R.id.titulo);
        //muesta el titulo obtenido
        titulo.setText(noticia.getTitulo());
        //toma la descripción de detalle de la noticia
        descripcion = (TextView) getView().findViewById(R.id.descripcion);
        //muesta la descripción obtenida
        descripcion.setText(noticia.getDescripcion());
        //toma la imagen de detalle de la noticia
        imagen = (ImageView) getView().findViewById(R.id.imagen);
        //muesta la imagen obtenida
        imagen.setImageResource(noticia.getImagen());
        boton = (Button) getView().findViewById(R.id.boton);
        boton.setOnClickListener(this);
    }

    /**
     *onClick del Fragmento
     */
    @Override
    public void onClick(View v) {
    }
}
