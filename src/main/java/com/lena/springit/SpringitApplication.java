package com.lena.springit;

import com.lena.springit.config.SpringitProperties;
import com.lena.springit.model.Comment;
import com.lena.springit.model.Link;
import com.lena.springit.repository.CommentRepository;
import com.lena.springit.repository.LinkRepository;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
@EnableJpaAuditing
public class SpringitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LinkRepository linkRepo, CommentRepository commentRepo) {
		return args -> {
			Link link = new Link();
			link.setTitle("Google link");
			link.setUrl("https://google.com");
			linkRepo.save(link);

			Comment comment = new Comment();
			comment.setBody("What a nice link");
			comment.setLink(link);
			commentRepo.save(comment);

			Link byTitle = linkRepo.findByTitle(link.getTitle());
			System.out.println(byTitle.getTitle());
		};
	}
}
