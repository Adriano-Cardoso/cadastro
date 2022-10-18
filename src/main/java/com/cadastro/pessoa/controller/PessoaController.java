package com.cadastro.pessoa.controller;

import com.cadastro.pessoa.domain.dto.request.PessoaRequest;
import com.cadastro.pessoa.domain.dto.request.PessoaUpdateRequest;
import com.cadastro.pessoa.domain.dto.response.PessoaResponse;
import com.cadastro.pessoa.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Pessoa Endpoint", description = "Endpoints para cadastro de pessoas", tags = { "Pessoas Endpoint" })
@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaService pessoaService;


    @ApiOperation(value = "criar uma nova pessoa")
    @PostMapping
    public ResponseEntity<PessoaResponse> create(@RequestBody PessoaRequest pessoaRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pessoaService.create(pessoaRequest));
    }

    @ApiOperation(value = "atualizar pessoa")
    @PatchMapping("/{pessoaId}")
    public ResponseEntity<PessoaResponse> update(@PathVariable("pessoaId") Long pessoaId, @RequestBody PessoaUpdateRequest pessoaUpdateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pessoaService.update(pessoaId, pessoaUpdateRequest));
    }

    @ApiOperation(value = "buscar pessoas por id")
    @GetMapping("/{pessoaId}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable("pessoaId") Long pessoaId){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pessoaService.findById(pessoaId));
    }

    @ApiOperation(value = "buscar todas as pessoas")
    @GetMapping("/list")
    public ResponseEntity<List<PessoaResponse>> listAllPessoas(){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pessoaService.listAllPessoa());
    }

    @ApiOperation(value = "deletar pessoa por id")
    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<PessoaResponse> delete(@PathVariable("pessoaId") Long pessoaId){
        this.pessoaService.delete(pessoaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
