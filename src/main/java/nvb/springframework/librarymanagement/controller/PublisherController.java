package nvb.springframework.librarymanagement.controller;

import lombok.AllArgsConstructor;
import nvb.springframework.librarymanagement.model.Publisher;
import nvb.springframework.librarymanagement.service.PublisherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
@AllArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping("/list")
    public String listPublishers(Model model) {
        List<Publisher> publisherList = publisherService.findAll();
        model.addAttribute("publishers", publisherList);
        return "list-publishers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("publishers", publisher);
        return "publisher-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Publisher publisher = publisherService.findPublisherById(id);
        model.addAttribute("publishers", publisher);
        return "publisher-form";
    }

    @PostMapping("/save")
    public String savePublisher(@ModelAttribute("publishers") Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/publisher/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        publisherService.deletePublisherById(id);
        return "redirect:/publisher/list";
    }

}
