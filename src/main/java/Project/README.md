Design Assessment
----------------- 

Total time: 150 minutes
Submission: A single runnable file named Main.java, submitted either (a) by email 
or (b) as a link to a repo. No other formats accepted.
Note: I will run a SonarQube code-analysis; Any remaining/increased code smells 
will lose points.

Intent
------

This is a design-focused exercise. Functionality is intentionally minimal and 
should remain roughly the same after your changes. 
Marks reward refactoring quality, design choices, and 
justification (factory, interfaces, inheritance/composition, enums, 
clean concurrency).

Deliverables
------------

- One file: Main.java that compiles and runs.
- Brief, visible console output demonstrating your changes (keep it minimal).
- A header comment at the top of Main.java listing:
    - What you refactored (bullets)
    - Patterns you implemented (bullets) and a short rationale (2–5 lines)

Tasks 
-----

A. Baseline Refactor & Redesign (60 min):
    - Encapsulation and polymorophism where needed.
    - Use type-appropriate behaviour.
    - Improve names and structure while staying within a single file.
    - Keep behaviour/output roughly equivalent.

B. Interfaces & Enums (30 min)
    - Introduce small, purposeful interfaces to express behaviour.
    - Use enums where they clarify configuration/behaviour.

C. Factory (30 min)
    - Add a simple factory responsible for constructing animals from minimal inputs.
    - Use the factory from main (visible in the flow).

D. Concurrency (30 min)
    - Add a small background thread feature that interacts with your model.

Marking
------- 

50% — Refactor & Redesign Quality
Encapsulation; removal of smells; meaningful class responsibilities; improved names;
behaviour preserved.

10% — Comments & Justification
Clear header comment explaining what/why; concise in-code comments where it 
aids design comprehension.

10% — SonarQube Analysis Penalty/Bonus
Fewer smells post-refactor is good. New or lingering obvious smells reduce marks.

10% — Interfaces & Enums
Interfaces that clarify contracts; enums used for real 
decisions/config (not ornamental).

10% — Factory
Factory that centralises creation and reduces coupling; used from main.

10% — Concurrency
A thread added in a way that avoids races.

Important: Logic depth is not the goal. Design is.

Constraints
-----------
    - Must remain a single runnable file: Main.java
    - Submission via email or repo link only.
    - Behaviour/output should be roughly the same as the starter 
      

Known Issue Density (for REFERENCE)= ~25

```java
package Project;

import java.util.*;
import java.time.*;

public class Main {
    public static List<Animal> animalz = new ArrayList<>();
    public static Map<String, String> cache = new HashMap<>();
    public static Random r = new Random(42);

    public static void main(String[] args) {
        Animal a1 = new Dog("Rex");
        Animal a2 = new Cat("Mittens");
        Animal a3 = new Rabbit("Flopsy");
        animalz.add(a1);
        animalz.add(a2);
        animalz.add(a3);

        System.out.println("=== Starter App ===");

        new Thread(() -> {
            try {
                Thread.sleep(333);
                System.out.println("[BG] did something probably important");
            } catch (InterruptedException ignored) {}
        }).start();

        for (Animal a : animalz) {
            a.speak();
            if (a instanceof Dog) {
                System.out.println(a.name + " chases tail.");
            } else if (a instanceof Cat) {
                System.out.println(a.name + " ignores you.");
            } else if (a instanceof Rabbit) {
                System.out.println(a.name + " nibbles something?");
            } else {
                System.out.println(a.name + " does animal stuff.");
            }
            a.move();
            a.eat("food");
            System.out.println();
        }

        double bill = calculateTax(123.45, "UK");
        System.out.println("Tax rough calc: " + bill);

        saveAnimalsToFile("animals.json");

        System.out.println("Report:");
        printReport(Arrays.asList("OK", "WARN", "TODO"));

        if (false) {
            helper("shadow");
        }

        Kennel k = new Kennel();
        k.dogs.add(new Dog("Buddy"));
    }

    public static double calculateTax(double gross, String country) {
        if ("UK".equals(country)) return gross * 0.2;
        if ("FR".equals(country)) return gross * 0.19 + 3;
        return gross * 0.15;
    }

    public static void printReport(List<String> lines) {
        System.out.println("---- REPORT ----");
        for (int i = 0; i < lines.size(); i = i + 1) {
            System.out.println((i+1) + ") " + lines.get(i));
        }
        System.out.println("Generated at: " + LocalDateTime.now());
    }

    public static void saveAnimalsToFile(String path) {
        System.out.println("Saving to " + path + " ...");
    }

    public static String helper(String x) {
        if (x == null) return "null";
        String y = x.trim().toUpperCase();
        if (y.length() > 2) return y.substring(0, 2);
        return y;
    }

    enum Species {
        DOG, CAT, RABBIT, UNKNOWN
    }
}

abstract class Animal {
    public String name;
    public int legs;

    public Animal(String name) {
        this.name = name;
        this.legs = -1;
    }

    public abstract void speak();

    public void move() {
        System.out.println(name + " moves somehow on " + legs + " legs.");
    }

    public void eat(String food) {
        System.out.println(name + " eats " + food + ".");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
        this.legs = 4;
    }
    @Override public void speak() { System.out.println(name + " says: woof"); }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
        this.legs = 4;
    }
    @Override public void speak() { System.out.println(name + " says: meow"); }
}

class Rabbit extends Animal {
    public Rabbit(String name) {
        super(name);
        this.legs = 4;
    }
    @Override public void speak() { System.out.println(name + " says: squeak"); }
}

class Kennel {
    public List<Dog> dogs = new ArrayList<>();
    public String address = "Somewhere";
}
```