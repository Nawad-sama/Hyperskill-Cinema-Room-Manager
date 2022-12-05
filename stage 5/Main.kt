fun test(): MutableList<MutableList<Any>>{
    print("Enter the number of rows: ")
    val rows = readln().toInt()
    print("Enter the number of seats in each row: ")
    val columns = readln().toInt()
    println("Cinema:")
    val mart: MutableList<MutableList<Any>> = MutableList(rows+1) { MutableList(columns+1) { "S" } }
    for(i in 1.rangeTo(mart[0].indices.last)){mart[0][i] = (i).toString()}
    for(i in mart.indices){for ((index, j) in mart[i].indices.withIndex()) {mart[i][j]=(i).toString(); if(index == 0) break}}
    mart[0][0]= buildString {
        append(" ")
    }
    val tickets = mutableListOf<Any>(0, 0) // @index[0] - $10 bucks; @index[1] - $8 bucks
    mart.add(tickets)
    return mart
}

fun seat(mart: MutableList<MutableList<Any>>): MutableList<MutableList<Any>> {
    print("Enter a row number:")
    val sRow = readln().toInt()
    print("Enter a seat number in that row:")
    val sNumber = readln().toInt()
    //mart[sRow][sNumber] == "B" -> print("That ticket has already been purchased!")
    val rows = mart.lastIndex-1
    val columns = mart[0].lastIndex
    when{
        sRow > rows -> {println("Wrong input!"); seat(mart)}
        sNumber > columns -> {println("Wrong input!"); seat(mart)}
        mart[sRow][sNumber] == "B" -> {println("That ticket has already been purchased!"); seat(mart)}
        else -> mart[sRow][sNumber] = "B"
    }
    if (rows * columns <= 60){println("\nTicket price: $10\n"); mart[mart.lastIndex][0] = mart[mart.lastIndex].get(0).toString().toInt() +1 }else if (sRow <= rows / 2){println("\nTicket price: $10\n"); mart[mart.lastIndex][0] = mart[mart.lastIndex].get(0).toString().toInt() +1 }else{println("\nTicket price: $8\n"); mart[mart.lastIndex][1] = mart[mart.lastIndex].get(1).toString().toInt() +1 }
    return mart
}

fun print(mart: MutableList<MutableList<Any>>){
    println("Cinema: ")
    for(i in 0 until mart.indices.last){println(mart[i].joinToString(" "))}
}

fun statistics (mart: MutableList<MutableList<Any>>){
    val a = mart[mart.lastIndex][0].toString().toInt()
    val b = mart[mart.lastIndex][1].toString().toInt()
    val c = mart.lastIndex - 1
    val d = mart[0].lastIndex
    println("Number of purchased tickets: ${a + b}")
    val e = (a.toDouble()+b.toDouble())*100/(c.toDouble()*d.toDouble())
    //println(a + b)
    //println(String.format("%.2f", e))
    //println(e)
    //println(d)
    val f = String.format("%.2f", e)
    println("Percentage: $f%")
    println("Current income $${a * 10 + b * 8}")
    println("Total income: $${when{
        c * d <= 60 -> c * d * 10
        else -> (c / 2 * d * 10) + (c - (c/2)) * d *8
    }}")
    println()

}

fun menu(mart:MutableList<MutableList<Any>>){
    print("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n")
    when (readln().toInt()){
        1 -> {print(mart); menu(mart)}
        2 -> {seat(mart); menu(mart)}
        3 -> {statistics(mart); menu(mart)}
        0 -> println()
        else -> menu(mart)
    }
}

fun main() {
    val mart = test()
    for(i in 0 until mart.indices.last){println(mart[i].joinToString(" "))}
    menu(mart)
}
