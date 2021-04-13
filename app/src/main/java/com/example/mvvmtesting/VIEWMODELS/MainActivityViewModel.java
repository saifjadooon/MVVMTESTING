package com.example.mvvmtesting.VIEWMODELS;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.RequestQueue;
import com.example.mvvmtesting.Retrofit.ResponseModels.Comment;
import com.example.mvvmtesting.Retrofit.jsonPlaceHolderApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityViewModel extends AndroidViewModel {


    //we can get and set data
    private MutableLiveData<String> sTextMLD = new MutableLiveData<>();

    //we can only get data through live data but cannot set data
    public LiveData<String> sTextLD;

    //counstructor
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        initVar();
    }

    //setting vallue to LiveData
    private void initVar() {

        sTextLD = sTextMLD;

    }

    //method when button get data is clicked
    public void getDataButtonClicked() {

        //we will get data heree.....>>>
        getdata();


    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }

    private void getdata() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client) // Set HttpClient to be used by Retrofit
                .build();

        client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();

        jsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(jsonPlaceHolderApi.class);

        Call<List<Comment>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if (!response.isSuccessful()) {
                    sTextMLD.postValue(response.code() + "lol");
                    return;
                }

                List<Comment> comments = response.body();
                for (Comment comment : comments) {

                    String id = comment.getEmail().toString();

                }
                Gson hGson = new GsonBuilder().setPrettyPrinting().create();
                sTextMLD.postValue(hGson.toJson(comments));
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

                sTextMLD.postValue(t.getMessage());
                Log.i("dsd", t.getMessage());


            }
        });



          /*  requestQueue = Volley.newRequestQueue(getApplication());
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Constants.BASE_URL + Constants.comments, null, response -> {
                JSONArray jsonArray = response;
                try {
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String postId = String.valueOf(jsonObject.getInt("postId"));
                        String id = String.valueOf(jsonObject.getInt("id"));
                        String name = jsonObject.getString("name");
                        String email = jsonObject.getString("email");
                        String body = jsonObject.getString("body");

                        Comment comment = new Comment();
                        comment.setPostId(Integer.valueOf(postId));
                        comment.setId(Integer.valueOf(id));
                        comment.setName(name);
                        comment.setEmail(email);
                        comment.setBody(body);

                        Global.listData.add(comment);
                    }
                    sTextMLD.postValue(Global.listData.get(0).getEmail().toString());


           *//*         adapter.notifyDataSetChanged();//To prevent app from crashing when updating*//*
                    //UI through background Thread
                }
                catch (Exception w)
                {
                    Toast.makeText(getApplication(),w.getMessage(),Toast.LENGTH_LONG).show();
                    Log.i("error",w.getMessage());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplication(),error.getMessage(),Toast.LENGTH_LONG).show();
                    Log.i("error", error.getMessage());
                }
            });
            requestQueue.add(jsonArrayRequest);*/
    }
}