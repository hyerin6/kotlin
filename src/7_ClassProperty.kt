// 코틀린에서 본문이 없는 클래스도 만들 수 있다.
class EmptyClass

// 특정 어노테이션을 사용하는 경우 constructor 키워드를 사용하여 생성자를 만들 수 있다.
// constructor 키워드는 생략 가능하다.
class Test constructor(val name: String) {
}

// var 는 Getter/Setter를 자동으로 생성해준다.
// val 은 Setter이 존재하지 않고 Getter만 생성된다.
class Coffee(
        // 후행 쉼표를 사용하면 나중에 프로퍼티를 추가할 때, price 행은 수정하지 않아도 된다.
        // 코드 리뷰할 때 diff 비교 시 추가된 내용 파악이 쉬워진다.
        var name: String = "",
        var price: Int = 0,
        var iced: Boolean = false,
) {

    val brand: String
        get() = "스타벅스" // custom getter, 로직이 필요한 경우 함수 처럼 만들어 return 값을 정할 수 있다.

    var quantity: Int = 0
        set(value) {
            if (value > 0) {
                // 코틀린에서는 field라는 식별자를 사용해서 실제 필드 참조에 접근한다. (= backing field에 접근한다.)
                // 실제로 프로퍼티를 사용할 때 Setter를 사용하는데
                // 만약 field 가 아닌 quantity를 사용하면 stackoverflow가 발생한다.
                field = value
            }
        }

}

fun main() {
    val coffee = Coffee()
    // Setter로 값을 할당한다.
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000
    coffee.quantity = 1
    coffee.iced = true

    if (coffee.iced) { // 프로퍼티가 상태를 나타낸다. (객체지향적이다.)
        println("아이스 커피")
    }

    // Getter를 사용
    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price} 수량은 ${coffee.quantity}")

}

// 코틀린의 프로퍼티는 객체지향 적이다.
// 자바의 경우 상태를 프로퍼티가 아닌 메서드로 나타나게 되는데
// 코틀린은 프로퍼티가 상태, 메서드가 행동을 표현한다.