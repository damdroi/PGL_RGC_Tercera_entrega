package com.example.yo.pgl_rgc_tabs_fragments_try_03;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yo.pgl_rgc_tabs_fragments_try_03.deal.DealContract;
import com.example.yo.pgl_rgc_tabs_fragments_try_03.pojos.Country;

public class CountryActivity extends AppCompatActivity {
    TextInputEditText textInputEditTextId;
    TextInputEditText textInputEditTextDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textInputEditTextId = findViewById(R.id.TextInputEditTextId);
        textInputEditTextDescription = findViewById(R.id.TextInputEditTextDescription);

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
            //Enviar por parcelable
            //Country country = new Country(1, "s");
            //Country country = new Country(1, textInputEditTextDescription.getText().toString());
            //Country country=new Country(id,description);
            //end-Enviar por parcelable


            Country country = new Country(Integer.parseInt(id), description);
            DealContract.CONTENT_URI.toString();

            Uri uri = Uri.parse(DealContract.CONTENT_URI);
            ContentValues values = new ContentValues();
            values.put(DealContract._ID, country.getId());
            values.put(DealContract.DESCRIPTION, country.getDescription());
            String selection = DealContract._ID + "="+country.getId();
            getApplication().getContentResolver().update(uri,values,selection,null);
            getApplication().getContentResolver().insert(uri,values);


            Intent intent = new Intent(getApplicationContext(), OkActivity.class);
            startActivity(intent);

            //el siguiente codigo debe estar el el "target" de este "intent"
            //para recoger en la siguiente actividad
            //TextView textViewId=findViewById(R.id.textViewId);
            //TextView textViewDescription=findViewById(R.id.textViewDescription);
            //Country country=getIntent().getExtras().getParcelable(key: "country");
            //end-para recoger en la siguiente actividad

        }

    }

}
