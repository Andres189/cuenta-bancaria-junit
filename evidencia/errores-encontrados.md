# Errores encontrados en la versión del compañero

Mi suite (MP-1 a MP-4) atrapó sola **N** de los 5 errores: (nombres de las pruebas que fallaron en mp5-companero.txt)

| Queja | Prueba que la reproduce | Qué estaba mal en el código (la línea y por qué) | ¿Mi suite ya lo atrapaba? |
|---|---|---|---|
| 1 | tercerRetiroGratis | Solamente faltaba un singo de "=" | sí |
| 2 | retiroExactoDelLimite | parecido al atenrior pero era de quitar un "=" cuando se comprobaba el limte | si |
| 3 | transferenciaRechazadaNoCambiaElSaldo | Se agrego una comprobacion antes de hacer la resta para que el saldo se mantenga | no |
| 4 | laComisionApareceEnElHistorial | se hacian los cambios en el hisotrial del movimiento pero flataba agregar los de comision | si |
| 5 | elHistorialNoSePuedeModificar | la lista de movimienots retornaba directamente la referencia, se tiene de devolver la ya modificada | si |