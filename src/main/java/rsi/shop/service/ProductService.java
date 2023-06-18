package rsi.shop.service;

import org.springframework.stereotype.Service;
import rsi.shop.api.dto.ProductDTO;
import rsi.shop.exceptions.ProductAlreadyExistsException;
import rsi.shop.model.Product;
import rsi.shop.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductOrException(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product with id: " + id +
                " not found"));
    }

    public void deleteProduct(Long id) {
        getProductOrException(id);
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, ProductDTO productDTO) {
        Product product = getProductOrException(id);
        productRepository.findByName(productDTO.getName()).ifPresent(p -> {
            if (p.getId() != id) {
                throw new ProductAlreadyExistsException(productDTO.getName());
            }
        });
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setExpirationDate(productDTO.getExpirationDate());
        productRepository.save(product);
    }

    public Product addProduct(ProductDTO productDTO) {
        if (productRepository.existsByName(productDTO.getName())) {
            throw new ProductAlreadyExistsException(productDTO.getName());
        }
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setExpirationDate(productDTO.getExpirationDate());
        return productRepository.save(product);
    }

    public int getProductsCount() {
        return productRepository.findAll().size();
    }
}
