package com.calyrsoft.ucbp1.feature.profile.domain.usecase

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Cellphone
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Email
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Name
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.PathUrl
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Summary
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository
import com.calyrsoft.ucbp1.features.profile.domain.usecase.GetProfileUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class GetProfileUseCaseTest {

    private class FakeProfileRepository(
        private val profile: ProfileModel
    ) : IProfileRepository {
        override suspend fun getProfile(): ProfileModel = profile
    }

    @Test
    fun `invoke retorna el profile del repo`() = runTest {
        val expected = ProfileModel(
            pathUrl   = PathUrl.create("https://example.com/me.png"),
            name      = Name.create("Juan Perez"),
            email     = Email.create("juan@correo.com"),
            cellphone = Cellphone.create("+59170000001"),
            summary   = Summary.create("Kotlin & Compose")
        )
        val repo = FakeProfileRepository(expected)
        val useCase = GetProfileUseCase(repo)

        val result = useCase()

        assertEquals(expected, result)
    }
}
