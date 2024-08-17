import org.academy.codewars.entities.Author;
import org.academy.codewars.services.AuthorService;

public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    public Author getById(int id) {
        Author author = Author.findById(id);
        if (author == null) throw new IllegalArgumentException("ID must be a positive number.");
        return authorService.getById(id);
    }
}
