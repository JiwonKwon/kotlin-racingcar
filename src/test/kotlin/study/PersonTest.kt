package study

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    internal fun `이름 붙인 인자`() {
        val person = Person(name = "황재우", age = 39, nickname = "dreamboy1339")
        assertThat(person.name).isEqualTo("황재우")
        assertThat(person.age).isEqualTo(39)
        assertThat(person.nickname).isEqualTo("dreamboy1339")
    }

    @Test
    internal fun `널 타입`() {
        val person = Person("황재우", 39, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("황재우", 39)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("황재우", 39)
        val person2 = Person("황재우", 39)
        assertThat(person1).isEqualTo(person2)
    }
}
