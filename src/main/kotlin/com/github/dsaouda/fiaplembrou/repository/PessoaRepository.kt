package com.github.dsaouda.fiaplembrou.repository

import com.github.dsaouda.fiaplembrou.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface PessoaRepository : JpaRepository<Pessoa, Long>