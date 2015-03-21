JC = javac
JFLAGS = -g

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

JAVASRC = $(shell ls *.java)
CLASSES = $(JAVASRC:.java=.class)

all: classes

default: classes

classes: $(CLASSES:.java=.class)

clean:
	rm -f *.class
