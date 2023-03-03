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

import edu.poly.shop.domain.Customer;
import edu.poly.shop.domain.Order;
import edu.poly.shop.model.ReportDto;
import edu.poly.shop.repository.OrderRepository;
import edu.poly.shop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public <S extends Order> S save(S entity) {
		return orderRepository.save(entity);
	}

	

	public List<ReportDto> listReport(int thang) {
		return orderRepository.listReport(thang);
	}



	@Override
	public List<Order> findByCustomerCustomerId(Integer customer) {
		return orderRepository.findByCustomerCustomerId(customer);
	}
	
	
	@Override
	public <S extends Order> Optional<S> findOne(Example<S> example) {
		return orderRepository.findOne(example);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@Override
	public List<Order> findAll(Sort sort) {
		return orderRepository.findAll(sort);
	}

	@Override
	public List<Order> findAllById(Iterable<Integer> ids) {
		return orderRepository.findAllById(ids);
	}

	@Override
	public <S extends Order> List<S> saveAll(Iterable<S> entities) {
		return orderRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		orderRepository.flush();
	}

	@Override
	public <S extends Order> S saveAndFlush(S entity) {
		return orderRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
		return orderRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Order> findById(Integer id) {
		return orderRepository.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Order> entities) {
		orderRepository.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return orderRepository.existsById(id);
	}

	@Override
	public <S extends Order> long count(Example<S> example) {
		return orderRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Order> entities) {
		orderRepository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Order> boolean exists(Example<S> example) {
		return orderRepository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		orderRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return orderRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void deleteAllInBatch() {
		orderRepository.deleteAllInBatch();
	}

	@Override
	public void deleteById(Integer id) {
		orderRepository.deleteById(id);
	}

	@Override
	public Order getOne(Integer id) {
		return orderRepository.getOne(id);
	}

	@Override
	public void delete(Order entity) {
		orderRepository.delete(entity);
	}

	@Override
	public Order getById(Integer id) {
		return orderRepository.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		orderRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Order> entities) {
		orderRepository.deleteAll(entities);
	}

	@Override
	public Order getReferenceById(Integer id) {
		return orderRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example) {
		return orderRepository.findAll(example);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
		return orderRepository.findAll(example, sort);
	}



	@Override
	public List<ReportDto> listReport(String thang) {
		// TODO Auto-generated method stub
		return null;
	}




}
