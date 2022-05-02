package homework2

fun main() {
    println("Введите количество секунд, прошедших с последнего посещения")
    val second: Int = readln().toInt()

    val result: String = agoToText(second)

    print("был(а) в сети $result")

}

fun agoToText(second: Int): String {
    return when {
        (second < 60) -> return "только что"
        (second < 60 * 60) -> return minuteAgo(second)
        (second < 60 * 60 * 24) -> return hoursAgo(second)
        (second < 60 * 60 * 24 * 2) -> return "сегодня"
        (second < 60 * 60 * 24 * 2 * 2) -> return "вчера"
        (second > 60 * 60 * 24 * 2 * 2) -> return "давно"

        else -> "Введите положительное значение"
    }
}

fun minuteAgo(second: Int): String {
    val minute: Int = second / 60
    return when {
        (minute == 1 || (minute % 10 == 1) && minute != 11) -> return "$minute минуту назад"
        (minute < 5) -> return "$minute минуты назад"
        (minute < 21 || (minute % 10) == 0) -> return "$minute минут назад"
        (minute % 10) < 5 -> return "$minute минуты назад"
        (minute % 10) < 10 -> return "$minute минут назад"

        else -> return "$second секунд назад"
    }
}

fun hoursAgo(second: Int): String {
    val hours: Int = second / (60 * 60)
    return when {
        (hours == 1 || (hours % 10 == 1) && hours != 11) -> return "$hours час назад"
        (hours < 5 || hours > 21) -> return "$hours часа назад"
        (hours < 21) -> return "$hours часов назад"
        else -> return "$second секунд назад"
    }
}




