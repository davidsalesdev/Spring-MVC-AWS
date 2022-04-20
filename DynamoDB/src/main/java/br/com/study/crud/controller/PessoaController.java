package br.com.study.crud.controller;

import br.com.study.crud.entity.Pessoa;
import br.com.study.crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/pessoa")
    public Pessoa saveEmployee(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa getPessoa(@PathVariable("id") String pessoaId) {
        return pessoaRepository.getPessoaById(pessoaId);
    }

    @DeleteMapping("/pessoa/{id}")
    public String deletePessoa(@PathVariable("id") String pessoaId) {
        return  pessoaRepository.delete(pessoaId);
    }

    @PutMapping("/pessoa/{id}")
    public String updatePessoa(@PathVariable("id") String pessoaId, @RequestBody Pessoa pessoa) {
        return pessoaRepository.update(pessoaId,pessoa);
    }
}
