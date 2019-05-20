import MyColor.*
import java.util.function.Consumer
import kotlin.math.min

data class Person(val name: String, val age: Int? = null)

fun main() {
    val persons = listOf(
        Person("divad"),
        Person("Bob", 20),
        Person("Tim", 2)
    )


    val person = persons.maxBy { it.age ?: 0 }
//    println("the oldest : $person")
//
//    mix(RED,RED)
//    mix(RED,RED)
//    mix(RED,GREEN)
//    getSamething(2)
    getTestValue()
}


enum class MyColor{
    RED , ORANGE , GREEN , YELLOW
}

fun mix(c1: MyColor, c2: MyColor) {
    when (setOf(c1, c2)) {
        setOf(RED, GREEN) -> println("test1")
        setOf(YELLOW, GREEN) -> println("test2")
        else -> println("test3")
    }
}

fun getSamething(number : Int) {
    when {
        number > 0 -> println("show bigger")
        number < 0 -> println("show smaller")
        else -> println("equal")

    }
}

fun getTestValue(){
    val oneToTen = 1..10
    val arrayList = ArrayList<Int>()

    for (i in oneToTen) {
        when {
            i % 3  == 0 -> {
                arrayList.add(i)
            }
            else -> {
            }
        }
    }

//    println("mod 3 list : ${
        arrayList.forEach(Consumer {
            print("$it ") })
//    }")

}