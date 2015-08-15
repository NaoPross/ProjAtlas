compile:
	javac -d bin -sourcepath src src/org/atlasengine/*.java
	javac -d bin -sourcepath src src/org/enginetest/*.java

run:
	java -cp bin org.enginetest.Game

vim:
	vim src/org/

gvim:
	gvim src/org/
