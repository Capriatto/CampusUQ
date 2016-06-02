package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo.Sugerencias;

/**
 * Created by USER PC on 1/06/2016.
 */
public class CRUDSQL {
    private SugerenciasSQLiteHelper usdbh;
    private SQLiteDatabase db;

    public CRUDSQL(Context context, int version) {
        usdbh = new SugerenciasSQLiteHelper(context, Utilidades.NOMBRE_BD, null, version);
        db = usdbh.getWritableDatabase();
    }

    public static String crearTabla() {
        String crearTabla = "CREATE TABLE ? ( ? INTEGER PRIMARY KEY AUTOINCREMENT, ? TEXT, ? TEX)";
        StringBuilder builder = new StringBuilder(crearTabla);
        builder.replace(builder.indexOf("?"), crearTabla.indexOf("?") + 1, Utilidades.NOMBRE_TABLA);
        builder.replace(builder.indexOf("?"), builder.indexOf("?") + 1, Utilidades.CAMPOS_TABLA[0]);
        builder.replace(builder.indexOf("?"), builder.indexOf("?") + 1, Utilidades.CAMPOS_TABLA[1]);
        builder.replace(builder.indexOf("?"), builder.indexOf("?") + 1, Utilidades.CAMPOS_TABLA[2]);
        return builder.toString();
    }


    public ArrayList<Sugerencias> getInformacionBD() {
        ArrayList<Sugerencias> sugerencias = new ArrayList<>();
        Cursor c = db.query(Utilidades.NOMBRE_TABLA, Utilidades.CAMPOS_TABLA, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                String _id = c.getString(0);
                String titulo = c.getString(1);
                String descripcion = c.getString(2);
                sugerencias.add(new Sugerencias(_id,titulo,descripcion));
            } while (c.moveToNext());
        }
        return sugerencias;
    }
}
