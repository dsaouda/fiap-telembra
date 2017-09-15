package com.github.dsaouda.fiaptelembra.repository

import com.github.dsaouda.fiaptelembra.model.Login
import org.springframework.data.jpa.repository.JpaRepository

interface LoginRepository : JpaRepository<Login, Long>