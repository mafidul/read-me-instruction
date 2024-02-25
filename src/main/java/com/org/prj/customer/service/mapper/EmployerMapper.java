package com.org.prj.customer.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.org.prj.customer.repository.entity.Login;
import com.org.prj.customer.service.model.LoginModel;

@Mapper(componentModel = "spring")
public interface EmployerMapper {

	Login toEntity(LoginModel source);

	List<LoginModel> toModel(Page<Login> source);

	LoginModel toModel(Login source);
	
	List<LoginModel> toModel(List<Login> source);
}
