package com.cadastro.pessoa.repository;

import com.cadastro.pessoa.domain.Pessoa;
import com.cadastro.pessoa.domain.dto.response.PessoaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("select new com.cadastro.pessoa.domain.dto.response.PessoaResponse(p.pessoaId, p.nome, p.cpf, p.cep, p.endereco, p.numero) From Pessoa p where p.cpf=:cpf")
    Optional<PessoaResponse> findByCpf(@Param("cpf") String cpf);


    @Query("select new com.cadastro.pessoa.domain.dto.response.PessoaResponse(p.pessoaId, p.nome, p.cpf, p.cep, p.endereco, p.numero) From Pessoa p")
    List<PessoaResponse> findAllPessoas();
}
