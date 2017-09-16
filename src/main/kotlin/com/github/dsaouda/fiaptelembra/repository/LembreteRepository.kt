package com.github.dsaouda.fiaptelembra.repository

import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.model.Lembrete
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface LembreteRepository : JpaRepository<Lembrete, Long> {

    fun findByCliente(cliente: Cliente): List<Lembrete>

    @Query("select l from Lembrete l where l.enviadaEm is null and l.cliente = :cliente")
    fun findNaoEnviado(@Param("cliente") cliente: Cliente): List<Lembrete>

    @Query("select l from Lembrete l where l.enviadaEm is not null and l.cliente = :cliente")
    fun findEnviado(@Param("cliente") cliente: Cliente): List<Lembrete>

}