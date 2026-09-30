# Cuenta bancaria — pruebas unitarias con JUnit 5

**Autor:** Andrés Juárez Garduño

## Cómo correr las pruebas

    ./probar.sh final

## Qué prueba cada clase

| Clase de prueba | Qué prueba | Cuántas pruebas |
|---|---|---|
| DepositoTest | cuenta nueva y deposito | 2 |
| RetiroTest | Errores sobre los retiros como el limite, 0.01+ del saldo rechazar, etc. | 8 |
| TransferenciaTest | separado en 2, cuandos las transferencias proceden y cuando se rechazan | 7 |
| InteresTest | saldos negativos y calculos segun la tabla presentada | 8 |
| ComisionTest | comision segun el n numero de retiros | 6 |
| QuejasTest | pureba sobre retiros, comisiones e historial | 5 |
| CierreDeCuentaTest | operaciones cuando las cuentas estan cerradas o abiertas y su interaccion entre ellas | 7 |

## Boleto de salida

1. ¿Por qué una prueba que nunca viste en rojo no es confiable? Da un ejemplo de hoy.
Por que se tiene que mostrar que realmente significa o prueba algo, como cuando agregamos el metodo que regresaba false y ya pasaba la prueba.
2. ¿Qué error se escondía en un valor frontera, y qué prueba lo atrapó?
el error en el valor fronter es cuando se toman los limites usando <= en lugar de solo <, de esa manera los valores exactos como el 100.00 pueden entrar en ese rango. en los quejas se vieron 2 casos si no mal recuerdo.
3. ¿Qué cambió en tu forma de programar al escribir la prueba ANTES del código (MP-6)?
Es muy cansado escribir pruebas porque tienes que estar ala tanto de todas las salidas, execpeciones y muchas otras cosas.