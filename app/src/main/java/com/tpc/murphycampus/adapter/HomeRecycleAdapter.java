package com.tpc.murphycampus.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpc.murphycampus.R;
import com.tpc.murphycampus.pojo.Errand;

import java.util.ArrayList;

public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.myViewHodler> {

    private Context context;
    private ArrayList<Errand> OrderList;

    public HomeRecycleAdapter(Context context, ArrayList<Errand> orderList) {
        this.context = context;
        this.OrderList = orderList;
    }

    @NonNull
    @Override
    public myViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.item_order, null);
        return new myViewHodler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecycleAdapter.myViewHodler holder, int position) {

        Errand data = OrderList.get(position);
        holder.details.setText(data.getDetails());
        holder.status.setText(data.getStatus());
        holder.pickUpAddress.setText(data.getPickUpAddress());
        holder.shippingAddress.setText(data.getShippingAddress());
        holder.addressee.setText(data.getAddressee());
        holder.addresseePhone.setText(data.getAddresseePhone());
        holder.price.setText(String.valueOf(data.getPrice()));
    }

    @Override
    public int getItemCount() {
        return OrderList.size();
    }

    class myViewHodler extends RecyclerView.ViewHolder{

        private TextView status;
        private TextView details;
        private TextView pickUpAddress;
        private TextView shippingAddress;
        private TextView addressee;
        private TextView addresseePhone;
        private TextView price;

        public myViewHodler(@NonNull View itemView) {
            super(itemView);
            status = itemView.findViewById(R.id.textView5);
            details = itemView.findViewById(R.id.textView6);
            pickUpAddress = itemView.findViewById(R.id.quJianDiZhi);
            shippingAddress = itemView.findViewById(R.id.shouJianDiZhi);
            addressee = itemView.findViewById(R.id.shou_userName);
            addresseePhone = itemView.findViewById(R.id.shou_userPhone);
            price = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null){
                        onItemClickListener.OnItemClick(v,OrderList.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    /**
     * 设置item的监听事件的接口
     */
    public interface OnItemClickListener {
        /**
         * 接口中的点击每一项的实现方法，参数自己定义
         *
         * @param view 点击的item的视图
         * @param data 点击的item的数据
         */
        public void OnItemClick(View view, Errand data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
