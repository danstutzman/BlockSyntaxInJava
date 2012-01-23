.PHONY: run clean
run: FunctionalDemo.class
	java FunctionalDemo
clean:
	rm -f *.class FunctionalDemo.java
FunctionalDemo.class: FunctionalDemo.java
	javac -Xlint:unchecked FunctionalDemo.java
FunctionalDemo.java: define_*.javacpp FunctionalDemo.javacpp
	cat define_*.javacpp FunctionalDemo.javacpp | sed -E 's/(\\)?$$/__NEWLINE__\1/' | cpp -P | perl -pe 's/__NEWLINE__([^\n])/\1\n/g' | perl -pe 's/__NEWLINE__//g' > FunctionalDemo.java

# Note that we first transform newlines into __NEWLINE__, then do the cpp
# macro substitution, then transform __NEWLINE__ back into newlines.
# The reason is that otherwise the C preprocessor will compact multi-line
# blocks into a single line.  That's a problem if the programmer uses the
# double-slash syntax for comments, because a block like:
# {
#   // comment
#   foo = "bar";
# }
#
# ... would change into { // comment foo = "bar"; }, which won't compile.
#
# By using __NEWLINE__ tokens, for example:
#   { __NEWLINE__ // comment __NEWLINE__ foo = "bar"; __NEWLINE__ }
# ...we can counteract the C preprocessor's behavior of ignoring newlines.
