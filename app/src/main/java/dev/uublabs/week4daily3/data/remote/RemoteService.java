package dev.uublabs.week4daily3.data.remote;

import java.util.List;

import dev.uublabs.week4daily3.model.Book;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Admin on 11/29/2017.
 */

public interface RemoteService
{
    @GET("books.json")
    Observable<List<Book>> getBooks();
}
