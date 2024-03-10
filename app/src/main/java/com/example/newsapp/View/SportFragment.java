package com.example.newsapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.View.Adapter.Adapter;
import com.example.newsapp.Utilities.ApiUtilities;
import com.example.newsapp.Model.ModelClass;
import com.example.newsapp.R;
import com.example.newsapp.Model.mainNews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportFragment extends Fragment {

    String apiKey = "6ebdd180613e4bd685c5547ccbde6bbc";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "us";
    private RecyclerView recyclerViewofSport;

    private  String category = "sport";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sportfragment,null);
        recyclerViewofSport = v.findViewById(R.id.recyclerviewofsport);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofSport.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewofSport.setAdapter(adapter);

        findNews();

        return v;
    }

    private void findNews() {
       ApiUtilities.getApiIntertface().getCategoryNews(country,category,100,apiKey).enqueue(new Callback<mainNews>() {
           @Override
           public void onResponse(Call<mainNews> call, Response<mainNews> response) {
               if (response.isSuccessful()){
                   modelClassArrayList.addAll(response.body().getArticles());
                   adapter.notifyDataSetChanged();
               }
           }

           @Override
           public void onFailure(Call<mainNews> call, Throwable t) {

           }
       });
    }
}