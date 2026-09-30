package com.academia.banco;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cierre de cuenta (hecho con TDD)")
class CierreDeCuentaTest {

    private CuentaBancaria cuenta;
    private CuentaBancaria destino;

    @BeforeEach
    void prepararCuenta() {
        cuenta = new CuentaBancaria("Ana");
        destino = new CuentaBancaria("bob");
    }

    @Test
    @DisplayName("1. una cuenta nueva está abierta")
    void cuentaNuevaAbierta() {
        assertFalse(cuenta.estaCerrada());
    }

    @Test
    @DisplayName("2. una cuenta sin saldo se puede cerrar")
    void cerrarSinSaldo() {
        cuenta.cerrar();

        assertTrue(cuenta.estaCerrada());
    }

    @Test
    @DisplayName("3. una cuenta con saldo NO se puede cerrar")
    void cuentaSaldo() {
        cuenta.depositar(new BigDecimal("0.01"));
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> cuenta.cerrar());

        assertAll(
            () -> assertEquals("No puedes cerrar una cuenta con saldo: $0.01", e.getMessage())
        );
    }

    @Test
    @DisplayName("4. en una cuenta cerrada no se puede depositar")
    void cuentaCerrada(){
        cuenta.cerrar();

        CuentaCerradaException e = assertThrows(CuentaCerradaException.class,
            () -> cuenta.depositar(new BigDecimal("100.00")));

        assertEquals("La cuenta de " + cuenta.getTitular() + " está cerrada", e.getMessage());
    }

    @Test
    @DisplayName("5. de una cuenta cerrada no se puede retirar")
    void cuentaCerradaRetirar(){
        cuenta.cerrar();
    
        CuentaCerradaException e = assertThrows(CuentaCerradaException.class,
            () -> cuenta.retirar(new BigDecimal("100.00")));
    }

    @Test
    @DisplayName("6. no se puede transferir HACIA una cuenta cerrada, y el origen no cambia")
    void cuentaCerradaTransferir(){
        cuenta.depositar(new BigDecimal("500.00"));
        destino.cerrar();

        CuentaCerradaException e = assertThrows(CuentaCerradaException.class,
            () -> cuenta.transferir(new BigDecimal("100.00"), destino));
    
        assertAll(
            () -> assertEquals("La cuenta de " + destino.getTitular() + " está cerrada", e.getMessage()),
            () -> assertEquals(0, new BigDecimal("500.00").compareTo(cuenta.getSaldo())));
    }

    @Test
    @DisplayName("7. una cuenta cerrada no se puede volver a cerrar")
    void dobleCerrar(){
        cuenta.cerrar();

        CuentaCerradaException e = assertThrows(CuentaCerradaException.class,
            () -> cuenta.cerrar());
    }
}
