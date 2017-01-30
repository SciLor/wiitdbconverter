import com.scilor.wii.wiitdb2romcollectionbrowser.Main;

/**
 * Created by SciLor on 30.01.2017.
 */
public class TestStart {
    public static void main(String[] args) throws Exception {
        args = new String[] {
                "-i", "D:\\_Programmierung\\IntelliJ\\WiiTDB2RomCollectionBrowser\\test\\wiitdb.xml",
                "-o", "D:\\_Programmierung\\IntelliJ\\WiiTDB2RomCollectionBrowser\\test\\output\\",
                "-lp", "DE", "EN"
        };
        Main.main(args);
    }
}
