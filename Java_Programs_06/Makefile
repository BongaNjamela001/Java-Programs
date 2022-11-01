# VaccineArrayApp and VaccineBSTApp Makefile
# Bonga Njamela
# 10 March 2021

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BinarySearchTree.class BinarySearchTreeInterface.class BinaryTreeNode.class BinaryTreeNodeInterface.class BTQueue.class VaccinationsBST.class Country.class CountryRegister.class VaccineArrayApp.class VaccineBSTApp.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)
clean:
	rm $(BINDIR)/*.class
run: $(CLASS_FILES)
	java -cp bin VaccineArrayApp
	java -cp bin VaccineBSTApp
