package com.getinfo.contratos.repository;

import com.getinfo.contratos.entity.EnderecoEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoEmpresaRepository extends JpaRepository<EnderecoEmpresa, Long> {

}
