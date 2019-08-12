package govca.id.listviewdicoding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView imgPhoto = findViewById(R.id.img_item_photo);

        Glide
                .with(this)
                .load(R.drawable.sg_2016)
                .into(imgPhoto);
    }
}
