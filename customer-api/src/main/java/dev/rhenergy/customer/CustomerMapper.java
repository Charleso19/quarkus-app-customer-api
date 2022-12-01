package dev.rhenergy.customer;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    CustomerEntity toEntity(final Customer domain);

    Customer toDomain(final CustomerEntity entity);
}
