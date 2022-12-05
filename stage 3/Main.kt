fun main() {
    print("Enter the number of rows: ")
    val rows = readln().toInt()
    print("Enter the number of seats in each row: ")
    val columns = readln().toInt()
    println("Cinema:")
    val mart = MutableList(rows+1) { MutableList(columns+1) { "S" } }
    for(i in 1.rangeTo(mart[0].indices.last)){mart[0][i] = (i).toString()}
    mart[0][0]= buildString {
        append(" ")
    }
    for(i in 1.rangeTo(mart.indices.last)){for ((index, j) in mart[i].indices.withIndex()) {mart[i][j]=(i).toString(); if(index == 0) break}}
    for(i in mart.indices){println(mart[i].joinToString(" "))}
    println()
        print("Enter a row number: ")
    val sRow = readln().toInt()
    print("Enter a seat number in that row: ")
    val sNumber = readln().toInt()
    mart[sRow][sNumber] = "B"
    println()
    if (rows * columns <= 60){println("Ticket price: $10")}else if (sRow <= rows / 2){println("Ticket price: $10")}else{println("Ticket price: $8")}
    println("Cinema:")
    for(i in mart.indices){println(mart[i].joinToString(" "))}

}
