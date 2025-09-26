package com.calyrsoft.ucbp1.feature.profile.domain.model.vo

import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Cellphone
import org.junit.Assert.assertEquals
import org.junit.Test

class CellphoneTest {

    @Test
    fun `celular internacional`() {
        val c = Cellphone.create("+59170000000")
        assertEquals("+59170000000", c.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `celular invalido`() {
        Cellphone.create("abc-123")
    }
}