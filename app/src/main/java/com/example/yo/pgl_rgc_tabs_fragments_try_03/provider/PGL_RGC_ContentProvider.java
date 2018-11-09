package com.example.yo.pgl_rgc_tabs_fragments_try_03.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.SparseArray;

import com.example.yo.pgl_rgc_tabs_fragments_try_03.DealAplication;
import com.example.yo.pgl_rgc_tabs_fragments_try_03.database.DealDatabase;
import com.example.yo.pgl_rgc_tabs_fragments_try_03.deal.DealContract;

public class PGL_RGC_ContentProvider extends ContentProvider {
    private final static int DEAL_ONE_REG = 1;
    private final static int DEAL_ALL_REG = 2;

    private static UriMatcher uriMatcher;
    private static SparseArray<String> mimeTypes;

    static {
        uriMatcher = new UriMatcher(0);
        mimeTypes = new SparseArray<>();
        uriMatcher.addURI(DealAplication.AUTHORITY, DealContract.TABLE_COUNTRY, DEAL_ALL_REG);
        uriMatcher.addURI(DealAplication.AUTHORITY, DealContract.TABLE_COUNTRY + "/#", DEAL_ONE_REG);
        mimeTypes.put(DEAL_ALL_REG, "vnd.android.cursor.dir/vnd." + DealContract.CONTENT_URI + "." + DealContract.TABLE_COUNTRY);
        mimeTypes.put(DEAL_ONE_REG, "vnd.android.cursor.item.dir/vnd." + DealContract.CONTENT_URI + "." + DealContract.TABLE_COUNTRY);

    }

    DealDatabase dealDatabase;

    public PGL_RGC_ContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        //throw new UnsupportedOperationException("Not yet implemented");
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = dealDatabase.getWritableDatabase();

        String table = null;

        switch(uriMatcher.match(uri)){
            case DEAL_ALL_REG:
            case DEAL_ONE_REG:
                table = DealContract.TABLE_COUNTRY;
                break;
        }

        return db.delete(table,selection,selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        return mimeTypes.get(uriMatcher.match(uri));
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = dealDatabase.getWritableDatabase();

        String table = null;

        switch(uriMatcher.match(uri)){
            case DEAL_ALL_REG:
            case DEAL_ONE_REG:
                table = DealContract.TABLE_COUNTRY;
                break;
        }

        db.insert(table,null,values);
        return uri;

    }

    @Override
    public boolean onCreate() {
        dealDatabase = new DealDatabase(getContext());
        return dealDatabase == null ? false : true;

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = dealDatabase.getReadableDatabase();

        switch (uriMatcher.match(uri)) {
            case DEAL_ALL_REG:
            case DEAL_ONE_REG:
                qb.setTables(DealContract.TABLE_COUNTRY);
                break;
        }

        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = dealDatabase.getWritableDatabase();

        String table = null;

        switch(uriMatcher.match(uri)){
            case DEAL_ALL_REG:
            case DEAL_ONE_REG:
                table = DealContract.TABLE_COUNTRY;
                break;

        }

        return db.update(table, values, selection, selectionArgs);

    }
}
