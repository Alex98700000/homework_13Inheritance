
package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product book1 = new Book(1, "Бородино", 100, "Лермонтов");
    Product book2 = new Book(52, "Шинель", 220, "Гоголь");
    Product book3 = new Book(57, "Дон кихот", 155, "Сервантес");
    Product smartphone1 = new Smartphone(101, "IPhone 11", 56000, "Apple");
    Product smartphone2 = new Smartphone(300, "IPhone 13", 98000, "Apple");
    Product smartphone3 = new Smartphone(151, "Samsung 16", 56000, "Sam");

    @Test
    public void repositoryTestOne() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repositoryTestTwo() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(book1.getId());

        Product[] expected = {book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void repositoryTestThree() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(300);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void noCorrectDeletionById() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(299)
        );

    }


}