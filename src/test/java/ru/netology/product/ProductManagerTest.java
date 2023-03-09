
package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void searchByNameTestOne() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Бородино", 300, "Лермонтов");
        Product book2 = new Book(52, "Шинель", 320, "Гоголь");
        Product book3 = new Book(57, "Дон Кихот", 155, "Сервантес");

        Product smartphone1 = new Smartphone(101, "IPhone 11", 56000, "Apple");
        Product smartphone2 = new Smartphone(300, "IPhone 13", 98000, "Apple");
        Product smartphone3 = new Smartphone(151, "Samsung 16", 56000, "Sam");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameTestTwo() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Бородино", 300, "Лермонтов");
        Product book2 = new Book(52, "Шинель", 320, "Гоголь");
        Product book3 = new Book(57, "Дон Кихот", 155, "Сервантес");
        Product smartphone1 = new Smartphone(101, "IPhone 11", 56000, "Apple");
        Product smartphone2 = new Smartphone(300, "IPhone 13", 98000, "Apple");
        Product smartphone3 = new Smartphone(151, "Samsung 16", 56000, "Sam");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Бородино");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameTestThree() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Бородино", 300, "Лермонтов");
        Product book2 = new Book(52, "Шинель", 320, "Гоголь");
        Product book3 = new Book(57, "Дон Кихот", 155, "Сервантес");
        Product smartphone1 = new Smartphone(101, "IPhone 11", 56000, "Apple");
        Product smartphone2 = new Smartphone(300, "IPhone 13", 98000, "Apple");
        Product smartphone3 = new Smartphone(151, "Samsung 16", 56000, "Sam");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("IPhone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameTestFour() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Бородино", 300, "Лермонтов");
        Product book2 = new Book(52, "Шинель", 320, "Гоголь");
        Product book3 = new Book(57, "Дон Кихот", 155, "Сервантес");
        Product smartphone1 = new Smartphone(101, "IPhone 11", 56000, "Apple");
        Product smartphone2 = new Smartphone(300, "IPhone 13", 98000, "Apple");
        Product smartphone3 = new Smartphone(151, "Samsung 16", 56000, "Sam");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Блок");

        Assertions.assertArrayEquals(expected, actual);
    }

}