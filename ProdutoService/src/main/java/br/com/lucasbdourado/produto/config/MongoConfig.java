package br.com.lucasbdourado.produto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@Configuration
@EnableMongoRepositories(basePackages = "br.com.lucasbdourado.produto.repository")
public class MongoConfig {

}
