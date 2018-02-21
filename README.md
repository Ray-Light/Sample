This repository contains the source code for two basic programs whose functionality is to implement Sorted Doubly Linked List and some of its functionalities.

The program SortedDoublyLinkedList.java in Un-Annotated folder is not annotated and gives errors on compilation using Checker Framework plugin.

The program SortedDoublyLinkedList.java in Annotated folder has been annotated for the type checker "Nullness Checker" of Checker Framework. The Checker Framework was already istalled and present in the class path.

To compile from terminal, following command needs to be passed : 
javacheck -processor org.checkerframework.checker.nullness.NullnessChecker <Name of the .java file>

Note : 
Here javacheck is an alias of $CHECKERFRAMEWORK/checker/bin/javac which is created by adding the following syntax in the ~/.bashrc file as mentioned in the manual :-

export CHECKERFRAMEWORK=${HOME}/checker-framework-2.3.2
alias javacheck='$CHECKERFRAMEWORK/checker/bin/javac' 
