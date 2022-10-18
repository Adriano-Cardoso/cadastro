package com.cadastro.pessoa.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PessoaResponse {

    private Long pessoaId;

    private String nome;

    private String cpf;

    private String cep;

    private String endereco;

    private Integer numero;
}
