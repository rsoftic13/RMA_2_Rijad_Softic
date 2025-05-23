package com.example.rma_2_rijad_softic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class NarudzbaAdapter extends RecyclerView.Adapter<NarudzbaAdapter.NarudzbaViewHolder> {

    private List<NarudzbaEntity> narudzbe = new ArrayList<>();

    @NonNull
    @Override
    public NarudzbaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.narudzba_item, parent, false);
        return new NarudzbaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NarudzbaViewHolder holder, int position) {
        NarudzbaEntity narudzba = narudzbe.get(position);
        holder.textViewArtikal.setText(narudzba.nazivArtikla + " - " + narudzba.cijenaArtikla);
        holder.textViewKupac.setText(narudzba.imeKupca + " " + narudzba.prezimeKupca);
        holder.textViewAdresa.setText(narudzba.adresaKupca + ", " + narudzba.opcinaKupca);
    }

    @Override
    public int getItemCount() {
        return narudzbe.size();
    }

    public void setNarudzbe(List<NarudzbaEntity> narudzbe) {
        this.narudzbe = narudzbe;
        notifyDataSetChanged();
    }

    class NarudzbaViewHolder extends RecyclerView.ViewHolder {
        TextView textViewArtikal;
        TextView textViewKupac;
        TextView textViewAdresa;

        public NarudzbaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewArtikal = itemView.findViewById(R.id.textViewArtikal);
            textViewKupac = itemView.findViewById(R.id.textViewKupac);
            textViewAdresa = itemView.findViewById(R.id.textViewAdresa);
        }
    }
}
