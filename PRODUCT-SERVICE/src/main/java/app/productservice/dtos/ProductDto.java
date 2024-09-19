package app.productservice.dtos;

public record ProductDto(Long id,
                         Long name,
                         Long description,
                         Integer price,
                         Integer stock) {
}

