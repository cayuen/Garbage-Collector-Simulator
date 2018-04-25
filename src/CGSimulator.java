import java.util.HashMap;
import java.util.Map;

public class CGSimulator {
    private static HashMap<String, String> stackRef = new HashMap<String, String>(); 
    private static HashMap<Object, Map<String, Object>> heapRef = new HashMap<Object, Map<String, Object>>();
    
    public CGSimulator() {
    }
	
    // Add pair <aName, o> into the stackRef
    // aName and bName represent the variable names “a” and “b”, respectively;  
    static void assign(String aName, String bName, Object o) {
    	stackRef.put(aName, (String) o);
     }

     // o denotes the object referenced by a and b
     static void createObject (String aName, Object o) {
    	 
     }  

     // aName is the name of variable “a”, and o represents the newly created object
     static void readObject (String bName, String aName,  Object o) {
    	 stackRef.put(bName, (String) o);
     }  

     
     
     // bName and aName represent the two variables “b” and “a”,
     // and o denotes the heap object referenced by b
     // For each object o,  heapRef maps it to a another map, which, in turn,
     // maps each field name to an object. When a field write is seen (i.e., writeObject),
     // we need to perform the following map update:  ((Map)heapRef.get(oa)).put(fieldname, ob)),
     // which basically replaces the old object referenced by the field “fieldname” of oa
     // with a new object ob.  
     static void writeObject(String aName, String bName,  String fieldname, Object oa, Object ob) {
    	 Map<String, Object> objectPair = new Map<String, Object>();
    	 objectPair.put(fieldname, ob);
    	 heapRef.put(oa, objectPair);
     }

     // a gc method that will be explicitly called to collect garbage
     static void gc() {
    	 
     }
}

