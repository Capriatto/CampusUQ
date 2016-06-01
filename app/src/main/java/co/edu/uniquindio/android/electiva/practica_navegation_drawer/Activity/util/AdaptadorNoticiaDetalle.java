package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.NoticiasFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo.Noticia;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;

/**
 *
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 * Este adaptador me permite el paso de información entre fragmentos mediante la interface
 *
 */
public class AdaptadorNoticiaDetalle extends RecyclerView.Adapter<AdaptadorNoticiaDetalle.NoticiaViewHolder> {

    private ArrayList<Noticia> noticias;
    private static OnClickAdaptadorDeNoticia listener;

    public AdaptadorNoticiaDetalle(ArrayList<Noticia> noticias, NoticiasFragment noticiaFragment ) {
        this.noticias = noticias;
        listener = (OnClickAdaptadorDeNoticia) noticiaFragment;
    }

    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detalle_noticia, parent, false);
        NoticiaViewHolder noticiaVH = new NoticiaViewHolder(itemView);
        return noticiaVH;
    }

    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {
        Noticia noticia = noticias.get(position);
        holder.binNoticia(noticia);
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public static class NoticiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtTitulo;
        private ImageView imagen;

        public NoticiaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);

        }
        public void binNoticia(Noticia n) {
            txtTitulo.setText(n.getTitulo());
            imagen.setImageResource(n.getImagen());
        }

        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " + txtTitulo.getText());
        }
    }

    public interface OnClickAdaptadorDeNoticia{
        public void onClickPosition(int pos);
    }


}
