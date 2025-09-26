package com.calyrsoft.ucbp1.feature.profile.domain.model.vo

import com.calyrsoft.ucbp1.features.profile.domain.model.vo.PathUrl
import org.junit.Assert.assertEquals
import org.junit.Test

class PathUrlTest {

    @Test
    fun `url valida con https`() {
        val url = PathUrl.create("https://example.com/img.png")
        assertEquals("https://example.com/img.png", url.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `url vacia lanza error`() {
        PathUrl.create("   ")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `url sin http o https lanza error`() {
        PathUrl.create("ftp://example.com")
    }
}