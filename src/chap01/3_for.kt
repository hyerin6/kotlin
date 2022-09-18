fun main() {
    // 범위 연산자 .. 를 사용한 for loop
    // 특징: 맨 끝의 숫자도 포함한다.
    for (i in 0..3) {
        println(i)
    }

    // until 을 사용해 반복하면
    // 뒤에 온 숫자는 포함하지 않는다.
    for (i in 0 until 3) {
        println(i)
    }

    // step에 들어온 값 만큼 증가시킨다.
    for (i in 0..6 step 2) {
        println(i)
    }

    // downTo를 사용해 반복하면서 값을 감소시킨다.
    for (i in 3 downTo 1) {
        println(i)
    }

    // 전달받은 배열 반복 (foreach)
    val numbers = arrayOf(1, 2, 3)

    for (i in numbers) {
        println(i)
    }

}
