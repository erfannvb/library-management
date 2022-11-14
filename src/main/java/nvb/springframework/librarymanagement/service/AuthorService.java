package nvb.springframework.librarymanagement.service;

import lombok.AllArgsConstructor;
import nvb.springframework.librarymanagement.exception.NotFoundException;
import nvb.springframework.librarymanagement.model.Author;
import nvb.springframework.librarymanagement.model.Book;
import nvb.springframework.librarymanagement.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        Author author = null;
        if (authorOptional.isPresent()) {
            author = authorOptional.get();
        } else {
            throw new NotFoundException("Did not find author id - " + id);
        }
        return author;
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    public void addBook(Author author, Book book) {
        if (authorRepository.findById(author.getId()).isPresent()) {
            authorRepository.findById(author.getId()).get().getBookList().add(book);
        }
    }

    public Optional<Author> getAuthor(Long authorId) {
        return authorRepository.findById(authorId);
    }

}
