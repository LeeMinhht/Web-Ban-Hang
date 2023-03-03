package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.Customer;
import edu.poly.shop.repository.CustomerRepository;
import edu.poly.shop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer login(String username,String password) {
		Customer optExitst = findByUsername(username);
		
		if(optExitst!=null && password.equals(optExitst.getPassword())) {
			optExitst.setPassword("");
			return optExitst;
		}
		return null;
		
	}
	
	//tìm kiếm theo tên
	@Override
	public Customer findByUsername(String name) {
		
		List<Customer> list = customerRepository.findAll();
		for (Customer customer : list) {		
			if(name.equals(customer.getName())) {
				return customer;
			}
		}
		return null;
		
	}
	@Override
	public <S extends Customer> S save(S entity) {
		return customerRepository.save(entity);
	}

	@Override
	public <S extends Customer> Optional<S> findOne(Example<S> example) {
		return customerRepository.findOne(example);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@Override
	public List<Customer> findAll(Sort sort) {
		return customerRepository.findAll(sort);
	}

	@Override
	public List<Customer> findAllById(Iterable<Integer> ids) {
		return customerRepository.findAllById(ids);
	}

	@Override
	public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
		return customerRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		customerRepository.flush();
	}

	@Override
	public <S extends Customer> S saveAndFlush(S entity) {
		return customerRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
		return customerRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {
		return customerRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		return customerRepository.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Customer> entities) {
		customerRepository.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return customerRepository.existsById(id);
	}

	@Override
	public <S extends Customer> long count(Example<S> example) {
		return customerRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Customer> entities) {
		customerRepository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Customer> boolean exists(Example<S> example) {
		return customerRepository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		customerRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Customer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return customerRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return customerRepository.count();
	}

	@Override
	public void deleteAllInBatch() {
		customerRepository.deleteAllInBatch();
	}

	@Override
	public void deleteById(Integer id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer getOne(Integer id) {
		return customerRepository.getOne(id);
	}

	@Override
	public void delete(Customer entity) {
		customerRepository.delete(entity);
	}

	@Override
	public Customer getById(Integer id) {
		return customerRepository.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		customerRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Customer> entities) {
		customerRepository.deleteAll(entities);
	}

	@Override
	public Customer getReferenceById(Integer id) {
		return customerRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		customerRepository.deleteAll();
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example) {
		return customerRepository.findAll(example);
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
		return customerRepository.findAll(example, sort);
	}
	
	
}
