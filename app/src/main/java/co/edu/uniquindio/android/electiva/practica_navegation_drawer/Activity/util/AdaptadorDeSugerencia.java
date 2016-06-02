package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.SugerenciasFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo.Sugerencias;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;


public class AdaptadorDeSugerencia extends RecyclerView.Adapter<AdaptadorDeSugerencia.SugerenciaViewHolder> {

    private ArrayList<Sugerencias> Sugerencia;
    private static OnClickAdaptadorDeSugerencia listener;


    public AdaptadorDeSugerencia(ArrayList<Sugerencias> sugerencia, SugerenciasFragment sugerenciaFragment) {
        this.Sugerencia = sugerencia;

        try{
            listener = (OnClickAdaptadorDeSugerencia) sugerenciaFragment;
        }
        catch (ClassCastException e){
            //
        }

    }

    @Override
    public SugerenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detalle_de_agenda, parent, false);
        SugerenciaViewHolder agendaVH = new SugerenciaViewHolder(itemView);
        return agendaVH;
    }

    @Override
    public void onBindViewHolder(SugerenciaViewHolder holder, int position) {
        Sugerencias suge = Sugerencia.get(position);
        holder.binSugerencia(suge);
    }

    @Override
    public int getItemCount() {
        return Sugerencia.size();
    }

    public static class SugerenciaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView titulo;
        private TextView descripcion;



        public SugerenciaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titulo = (TextView) itemView.findViewById(R.id.dependencia);
            descripcion = (TextView) itemView.findViewById(R.id.numero);

        }

        public void binSugerencia(Sugerencias a) {
            titulo.setText(a.getTitulo());
            descripcion.setText(a.getId());
        }

        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
        }
    }
    public interface OnClickAdaptadorDeSugerencia{
        public void onClickPosition(int pos);
    }

}
