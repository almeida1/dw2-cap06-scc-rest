package com.fatec.sccrest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fatec.sccrest.model.Cliente;
import com.fatec.sccrest.model.ClienteRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	@Autowired
	ClienteRepository clienteRepository;

	@Bean
	CommandLineRunner initDatabase(ClienteRepository repository) {

		return args -> {
			repository.deleteAll();
			Cliente cliente1 = new Cliente("Jose da Silva", "01/03/1964", "M", "59672555598", "03694000", "2983");
			cliente1.setEndereco("Aguia de Haia");
			log.info("Preloading " + repository.save(cliente1));
			Cliente cliente2 = new Cliente("Carlos Alberto", "19/08/1970", "M", "16467548671", "04280130", "59");
			cliente2.setEndereco("Rua Frei Joao");
			log.info("Preloading " + repository.save(cliente2));
		};
	}
}
