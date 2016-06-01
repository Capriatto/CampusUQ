package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util.Utilidades;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;

/**
 *
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 *
 * Fragmento que contiene  el layout que contiene la imagen de la universidad
 */
public class HomeFragment extends Fragment implements NoticiasFragment.OnNoticiaSeleccionadaListener{
    @Override
    public void onNoticiaSeleccionada(int position) {

    }

    /**
     * constructor del fragmento HomeFragment
     */
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Este método infla el fragmento que vamos a utilizar
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
