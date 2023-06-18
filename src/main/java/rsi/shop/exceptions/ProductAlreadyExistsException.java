package rsi.shop.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String name) {
        super("Product with given name: [" + name + "] already exists.");
    }
}
