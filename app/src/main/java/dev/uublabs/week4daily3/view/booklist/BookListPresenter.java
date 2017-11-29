package dev.uublabs.week4daily3.view.booklist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dev.uublabs.week4daily3.data.remote.RemoteDataSource;
import dev.uublabs.week4daily3.model.Book;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 11/29/2017.
 */

public class BookListPresenter implements BookListContract.Presenter
{
    BookListContract.View view;
    public static final String TAG = BookListPresenter.class.getSimpleName() + "_TAG";
    List<Book> bookList = new ArrayList<>();

    @Override
    public void attachView(BookListContract.View view)
    {
        this.view = view;
    }

    @Override
    public void detachView()
    {

    }

    @Override
    public void getBooks()
    {

        RemoteDataSource.getBookList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Book>>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {
                        view.showProgress("Downloading books...");
                    }

                    @Override
                    public void onNext(List<Book> books)
                    {
                        bookList.addAll(books);
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        view.showError(e.toString());
                    }

                    @Override
                    public void onComplete()
                    {
                        view.setBooks(bookList);
                        view.showProgress("Downloaded all books");
                    }
                });
    }


}
