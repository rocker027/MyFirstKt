class BookUtils(val books: List<String>) {
    val ONE_BOOK_PRICE = 100

    fun groupBy(): MutableMap<String, Int?> {

        // group by
        val groupMap = mutableMapOf<String, Int?>()
        books.onEach {
            when {
                groupMap.containsKey(it) -> {
                    val count: Int? = groupMap[it]
                    groupMap.put(it, count?.plus(1))
                }
                else -> groupMap.put(it, 1)
            }
        }

        // print content
        groupMap.forEach {
            println("書籍: ${it.key} , 數量: ${it.value} , 總金額: ${it.value?.times(100)}")
        }

        return groupMap
    }

    fun getOneBooks(): Int = books.size

    /**
     * 取得書本分類數
     */
    fun getGroupSize(): Int = groupBy().entries.size

    /**
     * 取總共買幾本書
     */
    fun getBooksCount(): Int = books.size

    /**
     * 是否買兩本不一樣的書
     */
    fun isDiffTwoBooks(): Boolean = when {
        getBooksCount() != 2 -> false
        getGroupSize() != 2 -> false
        else -> true
    }

    /**
     * 兩本書的價錢
     * @return (Int)
     */
    fun getTwoBooksPrice(): Int = when {
        isDiffTwoBooks() == true ->
            (ONE_BOOK_PRICE * 2 * 0.95).toInt()
        else ->
            (ONE_BOOK_PRICE * 2)

    }

}