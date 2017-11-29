package dev.uublabs.week4daily3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dev.uublabs.week4daily3.di.repolist.DaggerBookListComponent;
import dev.uublabs.week4daily3.model.Book;
import dev.uublabs.week4daily3.view.booklist.BookListContract;
import dev.uublabs.week4daily3.view.booklist.BookListPresenter;

public class BookList extends AppCompatActivity implements BookListContract.View
{

    private static final String TAG = BookList.class.getSimpleName() + "_TAG";

    @Inject
    BookListPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        //DaggerRepoListComponent
        DaggerBookListComponent.create().inject(this);

        recyclerView = findViewById(R.id.rvBookList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);

        presenter.attachView(this);
        presenter.getBooks();
    }



    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showError(String error)
    {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setBooks(List<Book> books)
    {
        recyclerAdapter = new RecyclerAdapter(books);
        recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public void showProgress(String progress)
    {
        Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();
    }

}
