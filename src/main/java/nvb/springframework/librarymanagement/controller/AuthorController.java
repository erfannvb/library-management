package nvb.springframework.librarymanagement.controller;

import lombok.AllArgsConstructor;
import nvb.springframework.librarymanagement.model.Author;
import nvb.springframework.librarymanagement.service.AuthorService;
import nvb.springframework.librarymanagement.service.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping("/list")
    public String listAuthors(Model model) {
        List<Author> authorList = authorService.findAll();
        model.addAttribute("authors", authorList);
        return "list-authors";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Author author = new Author();
        model.addAttribute("authors", author);
        return "author-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Author author = authorService.findAuthorById(id);
        model.addAttribute("authors", author);
        return "author-form";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("authors") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/author/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        authorService.deleteAuthorById(id);
        return "redirect:/author/list";
    }

}
