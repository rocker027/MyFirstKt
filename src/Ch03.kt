const val VALUE_TEST = 1001


fun main() {
    val arrayList: ArrayList<String> = arrayListOf("AAA", "BBB")
    val hashMap: HashMap<Int, String> = hashMapOf(1 to "one", 2 to "two")
    val str = "TEST"
    println(str.javaClass) // java class
    println(str::class) // kotlin class

    str.myfun()
    println(str)
}

fun String.myfun() {
    println("this is extension")
}


fun getArray(vararg strings: String): ArrayList<String> {
    val arrayList = arrayListOf<String>()
    for (str in strings) {
        arrayList.add(str)

    }
    return arrayList
}
