package domain.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PositionKoTest : DescribeSpec({
    describe("method test") {
        context("move method") {
            it("위치가 이동된다.") {
                val position = Position.create()

                position.move().position shouldBe 1
            }
        }
    }
})