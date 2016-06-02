package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by USER PC on 1/06/2016.
 */
public class SugerenciasSQLiteHelper extends SQLiteOpenHelper {


    public SugerenciasSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRUDSQL.crearTabla());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
