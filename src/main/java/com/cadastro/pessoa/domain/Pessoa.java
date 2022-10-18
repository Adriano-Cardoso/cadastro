package com.cadastro.pessoa.domain;

import com.cadastro.pessoa.domain.dto.request.PessoaRequest;
import com.cadastro.pessoa.domain.dto.request.PessoaUpdateRequest;
import com.cadastro.pessoa.domain.dto.response.PessoaResponse;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_pessoa")
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pessoaId;

    private String nome;

    private String cpf;

    private String cep;

    private String endereco;

    private Integer numero;

    public static Pessoa of(PessoaRequest pessoaRequest) {
        return Pessoa.builder().nome(pessoaRequest.getNome()).cpf(pessoaRequest.getCpf()).cep(pessoaRequest.getCep())
                .endereco(pessoaRequest.getEndereco()).numero(pessoaRequest.getNumero()).build();
    }

    public PessoaResponse toResponse() {
        return PessoaResponse.builder().pessoaId(this.getPessoaId()).nome(this.getNome()).cpf(this.getCpf())
                .cep(this.getCep()).endereco(this.getEndereco()).numero(this.getNumero()).build();
    }

    public void update(PessoaUpdateRequest pessoaUpdateRequest) {
        this.cep = pessoaUpdateRequest.getCep();
        this.endereco = pessoaUpdateRequest.getEndereco();
        this.numero = pessoaUpdateRequest.getNumero();
    }
}
