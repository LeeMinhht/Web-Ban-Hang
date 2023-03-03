package edu.poly.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Customer;
import edu.poly.shop.domain.Order;
import edu.poly.shop.model.ReportDto;

@Repository
public interface OrderRepository  extends JpaRepository<Order,Integer>{
	
	List<Order> findByCustomerCustomerId(Integer customer);
	
	@Query("SELECT new edu.poly.shop.model.ReportDto(MONTH(o.orderDate),SUM(o.amount)) FROM Order o where (MONTH(o.orderDate)=?1) GROUP BY MONTH(o.orderDate)")
	List<ReportDto> listReport(int thang);
	
}
