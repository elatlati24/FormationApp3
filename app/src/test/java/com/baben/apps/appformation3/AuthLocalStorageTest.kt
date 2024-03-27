import com.baben.apps.appformation3.core.app.AuthLocalStorage
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class AuthLocalStorageTest {

    private lateinit var authLocalStorage: AuthLocalStorage
    private val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsInVzZXIiOiJqb2huZCIsImlhdCI6MTcxMTU0MjI0Nn0.Pl0L7k78aG15fJJtyKnom2755Ks5pJKLwDgPPoDWj30"

    @Before
    fun setUp() {
        authLocalStorage = AuthLocalStorage()
    }

    @Test
    fun enregistrerEtRendreUnToken() {
        // Arrange
        val tokenAttendu = token
        val mockAuthLocalStorage = mock(AuthLocalStorage::class.java)
        `when`(mockAuthLocalStorage.rendreToken()).thenReturn(tokenAttendu)

        // Act
        mockAuthLocalStorage.enregistrerToken(tokenAttendu)
        val tokenRendu = mockAuthLocalStorage.rendreToken()

        // Assert
        assertEquals(tokenAttendu, tokenRendu)
    }

    @Test
    fun vérifierSiLUtilisateurEstConnecté() {
        // Arrange
        val mockAuthLocalStorage = mock(AuthLocalStorage::class.java)
        `when`(mockAuthLocalStorage.estConnecte()).thenReturn(true)

        // Act
        val estConnecte = mockAuthLocalStorage.estConnecte()

        // Assert
        assertEquals(true, estConnecte)
    }

    @Test
    fun vérifierSiLUtilisateurNestPasConnecté() {
        // Arrange
        val mockAuthLocalStorage = mock(AuthLocalStorage::class.java)
        `when`(mockAuthLocalStorage.estConnecte()).thenReturn(false)

        // Act
        val estConnecte = mockAuthLocalStorage.estConnecte()

        // Assert
        assertEquals(false, estConnecte)
    }
}
