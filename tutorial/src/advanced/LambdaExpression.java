/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
A lambda expression is an anonymous function. A function that
doesn't have a name and doesn't belong to any class.
To create a Lambda Expression, we specify input parameters
(if there are any, otherwise an opening and a closing parentheses)
on the left side of the lambda operator ->, and place the expression
or block of statements on the right side of lambda operator
(parameter_list) -> {function_body}
They have no name and return type, only arguments and body

Highly used when developing graphical user interfaces (GUIs) when
previously Anonymous Classes were used.
 */
package advanced;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class LambdaExpression {
    public LambdaExpression() {
//        builtInLambdaExpressionExample();

//        customLambdaExpressionExample();

        loopIterationExample();
    }

    private void loopIterationExample() {
        List<String> provinces = new ArrayList<>();
        provinces.add("Quebec");
        provinces.add("Ontario");
        provinces.add("Alberta");
        provinces.add("British Columbia");

        provinces.forEach((province) -> System.out.println(province));
        System.out.println();
        // Or even shorter with method reference (covered next)
        provinces.forEach(System.out::println);
        System.out.println();

        Map<String, Integer> productToPrice = new HashMap<>();
        productToPrice.put("Bagel", 1);
        productToPrice.put("Coffee", 2);
        productToPrice.put("Tea", 2);
        productToPrice.put("Sandwich", 5);

        productToPrice.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private void customLambdaExpressionExample() {
        MyFI message = () -> {
            return "McMaster";
        };
        System.out.println(message.printUniversity());

        MyFI2 message2 = (uni) -> {
            if (uni.equalsIgnoreCase("McMaster"))
                return "Ontario";
            else return "Outside of Ontario";
        };
    }

    private void builtInLambdaExpressionExample() {
        Frame frame = new Frame("Lambda Expression example");
        Button b = new Button("Click Me!");
        b.setBounds(50, 100, 100, 50);

        // Anonymous inner class
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked!");
            }
        });

//        // Lambda Expression
//        b.addActionListener(e -> System.out.println("Clicked"));

        frame.add(b);
        frame.setSize(200, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LambdaExpression();
    }
}

@FunctionalInterface
        // An interface with only single abstract method
interface MyFI {
    // Only one method allowed (remember, lambda expression is a
    // no-name method, therefore there must be only one method to
    // implement)
    String printUniversity();
}

@FunctionalInterface
interface MyFI2 {
    String printProvince(String university);
}
