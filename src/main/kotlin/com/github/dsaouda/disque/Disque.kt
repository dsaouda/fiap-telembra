package com.github.dsaouda.disque

import biz.paluch.spinach.DisqueClient
import biz.paluch.spinach.DisqueURI
import biz.paluch.spinach.api.AddJobArgs
import biz.paluch.spinach.api.DisqueConnection
import biz.paluch.spinach.api.Job
import biz.paluch.spinach.api.sync.DisqueCommands
import com.lambdaworks.redis.RedisCommandTimeoutException
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

class Disque {

    private val client: DisqueClient
    private val connection: DisqueConnection<String, String>
    private val sync: DisqueCommands<String, String>

    constructor(host: String) {
        client = DisqueClient.create(DisqueURI.create(host))
        connection = client.connect()
        sync = connection.sync()
    }

    fun addJob(queue: String, body: String) = sync.addjob(queue, body, 5, TimeUnit.SECONDS)

    fun addScheduleJob(queue: String, body: String, dateTimeExecute: LocalDateTime): String {

        val now = LocalDateTime.now()
        val seconds = now.until(dateTimeExecute, ChronoUnit.SECONDS)

        if (seconds <= 0) {
            return addJob(queue, body)
        }

        val args = AddJobArgs.builder()
            .delay(seconds, TimeUnit.SECONDS)
            .build()

        return sync.addjob(queue, body, 5, TimeUnit.SECONDS, args)
    }

    fun deamonGetJob(queue: String): Job<String, String> {
        while(true) {

            try {
                val job = sync.getjob(30, TimeUnit.SECONDS, queue)
                if (job == null) {
                    continue;
                }

                return job;
            } catch (e: RedisCommandTimeoutException) {
                sync.ping()
            }

        }
    }

    fun ackjob(vararg jobIds: String) = sync.ackjob(*jobIds)
}