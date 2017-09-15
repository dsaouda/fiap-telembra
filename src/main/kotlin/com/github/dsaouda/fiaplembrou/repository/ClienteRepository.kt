package com.github.dsaouda.fiaplembrou.repository

import com.github.dsaouda.fiaplembrou.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository <Cliente, Long>