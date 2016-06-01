package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util.AdaptadorDeAgenda;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo.Agenda;
/**
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 * Fragmento Agenda
 * en el se tiene el listado de números de la universidad
 *
 */
public class AgendaFragment extends Fragment implements View.OnClickListener, AdaptadorDeAgenda.OnClickAdaptadorDeAgenda{


    private RecyclerView agendaRecycler;
    private AdaptadorDeAgenda adaptador;
    private ArrayList<Agenda> Agenda;


    /**
     * Constructor del Fragmento AgendaFragment
     */
    public AgendaFragment() {
        // Required empty public constructor
    }

    /**
     * onAtivityCreated me define primeramente los números del directorio
     * y luego envía al adaptador AdaptadorDeAgenda la lista de números.
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Arraylist de los números que tiene la Agenda
        Agenda = new ArrayList();
        Agenda.add(new Agenda("Labor", "0367402383", "ext 311"));
        Agenda.add(new Agenda("GRID", "0367402383", "ext 315"));
        Agenda.add(new Agenda("CEIFI", "0367402383", "ext 319"));
        Agenda.add(new Agenda("Secretaria", "0367402383", "ext 308"));
        Agenda.add(new Agenda("Direccion", "0367402383", "ext 318"));
        Agenda.add(new Agenda("Proyecto", "0367402383", "ext 300"));
        agendaRecycler= (RecyclerView) getView().findViewById(R.id.RecView);
        //adaptador de Agenda
        adaptador = new AdaptadorDeAgenda(Agenda, this);
        agendaRecycler.setAdapter(adaptador);
        agendaRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    /**
     * infla el Fragmento AgendaFragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agenda, container, false);
    }

    /**
     * OnClick del Fragmento AgendaFragment
     */
    @Override
    public void onClick(View v) {

    }

    /**
     * onClickPosition me recibe la posición que fue clickeada y
     * hace un intent.ACTION_DIAL para poder llamar al número que fue
     * clickeado
     * @param pos
     */
    @Override
    public void onClickPosition(int pos) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0367402383"));
        startActivity(intent);

    }
}
