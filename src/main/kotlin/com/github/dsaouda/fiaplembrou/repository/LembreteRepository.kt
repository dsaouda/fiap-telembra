package com.github.dsaouda.fiaplembrou.repository

import com.github.dsaouda.fiaplembrou.model.Lembrete
import org.springframework.data.jpa.repository.JpaRepository

interface LembreteRepository : JpaRepository<Lembrete, Long>