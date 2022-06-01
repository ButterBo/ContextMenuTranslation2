package sg.edu.rp.c346.id21044912.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == tvTranslatedText){
            wordClicked = "hello";
        }
        else if (v == tvTranslatedText2){
            wordClicked = "bye";
        }
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            if (wordClicked == "hello"){
                tvTranslatedText.setText("Hello");
            }
            else if (wordClicked == "bye"){
                tvTranslatedText2.setText("Bye");
            }
            return true;
        } else if (id == R.id.italianSelection) {
            Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
            if (wordClicked == "hello"){
                tvTranslatedText.setText("Ciao");
            }
            else if (wordClicked == "bye"){
                tvTranslatedText2.setText("Addio");
            }
            return true;
        } else {
            tvTranslatedText.setText("Error translation");
        }

        return super.onContextItemSelected(item);
    }

}