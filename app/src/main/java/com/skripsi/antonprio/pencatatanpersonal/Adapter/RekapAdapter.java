package com.skripsi.antonprio.pencatatanpersonal.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skripsi.antonprio.pencatatanpersonal.Pengeluaran.PengeluaranService;
import com.skripsi.antonprio.pencatatanpersonal.R;
import com.skripsi.antonprio.pencatatanpersonal.Rekap.RekapModel;

import java.util.List;

/**
 * Created by Anton Prio on 8/3/2016.
 */
public class RekapAdapter extends RecyclerView.Adapter<RekapAdapter.MyHolder> {
    private List<RekapModel> list;

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rekap_adapter, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        RekapModel model = list.get(position);
        String jumlah = PengeluaranService.formatedString(model.getRekapJumlah());
        holder.rekapJumlah.setText(jumlah);
        holder.rekapTanggal.setText(model.getRekapTanggal());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public TextView rekapJumlah, rekapTanggal;
        public MyHolder(View view) {
            super(view);
            rekapJumlah = (TextView) view.findViewById(R.id.rekap_jumlah);
            rekapTanggal = (TextView) view.findViewById(R.id.rekap_tanggal);
        }
    }

    public RekapAdapter(List<RekapModel> list) {
        this.list = list;
    }
}
