package com.appfromzero.mapper;

import com.appfromzero.dto.ProductDTO;
import model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.description", target = "code")
      ProductDTO toProductDTO(Product product);

     List<ProductDTO> toProductDTOs(List<Product> products);

    @InheritInverseConfiguration
     Product toProduct(ProductDTO productDTO);
}
