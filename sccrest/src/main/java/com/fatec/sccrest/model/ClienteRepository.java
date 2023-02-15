package com.fatec.sccrest.model;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Abstrai o acesso ao banco de dados. Nomes de metodos derivados tem duas partes separadas 
 * pela palavra-chave By. 
 * A primeira parte — como find seguido de By seguido de Cpf — se constitue no critério
 * de busca derivados de atributos onde cpf é um atributo da tabela no banco de dados.
 * @author 
 */
@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>{
	Optional<Cliente> findByCpf(String cpf);
	List<Cliente> findAllByNomeIgnoreCaseContaining(String nome);
}