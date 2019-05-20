import kotlin.random.Random

fun main() {
    println()

    val yearsToCompute: Double
    yearsToCompute = 7.5e6

    val amount  = arrayListOf<Int>(1,2,3)
    amount.add(34)

    val number = Random.nextInt(10)
}

fun max(a: Int, b: Int): Int = if (a > b) a else b

class Ch02(val name: String , val age : Int)

class Test(val height : Int , val hh : Int)

enum class DaysEnum {
    Mon,THU,WED
}

fun testM() {
    for (i in 1..10 step 3) {
        println(i)
    }
}

