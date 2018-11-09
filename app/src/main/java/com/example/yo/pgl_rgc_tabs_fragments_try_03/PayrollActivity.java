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

public class PayrollActivity extends AppCompatActivity {
    TextInputEditText textInputEditTextId;
    TextInputEditText textInputEditTextIdentification;
    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextSurnames;
    TextInputEditText textInputEditTextEmployeeAccount;
    TextInputEditText textInputEditTextPersonalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payroll);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textInputEditTextId = findViewById(R.id.TextInputEditTextId);
        textInputEditTextIdentification = findViewById(R.id.TextInputEditTextIdentification);
        textInputEditTextName = findViewById(R.id.TextInputEditTextName);
        textInputEditTextSurnames = findViewById(R.id.TextInputEditTextSurnames);
        textInputEditTextEmployeeAccount = findViewById(R.id.TextInputEditTextOrderingAccount);
        textInputEditTextPersonalAmount = findViewById(R.id.TextInputEditTextPersonalAmount);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OkActivity.class);
                startActivity(intent);

                //validate();//esta ventana no es para validar datos sino que es para corregir sin validar

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
        textInputEditTextEmployeeAccount.setError(null);

        String id = textInputEditTextId.getText().toString();
        String identification = textInputEditTextIdentification.getText().toString();
        String name = textInputEditTextName.getText().toString();
        String surnames = textInputEditTextSurnames.getText().toString();
        String employeeAccount = textInputEditTextEmployeeAccount.getText().toString();

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


        if (TextUtils.isEmpty(employeeAccount)) {
            textInputEditTextEmployeeAccount.setError(getString(R.string.error_field_required));
            textInputEditTextEmployeeAccount.requestFocus();
            error = true;
        }

        System.out.println(error);

        if (!error) {
            Intent intent = new Intent(getApplicationContext(), OkActivity.class);
            startActivity(intent);
        }
    }
}
