package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.util.Arrays;

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
    ShareDialog shareDialog;

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
     *
     * @param noticia, la noticia que se requiere ver los detalles
     */
    public void showDetail(Noticia noticia) {
        this.noticia = noticia;
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

        boton = (Button) getView().findViewById(R.id.boton_compartir);
        boton.setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        shareDialog = new ShareDialog(getActivity());
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * onClick del Fragmento donde compartimos en red social facebook
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boton_compartir:

                CallbackManager callbackManager = CallbackManager.Factory.create();
                final ShareDialog shareDialog = new ShareDialog(this);






                if (shareDialog.canShow(ShareLinkContent.class)) {

                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                            .setContentTitle(this.titulo.getText().toString())
                            .setContentDescription(this.noticia.getDescripcion().toString())
                            .setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=de.ginkoboy.flashcards"))

                                    //.setImageUrl(Uri.parse("android.resource://de.ginkoboy.flashcards/" + R.drawable.logo_flashcards_pro))
                            .setImageUrl(Uri.parse("http://www.afacom.org/images/uniquindio.jpeg"))
                            .build();

                    shareDialog.show(linkContent);
                }
        }
    }

}