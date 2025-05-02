package com.getinfo.contratos.service;

import com.getinfo.contratos.entity.EnderecoEmpresa;
import com.getinfo.contratos.repository.EnderecoEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoEmpresaService {

    private final EnderecoEmpresaRepository repository;


    public EnderecoEmpresaService(EnderecoEmpresaRepository repository) {
        this.repository = repository;
    }

    public List<EnderecoEmpresa> listarTodos () {
        return repository.findAll();
    }
    public Optional<EnderecoEmpresa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public EnderecoEmpresa salvar(EnderecoEmpresa enderecoEmpresa) {
        return repository.save(enderecoEmpresa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
