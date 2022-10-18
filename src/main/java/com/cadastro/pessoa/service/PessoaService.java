package com.cadastro.pessoa.service;

import com.cadastro.pessoa.domain.Pessoa;
import com.cadastro.pessoa.domain.dto.request.PessoaRequest;
import com.cadastro.pessoa.domain.dto.request.PessoaUpdateRequest;
import com.cadastro.pessoa.domain.dto.response.PessoaResponse;
import com.cadastro.pessoa.repository.PessoaRepository;
import com.cadastro.pessoa.validation.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaResponse create (PessoaRequest pessoaRequest){
        this.pessoaRepository.findByCpf(pessoaRequest.getCpf()).ifPresent(c -> {
            throw Message.CPF_EXIST.asBusinessException();
        });

        Pessoa pessoa = Pessoa.of(pessoaRequest);

        this.pessoaRepository.save(pessoa);

        return pessoa.toResponse();
    }

    public PessoaResponse update (Long pessoaId, PessoaUpdateRequest pessoaUpdateRequest){
        Pessoa pessoa = this.pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> Message.NOT_FOUND_ID.asBusinessException());

        pessoa.update(pessoaUpdateRequest);

        return pessoa.toResponse();
    }

    public List<PessoaResponse> listAllPessoa(){
        return this.pessoaRepository.findAllPessoas();
    }

    public PessoaResponse findById(Long pessoaId){
        Pessoa pessoa = this.pessoaRepository.findById(pessoaId).orElseThrow(Message.NOT_FOUND_ID::asBusinessException);

        return pessoa.toResponse();
    }

    public void delete(Long pessoaId){
        Pessoa pessoa = this.pessoaRepository.findById(pessoaId).orElseThrow(Message.NOT_FOUND_ID::asBusinessException);
        this.pessoaRepository.delete(pessoa);
    }
}
