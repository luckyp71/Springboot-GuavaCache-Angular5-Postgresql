package com.example.main.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

import org.springframework.context.annotation.Bean;

@Configuration
@EnableCaching
public class CacheConfig implements CachingConfigurer {

	@Bean
	@Override
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		
		//Singe object of employee 
		GuavaCache employeeCache = new GuavaCache("employee", CacheBuilder.newBuilder()
				//You could change the expiration time of cache bellow
				.expireAfterWrite(1, TimeUnit.MINUTES)
				.build());
		
		//List of employees
		GuavaCache employeesCache = new GuavaCache("employees", CacheBuilder.newBuilder()
				//You could change the expiration time of cache bellow
				.expireAfterWrite(1, TimeUnit.MINUTES)
				.build());
		
		//New employee
		GuavaCache newEmloyeeCache = new GuavaCache("newEmployee", CacheBuilder.newBuilder()
				.expireAfterWrite(1, TimeUnit.MINUTES)
				.build());
		
		//Updated employee
		GuavaCache updatedEmployeeCache = new GuavaCache("updatedEmployee", CacheBuilder.newBuilder()
				.expireAfterWrite(1, TimeUnit.MINUTES)
				.build());
		
		//Delete employee
		GuavaCache deleteEmployeeCache = new GuavaCache("deletedEmployee", CacheBuilder.newBuilder()
				.expireAfterWrite(1, TimeUnit.MINUTES)
				.build());
		
		cacheManager.setCaches(Arrays.asList(employeeCache,employeesCache, newEmloyeeCache, updatedEmployeeCache, deleteEmployeeCache));
		return cacheManager;
	}
		
	@Override
	public CacheResolver cacheResolver() {
		// this body code intentionally left blank
		return null;
	}

	@Override
	public CacheErrorHandler errorHandler() {
		// this body code intentionally left blank
		return null;
	}

	@Override
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

}
