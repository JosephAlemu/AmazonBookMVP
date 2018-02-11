package githubprofile.joseph.com.amazonbook.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import githubprofile.joseph.com.amazonbook.R;
import githubprofile.joseph.com.amazonbook.model.Book;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    List<Book> response = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.Adapter myAdapter;

    Presenter presenter;
    private String TAG = "mainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       presenter= new Presenter(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.books_recycler_view);

        presenter.loadBooks();

    }

    @Override
    public void success(List<Book> response) {

        this.response = response;

        Log.d(TAG,""+response.get(0));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new BookAdapter(response, R.layout.list_item_book,  getApplicationContext());
        mRecyclerView.setAdapter(myAdapter);

    }

    @Override
    public void failed(String message) {


        Log.e(TAG, "failed: "+message );
    }



}
