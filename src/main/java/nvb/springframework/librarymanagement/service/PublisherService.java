package nvb.springframework.librarymanagement.service;

import lombok.AllArgsConstructor;
import nvb.springframework.librarymanagement.exception.NotFoundException;
import nvb.springframework.librarymanagement.model.Publisher;
import nvb.springframework.librarymanagement.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("not found with id %d", id)));
    }

    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }

}
