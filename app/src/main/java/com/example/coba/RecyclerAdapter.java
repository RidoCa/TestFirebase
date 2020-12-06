package com.example.coba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Mahasiswa> mahasiswaList;

    public RecyclerAdapter(List<Mahasiswa> mahasiswaList){
        this.mahasiswaList = mahasiswaList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        Mahasiswa mhs = mahasiswaList.get(position);
        holder.tv_nama.setText("Nama: "+mhs.getNama());
        holder.tv_fakultas.setText("Fakultas: "+mhs.getFakultas());
        holder.tv_jurusan.setText("Jurusan: "+mhs.getJurusan());
        holder.tv_semester.setText("Semester: "+mhs.getSemester());

    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama;
        TextView tv_fakultas;
        TextView tv_jurusan;
        TextView tv_semester;
        CardView card_View;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nama  = itemView.findViewById(R.id.tv_nama);
            tv_fakultas  = itemView.findViewById(R.id.tv_fakultas);
            tv_jurusan  = itemView.findViewById(R.id.tv_jurusan);
            tv_semester  = itemView.findViewById(R.id.tv_semester);
            card_View = itemView.findViewById(R.id.card_view);

        }
    }
}
