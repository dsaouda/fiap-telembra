package com.github.dsaouda.fiaptelembra.repository

import com.github.dsaouda.fiaptelembra.model.Lembrete
import org.springframework.data.jpa.repository.JpaRepository

interface LembreteRepository : JpaRepository<Lembrete, Long>