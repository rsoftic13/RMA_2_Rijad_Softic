package com.example.rma_2_rijad_softic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArtikalAdapter extends RecyclerView.Adapter<ArtikalAdapter.ArtikalViewHolder> {

    private Context context;
    private List<Artikal> artikli;

    public ArtikalAdapter(Context context, List<Artikal> artikli) {
        this.context = context;
        this.artikli = artikli;
    }

    @NonNull
    @Override
    public ArtikalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_artikal, parent, false);
        return new ArtikalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikalViewHolder holder, int position) {
        Artikal artikal = artikli.get(position);
        holder.naziv.setText(artikal.getNaziv());
        holder.cijena.setText(artikal.getCijena());
        holder.slika.setImageResource(artikal.getSlikaResurs());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, artikal.getAktivnost());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return artikli.size();
    }

    static class ArtikalViewHolder extends RecyclerView.ViewHolder {
        ImageView slika;
        TextView naziv, cijena;

        public ArtikalViewHolder(@NonNull View itemView) {
            super(itemView);
            slika = itemView.findViewById(R.id.artikalSlika);
            naziv = itemView.findViewById(R.id.artikalNaziv);
            cijena = itemView.findViewById(R.id.artikalCijena);
        }
    }
}