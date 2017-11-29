package dev.uublabs.week4daily3.view.booklist;

import java.util.List;

import dev.uublabs.week4daily3.model.Book;
import dev.uublabs.week4daily3.util.BasePresenter;
import dev.uublabs.week4daily3.util.BaseView;

/**
 * Created by Admin on 11/29/2017.
 */

public interface BookListContract
{
    //methods for booklist activity
    interface View extends BaseView
    {
        void setBooks(List<Book> books);
        void showProgress(String progress);
    }

    interface Presenter extends BasePresenter<View>
    {
        void getBooks();
    }
}
