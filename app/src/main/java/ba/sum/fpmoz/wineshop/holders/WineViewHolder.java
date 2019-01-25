package ba.sum.fpmoz.wineshop.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ba.sum.fpmoz.wineshop.R;
import ba.sum.fpmoz.wineshop.model.Wine;

public class WineViewHolder extends RecyclerView.ViewHolder {
    View mView;

    ImageView imageImg;
    TextView titleTxt;
    TextView opisTxt;
    TextView cijenaInt;

    public WineViewHolder(@NonNull View itemView) {
        super(itemView);
        this.mView = itemView;
        this.imageImg = itemView.findViewById(R.id.wine_image);
        this.titleTxt = itemView.findViewById(R.id.wine_title);
        this.opisTxt = itemView.findViewById(R.id.wine_opis);
        this.cijenaInt = itemView.findViewById(R.id.wine_cijena);

        this.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v, getAdapterPosition());
            }
        });
    }
    public ClickListener clickListener;

    public void setOnClickListener (ClickListener clickListener) {
        this.clickListener = clickListener;
    }
    public interface ClickListener {
        public void onItemClick(View v, int position);
    }
    public void setMovie (Wine wine) {
        this.titleTxt.setText(wine.naziv);
        this.opisTxt.setText(wine.opis);
        this.cijenaInt.setText(wine.cijena);
        Picasso.get().load(wine.slika).into(this.imageImg);
    }


}
