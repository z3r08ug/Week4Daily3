package dev.uublabs.week4daily3.di.repolist;

import javax.inject.Singleton;

import dagger.Component;
import dev.uublabs.week4daily3.BookList;

/**
 * Created by Admin on 11/29/2017.
 */

@Component(modules = BookListModule.class)
@Singleton
public interface BookListComponent
{

    void inject(BookList bookList);
}
