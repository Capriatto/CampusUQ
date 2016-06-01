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
 *
 */


public class AdaptadorDeNoticia extends RecyclerView.Adapter<AdaptadorDeNoticia.NoticiaViewHolder> {

    private ArrayList<Noticia> noticias;
    private static OnClickAdaptadorDeNoticia listener;


    public AdaptadorDeNoticia(ArrayList<Noticia> noticias, NoticiasFragment noticiasFragment) {
        this.noticias = noticias;
        listener = (OnClickAdaptadorDeNoticia) noticiasFragment;
    }

    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.v("Entre","onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_de_noticia, parent, false);
        NoticiaViewHolder noticiaVH = new NoticiaViewHolder(itemView);
        return noticiaVH;
    }


    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {
        Log.v("Entre","onBindViewHolder");
        Noticia noticia = noticias.get(position);
        holder.binNoticia(noticia);
    }

    @Override
    public int getItemCount() {
        Log.v("Entre","getItemCount");
        return noticias.size();
    }


    /**
     *
    **/
    public static class NoticiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTitulo;
        private TextView txtDescripcion;
        private ImageView imagen;

        public NoticiaViewHolder(View itemView) {
            super(itemView);

            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);
            txtDescripcion = (TextView) itemView.findViewById(R.id.descripcion);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            itemView.setOnClickListener(this);
        }

        public void binNoticia(Noticia p) {
            //String textoSinDetalle = p.getDescripcion().substring(0,100) + "...Ver más";
            txtTitulo.setText(p.getTitulo());
            txtDescripcion.setText("");
            imagen.setImageResource(p.getImagen());

        }

        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
        }
    }

    public interface OnClickAdaptadorDeNoticia{
        public void onClickPosition(int pos);
    }

}


/**

public class AdaptadorDeNoticia  extends RecyclerView.Adapter<AdaptadorDeNoticia.NoticiaViewHolder> {

    private ArrayList<Noticia> noticias;
    private static OnClickAdaptadorDeNoticia listener; //

    public AdaptadorDeNoticia(ArrayList<Noticia> noticias, NoticiasFragment noticiaFragment) {
        this.noticias = noticias;
        listener = (OnClickAdaptadorDeNoticia) noticiaFragment;
    }

    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_de_noticia, parent, false);
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

    public interface OnClickAdaptadorDeNoticia {
        public void onClickPosition(int pos);
    }
}
**/