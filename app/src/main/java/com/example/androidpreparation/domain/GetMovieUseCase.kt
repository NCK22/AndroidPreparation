package com.example.androidpreparation.domain

import android.util.Log
import com.example.androidpreparation.data.MovieRepositoryInterface

class GetMovieUseCase(
    private val movieRepositoryInterface: MovieRepositoryInterface
) {

    suspend operator fun invoke(): String {
        collectionTransformation()
        // return "Use case Value"
        return movieRepositoryInterface.getMovie()
    }

    fun collectionTransformation() {
        // map
        val numbers = listOf(1, 2, 3, 4)
        numbers.toHashSet()
        val squares = numbers.map {
            it * it
        } // [1, 4, 9, 16]
        Log.e("##", "map " + squares.toString())

        // filter
        val numbers1 = listOf(1, 2, 3, 4, 5)
        val evenNumbers = numbers1.filter {
            it % 2 == 0
        } // [2, 4]
        Log.e("##", "filter " + evenNumbers.toString())

        // flatmap
        val lists = listOf(listOf(1, 2), listOf(3, 4))
        val flattened = lists.flatMap { it } // [1, 2, 3, 4]
        Log.e("##", "flatmap " + flattened.toString())

      // fold
        val numbers2 = listOf(1, 2, 3, 4)
        val sum = numbers2.fold(0) {
                acc, number -> acc + number
        } // 10
        Log.e("##", "fold " + sum.toString())

        // reduce
        val numbers3 = listOf(1, 2, 3, 4)
        val product = numbers3.reduce { acc, number -> acc * number } // 24
        Log.e("##", "reduce " + product.toString())

        // associate
        val words = listOf("one", "two", "three")
        val lengthMap = words.associateWith { it.length }
        // {one=3, two=3, three=5}

        Log.e("##", "associate " + lengthMap.toString())

        // group by
        val numbers4 = listOf(1, 2, 3, 4, 5)
        val grouped = numbers4.groupBy { it % 2 } // {1=[1, 3, 5], 0=[2, 4]}
        Log.e("##", "groupby " + lengthMap.toString())

        surplus("surplus") { x -> x }
        surplus("surplus", ::add)
        surplus("surplus", getOperation("add"))

    }
}

fun GetMovieUseCase.add(string: String): String = string

fun surplus(string: String, operation: (string: String)-> String) = operation(string)

fun getOperation(string:String): (String) -> String = when(string){
    "add"-> {x -> x}
    else -> {x -> x+""}
}