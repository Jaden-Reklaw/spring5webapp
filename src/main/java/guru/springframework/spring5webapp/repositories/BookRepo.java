package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
