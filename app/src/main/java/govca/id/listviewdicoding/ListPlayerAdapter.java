package govca.id.listviewdicoding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import govca.id.listviewdicoding.pojo.Player;

public class ListPlayerAdapter extends RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder> {
    private ArrayList<Player> listPlayer;

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Player data);
    }

    public ListPlayerAdapter(ArrayList<Player> list)
    {
        this.listPlayer = list;
    }

    @NonNull
    @Override
    public ListPlayerAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_player, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListPlayerAdapter.ListViewHolder listViewHolder, int i) {
        Player player = listPlayer.get(i);

        String packageName = listViewHolder.itemView.getContext().getPackageName();

        int identifier =  listViewHolder
                .itemView.getContext()
                .getResources()
                .getIdentifier(player.getPlayer_photo(), "drawable", packageName);

        Glide
                .with(listViewHolder.itemView.getContext())
                .load(identifier)
                .into(listViewHolder.img_photo_player);

        listViewHolder.tv_player_name.setText(player.getPlayer_name());
        listViewHolder.tv_player_nationality.setText(player.getPlayer_nationality());
        listViewHolder.tv_player_position.setText(player.getPlayer_position());
        listViewHolder.tv_player_number.setText(player.getPlayer_number());

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listPlayer.get(listViewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPlayer.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView img_photo_player;
        TextView tv_player_name, tv_player_position, tv_player_nationality, tv_player_number;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            img_photo_player = itemView.findViewById(R.id.img_photo_player);
            tv_player_name = itemView.findViewById(R.id.tv_player_name);
            tv_player_position = itemView.findViewById(R.id.tv_player_position);
            tv_player_nationality = itemView.findViewById(R.id.tv_player_nationality);
            tv_player_number = itemView.findViewById(R.id.tv_player_number);
        }
    }


}
