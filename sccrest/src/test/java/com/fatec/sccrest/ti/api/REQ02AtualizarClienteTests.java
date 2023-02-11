package com.fatec.sccrest.ti.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fatec.sccrest.model.Cliente;
import com.fatec.sccrest.model.ClienteDTO;
import com.fatec.sccrest.model.ClienteRepository;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class REQ02AtualizarClienteTests {
	@Autowired
	private TestRestTemplate testRestTemplate;
	@Autowired
	private ClienteRepository repository;
	String urlBase = "/api/v1/clientes";
	
	@Test
	void ct01_atualizar_informacoes_de_cliente_com_sucesso() {
		
		// quando cadastra cliente valido
		ClienteDTO cliente = new ClienteDTO("Jose Pedro", "02/04/1960", "M", "43011831084", "04280130", "1234");
		HttpEntity<ClienteDTO> httpEntity = new HttpEntity<ClienteDTO>(cliente);
		ResponseEntity<String> resposta = testRestTemplate.exchange(urlBase +"/1", HttpMethod.PUT, httpEntity, String.class);
		// Entao retorna os detalhes do cliente
		//assertEquals(HttpStatus.OK, resposta.getStatusCode());
		Optional<Cliente> re = repository.findByCpf("43011831084");
		//System.out.println(">>>>>>" + re.get().getDataCadastro());
		//assertTrue(re.isPresent());
		System.out.println(">>>>>>" + resposta.getBody());
	}
	@Test
	void ct02_atualizar_informacoes_de_cliente_com_id_invalido() {
		
		// quando cadastra cliente valido
		ClienteDTO cliente = new ClienteDTO("Jose Pedro", "02/04/1960", "M", "43011831084", "04280130", "1234");
		HttpEntity<ClienteDTO> httpEntity = new HttpEntity<ClienteDTO>(cliente);
		ResponseEntity<String> resposta = testRestTemplate.exchange(urlBase + "/9", HttpMethod.PUT, httpEntity, String.class);
		// Entao retorna os detalhes do cliente
		assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
		Optional<Cliente> re = repository.findByCpf("43011831084");
		//System.out.println(">>>>>>" + re.get().getDataCadastro());
		assertFalse(re.isPresent());
		System.out.println(">>>>>>" + resposta.getBody());
	}
}
