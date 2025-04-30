package com.getinfo.contratos.repository;

import com.getinfo.contratos.entity.TelefoneEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneEmpresaRepository extends JpaRepository<TelefoneEmpresa, Long> {
    // Aqui você pode adicionar métodos de consulta customizados, se precisar
}