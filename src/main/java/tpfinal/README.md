TPFinal - Juego TicTacToe (Cliente-Servidor)
===========================================

Proyecto Java 17 Maven (compatible con Spring Tools 4).
ArtifactId: ar.edu.et32
Nombre de proyecto: TPFinal

Ejecutar:
- Iniciar servidor: mvn -q exec:java -Dexec.mainClass="tpfinal.Servidor" -Dexec.args="5000"
  (o ejecutar la clase Servidor desde tu IDE)
- Iniciar dos clientes (en consolas distintas):
  java -cp target/classes tpfinal.Cliente localhost 5000

Protocolo simple (por líneas de texto):
- Cliente envía su nombre como primera línea (autenticación simple).
- Servidor envía mensajes como: WELCOME|..., START|ERES|X, ESTADO|..., YOUR_MOVE, OPPONENT_MOVE, INVALID, END|...
- Cliente envía MOVEs con formato: MOVE|fila|col
