import java.util.Hashtable;

class TestClass3 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "chrome");
        capsHashtable.put("browser_version", "93.0");
        capsHashtable.put("os", "OS X");
        capsHashtable.put("os_version", "Big Sur");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 3");
        MainClass r3 = new MainClass();
        r3.executeTest(capsHashtable);
    }
}