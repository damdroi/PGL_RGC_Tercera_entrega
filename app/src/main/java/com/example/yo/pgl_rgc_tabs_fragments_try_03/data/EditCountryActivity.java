package com.example.yo.pgl_rgc_tabs_fragments_try_03.data;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.yo.pgl_rgc_tabs_fragments_try_03.BridgeActivity;
import com.example.yo.pgl_rgc_tabs_fragments_try_03.R;
import com.example.yo.pgl_rgc_tabs_fragments_try_03.deal.DealContract;
import com.example.yo.pgl_rgc_tabs_fragments_try_03.pojos.Country;

public class EditCountryActivity extends AppCompatActivity {
    TextInputEditText textInputEditTextId;
    TextInputEditText textInputEditTextDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_country);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int idRecibido = getIntent().getExtras().getInt("id");
        final String descriptionRecibido = getIntent().getExtras().getString("description");
        //Log.i("tiburcio", String.valueOf(idRecibido));

        textInputEditTextId = findViewById(R.id.TextInputEditTextId);
        textInputEditTextDescription = findViewById(R.id.TextInputEditTextDescription);

        textInputEditTextId.setText(String.valueOf(idRecibido));
        textInputEditTextDescription.setText(descriptionRecibido);

        Button buttonDel=findViewById(R.id.buttonDel);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("asdf");



                Country country = new Country(idRecibido, descriptionRecibido);
                DealContract.CONTENT_URI.toString();

                Uri uri = Uri.parse(DealContract.CONTENT_URI);
                ContentValues values = new ContentValues();
                values.put(DealContract._ID, country.getId());
                values.put(DealContract.DESCRIPTION, country.getDescription());
                String selection = DealContract._ID + "="+country.getId();
                getApplication().getContentResolver().update(uri,values,selection,null);
                getApplication().getContentResolver().delete(uri,selection,null);

                Intent intent = new Intent(getApplicationContext(), BridgeActivity.class);
                startActivity(intent);




            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void validate() {
        boolean error = false;
        textInputEditTextId.setError(null);
        textInputEditTextDescription.setError(null);

        String id = textInputEditTextId.getText().toString();
        String description = textInputEditTextDescription.getText().toString();

        try {
            //if (TextUtils.isEmpty(id)) {
            //    textInputEditTextId.setError(getString(R.string.error_value_invalid));
            //    textInputEditTextId.requestFocus();
            //    error = true;
            //}
            int id_int = Integer.parseInt(id);
            if (id_int < 1) {
                textInputEditTextId.setError(getString(R.string.error_value_invalid));
                textInputEditTextId.requestFocus();
                error = true;
            }
        } catch (Exception e) {
            textInputEditTextId.setError(getString(R.string.error_value_invalid));
            textInputEditTextId.requestFocus();
            error = true;
        }

        if (TextUtils.isEmpty(description)) {
            textInputEditTextDescription.setError(getString(R.string.error_field_required));
            textInputEditTextDescription.requestFocus();
            error = true;
        }

        if (!error) {
            Country country = new Country(Integer.parseInt(id), description);
            DealContract.CONTENT_URI.toString();

            Uri uri = Uri.parse(DealContract.CONTENT_URI);
            ContentValues values = new ContentValues();
            values.put(DealContract._ID, country.getId());
            values.put(DealContract.DESCRIPTION, country.getDescription());
            String selection = DealContract._ID + "="+country.getId();
            getApplication().getContentResolver().update(uri,values,selection,null);

            Intent intent = new Intent(getApplicationContext(), BridgeActivity.class);
            startActivity(intent);
        }
    }

}
