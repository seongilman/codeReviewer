package org.kata.alu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AluTest {

    @Test
    void addTest() {
        Alu alu = new Alu();
        alu.setOperand1(1);
        alu.setOperand2(2);
        alu.setOPCODE("ADD");

        Result result = new Result();
        alu.enableSignal(result);

        assertEquals(3, result.getResult());
        assertEquals(0, result.getStatus());
    }

}