package rsi.shop.api;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rsi.shop.api.dto.ProductDTO;
import rsi.shop.model.Product;
import rsi.shop.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/authors")
    @Operation(summary = "Get authors", description = "Get authors names")
    public ResponseEntity<String> getAuthors() {
        return ResponseEntity.ok("Magdalena Nowicka, Weronika Litkowska");
    }

    @GetMapping("/products/{id}")
    @Operation(summary = "Get product", description = "Get product by id")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProductOrException(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    @Operation(summary = "Get all products", description = "Get all products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/filter")
    @Operation(summary = "Get product by name", description = "Get product by name")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @PostMapping("/products")
    @Operation(summary = "Add product", description = "Add product")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.addProduct(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    @Operation(summary = "Update product", description = "Update product")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/products/{id}")
    @Operation(summary = "Delete product", description = "Delete product")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/products/size")
    @Operation(summary = "Get products number", description = "Get products number")
    public ResponseEntity<Integer> getProductsSize() {
        return ResponseEntity.ok(productService.getProductsCount());
    }


}
