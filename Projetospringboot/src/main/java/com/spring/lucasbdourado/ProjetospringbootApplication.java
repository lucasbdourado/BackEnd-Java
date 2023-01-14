package com.spring.lucasbdourado;

import com.spring.lucasbdourado.domain.Cliente;
import com.spring.lucasbdourado.repository.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.spring.lucasbdourado.repository")
@EntityScan("com.spring.lucasbdourado.*")
public class ProjetospringbootApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ProjetospringbootApplication.class);

    @Autowired
    private IClienteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetospringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("StartApplication...");
        Cliente cliente = createCliente();
        repository.save(cliente);
    }

    private Cliente createCliente() {
        return Cliente.builder()
                .cidade("SP")
                .cpf(11711295466L)
                .email("Teste@teste.com")
                .end("Praia")
                .estado("SP")
                .nome("Lucas Dourado")
                .numero(20)
                .tel(10203040L)
                .build();
    }

}
