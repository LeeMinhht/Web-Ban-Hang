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
import edu.poly.shop.domain.Order;
import edu.poly.shop.model.ReportDto;

public interface OrderService {

	<S extends Order> List<S> findAll(Example<S> example, Sort sort);

	<S extends Order> List<S> findAll(Example<S> example);

	void deleteAll();

	Order getReferenceById(Integer id);

	void deleteAll(Iterable<? extends Order> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	Order getById(Integer id);

	void delete(Order entity);

	Order getOne(Integer id);

	void deleteById(Integer id);

	void deleteAllInBatch();

	long count();

	<S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends Order> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<Order> entities);

	<S extends Order> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<Order> entities);

	Optional<Order> findById(Integer id);

	<S extends Order> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Order> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Order> S saveAndFlush(S entity);

	void flush();

	<S extends Order> List<S> saveAll(Iterable<S> entities);

	List<Order> findAllById(Iterable<Integer> ids);

	List<Order> findAll(Sort sort);

	Page<Order> findAll(Pageable pageable);

	List<Order> findAll();

	<S extends Order> Optional<S> findOne(Example<S> example);

	<S extends Order> S save(S entity);


	List<Order> findByCustomerCustomerId(Integer customer);

	List<ReportDto> listReport(String thang);

	List<ReportDto> listReport(int thang);





}
