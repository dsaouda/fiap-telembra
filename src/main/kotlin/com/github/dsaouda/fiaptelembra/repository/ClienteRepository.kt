package com.github.dsaouda.fiaptelembra.repository

import com.github.dsaouda.fiaptelembra.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository <Cliente, Long>