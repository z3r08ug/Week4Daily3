package dev.uublabs.week4daily3.di.repolist;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.uublabs.week4daily3.view.booklist.BookListPresenter;

/**
 * Created by Admin on 11/29/2017.
 */

@Module
public class BookListModule
{
    @Provides
    @Singleton
    BookListPresenter providerBookListPresenter()
    {
        return new BookListPresenter();
    }
}
