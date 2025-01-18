
// Calculator.kt
class Calculator {
    private var currentValue: Double = 0.0
    private var storedValue: Double = 0.0
    private var currentOperation: Operation? = null
    private var newNumber = true

    enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    fun inputDigit(digit: Int) {
        if (newNumber) {
            currentValue = digit.toDouble()
            newNumber = false
        } else {
            currentValue = currentValue * 10 + digit
        }
    }

    fun setOperation(op: Operation) {
        currentOperation = op
        storedValue = currentValue
        newNumber = true
    }

    fun calculateResult(): Double {
        if (currentOperation == null) return currentValue

        val result = when (currentOperation) {
            Operation.ADD -> storedValue + currentValue
            Operation.SUBTRACT -> storedValue - currentValue
            Operation.MULTIPLY -> storedValue * currentValue
            Operation.DIVIDE -> if (currentValue != 0.0) storedValue / currentValue else Double.NaN
            else -> currentValue
        }

        currentValue = result
        currentOperation = null
        newNumber = true
        return result
    }

    fun clear() {
        currentValue = 0.0
        storedValue = 0.0
        currentOperation = null
        newNumber = true
    }

    fun getCurrentValue(): Double = currentValue
}
