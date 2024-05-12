package com.company;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.dao.impl.UserRepositoryCustomImpl;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResumeDbAppSpringApplication {



	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppSpringApplication.class, args);
	}

//	@Autowired
//	private UserDaoInter userDao;
//
//	@Bean
//	public CommandLineRunner run(){
//		CommandLineRunner clr = new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				List<User> list = userDao.getAll("Huseynaga","Qurbanov",1);
//				System.out.println(list);
//			}
//		};
//
//		return clr;
//	}

	@Autowired
	private UserServiceInter userRepository;

	@Bean
	public CommandLineRunner run(){
		CommandLineRunner clr = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
//				User list = userRepository.getById(1);
//				list.setPassword("huseyn58");
//				userRepository.updateUser(list);
			}
		};

		return clr;
	}
}
