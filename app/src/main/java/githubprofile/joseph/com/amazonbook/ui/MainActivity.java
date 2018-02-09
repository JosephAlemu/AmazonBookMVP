package githubprofile.joseph.com.amazonbook.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import githubprofile.joseph.com.amazonbook.R;
import githubprofile.joseph.com.amazonbook.model.Book;
import githubprofile.joseph.com.amazonbook.rest.AmzBookEndPoint;
import githubprofile.joseph.com.amazonbook.rest.ApiClient;
import githubprofile.joseph.com.amazonbook.utility.Presenter;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    List<Book> response = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.Adapter myAdapter;

    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       presenter= new Presenter(this);

       // List<Book>  response =  presenter.loadBooks();

        presenter.loadBooks();



        mRecyclerView = (RecyclerView) findViewById(R.id.books_recycler_view);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new BookAdapter(this.response, R.layout.list_item_book,  getApplicationContext());

        mRecyclerView.setAdapter(myAdapter);

    }

    @Override
    public void success(List<Book> response) {

        this.response = response;

    }

    @Override
    public void failed(String message) {

    }



}
