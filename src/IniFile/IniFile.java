package IniFile;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.*;

public class IniFile {

    private Pattern sectionV = Pattern.compile( "\\s*\\[([^]]*)\\]\\s*" );
    private Pattern keyValueV = Pattern.compile( "\\s*([^=]*)=(.*)" );
    private Map< String, Map< String, String >>  entriesV  = new HashMap<>();
    private String path;

    public IniFile(String path) throws IOException {
        this.path = path;
        load(path);
    }

    public void load( String path ) throws IOException {
        try( BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            String section = null;
            while((line = br.readLine()) != null) {
                Matcher m = this.sectionV.matcher(line);
                if( m.matches()) {
                    section = m.group(1).trim();
                }
                else if( section != null ) {
                    m = keyValueV.matcher( line );
                    if( m.matches()) {
                        String key   = m.group(1).trim();
                        String value = m.group(2).trim();
                        Map< String, String > kv = entriesV.get( section );
                        if( kv == null) {
                            entriesV.put( section, kv = new HashMap<>());
                        }
                        kv.put( key, value );
                        Ini
                    }
                }
            }
        }
    }

    public String getString(String section, String key, String defaultvalue) {
        Map< String, String > kv = entriesV.get( section );
        if( kv == null ) {
            return defaultvalue;
        }
        return kv.get( key );
    }

    public int getInt( String section, String key, int defaultvalue ) {
        Map< String, String > kv = entriesV.get( section );
        if( kv == null ) {
            return defaultvalue;
        }
        return Integer.parseInt( kv.get( key ));
    }

    public float getFloat( String section, String key, float defaultvalue ) {
        Map< String, String > kv = entriesV.get( section );
        if( kv == null ) {
            return defaultvalue;
        }
        return Float.parseFloat( kv.get( key ));
    }

    public double getDouble( String section, String key, double defaultvalue ) {
        Map< String, String > kv = entriesV.get( section );
        if( kv == null ) {
            return defaultvalue;
        }
        return Double.parseDouble( kv.get( key ));
    }

    public void put(Object section, Object key, Object value) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String sb = "";
        boolean was = false;

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            sb += line + "\n";
            if (line.equals("[" + section + "]")) {
                was = true;
                sb += key + "=" + value + "\n";
            }
        }
        if (!was) {
            sb += "[" + section + "]" + "\n";
            sb += key + "=" + value + "\n";
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        bufferedWriter.write(sb);

        bufferedReader.close();
        bufferedWriter.close();
    }

    public void sout() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
    }
}


