package com.calyrsoft.ucbp1.feature.profile.domain.model.vo

import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Summary
import org.junit.Assert.assertEquals
import org.junit.Test

class SummaryTest {

    @Test
    fun `summary dentro del limite`() {
        val s = Summary.create("Android dev", maxLen = 50)
        assertEquals("Android dev", s.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `summary excede limite`() {
        Summary.create("x".repeat(51), maxLen = 50)
    }
}