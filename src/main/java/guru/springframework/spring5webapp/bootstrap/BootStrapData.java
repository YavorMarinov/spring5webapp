package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author petur = new Author("Petar", "Pan");
        Book ddd = new Book("Black Pirate","xczcxzc");
        petur.getBook().add(ddd);
        ddd.getAuthors().add(petur);

        authorRepository.save(petur);
        bookRepository.save(ddd);

        Author rod = new Author("Ivan", "On tech");
        Book d2 = new Book("Bitcoin Masterclass", "32322");
        rod.getBook().add(d2);
        d2.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(d2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number if books:" + bookRepository.count());

    }
}