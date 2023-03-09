package ru.netology.product;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Продукт с id " + id + " не найден");
    }
}