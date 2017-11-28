package com.example.joana.work2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTrackActivity extends AppCompatActivity {

    TextView textViewArtistName;
    EditText editTextTrackname;
    Button buttonAddTrack;

    ListView listViewTracks;
    DatabaseReference databaseTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);

        textViewArtistName = findViewById(R.id.textViewArtistName);
        editTextTrackname = findViewById(R.id.editTextTrackName);
        listViewTracks = findViewById(R.id.listViewTrack);
        buttonAddTrack = findViewById(R.id.buttonSaveTrack);

        Intent intent = getIntent();
        String id = intent.getStringExtra(MainActivity.ARTIST_ID);
        String name = intent.getStringExtra(MainActivity.ARTIST_NAME);

        textViewArtistName.setText(name);
        databaseTracks = FirebaseDatabase.getInstance().getReference("Tracks").child(id);

        buttonAddTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTrack();
            }
        });

    }
    private void saveTrack(){
        String trackName = editTextTrackname.getText().toString().trim();

        if (!TextUtils.isEmpty(trackName)){
            String id = databaseTracks.push().getKey();
            Track track = new Track(id,trackName);
            databaseTracks.child(id).setValue(track);
            Toast.makeText(this,"Track Added",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"Enter something not Empty",Toast.LENGTH_LONG).show();
        }
    }

}
