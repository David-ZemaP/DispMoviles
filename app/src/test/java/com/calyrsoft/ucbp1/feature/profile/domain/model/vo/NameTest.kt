package com.calyrsoft.ucbp1.feature.profile.domain.model.vo

import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Name
import org.junit.Assert.assertEquals
import org.junit.Test

class NameTest {

    @Test
    fun `nombre valido`() {
        val n = Name.create("Juan Pérez")
        assertEquals("Juan Pérez", n.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `nombre muy corto`() {
        Name.create("A")
    }
}