.PHONY: run clean
run: FunctionalDemo.class
	java FunctionalDemo
clean:
	rm -f *.class FunctionalDemo.java
FunctionalDemo.class: FunctionalDemo.java
	javac -Xlint:unchecked FunctionalDemo.java
FunctionalDemo.java: define_*.javacpp FunctionalDemo.javacpp
	cat define_*.javacpp FunctionalDemo.javacpp | sed -E 's/(\\)?$$/__NEWLINE__\1/' | cpp -P | perl -pe 's/__NEWLINE__([^\n])/\1\n/g' | perl -pe 's/__NEWLINE__//g' > FunctionalDemo.java
