package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.DetalleNoticiaFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.NoticiasFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.MapFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.SugerenciasFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.AgendaFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.DialogoInternetFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util.Utilidades;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo.Noticia;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;

/**
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 * Actividad principal de la aplicación
 * en ella se soportará cada uno de los fragmentos que tenemos en la vista principal como sugerencias, directorio, etc...
 */
public class NavigationActivity extends AppCompatActivity implements NoticiasFragment.OnNoticiaSeleccionadaListener{

    private NoticiasFragment noticiasFragment;
    DrawerLayout drawerLayout;
    NavigationView navView;
    boolean estaAbierto = false;
    static Context contexto;
    private ArrayList<Noticia> noticias;


    /**
     * Metodo para obtener el contexto de la actividad
     */
    public static Context getContexto() {
        return contexto;
    }


    /**
     * Inflamos el menú principal
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_nav, menu);
        return true;
    }


    /**
     * crea la ctividad principal de la aplicación
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.v("entro", "onCreate");
        super.onCreate(savedInstanceState);
        Utilidades.obtenerLenguaje(this);
        setContentView(R.layout.activity_navigation);
        contexto = this.getBaseContext();
        //añadimos el menú desplegable
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.navview);
        navView.setItemIconTintList(null);

        // reemplazamos el fragmento cuando seleccionamos alguna de las opciones del navigation drawer
        noticiasFragment= new NoticiasFragment();

        remplazarFragmento(noticiasFragment, 2);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_noticias:
                        //me permite ir a mostrar el fragmento de las noticias NoticiasFragment
                        //PeliculasActualesActivity.onCreate(savedInstanceState);
                        remplazarFragmento(new NoticiasFragment(), 1);
                        Log.v("entro", "entrar a noticias");
                        break;
                    case R.id.menu_directorio:
                        //me permite ir a mostrar el fragmento de la agenda AgendaFragment
                        remplazarFragmento(new AgendaFragment(), 1);

                        Log.v("entro", "entrar a agenda");
                        break;
                    case R.id.menu_mapa:
                        //me permite ir a mostrar el fragmento del mapa MapFragment
                        remplazarFragmento(new MapFragment(), 1);
                        Log.v("entro", "entrar a mapa");
                        break;
                    case R.id.menu_internacionalizacion:
                        //va a cambiar el lenguaje de la aplicación
                        cambiarLenguaje();
                        break;
                    case R.id.menu_sugerencia:
                        //me permite ir a mostrar el fragmento de las sugenrecias SugerenciasFragment
                        remplazarFragmento(new SugerenciasFragment(), 1);
                        break;
                    case R.id.redireccionar:
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://www.uniquindio.edu.co"));
                        startActivity(intent);
                        break;
                }
                // esta asignación es para que no tenga que dar click dos veces para volver a abrir el navigationDrawer
                estaAbierto = !estaAbierto;
                item.setChecked(false);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    /**
     * Este metodo ingresa a la clase de utilidades para poder cambiar el idioma de la aplicación
     */
    public void cambiarLenguaje() {
        Utilidades.cambiarIdioma(this);
        Intent intent = this.getIntent();
        this.finish();
        startActivity(intent);
    }

    /**
     * Este metodo sirve para que se despliegue o se oculte el NavigationDrawer
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                if(Utilidades.comprobarConexionInternet(0, contexto)==1) {
                    // si esta abierto se cierra, o abre si esta cerrado
                    if (estaAbierto) {
                        //cerrar NavigationDrawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        estaAbierto = false;
                    } else {
                        //abrir NavigationDrawer
                        drawerLayout.openDrawer(GravityCompat.START);
                        estaAbierto = true;
                    }
                    return true;
                }else{Utilidades.mostrarDialigo(getFragmentManager(), DialogoInternetFragment.class.getSimpleName()); break;}
            case R.id.menu_wifi:
                //mostar el framento de la conexión a internet
                Utilidades.mostrarDialigo(getFragmentManager(), DialogoInternetFragment.class.getSimpleName());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Este metodo me reemplaza el fragmento al cual vamos a acceder con el .replace
     *
     * @param fragment
     * @param num
     */
    private void remplazarFragmento(Fragment fragment, int num) {
        if (num == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
    }


    /**
     * Este método sirve para cuando presinamos el boton atras del dispositivo movil
     **/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (estaAbierto) {
            drawerLayout.closeDrawer(GravityCompat.START);
            estaAbierto = false;
        } else {
            remplazarFragmento(new NoticiasFragment(), 2);
        }

    }

    /**
     * Toma la noticia Clickeada y envia por parametro la posicion de esta
     * luego envia esta posicion al Fragmento DetalleNoticiaFragment
     * @param position
     */
    @Override
    public void onNoticiaSeleccionada(int position) {
        boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_pelicula) != null;

        if (esFragmento) {
                ((DetalleNoticiaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_pelicula)).showDetail(noticias.get(position));

        } else {
            //Abrir la actividad DetalleNoticiaActivity
            Intent intent = new Intent(NavigationActivity.this,
                    DetalleNoticiaActivity.class);
            //intent.putExtra("noticia", noticias.get(position));
            startActivity(intent);

        }
    }
}
