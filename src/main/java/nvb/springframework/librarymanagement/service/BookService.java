package nvb.springframework.librarymanagement.service;

import lombok.AllArgsConstructor;
import nvb.springframework.librarymanagement.exception.NotFoundException;
import nvb.springframework.librarymanagement.model.Book;
import nvb.springframework.librarymanagement.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("not found with id %d", id)));
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findBookByName(String name) {
        return bookRepository.findByName(name);
    }

}
