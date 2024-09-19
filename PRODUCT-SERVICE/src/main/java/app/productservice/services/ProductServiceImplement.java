package app.productservice.services;

import app.productservice.dtos.ProductDto;
import app.productservice.dtos.ProductMapper;
import app.productservice.dtos.ProductToSaveDto;
import app.productservice.models.Product;
import app.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImplement implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImplement(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto saveProduct(ProductToSaveDto productToSaveDto) {
        Product product = productMapper.toEntity(productToSaveDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return productMapper.toDto(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productRepository.delete(product);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        existingProduct.setName(String.valueOf(productDto.name()));
        existingProduct.setDescription(String.valueOf(productDto.description()));
        existingProduct.setPrice(productDto.price());
        existingProduct.setStock(productDto.stock());

        Product updatedProduct = productRepository.save(existingProduct);

        return productMapper.toDto(updatedProduct);
    }
}