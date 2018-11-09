package com.example.yo.pgl_rgc_tabs_fragments_try_03.deal;

import android.provider.BaseColumns;

import com.example.yo.pgl_rgc_tabs_fragments_try_03.DealAplication;

public class DealContract implements BaseColumns {
    public static String TABLE_COUNTRY = "country";
    //public static String ID = "id";
    public static String DESCRIPTION = "description";

    public static String CONTENT_URI="content://"+DealAplication.AUTHORITY+"/"+TABLE_COUNTRY;



}
