import java.util.Hashtable;

class TestClass2 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "edge");
        capsHashtable.put("browser_version", "93.0");
        capsHashtable.put("os", "Windows");
        capsHashtable.put("os_version", "10");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 2");
        MainClass r2 = new MainClass();
        r2.executeTest(capsHashtable);
    }
}