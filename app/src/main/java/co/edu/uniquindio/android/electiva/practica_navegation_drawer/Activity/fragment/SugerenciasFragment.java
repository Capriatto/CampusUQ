package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;


/**
 *
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 *
 * Fragmento que contiene  el layout que contiene las sugerencias que se tienen acerca de la universidad
 */
public class SugerenciasFragment extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sugerencias, container, false);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
        //Crear el "Combobox" de las sugerencias
        ArrayList<String> listaSugerencia = new ArrayList<String>();
        listaSugerencia.add(getString(R.string.Sugerenciatext3));
        listaSugerencia.add(getString(R.string.Noticias));
        listaSugerencia.add(getString(R.string.Directorio));
        listaSugerencia.add(getString(R.string.Campus));
        listaSugerencia.add(getString(R.string.ObjetosPerdidos));
        listaSugerencia.add(getString(R.string.Otros));
        //adaptador del "Combobox" dentro del layout
        ArrayAdapter<String> adaptadorcito = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listaSugerencia);
        adaptadorcito.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptadorcito);
        return rootView;
    }

}
