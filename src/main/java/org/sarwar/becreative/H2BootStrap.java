package org.sarwar.becreative;

import org.sarwar.becreative.entity.User;
import org.sarwar.becreative.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2BootStrap implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Starting.....");
		userRepository.save(new User("Sai", "k", "Ram", 25, "M","2132211556", "722031122"));
		userRepository.save(new User("Nishanth", "H", "Sunkara", 23, "M","1122234455", "722032211"));
		userRepository.save(new User("Raj", null, "Reddy", 21, "M","1022998822", "123122322"));
		
		System.out.println("Printing.....");
		Iterable<User> users = userRepository.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
