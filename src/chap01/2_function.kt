// 기본 함수 선언 스타일
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 표현식 스타일
fun sum2(a: Int, b: Int): Int = a + b

// 표현식 & 반환 타입 생략
// 컴파일러가 반환 타입을 추론해주기 때문에 생략 가능하다.
fun sum3(a: Int, b: Int) = a + b


// 몸통이 있는 함수는 반환 타입을 생략하면 컴파일 오류가 발생한다.
fun sum4(a: Int, b: Int): Int {
    return a + b
}

// 반환타입이 없는 함수는 Unit을 반환한다.
// Unit은 생략 가능하다.
// fun printSum(a: Int, b: Int) : Unit {
fun printSum(a: Int, b: Int) {
    println("$a + $b = ${a + b}")
}

// 디폴트 파라미터
fun greeting(message: String = "안녕하세요~") {
    println(message)
}

// Named Argument
// 오버로드를 줄이는 데 고움을 주고 가독성도 높여준다.
fun log(level: String = "INFO", message: String) {
    println("[$level]$message")
}

fun main(args: Array<String>) {
    log(message = "인포 로그")
    log(level = "DEBUG", "디버그 로그")
    log("WARN", "워닝 로그")
    log(level = "ERROR", message = "에러 로그")
    log(message = "message", level = "level") // 순서를 바꿔도 제대로 작동한다.
}
