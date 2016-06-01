package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.AgendaFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo.Agenda;


public class AdaptadorDeAgenda extends RecyclerView.Adapter<AdaptadorDeAgenda.AgendaViewHolder> {

    private ArrayList<Agenda> Agenda;
    private static OnClickAdaptadorDeAgenda listener;


    public AdaptadorDeAgenda(ArrayList<Agenda> agenda, AgendaFragment AgendaFragment) {
        this.Agenda = agenda;

        try{
            listener = AgendaFragment;
        }
        catch (ClassCastException e){
            //
        }

    }

    @Override
    public AgendaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detalle_de_agenda, parent, false);
        AgendaViewHolder agendaVH = new AgendaViewHolder(itemView);
        return agendaVH;
    }

    @Override
    public void onBindViewHolder(AgendaViewHolder holder, int position) {
        Agenda agenda = Agenda.get(position);
        holder.binAgenda(agenda);
    }

    @Override
    public int getItemCount() {
        return Agenda.size();
    }

    public static class AgendaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtDependencia;
        private TextView numero;
        private TextView extencion;


        public AgendaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtDependencia = (TextView) itemView.findViewById(R.id.dependencia);
            numero = (TextView) itemView.findViewById(R.id.numero);
            extencion = (TextView) itemView.findViewById(R.id.extencion);

        }

        public void binAgenda(Agenda a) {
            txtDependencia.setText(a.getDependencia());
            numero.setText(a.getNumero());
            extencion.setText(a.getExtencion());
        }

        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.v("Llamada", "llame 1");
        }
    }
    public interface OnClickAdaptadorDeAgenda{
        public void onClickPosition(int pos);
    }

}
