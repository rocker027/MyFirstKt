fun main() {
    val strValidate = StringFormat()
    val exStr01 = "abcd"
    val exStr02 = "5abbd"
    val exStr03 = ".abbd"
    val exStr04 = "@abbd"
    val exStr05 = "_abbd"
    val exStr06 = "a999.9"
    val exStr07 = "a9999"
    println("String : $exStr01 , result : ${strValidate.validate(exStr01)}")
    println("String : $exStr02 , result : ${strValidate.validate(exStr02)}")
    println("String : $exStr03 , result : ${strValidate.validate(exStr03)}")
    println("String : $exStr04 , result : ${strValidate.validate(exStr04)}")
    println("String : $exStr05 , result : ${strValidate.validate(exStr05)}")
    println("String : $exStr06 , result : ${strValidate.validate(exStr06)}")
    println("String : $exStr07 , result : ${strValidate.validate(exStr07)}")

}


class StringFormat {
    private val NUMBER_IS_FIRST = true
    private val IS_NULL_OR_EMPTY = true
    var result: Boolean = false

    /**
     * 字串驗證方法
     * @param str (String) 傳入需要檢查的字串
     * @return (Boolean)
     * true : 驗證正確
     * false : 驗證錯誤
     */
    fun validate(str: String): Boolean {

        /**
         * 1. 驗證是否為null or 空字串
         *
         * @return (Boolean)
         * true : 回傳驗證錯誤
         * false : 流程繼續向下走
         */
        result = isEmpty(str)
        if (result == IS_NULL_OR_EMPTY) {
            println("驗證錯誤的原因為 : 為空字串 或是 null")
            return false
        }

        /**
         * 2. 驗證第一個字元是否為數字
         *
         * @return
         * true : 回傳驗證錯誤
         * false : 流程繼續向下走
         */
        result = isNumberFirst(str)
        if (result == NUMBER_IS_FIRST) {
            println("驗證錯誤的字元為 : ${str.first()}")
            return false
        }

        /**
         * 3. 驗證每個字元是否為大小寫 a ~ z , 0 ~ 9 , _
         *
         * 透過 onEach 取出每個字元，進行 when 迴圈條件驗證
         * 也可以用 str.forEachIndexed 方式去作
         *
         * @return (Boolean)
         * true : 回傳驗成正確
         * false : 回傳驗證錯誤
         */
        str.onEach {
            when {
                isLetter(it) -> result = true
                isDigit(it) -> result = true
                isUnderLine(it) -> result = true
                else -> {
                    println("驗證錯誤的字元為 : $it")
                    return@validate false
                }
            }
        }

        return result

    }

    /**
     * 字串驗證方法 V2
     * @param str (String) 傳入需要檢查的字串
     * @return (Boolean)
     * true : 驗證正確
     * false : 驗證錯誤
     */
    fun validateV2(str: String): Boolean {

        /**
         * 1. 驗證是否為null or 空字串
         *
         * @return (Boolean)
         * true : 回傳驗證錯誤
         * false : 流程繼續向下走
         */
        result = isEmpty(str)
        if (result == IS_NULL_OR_EMPTY) {
            println("驗證錯誤的原因為 : 為空字串 或是 null")
            return false
        }

        /**
         * 2. 驗證第一個字元是否為數字與其他字元是否正確
         *
         * @return
         * true : 回傳驗證錯誤
         * false : 流程繼續向下走
         */
        str.forEachIndexed { index, c ->
            when {
                index == 0 -> {
                    if (isDigit(c) == true) {
                        return@validateV2 false
                    }

                    if (isLetter(c) == false && isUnderLine(c) == false) {
                        return@validateV2 false
                    }

                    result = true
                }
                else -> {
                    when {
                        isLetter(c) -> result = true
                        isDigit(c) -> result = true
                        isUnderLine(c) -> result = true
                        else -> {
                            println("驗證錯誤的字元為 : $c")
                            return@validateV2 false
                        }
                    }
                }
            }
        }


        return result

    }

    /**
     * 檢驗是否為底線 _
     *
     * @param c (Char) 單一字元
     * @return (Boolean)
     * true : 回傳驗成正確
     * false : 回傳驗證錯誤
     */
    private fun isUnderLine(c: Char): Boolean = ('_').equals(c)

    /**
     * 檢驗是否為底線 _
     *
     * @param c (Char) 單一字元
     * @return (Boolean)
     * true : 回傳驗成正確
     * false : 回傳驗證錯誤
     */
    private fun isLetter(c: Char): Boolean = c in 'a'..'z' || c in 'A'..'Z'

    /**
     * 檢驗是否為數字
     *
     * @param c (Char) 單一字元
     * @return (Boolean)
     * true : 回傳驗成正確
     * false : 回傳驗證錯誤
     */
    private fun isDigit(c: Char): Boolean = c in '0'..'9'

    /**
     * 檢驗是否為第一個字元是否為數字
     * 透過 first() 取出第一個字進行判斷是否為數字
     *
     * @param str (String) 檢驗字串
     * @return (Boolean)
     * true : 第一個字為數字
     * false : 非數字開頭字串
     */
    private fun isNumberFirst(str: String): Boolean = isDigit(str.first()) == NUMBER_IS_FIRST

    /**
     * 檢驗是否為null or empty
     *
     * @param str (String) 檢驗字串
     * @return (Boolean)
     * true : 為 null or empty
     * false : 一般正常字串
     */
    private fun isEmpty(str: String): Boolean = str.isNullOrEmpty()

}