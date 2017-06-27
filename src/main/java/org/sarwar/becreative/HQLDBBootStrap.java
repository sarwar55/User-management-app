package org.sarwar.becreative;

import java.util.UUID;

import org.sarwar.becreative.entity.User;
import org.sarwar.becreative.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HQLDBBootStrap implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Starting.....");
		User user1 = new User("Sai", "k", "Ram", 25, "M","2132211556", "722031122");
		user1.setUserId(UUID.fromString("deba3089-3feb-4974-8042-2c7c96c10aea"));
		userRepository.save(user1);
		User user2 = new User("Nishanth", "H", "Sunkara", 23, "M","1122234455", "722032211");
		user2.setUserId(UUID.fromString("deba1289-3feb-4974-8042-2c7c96c10aea"));
		userRepository.save(user2);
		User user3 = new User("Raj", "KK", "Reddy", 21, "M","1022998822", "123122322");
		user3.setUserId(UUID.fromString("deba1289-3fac-4974-8042-2c7c96c10aea"));
		userRepository.save(user3);
		
		System.out.println("Printing.....");
		Iterable<User> users = userRepository.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
