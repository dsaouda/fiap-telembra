package com.github.dsaouda.fiaptelembra.repository

import com.github.dsaouda.fiaptelembra.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface PessoaRepository : JpaRepository<Pessoa, Long>