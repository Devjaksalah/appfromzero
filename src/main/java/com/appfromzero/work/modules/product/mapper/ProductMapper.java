package com.appfromzero.work.modules.product.mapper;

import com.appfromzero.work.modules.product.dto.ProductResponse;

import com.appfromzero.work.modules.product.model.Product;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  //  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductResponse toProductDTO(Product product);

    List<ProductResponse> toProductDTOs(List<Product> products);

    Product toProduct(ProductResponse productResponse);
}
