# play-z3-test
Minimal play application using z3 prover from microsoft for testing platform compatibility espacially ubuntu 16.04

# Used Software and libraries
* [Z3 Prover by Microsoft Research](https://github.com/Z3Prover/z3)
* [Play Framework v 2.3.7](https://www.playframework.com/)

# current compatibility checks
* The code runs successfully on windows 10 using z3v4.3.2x64 release having the bin directory in the Path
* The code runs successfully on ubuntu 16.04 when compiling z3 locally using python 2.7 and installing it into /usr/lib. The .jar file in the lib/ folder of the extracted release has to be replaced to match the version of installed z3
* The code runs successfully on ubuntu 16.04 when using the z3v4.4.1-x64-ubuntu-14.04 release when the .jar file in the /lib folder of the play project matches the release and the .so files are in java.library.path (export LD_LIBRARY_PATH=$PATH_TO_so), it does not suffice to include them in ldconfig cache
