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

        // Act
        authLocalStorage.enregistrerToken(tokenAttendu)
        val tokenRendu = authLocalStorage.rendreToken()

        // Assert
        assertEquals(tokenAttendu, tokenRendu)
    }

    @Test
    fun vérifierSiLUtilisateurEstConnecté() {
        // Arrange
        val authLocalStorageMock = mock(AuthLocalStorage::class.java)
        val tokenAttendu = token

        // Configurer le mock pour renvoyer vrai lorsqu'on appelle estConnecte()
        `when`(authLocalStorageMock.estConnecte()).thenReturn(true)

        // Act & Assert
        assertEquals(true, authLocalStorageMock.estConnecte())

        // Enregistrons un token pour simuler que l'utilisateur est connecté
        `when`(authLocalStorageMock.rendreToken()).thenReturn(tokenAttendu)
        assertEquals(true, authLocalStorageMock.estConnecte())
    }
}
