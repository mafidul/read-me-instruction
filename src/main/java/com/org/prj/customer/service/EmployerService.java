package com.org.prj.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.org.prj.customer.service.model.EmployerSearchRequest;
import com.org.prj.customer.service.model.LoginDetailModel;
import com.org.prj.customer.service.model.LoginModel;

public interface EmployerService {

	LoginModel updateProfile(LoginModel source);

	LoginModel getProfileById(Long id);

	LoginModel createLogin(LoginModel loginModel);

	void deleteProfile(Long id);

	Page<LoginModel> searchEmployer(PageRequest pageRequest, EmployerSearchRequest searchRequest);

	LoginDetailModel login(LoginDetailModel loginModel);

	Page<LoginModel> findAll(Pageable pageable);
}
