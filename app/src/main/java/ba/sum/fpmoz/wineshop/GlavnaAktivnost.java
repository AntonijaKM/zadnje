package ba.sum.fpmoz.wineshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fpmoz.wineshop.holders.WineViewHolder;
import ba.sum.fpmoz.wineshop.model.Wine;

public class GlavnaAktivnost extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference mDatabase;
    FirebaseDatabase mFirebaseDatabase;
    RecyclerView wine_list;
    FirebaseRecyclerAdapter adapter;

    @Override
 protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_glavna_aktivnost);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        this.wine_list.setLayoutManager(manager);
        this.wine_list.setHasFixedSize(true);

        FirebaseRecyclerOptions<Wine> options = new FirebaseRecyclerOptions.Builder<Wine>().setQuery(
                mDatabase.child("vina"), new SnapshotParser<Wine>() {
                    @NonNull
                    @Override
                    public Wine parseSnapshot(@NonNull DataSnapshot snapshot) {
                        return snapshot.getValue(Wine.class);
                    }
                }
        ).build();

        adapter = new FirebaseRecyclerAdapter<Wine, WineViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull WineViewHolder holder, int position, @NonNull Wine model) {

            }

            @NonNull
            @Override
            public WineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wine_list, viewGroup, false);
                WineViewHolder wineViewHolder = new WineViewHolder(view);


                return wineViewHolder;
            }


        };
        this.wine_list.setAdapter(adapter);

    }


}

