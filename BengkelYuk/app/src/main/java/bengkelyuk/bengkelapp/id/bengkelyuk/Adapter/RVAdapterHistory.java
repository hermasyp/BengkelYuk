package bengkelyuk.bengkelapp.id.bengkelyuk.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Booking.Booking;
import bengkelyuk.bengkelapp.id.bengkelyuk.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by herma on 20-Sep-17.
 */

public class RVAdapterHistory extends RecyclerView.Adapter<RVAdapterHistory.ViewHolder> {
    private Context mContext;
    private List<Booking> mList;

    public RVAdapterHistory(Context mContext, List<Booking> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public RVAdapterHistory.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(RVAdapterHistory.ViewHolder holder, int position) {
        holder.txtNama.setText(mList.get(position).getNamaUser());
        holder.txtBengkel.setText(mList.get(position).getNamaBengkel());
        holder.txtTipeMotor.setText(mList.get(position).getNamaTipe().trim());
        holder.txtPlatNo.setText(mList.get(position).getPlatNo());
        holder.txtTanggal.setText(mList.get(position).getTanggalService());
        holder.txtKeluhan.setText(mList.get(position).getKeluhan());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtNama) TextView txtNama;
        @BindView(R.id.txtBengkel) TextView txtBengkel;
        @BindView(R.id.txtTipeMotor) TextView txtTipeMotor;
        @BindView(R.id.txtPlatNo) TextView txtPlatNo;
        @BindView(R.id.txtTanggal) TextView txtTanggal;
        @BindView(R.id.txtKeluhan) TextView txtKeluhan;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
