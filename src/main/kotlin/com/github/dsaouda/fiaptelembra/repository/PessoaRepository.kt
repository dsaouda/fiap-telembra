package com.github.dsaouda.fiaptelembra.repository

import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PessoaRepository : JpaRepository<Pessoa, Long> {
    @Query("select p from Pessoa p where p.cliente = :cliente")
    fun findAll(@Param("cliente") cliente: Cliente): List<Pessoa>
}