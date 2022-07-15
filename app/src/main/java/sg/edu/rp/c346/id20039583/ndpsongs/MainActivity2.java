package sg.edu.rp.c346.id20039583.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.lights.LightState;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    Button btnShowAll;
    ListView lv;
    ArrayList<Note> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnShowAll = findViewById(R.id.btnShowAll);
        lv = findViewById(R.id.lv);
        al = new ArrayList<Note>();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Note data = al.get(position); //retrieve based on the item you click.
                Intent i = new Intent(String.valueOf(MainActivity2.this));
                i.putExtra("data", data);
                startActivity(i);
            }
        });

    }
}