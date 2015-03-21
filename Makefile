JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	And.java \
	Composant.java \
	Interrupteur.java \
	LazySonde.java \
	NonConnecteException.java \
	Not.java \
	Or.java \
	Porte2Entrees.java \
	Porte.java \
	Sonde.java \
	TestCircuits.java \
	Vanne.java \
	Circuit.java \
	SondesTable.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
