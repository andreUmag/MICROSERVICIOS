package app.productservice.services;

import app.productservice.dtos.ProductDto;
import app.productservice.dtos.ProductToSaveDto;

public interface ProductService {
    ProductDto saveProduct(ProductToSaveDto productToSaveDto);

    ProductDto getProductById(Long id);

    void deleteProduct(Long id);

    ProductDto updateProduct(Long id, ProductDto productDto);
}
