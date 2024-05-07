package com.company;

import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserRepository;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
	private UserDaoImpl userRepository;

	@Bean
	public CommandLineRunner run(){
		CommandLineRunner clr = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				User list = userRepository.getById(1);
				System.out.println(list);
			}
		};

		return clr;
	}
}
