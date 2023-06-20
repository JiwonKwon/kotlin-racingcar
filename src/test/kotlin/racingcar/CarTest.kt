package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("자동차의 초기 위치는 0이다") {
        val car = Car("홍길동")
        car.position shouldBe 0
    }

    context("자동차는 무작위 값이 4 미만일 경우 정지한다") {
        withData(
            0..3,
        ) { condition ->
            val car = Car("홍길동")
            car.move(condition)
            car.position shouldBe 0
        }
    }

    context("자동차는 무작위 값이 4 이상일 경우 전진한다") {
        withData(
            4..9,
        ) { condition ->
            val car = Car("홍길동")
            car.move(condition)
            car.position shouldBe 1
        }
    }

    context("자동차 이름을 지정해 줄 수 있다.") {
        val car = Car("홍길동")
        car.name shouldBe "홍길동"
    }

    context("자동차 이름은 5자를 초과할 수 없다.") {
        shouldThrow<IllegalArgumentException> {
            Car(name = "홍길동홍길동")
        }.message shouldBe "자동차 이름은 5자를 초과할 수 없습니다."
    }
})