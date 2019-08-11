package govca.id.listviewdicoding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class PlayerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        String name = getIntent().getStringExtra("NAME");
        String position = getIntent().getStringExtra("POSITION");
        String nationality = getIntent().getStringExtra("NATIONALITY");
        String number = getIntent().getStringExtra("NUMBER");
        String photo = getIntent().getStringExtra("PHOTO");
        String comment = getIntent().getStringExtra("COMMENT");

        TextView tv_name = findViewById(R.id.tv_player_name_content);
        TextView tv_position = findViewById(R.id.tv_player_position_content);
        TextView tv_number = findViewById(R.id.tv_player_number_content);
        TextView tv_nationality = findViewById(R.id.tv_player_nationality_content);
        TextView tv_comment = findViewById(R.id.tv_player_comment_content);
        ImageView img_player = findViewById(R.id.imgView_player_photo_content);

        tv_name.setText(name);
        tv_position.setText(position);
        tv_number.setText(number);
        tv_nationality.setText(nationality);
        tv_comment.setText(comment);

        String packageName = this.getPackageName();

        int identifier =  this
                .getResources()
                .getIdentifier(photo, "drawable", packageName);

        Glide
                .with(this)
                .load(identifier)
                .into(img_player);
    }
}
