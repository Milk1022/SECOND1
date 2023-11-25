fun main() {
    println("Введите строку:")
    val input = readLine()

    if (!input.isNullOrBlank()) {
        val compressedString = compressString(input)
        println("Результат: $compressedString")
    } else {
        println("Введена пустая строка ")
    }
}

fun compressString(input: String): String {
    if (input.length <= 1) {
        return input
    }

    val compressedStringBuilder = StringBuilder()
    var currentChar = input[0]
    var charCount = 1

    for (i in 1 until input.length) {
        if (input[i] == currentChar) {
            charCount++
        } else {
            compressedStringBuilder.append(currentChar)
            if (charCount > 1) {
                compressedStringBuilder.append(charCount)
            }
            currentChar = input[i]
            charCount = 1
        }
    }

    compressedStringBuilder.append(currentChar)
    if (charCount > 1) {
        compressedStringBuilder.append(charCount)
    }

    return compressedStringBuilder.toString()
}