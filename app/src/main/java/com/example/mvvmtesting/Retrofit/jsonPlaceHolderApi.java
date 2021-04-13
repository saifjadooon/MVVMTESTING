package com.example.mvvmtesting.Retrofit;
import com.example.mvvmtesting.Retrofit.ResponseModels.Comment;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface jsonPlaceHolderApi {

    @GET("comments")
    Call<List<Comment>> getPosts();
}
