package app.productservice.dtos;

import app.productservice.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper
{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto toDto(Product product);
    Product toEntity(ProductToSaveDto dto);
    Product saveDtoToEntity(ProductToSaveDto productToSaveDto);
}