package githubprofile.joseph.com.amazonbook.rest;

import java.util.List;

import githubprofile.joseph.com.amazonbook.model.Book;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Admin on 2/9/2018.
 */
public interface AmzBookEndPoint
{

    //http://de-coding-test.s3.amazonaws.com/books.json
    @GET("/books.json")
    Call<List<Book>> getBook();

}
