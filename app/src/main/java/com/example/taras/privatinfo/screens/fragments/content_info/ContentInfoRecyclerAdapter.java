package com.example.taras.privatinfo.screens.fragments.content_info;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taras.privatinfo.R;
import com.example.taras.privatinfo.model.PrivatItem;

import java.util.List;
import java.util.TreeMap;

public class ContentInfoRecyclerAdapter extends RecyclerView.Adapter<CityVH> {

    private TreeMap<String, List<PrivatItem>> allPrivatItemsList;
    private TreeMap<String, List<PrivatItem>> showingList;
    private String[] mapKeys;
    private String searchText;

    public ContentInfoRecyclerAdapter(TreeMap<String, List<PrivatItem>> privatItemsTreeMap) {
        this.allPrivatItemsList = showingList = privatItemsTreeMap ;

        mapKeys = new String[allPrivatItemsList.size()];
        int pos = 0;
        for (String key : allPrivatItemsList.keySet()) {
            mapKeys[pos++] = key;
        }
    }

    @NonNull
    @Override
    public CityVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.vh_content_info, parent, false);
        return new CityVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityVH holder, int position) {
        ((CityVH) holder).bind(showingList.get(mapKeys[position]));
    }

    @Override
    public int getItemCount() {
        return showingList.size();
    }


    public void setCityForSearch(String text){
        this.searchText = text;
        if (searchText.trim().length() == 0){
            this.showingList = allPrivatItemsList;
            notifyDataSetChanged();
        } else {
            for (int i = 0; i < mapKeys.length; i++){
                if (mapKeys[i].toLowerCase().contains(searchText.toLowerCase())){
                    this.showingList.put(mapKeys[i], allPrivatItemsList.get(mapKeys[i]));
                }
            }
            this.notifyDataSetChanged();
        }
    }


    public void showMainCities(){

    }
}
