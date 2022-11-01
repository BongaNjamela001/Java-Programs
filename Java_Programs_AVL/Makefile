# AVLExperiment App Makefile
# Bonga Njamela
# 12 March 2022

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=AVLTree.class AVLTreeInterface.class BinaryTreeNode.class BinaryTreeNodeInterface.class BTQueue.class Country.class DataArray.class AVLExperiment.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)
clean:
	rm $(BINDIR)/*.class
run: $(CLASS_FILES)
	java -cp bin AVLExperiment
