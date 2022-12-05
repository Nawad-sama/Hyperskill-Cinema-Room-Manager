fun money (a:Int, b:Int): Int{
    return if (a * b <= 60) a * b * 10
    else  if (a % 2 == 0 ) {((a / 2 * 8) + (a / 2 *10)) * b} else{((a / 2 * 10) + (1 + a / 2) * 8) * b }
}

fun main() {
 print("Enter the number of rows:")
 val a = readln().toInt()
 print("Enter the number of seats in each row:")
 val b = readln().toInt()
 println("Total income: $${money(a, b)}")
}
