package com.lld.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
		//adding another obj data in cache
		Cache cache=new Cache(1,2);
		User u1=new User(1,"charu");
		User u2=new User(2,"charu");
		User u3=new User(3,"charu");
		User u4=new User(4,"charu");
		cache.put(u1.id,u1);
		cache.put(u2.id,u2);
		cache.put(u3.id,u3);
		cache.put(u4.id,u4);
		cache.put(u1.id,u1);
		cache.print();
		cache.get(4);
		cache.print();
		cache.get(4);
		cache.print();

		//adding only integer data to cache
		Cache cache1=new Cache(1,2);
		cache1.put(1,1);
		cache1.put(2,2);
		cache1.put(3,3);
		cache1.put(4,4);
		cache1.put(1,1);
		cache1.print();
		cache1.get(4);
		cache1.print();
		cache1.get(4);
		cache1.print();
	}

}
