package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.DetalleNoticiaFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.NoticiasFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo.Noticia;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;

/**
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 * Actividad que contiene el Fragmento DetalleNoticiaFragment
 * por esta actividad pasamos los datos que obtenemos de la lista de Noticias
 **/
public class DetalleNoticiaActivity extends AppCompatActivity {

    /**
     * crea la actividad de los detalles de las noticias
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_noticia);

        //muestra el fragmento
        DetalleNoticiaFragment detalleDeNoticia = (DetalleNoticiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_pelicula);
        Noticia noticia = (Noticia) getIntent().getExtras().getParcelable("noticia");
        // muestra el detalle completo de la noticia
        detalleDeNoticia.showDetail(noticia);
    }

}
