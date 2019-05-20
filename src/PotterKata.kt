fun main() {
//    println("購買書籍 ： , ${JavaBook(2).getPrice()}")
}

class PotterKata {
    val BOOK_PRICE = 100
    var javaBookCount = 0
    var iosBookCount = 0

    fun buyBookTotalPrice(count: Int): Int {
        val price: Int = when (count) {
            1 -> BOOK_PRICE
            2 -> ((BOOK_PRICE * 2) * 0.95).toInt()
            3 -> ((BOOK_PRICE * 3) * 0.9).toInt()
            4 -> ((BOOK_PRICE * 4) * 0.8).toInt()
            5 -> ((BOOK_PRICE * 5) * 0.75).toInt()
            else -> BOOK_PRICE * count
        }
        return price
    }

//    fun buyBookTotalPriceGroupByBook(books: List<BaseBook>): Int {
//        books.onEach {
//            when (it) {
//                is JavaBook -> javaBookCount += 1
//                else -> iosBookCount += 1
//            }
//        }
//
//    }
}


abstract class BaseBook(val count: Int) {
    abstract val name: String
    val PRICE = 100

    fun getPrice(): Int {
        return PRICE * count
    }

    fun getBookName(): String {
        return name
    }
}
