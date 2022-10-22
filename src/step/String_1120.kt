package step

import kotlin.math.min

private val br = System.`in`.bufferedReader()
private lateinit var A : String
private lateinit var B : String

fun main(){
    var arr = br.readLine().split(" ")
    A = arr[0]
    B = arr[1]

    if(A.length == B.length){ // 길이 같은 경우 바로 비교
        println(solveSame())
    }
    else { // 길이 다른 경우 최소 차이 구하기
        println(solveDif())
    }
}

fun solveSame(): Int {
    var min = 0

    A.mapIndexed { idx, c ->
        if(c != B[idx]){
            min++;
        }
    }

    return min
}

fun solveDif(): Int {
    var min = B.length
    // 길이 차이만큼 인덱스 시작점 바꿔서 돌기
    var loop = 0
    var time = B.length - A.length
    var idx = 0

    while (loop++ <= time){
        var differ = 0

        A.mapIndexed { index, c ->
            if(c != B[index+idx]){
                differ++
            }
        }

        min = min(min, differ)
        idx++
    }

    return min
}