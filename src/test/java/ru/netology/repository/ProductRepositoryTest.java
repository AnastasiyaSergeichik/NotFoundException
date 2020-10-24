package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    //private Book coreJava = new Book();
    private Product book1 = new Book(1, "first book", 2500, "Author1", 380, 2015);
    private Product book2 = new Book(5, "second book", 250, "Author2", 500, 2019);
    private Product tshirt1 = new TShirt(10, "TShirt1", 300, "white", "M");
    private Product tshirt2 = new TShirt(15, "TShirt2", 500, "black", "S");
    private Product product1 = new Product(12, "product1", 150);
    private Product product2 = new Product(13, "product2", 200);

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(tshirt1);
        repository.save(tshirt2);
        repository.save(product1);
        repository.save(product2);
    }

    @Test
    public void removeByIdCorrect() {
        repository.removeById(5);

        Product[] expected = new Product[]{book1, tshirt1, tshirt2, product1, product2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(6));
    }
}
