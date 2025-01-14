package com.backbase.goldensample.product.mapper;

import com.backbase.goldensample.product.persistence.ProductEntity;
import com.backbase.product.api.service.v1.model.Product;
import com.backbase.product.event.spec.v1.ProductCreatedEvent;
import com.backbase.product.event.spec.v1.ProductDeletedEvent;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

  @Mapping(source = "id", target = "productId")
  Product entityToApi(ProductEntity entity);

  @Mapping(source = "id", target = "productId")
  ProductCreatedEvent entityToCreatedEvent(ProductEntity entity);

  @Mapping(source = "id", target = "productId")
  ProductDeletedEvent entityToDeletedEvent(ProductEntity entity);

  @Mapping(source = "productId", target = "id")
  ProductEntity apiToEntity(Product api);

  List<Product> entityListToApiList(List<ProductEntity> entity);

  List<ProductEntity> apiListToEntityList(List<Product> api);
}
