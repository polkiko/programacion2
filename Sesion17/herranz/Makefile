# Este fichero Makefile permite compilar y ejecutar toda la
# solución.
#
# Es un ejemplo clásico de aplicación de una herramienta de "build"
# automática, en este caso make (para más información:
# https://www.gnu.org/software/make/manual/make.html)
#
# Otras herramientas más apropiadas para Java son ant, maven, y por
# supuesto, graddle, que es la que usan últimamente todos los entornos
# de desarrollo como Eclipse o IntelliJ IDEA.

default:
	@echo "Usage:"
	@echo "  make compile # Compila todo el código"
	@echo "  make run # Ejecuta los tests, primero listas acotadas y luego contactos"

compile:
	javac -Xlint:unchecked -d bin -cp src -s src src/TestsListaAcotada.java
	javac -d bin -cp src -s src src/TestsContacto.java

run: compile
	java -ea -cp bin TestsListaAcotada
	java -ea -cp bin TestsContacto

clean:
	rm -rf bin/*
