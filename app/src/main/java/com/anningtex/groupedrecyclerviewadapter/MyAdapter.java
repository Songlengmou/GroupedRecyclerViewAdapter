package com.anningtex.groupedrecyclerviewadapter;

import com.anningtex.groupedrecyclerviewadapter.menu.GroupedRecyclerViewAdapter;
import com.syp.library.viewholder.BaseViewHolder;

import java.util.List;

/**
 * @Author Song
 */
public class MyAdapter extends GroupedRecyclerViewAdapter<TestBean.DataBean> {
    @Override
    public int getGroupCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<TestBean.DataBean.PullerGoodsListBean> pullerGoods = data.get(groupPosition).getPullerGoodsList();
        //判断子项是否是直接展开
//        if (!isExpand(groupPosition)) {
//            return 0;
//        }
        return pullerGoods == null ? 0 : pullerGoods.size();
    }

    @Override
    public boolean hasHeader(int groupPosition) {
        return true;
    }

    @Override
    public boolean hasFooter(int groupPosition) {
        return true;
    }

    @Override
    public int getHeaderLayout(int viewType) {
        return R.layout.item_puller_off_loaded_header;
    }

    @Override
    public int getFooterLayout(int viewType) {
        return R.layout.item_puller_off_loaded_footer;
    }

    @Override
    public int getChildLayout(int viewType) {
        return R.layout.item_puller_off_loaded;
    }

    @Override
    public void onBindHeaderViewHolder(BaseViewHolder holder, int groupPosition) {
        TestBean.DataBean dataBean = data.get(groupPosition);
        holder.setText(R.id.item_tv_delivery_no, dataBean.getDeliveryNo());
        holder.setText(R.id.item_tv_load_date, dataBean.getLoadDate());
        holder.setText(R.id.item_tv_from_port, dataBean.getFromPort());
        holder.setText(R.id.item_tv_to_port, dataBean.getToPort() + "(" + dataBean.getClearBorder() + ")");
    }

    @Override
    public void onBindFooterViewHolder(BaseViewHolder holder, int groupPosition) {
        TestBean.DataBean bean = data.get(groupPosition);
        holder.setText(R.id.item_tv_volume_total, bean.getVolumeTotal() + " m³");
        holder.setText(R.id.item_tv_weight_total, bean.getWeightTotal() + " kg");
        holder.setText(R.id.item_tv_q_bales_total, bean.getQBalesTotal() + " 包");
    }

    @Override
    public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {
        TestBean.DataBean.PullerGoodsListBean pullerGoodsBean = data.get(groupPosition).getPullerGoodsList().get(childPosition);
        holder.setText(R.id.item_tv_container_no, pullerGoodsBean.getContainerNo());
        holder.setText(R.id.item_tv_in_date, pullerGoodsBean.getInDate());
        holder.setText(R.id.item_tv_order_no, pullerGoodsBean.getOrderNo());
        holder.setText(R.id.item_tv_volume_unit, pullerGoodsBean.getVolumeUnit() + " m³");
        holder.setText(R.id.item_tv_weight_unit, pullerGoodsBean.getWeightUnit() + " kg");
        holder.setText(R.id.item_tv_q_bales, pullerGoodsBean.getQBales() + " 包");
    }
}

