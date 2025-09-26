package com.calyrsoft.ucbp1.feature.profile.domain.model

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Cellphone
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Email
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Name
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.PathUrl
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Summary
import org.junit.Assert.assertEquals
import org.junit.Test

class ProfileModelTest {

    @Test
    fun `construccion de ProfileModel con VOs`() {
        val model = ProfileModel(
            pathUrl = PathUrl.create("https://example.com/pic.jpg"),
            name = Name.create("Maria Lopez"),
            email = Email.create("maria@correo.com"),
            cellphone = Cellphone.create("+59170000000"),
            summary = Summary.create("Desarrolladora Android")
        )

        assertEquals("https://example.com/pic.jpg", model.pathUrl.value)
        assertEquals("Maria Lopez", model.name.value)
        assertEquals("maria@correo.com", model.email.value)
        assertEquals("+59170000000", model.cellphone.value)
        assertEquals("Desarrolladora Android", model.summary.value)
    }
}