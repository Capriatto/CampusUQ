package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util.Utilidades;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;

/**
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 * DialogoInternetFragment me muestra si hay o no una conexión a internet
 * mediante un estado
 */
public class DialogoInternetFragment extends DialogFragment {
    TextView estado;
    Button aceptar;

    public DialogoInternetFragment() {
    }

    /**
     *Infla el layout fragment_dialogo_internet y me toma el estado actual de la conexión
     * mediante el llamado  comprobarConexionInternet que se encuentra en la clase Utilidades
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialogo_internet, container, false);
        estado = (TextView) view.findViewById(R.id.txtEstado);
        aceptar = (Button) view.findViewById(R.id.btnAceptar);
        getDialog().setTitle(R.string.internet);
        //Obtener el tipo de conexión
        int i = Utilidades.comprobarConexionInternet(0, getActivity());
        //conprobación de la conexión
        if (i == -1)
            estado.setText(R.string.negativo);
        else
            estado.setText(R.string.afirmativo);
        //dejar de mostrar el estado de la conexión
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return view;
    }


}
