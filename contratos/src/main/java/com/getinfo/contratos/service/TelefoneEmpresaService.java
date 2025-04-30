package com.getinfo.contratos.service;

import com.getinfo.contratos.entity.TelefoneEmpresa;
import com.getinfo.contratos.repository.TelefoneEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneEmpresaService {

    private final TelefoneEmpresaRepository repository;

    public TelefoneEmpresaService(TelefoneEmpresaRepository repository) {
        this.repository = repository;
    }

    public List<TelefoneEmpresa> listarTodos() {
        return repository.findAll();
    }

    public Optional<TelefoneEmpresa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public TelefoneEmpresa salvar(TelefoneEmpresa telefoneEmpresa) {
        return repository.save(telefoneEmpresa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
