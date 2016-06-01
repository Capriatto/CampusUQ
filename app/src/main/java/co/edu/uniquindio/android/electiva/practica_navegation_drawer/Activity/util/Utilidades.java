package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Locale;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment.DialogoInternetFragment;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;

/**
 *
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 * Esta clase cambia el idioma de la aplicación
 *
 */
public class Utilidades {
    public final static String MIS_PREFERENCIAS = "MisPreferencias";
    public final static String LENGUAJE_DE_PREFERENCIA = "languaje_preferences";
    public final static String LENGUAJE_ES = "es";
    public final static String LENGUAJE_EN = "en";


    /**
     *  Este metodo toma el contexto en donde vamos a cambiar el idioma
     * @param context
     */
    public static void cambiarIdioma(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(MIS_PREFERENCIAS, context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES);
        if (language.equals(LENGUAJE_ES)) {
            language = LENGUAJE_EN;
        } else if (language.equals(LENGUAJE_EN)) {
            language = LENGUAJE_ES;
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LENGUAJE_DE_PREFERENCIA, language);
        editor.commit();
        obtenerLenguaje(context);
    }

    /**
     * De este método obtenemos el lenguaje de preferencia (el que tenemos en nuestro celular o predefinido)
     * @param context
     */
    public static void obtenerLenguaje(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(MIS_PREFERENCIAS, context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES);
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }

    /**
     * es el encargado de mostrar el dialogo de comprobación de internet
     * @param fragmentManager permite realizar la transacción del dialogo
     * @param nameClass       nombre de la actividad que lo invoco
     */
    public static void mostrarDialigo(FragmentManager fragmentManager, String nameClass) {
        DialogoInternetFragment miDialogo = new DialogoInternetFragment();
        miDialogo.setStyle(miDialogo.STYLE_NORMAL, R.style.MiDialogo);
        miDialogo.show(fragmentManager, nameClass);
    }

    /**
     * Este método permite saber si hay conexion disponible a internet.
     * @return -1= desconectado, 0=conectado, 1=ConectadoWifi, 2=ConectadoDatos
     */
    public static int comprobarConexionInternet(int tipoConexion, Context contexto) {
        ConnectivityManager cm = (ConnectivityManager) contexto.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        switch (tipoConexion) {
            case 0:
                if (networkInfo != null && networkInfo.isConnected()) return 1;
                break;
            case 1:
                if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) return 2;
                break;
            case 2:
                if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) return 3;
                break;
        }
        return -1;
    }

}