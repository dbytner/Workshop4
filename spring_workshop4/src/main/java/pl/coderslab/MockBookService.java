package pl.coderslab;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MockBookService {

    private static Long nextId = 4L;
    private List<Book> list;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getList(){
        return list;
    }

    public void add(Book book) {
        book.setId(nextId++);
        list.add(book);
    }

    public Optional<Book> readBook(long id){
        return list.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MockBookService.nextId = nextId;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
