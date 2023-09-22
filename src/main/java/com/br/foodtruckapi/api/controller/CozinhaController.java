package com.br.foodtruckapi.api.controller;

import com.br.foodtruckapi.domain.exception.EntidadeEmUsoExeception;
import com.br.foodtruckapi.domain.exception.EntidadeNaoEncontradaExeception;
import com.br.foodtruckapi.domain.model.Cozinha;
import com.br.foodtruckapi.domain.repository.CozinhaRepository;
import com.br.foodtruckapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.util.BeanDefinitionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    @GetMapping
    public List<Cozinha>listar(){
        return cozinhaRepository.todas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id){
        Cozinha cozinha = cozinhaRepository.buscarPorId(id);

        if (cozinha!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adcionar(@RequestBody Cozinha cozinha){
        return cadastroCozinhaService.salvar(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha ){
        Cozinha cozinhaAtual = cozinhaRepository.buscarPorId(id);

        if(cozinhaAtual!=null) {
          BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");

        cozinhaRepository.salvar(cozinhaAtual);
        return ResponseEntity.ok(cozinhaAtual);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> deletar(@PathVariable Long id){
      try {
            cadastroCozinhaService.excluir(id);

            return ResponseEntity.noContent().build();
      } catch (EntidadeNaoEncontradaExeception e){
          return ResponseEntity.notFound().build();
      }
      catch (EntidadeEmUsoExeception e){
          return ResponseEntity.status(HttpStatus.CONFLICT).build();
      }
    }
}
