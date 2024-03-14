package org.solid.ocp.step1;

import java.util.HashMap;
import java.util.Map;

interface GreeterFormality {
    String greet();
}

class DefualtGreet implements GreeterFormality {
    @Override
    public String greet() {
        return "Hello.";
    }
}
class Formal implements GreeterFormality {
    @Override
    public String greet() {
        return "Good evening, sir.";
    }
}
class Casual implements GreeterFormality {
    @Override
    public String greet() {
        return "Sup bro?";
    }
}
class Intimate implements GreeterFormality {
    @Override
    public String greet() {
        return "Hello Darling!";
    }
}

class Greeter {
    final GreeterFormality formality;

    public Greeter(GreeterFormality formality) {
        this.formality = formality;
    }

    public String greet() {
        return formality.greet();
    }

    public static void main(String[] args) {
        Map<String, GreeterFormality> formalityMap = new HashMap<>();
        formalityMap.put("casual", new Casual());
        formalityMap.put("formal", new Formal());
        formalityMap.put("intimate", new Intimate());

        String greet = new Greeter(formalityMap.get("formal")).greet();
        System.out.println(greet);
    }
}