package com.cadastro.pessoa.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PessoaUpdateRequest {

    private String cep;

    private String endereco;

    private Integer numero;
}
