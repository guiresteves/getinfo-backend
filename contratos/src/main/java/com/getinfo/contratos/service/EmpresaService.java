package com.getinfo.contratos.service;

import com.getinfo.contratos.entity.Empresa;
import com.getinfo.contratos.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }

    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Optional<Empresa> atualizar(Long id, Empresa novaEmpresa) {
       Optional<Empresa> empresaExistente = empresaRepository.findById(id);

        if (empresaExistente.isPresent()) {
            Empresa empresa = empresaExistente.get();

            empresa.setCnpj(novaEmpresa.getCnpj());
            empresa.setRazaoSocial(novaEmpresa.getRazaoSocial());
            empresa.setNomeFantasia(novaEmpresa.getNomeFantasia());
            empresa.setTipo(novaEmpresa.getTipo());
            empresa.setIdEndereco(novaEmpresa.getIdEndereco());
            empresa.setIdResponsavel(novaEmpresa.getIdResponsavel());

            return Optional.of(empresaRepository.save(empresa));
        } else {
            return Optional.empty();
        }
    }

    public void deletar(Long id) {
        empresaRepository.deleteById(id);
    }




}
