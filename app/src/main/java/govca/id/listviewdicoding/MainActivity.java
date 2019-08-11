package govca.id.listviewdicoding;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import govca.id.listviewdicoding.pojo.Player;

public class MainActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();

    private RecyclerView rvPlayers;
    private ArrayList<Player> list = new ArrayList<>();

    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPlayers = findViewById(R.id.rv_player);
        rvPlayers.setHasFixedSize(true);

        String playersArray = this.fromFile("players.json");
        try {
            Player[] players = mapper.readValue(playersArray, Player[].class);

            for (int i=0; i<players.length; i++)
            {
                list.add(players[i]);
                Log.d(TAG, players[i].getPlayer_name());
                Log.d(TAG, players[i].getPlayer_nationality());
            }

            showRecyclerList();

        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }
    }

    public String fromFile(String fileName)
    {
        String json ;
        try {
            InputStream is = this.getApplicationContext().getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.e(TAG, ex.getMessage());
            return null;
        }
        return json;
    }

    private void showRecyclerList(){
        DividerItemDecoration divider = new DividerItemDecoration(rvPlayers.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.custom_divider));
        rvPlayers.addItemDecoration(divider);

        rvPlayers.setLayoutManager(new LinearLayoutManager(this));
        ListPlayerAdapter listHeroAdapter = new ListPlayerAdapter(list);
        rvPlayers.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListPlayerAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Player data) {
                Toast.makeText(getApplicationContext(), "Kamu memilih " + data.getPlayer_name(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, PlayerDetailActivity.class);
                intent.putExtra("NAME", data.getPlayer_name());
                intent.putExtra("POSITION", data.getPlayer_position());
                intent.putExtra("NATIONALITY", data.getPlayer_nationality());
                intent.putExtra("NUMBER", data.getPlayer_number());
                intent.putExtra("PHOTO", data.getPlayer_photo());
                intent.putExtra("COMMENT", data.getPlayer_comment());

                startActivity(intent);
            }
        });
    }
}
