package alg.stx;

import java.util.HashMap;

public class SelfFill {
	static HashMap<String, SelfFill> map = new HashMap<>();
	private String key;
	private String value;


	public SelfFill(String k) {
		key = k;
	}

	public boolean get() {
		if(map.get(this.key)!=null) {
			this.value = "awesome";
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		SelfFill sf = new SelfFill("k1");
		SelfFill sf2 = new SelfFill("k2");
		SelfFill sf3 = new SelfFill("k3");
		map.put("k1", sf); 		
		map.put("k3", sf3); 		
		if(sf.get()) System.out.println(sf.key + " : " + sf.value);
		if(sf2.get()) System.out.println(sf2.key + " : " + sf2.value);
		if(sf3.get()) System.out.println(sf3.key + " : " + sf3.value);
	}
}
