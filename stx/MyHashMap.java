package alg.stx;

import java.util.ArrayList;
public class MyHashMap<K,V> {
	private int bucketSize;
	private int size;
	// for duplicate hashcode
	private ArrayList<HashNode<K, V>> list = new ArrayList<>();

    public MyHashMap() 
    { 
        list = new ArrayList<>(); 
        bucketSize = 10; 
        size = 0; 
  
        // Create empty chains 
        for (int i = 0; i < bucketSize; i++) 
            list.add(null); 
    } 

	public V get(K key) {
		int idx = getBucketIndex(key);
		HashNode<K,V> node = list.get(idx);
		if(node==null) {
			return null;
		} else {
			while(node!=null) {
				if(node.equals(key)) {
					return node.value;
				}
				node = node.next;
			}
			return null;	
		}
	}

	public void put(K key, V value) { 
		int idx = getBucketIndex(key);
		HashNode<K,V> head = list.get(idx);
		if(head==null) {
			HashNode<K,V> newNode = new HashNode(key, value);
			list.set(idx, newNode);
			size++;
			return;
		} else {
			while(head!=null) {
				if(key.equals(head.key)) {
					head.value = value;
					return;
				} 
				head = head.next;
			}
			HashNode<K,V> newNode = new HashNode(key, value);
			newNode.next = list.get(idx);
			size++;
		}
	}

	public V remove(K key) {
		int idx = getBucketIndex(key);
		HashNode<K,V> head = list.get(idx);
		HashNode<K,V> prev = null;
		while(head!=null) {
			if(key.equals(head.key)) {
				break;
			} 
			prev = head;
			head = head.next;
		}

		if(head==null) return null;
		if(prev==null) list.set(idx, null);
		else {
			prev = head.next;
		}
		size--;
		return head.value;
	}

	private int getBucketIndex(K key) {
		int code = key.hashCode();
		int idx = code % bucketSize;
		return idx;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size()==0);
	}
	
	private void loadFactor() {
		if((1.0*size)/bucketSize >= 0.7) {
			ArrayList<HashNode<K,V>> temp = list;
			list = new ArrayList<HashNode<K,V>>();
			bucketSize *= 2;
			size = 0;
			for(int i=0; i<temp.size(); i++) {
				put(temp.get(i).key, temp.get(i).value);
			}
		}
	}

	public static void main(String args[]) {
        MyHashMap<String, Integer> map = new MyHashMap<>(); 
        map.put("this",1 ); 
        map.put("coder",2 ); 
        map.put("this",4 ); 
        map.put("hi",5 ); 
        System.out.println(map.size()); 
        System.out.println(map.remove("this")); 
        System.out.println(map.remove("this")); 
        System.out.println(map.size()); 
        System.out.println(map.isEmpty()); 
		
		ArrayList<String> list = new ArrayList<>();
		list.add(null);
		list.add(null);
		list.add(null);
		list.set(0, "test");
		System.out.println(list.size());
		for( String s : list) {
			System.out.println(s);
		}
	}
}

class HashNode<K, V> {
	K key;
	V value;

	HashNode<K,V> next;

	public HashNode(K k, V v) {
		key = k;
		value = v;
	}
}
