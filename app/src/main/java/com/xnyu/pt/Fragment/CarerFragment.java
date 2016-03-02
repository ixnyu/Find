package com.xnyu.pt.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.xnyu.pt.Bean.CarerBean;
import com.xnyu.pt.Global.GlobalData;
import com.xnyu.pt.R;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by xnyu on 2016/1/17.
 */
public class CarerFragment extends Fragment {

    private OptionsPickerView mPickerView1;
    private OptionsPickerView mPickerView2;
    private OptionsPickerView mPickerView3;
    private OptionsPickerView mPickerView4;
    private ArrayList<String> mStrfilter1 = new ArrayList<>();
    private ArrayList<String> mStrfilter2 = new ArrayList<>();
    private ArrayList<String> mStrfilter3 = new ArrayList<>();
    private ArrayList<String> mStrfilter4 = new ArrayList<>();
    private SwipeRefreshLayout mSrfl;

    //private Handler mHandler = new Handler() {
    //    @Override
    //    public void handleMessage(Message msg) {
    //        super.handleMessage(msg);
    //        switch (msg.what) {
    //            case 1:
    //                mSrfl.setRefreshing(false);
    //                mMyAdapter.notifyDataSetChanged();
    //                break;
    //        }
    //    }
    //};
    private ListView mListView;
    private CarerBean mCarerBean;
    private List<List<CarerBean.DataEntity>> mLists;
    private MyAdapter mAdapter;
    private List<CarerBean.DataEntity> mCarer = new ArrayList<>();
    private int mPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = initView(inflater);
        return v;
    }

    @NonNull
    private View initView(LayoutInflater inflater) {
        View v = inflater.inflate(R.layout.fragment_find_carer, null);
        mListView = (ListView) v.findViewById(R.id.fragment_find_carer_lv);
        getDataFromNetwork();
        mSrfl = (SwipeRefreshLayout) v.findViewById(R.id.find_carer_srfl);
        //设置圆圈颜色
        mSrfl.setColorSchemeResources(R.color.bgWidgetBule);
        mSrfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataFromNetwork();
            }
        });
        LinearLayout filter1 = (LinearLayout) v.findViewById(R.id.carer_filter1);
        LinearLayout filter2 = (LinearLayout) v.findViewById(R.id.carer_filter2);
        LinearLayout filter3 = (LinearLayout) v.findViewById(R.id.carer_filter3);
        LinearLayout filter4 = (LinearLayout) v.findViewById(R.id.carer_filter4);
        mStrfilter1.add("不限");
        mStrfilter1.add("普通护工");
        mStrfilter1.add("高级护工");
        mStrfilter1.add("护士");
        mStrfilter2.add("不限");
        mStrfilter2.add("16-25");
        mStrfilter2.add("26-35");
        mStrfilter2.add("36-45");
        mStrfilter2.add("46-55");
        mStrfilter2.add("56以上");
        mStrfilter3.add("不限");
        mStrfilter3.add("1公里");
        mStrfilter3.add("3公里");
        mStrfilter3.add("5公里");
        mStrfilter3.add("10公里");
        mStrfilter4.add("不限");
        mStrfilter4.add("住家含餐");
        mStrfilter4.add("住家不含餐");
        mStrfilter4.add("不住家含餐");
        mStrfilter4.add("不住家不含餐");
        mPickerView1 = new OptionsPickerView(getActivity());
        mPickerView1.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
            }
        });
        mPickerView1.setPicker(mStrfilter1);
        filter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPickerView1.show();
            }
        });
        mPickerView2 = new OptionsPickerView(getActivity());
        mPickerView2.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
            }
        });
        mPickerView2.setPicker(mStrfilter2);
        filter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPickerView2.show();
            }
        });
        mPickerView3 = new OptionsPickerView(getActivity());
        mPickerView3.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
            }
        });
        mPickerView3.setPicker(mStrfilter3);
        filter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPickerView3.show();
            }
        });
        mPickerView4 = new OptionsPickerView(getActivity());
        mPickerView4.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
            }
        });
        mPickerView4.setPicker(mStrfilter4);
        filter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPickerView4.show();
            }
        });
        return v;
    }

    private void getDataFromNetwork() {
        OkHttpUtils.get().url(GlobalData.GET_SEARCH_CARER).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                mSrfl.setRefreshing(false);
            }

            @Override
            public void onResponse(String response) {
                parserData(response);
                mSrfl.setRefreshing(false);
            }
        });
    }

    private void parserData(String response) {
        mCarerBean = new Gson().fromJson(response, CarerBean.class);
        mLists = GlobalData.splitList(mCarerBean.getData(), 20);
        mPage = 0;
        mCarer.addAll(mLists.get(mPage));
        mAdapter = new MyAdapter();
        mListView.setAdapter(mAdapter);
    }



    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mCarer.size();
        }

        @Override
        public CarerBean.DataEntity getItem(int position) {
            return mCarer.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getActivity(),R.layout.fragment_carer_item, null);
                holder.head_img = (ImageView) convertView.findViewById(R.id.carer_head_iv_item);
                holder.lv_img = (ImageView) convertView.findViewById(R.id.carer_lv_iv_item);
                holder.carer_name = (TextView) convertView.findViewById(R.id.carer_name_tv_item);
                holder.carer_location = (TextView) convertView.findViewById(R.id.carer_location_tv_item);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (!TextUtils.isEmpty(getItem(position).getImg())) {
                Picasso.with(getActivity())
                        .load(getItem(position).getImg())
                        .placeholder(R.mipmap.home_head)
                        .error(R.mipmap.home_head)
                        .into(holder.head_img);
            }
            if (getItem(position).getLevel() == 1) {
                holder.lv_img.setImageResource(R.mipmap.carer_lv1);
            } else if (getItem(position).getLevel() == 2) {
                holder.lv_img.setImageResource(R.mipmap.carer_lv2);
            } else {
                holder.lv_img.setImageResource(R.mipmap.carer_lv3);
            }
            holder.carer_name.setText(getItem(position).getName());
            holder.carer_location.setText(getItem(position).getLocation());
            System.out.println(getItem(position).getPhoto());
            return convertView;
        }
    }

    class ViewHolder {
        public ImageView head_img;
        public ImageView lv_img;
        public TextView carer_name;
        public TextView carer_location;
    }


}