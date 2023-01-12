package br.com.lucasbdourado.domain;


import javax.persistence.*;
import java.util.List;

public class Acessorio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
    @SequenceGenerator(name = "acessorio_seq", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "acessorio", length = 50, nullable = false)
    private String acessorio;
}
