package ee.ivkhkdev.services;

<<<<<<< HEAD
import ee.ivkhkdev.apphelpers.AppHelper;
=======
import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Service;
>>>>>>> New update
import ee.ivkhkdev.model.Author;

import java.util.List;

<<<<<<< HEAD
public class AuthorService implements Service<Author>{
=======
public class AuthorService implements Service<Author> {
>>>>>>> New update
    private final List<Author> authors;
    private final AppHelper<Author> appHelperAuthor;

    public AuthorService(List<Author> authors, AppHelper<Author>  appHelperAuthor) {
<<<<<<< HEAD
         this.authors = authors;
         this.appHelperAuthor = appHelperAuthor;
=======
        this.authors = authors;
        this.appHelperAuthor = appHelperAuthor;
>>>>>>> New update
    }

    @Override
    public boolean add() {
        try {
            Author author = appHelperAuthor.create();
            if(author == null) {return false;}
            authors.add(author);
            return true;
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean edit(Author entity) {
        return false;
    }

    @Override
    public boolean remove(Author entity) {
        return false;
    }

    @Override
    public void print() {
        appHelperAuthor.printList(this.list());
    }

    @Override
    public List<Author> list() {
        return authors;
    }
}
<<<<<<< HEAD
=======

>>>>>>> New update
