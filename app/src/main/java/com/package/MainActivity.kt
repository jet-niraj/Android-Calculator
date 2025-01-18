
class MainActivity : AppCompatActivity() {
    private lateinit var calculator: Calculator
    private lateinit var displayText: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        calculator = Calculator()
        displayText = findViewById(R.id.display)
        
        // Initialize number buttons
        for (i in 0..9) {
            val buttonId = resources.getIdentifier("button_$i", "id", packageName)
            findViewById<Button>(buttonId).setOnClickListener {
                calculator.inputDigit(i)
                updateDisplay()
            }
        }
        
        // Operation buttons
        findViewById<Button>(R.id.button_add).setOnClickListener {
            calculator.setOperation(Calculator.Operation.ADD)
            updateDisplay()
        }
        
        findViewById<Button>(R.id.button_equals).setOnClickListener {
            calculator.calculateResult()
            updateDisplay()
        }
        
        findViewById<Button>(R.id.button_clear).setOnClickListener {
            calculator.clear()
            updateDisplay()
        }
    }
    
    private fun updateDisplay() {
        displayText.text = calculator.getCurrentValue().toString()
    }
}
