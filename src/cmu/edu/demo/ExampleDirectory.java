package cmu.edu.demo;

public class ExampleDirectory {

//# packages: java.io.File
//# return: boolean
//# hints:
public static boolean existsDirectory(java.lang.String path) {
	//#SyPet
}

// # //
public static boolean test1() throws Throwable {
  java.lang.Process p1 = java.lang.Runtime.getRuntime().exec("mkdir synth-tmp");
  p1.waitFor();
  java.lang.Process p2 = java.lang.Runtime.getRuntime().exec(new String[]{ "sh", "-c", "echo f > synth-tmp/f.txt" });
  p2.waitFor();
  boolean t1 = existsDirectory("synth-tmp");

  java.lang.Process p3 = java.lang.Runtime.getRuntime().exec(new String[]{ "sh", "-c", "echo f > f.txt ; chmod +x f.txt" });
  p3.waitFor();
  boolean t2 = existsDirectory("f.txt");
  java.lang.Process p4 = java.lang.Runtime.getRuntime().exec("rm -r -f f.txt");
  p4.waitFor();

  java.lang.Process p5 = java.lang.Runtime.getRuntime().exec("rm -r -f synth-tmp");
  p5.waitFor();
  boolean t3 = existsDirectory("synth-tmp");

  return t1 && !t2 && !t3;
}
// # //

//# packages: java.io.File
//# return: boolean
//# hints:
public static boolean createDirectory(java.lang.String path) {
	//#SyPet
}

// # //
public static boolean test2() throws Throwable {
  boolean b1 = createDirectory("synth-tmp");
	java.io.File f1 = new java.io.File("synth-tmp");
  boolean b2 = f1.isDirectory();
  java.lang.Process p1 = java.lang.Runtime.getRuntime().exec("rm -r -f synth-tmp");
  p1.waitFor();

  boolean b3 = createDirectory("synth-tmp2");
	java.io.File f2 = new java.io.File("synth-tmp2");
  boolean b4 = f2.isDirectory();
  java.lang.Process p2 = java.lang.Runtime.getRuntime().exec("rm -r -f synth-tmp2");
  p2.waitFor();

  return b1 && b2 && b3 && b4;
}
// # //

}
