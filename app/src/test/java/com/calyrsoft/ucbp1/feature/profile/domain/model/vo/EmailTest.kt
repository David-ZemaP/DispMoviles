package com.calyrsoft.ucbp1.feature.profile.domain.model.vo

import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Email
import org.junit.Assert.assertEquals
import org.junit.Test

class EmailTest {

    @Test
    fun `email valido`() {
        val e = Email.create("user@example.com")
        assertEquals("user@example.com", e.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `email invalido`() {
        Email.create("user@")
    }
}