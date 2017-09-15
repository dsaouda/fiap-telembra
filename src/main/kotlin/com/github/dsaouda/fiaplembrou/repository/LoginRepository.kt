package com.github.dsaouda.fiaplembrou.repository

import com.github.dsaouda.fiaplembrou.model.Login
import org.springframework.data.jpa.repository.JpaRepository

interface LoginRepository : JpaRepository<Login, Long>