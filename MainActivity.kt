package com.example.programmercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.exp
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var expression = ""
        val ans: TextView = findViewById(R.id.result)
        val one: Button = findViewById(R.id.one)
        one.setOnClickListener{
            expression += "1"
            ans.text = expression
        }
        val two: Button = findViewById(R.id.two)
        two.setOnClickListener{
            expression += "2"
            ans.text = expression
        }
        val three: Button = findViewById(R.id.three)
        three.setOnClickListener{
            expression += "3";
            ans.text = expression
        }
        val four: Button = findViewById(R.id.four)
        four.setOnClickListener{
            expression += "4";
            ans.text = expression
        }
        val five: Button = findViewById(R.id.five)
        five.setOnClickListener{
            expression += "5";
            ans.text = expression
        }
        val six: Button = findViewById(R.id.six)
        six.setOnClickListener{
            expression += "6";
            ans.text = expression
        }
        val seven: Button = findViewById(R.id.seven)
        seven.setOnClickListener{
            expression += "7";
            ans.text = expression
        }
        val eight: Button = findViewById(R.id.eight)
        eight.setOnClickListener{
            expression += "8";
            ans.text = expression
        }
        val nine: Button = findViewById(R.id.nine)
        nine.setOnClickListener{
            expression += "9";
            ans.text = expression
        }
        val multiply: Button = findViewById(R.id.multiply)
        multiply.setOnClickListener{
            expression += "*";
            ans.text = expression
        }
        val add: Button = findViewById(R.id.add)
        add.setOnClickListener{
            expression += "+";
            ans.text = expression
        }
        val diff: Button = findViewById(R.id.diff)
        diff.setOnClickListener{
            expression += "-";
            ans.text = expression
        }
        val divide: Button = findViewById(R.id.divide)
        divide.setOnClickListener{
            expression += "/"
            ans.text = expression
        }
        val zero: Button = findViewById(R.id.zero)
        zero.setOnClickListener{
            expression += "0"
            ans.text = expression
        }
        val modop: Button = findViewById(R.id.modulus)
        modop.setOnClickListener{
            expression += "%"
            ans.text = expression
        }
        val equal: Button = findViewById(R.id.equal)
        equal.setOnClickListener{
            var value = expression
            var pos = -1
            var mod = -1
            for (i in value.indices) {
                var ch = value[i]
                if(ch == '&' || ch == '|' || ch == '^' || ch == '~'){
                    pos = i
                    break
                }
                if(ch == '%'){
                    mod = i
                    break
                }
            }
            if(mod != -1){
                var num1 = Integer.parseInt(expression.substring(0, mod))
                var num2 = Integer.parseInt(expression.substring(mod + 1))
                var rem = num1 % num2
                ans.text = rem.toString()
            }
            else if(pos == -1) {
                var result = ExpressionBuilder(value).build().evaluate()
                ans.text = result.toString()
            }
            else{
                var op = expression[pos]
                if(op == '&' || op == '|' || op == '^') {
                    var num1 = Integer.parseInt(expression.substring(0, pos))
                    var num2 = Integer.parseInt(expression.substring(pos + 1))
                    if (op == '&') {
                        var result = num1 and num2
                        ans.text = result.toString()
                    } else if (op == '|') {
                        var result = num1 or num2
                        ans.text = result.toString()
                    } else if (op == '^') {
                        var result = num1 xor num2
                        ans.text = result.toString()
                    }
                }
                else{
                    var num = Integer.parseInt(expression.substring(pos + 1))
                    var result = num.inv()
                    ans.text = result.toString()
                }
            }
        }
        val clear: Button = findViewById(R.id.clear)
        clear.setOnClickListener{
            expression = ""
            ans.text = expression
        }
        val and: Button = findViewById(R.id.and)
        and.setOnClickListener{
            expression += "&";
            ans.text = expression
        }
        val or: Button = findViewById(R.id.or)
        or.setOnClickListener{
            expression += "|";
            ans.text = expression
        }
        val xor: Button = findViewById(R.id.xor)
        xor.setOnClickListener{
            expression += "^";
            ans.text = expression
        }
        val negate: Button = findViewById(R.id.negate)
        negate.setOnClickListener{
            expression += "~";
            ans.text = expression
        }
        val prime: Button = findViewById(R.id.prime)
        prime.setOnClickListener{
            var num = Integer.parseInt(expression.substring(0))
            var ctr = 0
            for (i in 1..num) {
                if(num % i == 0){
                    ctr++
                }
            }
            if(ctr == 2){
                ans.text = num.toString() + " is a Prime Number"
            }
            else{
                ans.text = num.toString() + " is not a Prime Number"
            }
        }

        val perfect: Button = findViewById(R.id.perfect)
        perfect.setOnClickListener{
            var num = Integer.parseInt(expression.substring(0))
            var sfact = 0
            for (i in 1 until num){
                if(num % i == 0){
                    sfact += i
                }
            }
            if(sfact == num){
                ans.text = num.toString() + " is a Perfect Number"
            }
            else{
                ans.text = num.toString() + " is not a Perfect Number"
            }
        }

        val palin: Button = findViewById(R.id.palin)
        palin.setOnClickListener{
            var num = Integer.parseInt(expression.substring(0))
            var rno = 0
            var tno = num
            while(tno > 0){
                rno = (rno * 10) + (tno % 10)
                tno /= 10
            }
            if(rno == num){
                ans.text = num.toString() + " is a Palindrome Number"
            }
            else{
                ans.text = num.toString() + " is not a Palindrome Number"
            }
        }

        val even: Button = findViewById(R.id.even)
        even.setOnClickListener{
            var num = Integer.parseInt(expression.substring(0))
            if(num % 2 == 0){
                ans.text = num.toString() + " is a Even Number"
            }
            else{
                ans.text = num.toString() + " is a Odd Number"
            }
        }

        val binary: Button = findViewById(R.id.binary)
        binary.setOnClickListener{
            var num = Integer.parseInt(expression.substring(0))
            var bin = Integer.toBinaryString(num)
            ans.text = bin
        }

        val octal: Button = findViewById(R.id.octal)
        octal.setOnClickListener{
            var num = Integer.parseInt(expression.substring(0))
            var oct = Integer.toOctalString(num)
            ans.text = oct
        }

        val hexa: Button = findViewById(R.id.hex)
        hexa.setOnClickListener{
            var num = Integer.parseInt(expression.substring(0))
            var hex = Integer.toHexString(num)
            ans.text = hex
        }
    }
}
