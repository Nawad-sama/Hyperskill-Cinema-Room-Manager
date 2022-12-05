fun test(): MutableList<MutableList<String>>{
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
    return mart
}

fun seat(mart: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
    print("Enter a row number: ")
    val sRow = readln().toInt()
    print("Enter a seat number in that row: ")
    println()
    val sNumber = readln().toInt()
    mart[sRow][sNumber] = "B"
    val rows = mart.lastIndex
    val columns = mart[0].lastIndex
    if (rows * columns <= 60){println("\nTicket price: $10\n")}else if (sRow <= rows / 2){println("\nTicket price: $10\n")}else{println("\nTicket price: $8\n")}
    return mart
}

fun print(mart: MutableList<MutableList<String>>){
    println("Cinema: ")
    for(i in mart.indices){println(mart[i].joinToString(" "))}
}

fun menu(mart:MutableList<MutableList<String>>){
    print("1. Show the seats\n2. Buy a ticket\n0. Exit\n")
    when (readln().toInt()){
        1 -> {print(mart); menu(mart)}
        2 -> {seat(mart); menu(mart)}
        0 -> println()
        else -> menu(mart)
    }
}

fun main() {
    val mart = test()
    for(i in mart.indices){println(mart[i].joinToString(" "))}
    menu(mart)



}
