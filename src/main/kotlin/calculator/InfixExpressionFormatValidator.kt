package calculator

import calculator.operation.Operator

class InfixExpressionFormatValidator {
    fun validateExpressionFormat(expression: String) {
        expression
            .asSequence()
            .map { it.toString() }
            .forEach {
                require(Operator.isOperator(it) || it.matches("\\d".toRegex())) { "수식은 사칙연산과 숫자만 가능합니다." }
            }
    }

    fun validateNumberOfOperands(operands: List<String>, operators: List<String>) {
        if (operands.size <= operators.size) throw IllegalArgumentException("연산자가 피연산자 보다 많을 수 없습니다.")
    }
}