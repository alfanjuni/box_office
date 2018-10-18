package com.example.d2a.boxofiice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MovieFormActivity extends AppCompatActivity {

    EditText edtTitle, edtRating;
    Spinner spnStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_form);

        spnStatus = (Spinner) findViewById(R.id.spnStatus);
        String statuses[] = {"Playing", "Coming Soon", "Archived"};
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<String>(this,
                                        android.R.layout.simple_spinner_item, statuses);
        spnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnStatus.setAdapter(spnAdapter);

        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtRating = (EditText) findViewById(R.id.edtRating);
    }

    public void addMovie(View view) {

        Movie newMovie = new Movie(edtTitle.getText().toString(),
                Double.parseDouble(edtRating.getText().toString()),
                spnStatus.getSelectedItemPosition()+1);

        Intent retIt = new Intent();
        retIt.putExtra("newmovie", newMovie);
        setResult(Activity.RESULT_OK, retIt);
        finish();
    }
}
