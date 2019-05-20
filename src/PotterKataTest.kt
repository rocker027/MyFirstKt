import com.sun.tools.corba.se.idl.constExpr.And
import org.junit.Assert.assertEquals
import org.junit.Test

class PotterKataTest {
    val JAVA = "java"
    val IOS = "ios"
    val Android = "android"

    @Test
    fun buyOneBook() {
        val books = listOf(JAVA)
        val bookUtils = BookUtils(books)
        assertEquals(100, bookUtils.getOneBooks() * 100)
    }

    @Test
    fun buyDiffTwoBook() {
        val books = listOf(JAVA, IOS)
        val bookUtils = BookUtils(books)
        val twoBooksPrice = bookUtils.getTwoBooksPrice()
        println("兩本書籍總金額: ${twoBooksPrice}")
        assertEquals(190, twoBooksPrice)
    }

    @Test
    fun buySameTwoBook() {
        val books = listOf(JAVA, JAVA)
        val bookUtils = BookUtils(books)
        val twoBooksPrice = bookUtils.getTwoBooksPrice()
        println("兩本書籍總金額: ${twoBooksPrice}")
        assertEquals(200, twoBooksPrice)
    }


    @Test
    fun buyThreeBook() {
    }

    @Test
    fun buyFourBook() {
    }

    @Test
    fun buyFiveBook() {
    }

}