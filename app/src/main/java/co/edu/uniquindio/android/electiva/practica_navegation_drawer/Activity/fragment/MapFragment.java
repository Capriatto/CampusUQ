package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;

/**
 * @author:Arley Sneyder Rico B.
 * @author:Kevin Agudelo Gallego
 * @author:Juan Sebastian Ocampo
 * @version:1.0
 * Fragmento que contiene el layout que contiene el mapa de la universidad
 */

public class MapFragment extends Fragment {

    /**
     * Constructor del fragmento MapFragment
     */
    public MapFragment() {
        // Required empty public constructor
    }

    /**
     * Este método infla el fragmento que vamos a utilizar
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

}
