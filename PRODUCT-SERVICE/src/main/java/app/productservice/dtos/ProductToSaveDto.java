package app.productservice.dtos;

public record ProductToSaveDto(Long id,
                               Long name,
                               Long description,
                               Integer price,
                               Integer stock) {
}

