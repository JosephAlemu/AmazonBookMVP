package githubprofile.joseph.com.amazonbook.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import githubprofile.joseph.com.amazonbook.model.Book;
import githubprofile.joseph.com.amazonbook.rest.AmzBookEndPoint;
import githubprofile.joseph.com.amazonbook.rest.ApiClient;
import githubprofile.joseph.com.amazonbook.ui.MainContract;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Retrofit;


import retrofit.Response;


/**
 * Created by Admin on 2/9/2018.
 */

public class Presenter {

    List<Book> myDataSource =  new ArrayList<>(); ;
    MainContract.View view;

    public Presenter(MainContract.View view)
    {
        this.view = view;

    }

    public List<Book> loadBooks(){



        final AmzBookEndPoint apiService = ApiClient.getClient().create(AmzBookEndPoint.class);

        Call<List<Book>> call = apiService.getBook();

           call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Response<List<Book>> response, Retrofit retrofit) {

                myDataSource.addAll(response.body());

                view.success(myDataSource);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


     return myDataSource;
    }




}
