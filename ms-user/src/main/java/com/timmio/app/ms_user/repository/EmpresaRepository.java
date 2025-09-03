package com.timmio.app.ms_user.repository;

import com.timmio.app.ms_user.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    Optional<Empresa> findByNomeEmpresa(String nomeEmpresa);
}
