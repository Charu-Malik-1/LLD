package com.lld.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
		Cache cache=new Cache(1,2);
		User u1=new User(1,"charu");
		User u2=new User(2,"charu");
		User u3=new User(3,"charu");
		User u4=new User(4,"charu");
		cache.put(u1);
		cache.put(u2);
		cache.put(u3);
		cache.put(u4);
		cache.put(u1);
		cache.print();
		cache.get(4);
		cache.print();
		cache.get(4);
		cache.print();
	}

}
