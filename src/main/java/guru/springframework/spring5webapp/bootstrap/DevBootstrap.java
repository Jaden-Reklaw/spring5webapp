package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepo;
import guru.springframework.spring5webapp.repositories.BookRepo;
import guru.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private PublisherRepo publisherRepo;

    public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setAddress("123 Main St, Minneapolis, MN 49548");
        publisherRepo.save(publisher);

        //Eric
        Author author1 = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "1234", publisher);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepo.save(author1);
        bookRepo.save(book1);

        //Rod
        Author author2 = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development with EJB", "23444", publisher);
        author2.getBooks().add(book2);

        authorRepo.save(author2);
        bookRepo.save(book2);
    }
}
