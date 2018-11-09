package com.example.yo.pgl_rgc_tabs_fragments_try_03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextId;
    TextInputEditText textInputEditTextDescription;
    TextInputEditText textInputEditTextAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textInputEditTextId = findViewById(R.id.TextInputEditTextId);
        textInputEditTextDescription = findViewById(R.id.TextInputEditTextDescription);
        textInputEditTextAmount = findViewById(R.id.TextInputEditTextAmount);

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
        textInputEditTextAmount.setError(null);

        String id = textInputEditTextId.getText().toString();
        String description = textInputEditTextDescription.getText().toString();
        String amount = textInputEditTextAmount.getText().toString();

        try {
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

        try {
            float amount_float = Float.parseFloat(amount);
            if (amount_float < 1) {
                textInputEditTextAmount.setError(getString(R.string.error_value_invalid));
                textInputEditTextAmount.requestFocus();
                error = true;
            }
        } catch (Exception e) {
            textInputEditTextAmount.setError(getString(R.string.error_value_invalid));
            textInputEditTextAmount.requestFocus();
            error = true;
        }

        if (!error) {
            Intent intent = new Intent(getApplicationContext(), OkActivity.class);
            startActivity(intent);
        }
    }
}
