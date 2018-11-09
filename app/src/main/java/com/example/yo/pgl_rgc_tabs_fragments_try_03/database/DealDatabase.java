package com.example.yo.pgl_rgc_tabs_fragments_try_03.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.yo.pgl_rgc_tabs_fragments_try_03.deal.DealContract;

public class DealDatabase extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "dababase.db";
    private final static int DATABASE_VERSION = 6;


    //public DealDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    public DealDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DealContract.TABLE_COUNTRY + " (" +
                DealContract._ID + " INTEGER PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT, " +
                DealContract.DESCRIPTION + " TEXT " +
                ");");
        inicialiteData(db);

    }

    private void inicialiteData(SQLiteDatabase db) {
        db.execSQL("INSERT INTO " + DealContract.TABLE_COUNTRY + " (" + DealContract._ID + " , " + DealContract.DESCRIPTION + ") VALUES (1, 'TUno')");
        db.execSQL("INSERT INTO " + DealContract.TABLE_COUNTRY + " (" + DealContract._ID + " , " + DealContract.DESCRIPTION + ") VALUES (2, 'Dos')");
        db.execSQL("INSERT INTO " + DealContract.TABLE_COUNTRY + " (" + DealContract._ID + " , " + DealContract.DESCRIPTION + ") VALUES (3, 'Tres')");

        //db.execSQL("INSERT INTO " + DealContract.TABLE_COUNTRY + " (" +
        //        DealContract.ID + ", " + DealContract.DESCRIPTION +
        //        ") " + "VALUES" +
        //        " (1, 'Madrid')," +
        //        " (2, 'Sevilla')," +
        //        " (3, 'Granada')" +
        //        "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+DealContract.TABLE_COUNTRY);
        onCreate(db);
    }
}
