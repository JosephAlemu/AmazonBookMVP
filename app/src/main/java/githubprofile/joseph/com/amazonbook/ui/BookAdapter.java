package githubprofile.joseph.com.amazonbook.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import githubprofile.joseph.com.amazonbook.R;
import githubprofile.joseph.com.amazonbook.model.Book;

import static android.content.ContentValues.TAG;
import static com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BooksViewHolder> {

    private List<Book> books;
    private int rowLayout;
    private Context context;

    Bitmap myImage;

    public BookAdapter(List<Book> books, int rowLayout, Context context) {
        this.setBooks(books);
        this.setRowLayout(rowLayout);
        this.setContext(context);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> repos) {
        this.books = repos;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static class BooksViewHolder extends RecyclerView.ViewHolder {
        LinearLayout reposLayout;
        TextView tvTitle;
        TextView tvAuther;
        ImageView ivBook;


        public BooksViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvAuther = (TextView) v.findViewById(R.id.tvAuther);
            ivBook = (ImageView) v.findViewById(R.id.ivBook);
        }
    }

    @Override
    public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new BooksViewHolder(view);
    }


    @Override
    public void onBindViewHolder(BooksViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: " + books.get(position).toString());
        holder.tvTitle.setText(books.get(position).getTitle());
        holder.tvAuther.setText(books.get(position).getAuthor());

        ImageView imageView = ((BooksViewHolder) holder).ivBook;
        String currentUrl = books.get(position).getImageURL();


        Glide.with(context)
                .load(currentUrl)
                .into(imageView);

    }

    @Override
    public int getItemCount() {
        return books.size();
    }


}

