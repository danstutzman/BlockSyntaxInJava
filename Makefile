.PHONY: run clean
run: FunctionalDemo.class
	java FunctionalDemo
clean:
	rm -f *.class FunctionalDemo.java
FunctionalDemo.class: FunctionalDemo.java
	javac FunctionalDemo.java
FunctionalDemo.java: defines.javacpp FunctionalDemo.javacpp
	cat defines.javacpp FunctionalDemo.javacpp | sed -E 's/(\\)?$$/__NEWLINE__\1/' | cpp -P | perl -pe 's/__NEWLINE__([^\n])/\1\n/g' | perl -pe 's/__NEWLINE__//g' > FunctionalDemo.java
