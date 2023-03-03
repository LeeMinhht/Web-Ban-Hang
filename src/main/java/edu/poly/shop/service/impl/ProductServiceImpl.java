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

import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.repository.ProductRepositoty;
import edu.poly.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepositoty productRepositoty;

	@Override
	public <S extends Product> S save(S entity) {
		return productRepositoty.save(entity);
	}
	
	
	@Override
	public List<Product> findByCategoryCategoryId(Long categoryId) {
		return productRepositoty.findByCategoryCategoryId(categoryId);
	}


	@Override
	public <S extends Product> Optional<S> findOne(Example<S> example) {
		return productRepositoty.findOne(example);
	}

	@Override
	public List<Product> findAll() {
		return productRepositoty.findAll();
	}
	
	

	@Override
	public List<Product> findByNameContaining(String name) {
		return productRepositoty.findByNameContaining(name);
	}

	@Override
	public Page<Product> findByNameContaining(String name, Pageable pageable) {
		return productRepositoty.findByNameContaining(name, pageable);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepositoty.findAll(pageable);
	}
	

	@Override
	public List<Product> findAll(Sort sort) {
		return productRepositoty.findAll(sort);
	}

	@Override
	public List<Product> findAllById(Iterable<Long> ids) {
		return productRepositoty.findAllById(ids);
	}

	@Override
	public <S extends Product> List<S> saveAll(Iterable<S> entities) {
		return productRepositoty.saveAll(entities);
	}

	@Override
	public void flush() {
		productRepositoty.flush();
	}

	@Override
	public <S extends Product> S saveAndFlush(S entity) {
		return productRepositoty.saveAndFlush(entity);
	}

	@Override
	public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
		return productRepositoty.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productRepositoty.findAll(example, pageable);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepositoty.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Product> entities) {
		productRepositoty.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return productRepositoty.existsById(id);
	}

	@Override
	public <S extends Product> long count(Example<S> example) {
		return productRepositoty.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Product> entities) {
		productRepositoty.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Product> boolean exists(Example<S> example) {
		return productRepositoty.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		productRepositoty.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return productRepositoty.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return productRepositoty.count();
	}

	@Override
	public void deleteAllInBatch() {
		productRepositoty.deleteAllInBatch();
	}

	@Override
	public void deleteById(Long id) {
		productRepositoty.deleteById(id);
	}

	@Override
	public Product getOne(Long id) {
		return productRepositoty.getOne(id);
	}

	@Override
	public void delete(Product entity) {
		productRepositoty.delete(entity);
	}

	@Override
	public Product getById(Long id) {
		return productRepositoty.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		productRepositoty.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Product> entities) {
		productRepositoty.deleteAll(entities);
	}

	@Override
	public Product getReferenceById(Long id) {
		return productRepositoty.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		productRepositoty.deleteAll();
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example) {
		return productRepositoty.findAll(example);
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
		return productRepositoty.findAll(example, sort);
	}
	
	

}
