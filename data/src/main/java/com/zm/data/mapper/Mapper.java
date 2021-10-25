package com.zm.data.mapper;

import com.zm.data.model.Dto;
import com.zm.testapp.domain.model.Domain;

public interface Mapper<TypeDto extends Dto, TypeDomain extends Domain> {

    TypeDomain mapToDomain(TypeDto dto);
}
