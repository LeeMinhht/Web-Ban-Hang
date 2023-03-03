package edu.poly.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.poly.shop.interceptor.AdminAuthenticationInterceptor;
import edu.poly.shop.interceptor.SiteAuthenticationInterceptor;

@Configuration
public class AuthenticationInterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private AdminAuthenticationInterceptor adminAuthenticationInterceptor;
	
	@Autowired
	private SiteAuthenticationInterceptor siteAuthenticationInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//kiểm tra đăng nhập cho admin
		registry.addInterceptor(adminAuthenticationInterceptor)
		.addPathPatterns("/admin/**");
		
		//kiểm tra đăng nhập cho site
		registry.addInterceptor(siteAuthenticationInterceptor)
		.addPathPatterns("/site/**");
	}
	
	
	//đẩy file upload lên ngang hàng với src để load ảnh lên giao diện
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/site/**")
	    .addResourceLocations("file:uploads/images").setCachePeriod(0);	
	}
	
	
}
