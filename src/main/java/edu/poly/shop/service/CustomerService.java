package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Customer;

public interface CustomerService{

	<S extends Customer> List<S> findAll(Example<S> example, Sort sort);

	<S extends Customer> List<S> findAll(Example<S> example);

	void deleteAll();

	Customer getReferenceById(Integer id);

	void deleteAll(Iterable<? extends Customer> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	Customer getById(Integer id);

	void delete(Customer entity);

	Customer getOne(Integer id);

	void deleteById(Integer id);

	void deleteAllInBatch();

	long count();

	<S extends Customer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends Customer> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<Customer> entities);

	<S extends Customer> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<Customer> entities);

	Optional<Customer> findById(Integer id);

	<S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Customer> S saveAndFlush(S entity);

	void flush();

	<S extends Customer> List<S> saveAll(Iterable<S> entities);

	List<Customer> findAllById(Iterable<Integer> ids);

	List<Customer> findAll(Sort sort);

	Page<Customer> findAll(Pageable pageable);

	List<Customer> findAll();

	<S extends Customer> Optional<S> findOne(Example<S> example);

	<S extends Customer> S save(S entity);

	Customer findByUsername(String name);

	Customer login(String username, String password);

}
