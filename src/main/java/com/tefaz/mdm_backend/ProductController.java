package com.tefaz.mdm_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productHome")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getProductByID/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            return ResponseEntity.notFound().build(); // Handle not found case
        }
        return ResponseEntity.ok(product);  // Return successful response with product
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product existingProduct = productRepository.findById(product.getProductId()).orElseThrow();
        // Update relevant fields (consider using a copy method for safety)
        existingProduct.setName(product.getName());
        // Update other fields as needed
        productRepository.save(existingProduct);
        return ResponseEntity.ok(existingProduct);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        productRepository.delete(product);
        return ResponseEntity.noContent().build();
    }
}