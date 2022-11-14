package nvb.springframework.librarymanagement.repository;

import nvb.springframework.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.bookName like %?1%" +
            "or b.isbn like %?1%" +
            "or b.serialName like %?1%" +
            "or b.bookAuthor like %?1%")
    List<Book> findByName(String name);

}
