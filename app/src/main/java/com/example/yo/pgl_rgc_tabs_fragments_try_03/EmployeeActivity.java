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

import java.util.jar.Attributes;

public class EmployeeActivity extends AppCompatActivity {
    TextInputEditText textInputEditTextId;
    TextInputEditText textInputEditTextIdentification;
    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextSurnames;
    TextInputEditText textInputEditTextHome;
    TextInputEditText textInputEditTextCountry;
    TextInputEditText textInputEditTextEmployeeAccount;
    TextInputEditText textInputEditTextProfile;
    TextInputEditText textInputEditTextPersonalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textInputEditTextId = findViewById(R.id.TextInputEditTextId);
        textInputEditTextIdentification = findViewById(R.id.TextInputEditTextIdentification);
        textInputEditTextName = findViewById(R.id.TextInputEditTextName);
        textInputEditTextSurnames = findViewById(R.id.TextInputEditTextSurnames);
        textInputEditTextHome = findViewById(R.id.TextInputEditTextHome);
        textInputEditTextCountry = findViewById(R.id.TextInputEditTextCountry);
        textInputEditTextEmployeeAccount = findViewById(R.id.TextInputEditTextOrderingAccount);
        textInputEditTextProfile = findViewById(R.id.TextInputEditTextProfile);
        textInputEditTextPersonalAmount = findViewById(R.id.TextInputEditTextPersonalAmount);


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
        textInputEditTextIdentification.setError(null);
        textInputEditTextName.setError(null);
        textInputEditTextSurnames.setError(null);
        textInputEditTextHome.setError(null);
        textInputEditTextCountry.setError(null);
        textInputEditTextEmployeeAccount.setError(null);
        textInputEditTextProfile.setError(null);
        textInputEditTextPersonalAmount.setError(null);

        String id = textInputEditTextId.getText().toString();
        String identification = textInputEditTextIdentification.getText().toString();
        String name = textInputEditTextName.getText().toString();
        String surnames = textInputEditTextSurnames.getText().toString();
        String home = textInputEditTextHome.getText().toString();
        String country = textInputEditTextCountry.getText().toString();
        String employeeAccount = textInputEditTextEmployeeAccount.getText().toString();
        String profile = textInputEditTextProfile.getText().toString();
        String personalAmount = textInputEditTextPersonalAmount.getText().toString();

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

        if (TextUtils.isEmpty(identification)) {
            textInputEditTextIdentification.setError(getString(R.string.error_field_required));
            textInputEditTextIdentification.requestFocus();
            error = true;
        }

        if (TextUtils.isEmpty(name)) {
            textInputEditTextName.setError(getString(R.string.error_field_required));
            textInputEditTextName.requestFocus();
            error = true;
        }

        if (TextUtils.isEmpty(surnames)) {
            textInputEditTextSurnames.setError(getString(R.string.error_field_required));
            textInputEditTextSurnames.requestFocus();
            error = true;
        }

        if (TextUtils.isEmpty(home)) {
            textInputEditTextHome.setError(getString(R.string.error_field_required));
            textInputEditTextHome.requestFocus();
            error = true;
        }


        try {
            int country_int = Integer.parseInt(country);
            if (country_int < 1) {
                textInputEditTextCountry.setError(getString(R.string.error_value_invalid));
                textInputEditTextCountry.requestFocus();
                error = true;
            }
        } catch (Exception e) {
            textInputEditTextCountry.setError(getString(R.string.error_value_invalid));
            textInputEditTextCountry.requestFocus();
            error = true;
        }

        if (TextUtils.isEmpty(employeeAccount)) {
            textInputEditTextEmployeeAccount.setError(getString(R.string.error_field_required));
            textInputEditTextEmployeeAccount.requestFocus();
            error = true;
        }


        try {
            int profile_int = Integer.parseInt(profile);
            if (profile_int < 1) {
                textInputEditTextProfile.setError(getString(R.string.error_value_invalid));
                textInputEditTextProfile.requestFocus();
                error = true;
            }
        } catch (Exception e) {
            textInputEditTextProfile.setError(getString(R.string.error_value_invalid));
            textInputEditTextProfile.requestFocus();
            error = true;
        }


        try {
            float amount_float = Float.parseFloat(personalAmount);
            if (amount_float < 1) {
                textInputEditTextPersonalAmount.setError(getString(R.string.error_value_invalid));
                textInputEditTextPersonalAmount.requestFocus();
                error = true;
            }
        } catch (Exception e) {
            textInputEditTextPersonalAmount.setError(getString(R.string.error_value_invalid));
            textInputEditTextPersonalAmount.requestFocus();
            error = true;
        }

        if (!error) {
            Intent intent = new Intent(getApplicationContext(), OkActivity.class);
            startActivity(intent);
        }
    }
}
