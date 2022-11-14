package nvb.springframework.librarymanagement.controller;

import lombok.AllArgsConstructor;
import nvb.springframework.librarymanagement.model.Book;
import nvb.springframework.librarymanagement.service.BookService;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books", bookList);
        return "list-books";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Book book = new Book();
        model.addAttribute("books", book);
        return "book-form";
    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("books", book);
        return "book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("books") Book book) {
        bookService.save(book);
        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books/list";
    }

    @GetMapping("/search")
    public String findBookByName(Model model, @Param("name") String name) {
        model.addAttribute("books", bookService.findBookByName(name));
        return "list-books";
    }

}
