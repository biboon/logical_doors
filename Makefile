JC = javac
JFLAGS = -g # -Xlint:unchecked
JPATH = -cp .:./circuits/

CIRCUIT_SRC=$(shell ls circuits/*.java)
CIRCUIT_CLASS=$(CIRCUIT_SRC:.java=.class)
TEST_SRC=$(shell ls test/*.java)
TEST_CLASS=$(TEST_SRC:.java=.class)

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(JPATH) $*.java

all: circuits test
circuits: $(CIRCUIT_CLASS:.java=.class)
test: $(TEST_CLASS:.java=.class)

clean:
	rm -f circuits/*.class
	rm -f test/*.class
