package interesting;

import java.util.*;

public class HuffmanCoding {

	public static void main(String[] args) {
		HashMap<Character, Integer> hash=new HashMap<>();
		String in="aaaaaaaaaaaaaaaaaaaaaaaabbbbcccdde";
		hash=collect(in);
		Node n=build(hash);
		HashMap<Character, String> dict=coding(n);
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<in.length(); i++)
		{
			sb.append(dict.get(in.charAt(i)));
		}
		
		HashMap<String, Character> deco=new HashMap<>();
		for(Character c : dict.keySet())
		{
			deco.put(dict.get(c), c);
		}
		
		StringBuffer text=new StringBuffer();
		String word="";
		for(int i=0; i<sb.length(); i++)
		{
			word+=sb.charAt(i);
			if(deco.containsKey(word))
			{
				text.append(deco.get(word));
				word="";
			}
		}
		System.out.println(text);
	}
	public static HashMap<Character, Integer> collect (String s)
	{
		HashMap<Character, Integer> hash=new HashMap<>();
		char[] ch=s.toCharArray();
		for(int i=0; i<ch.length; i++)
		{
			if(hash.containsKey(ch[i]))
				hash.put(ch[i], 1+hash.get(ch[i]));
			else
				hash.put(ch[i], 1);
		}
		return hash;
	}
	public static Node build(HashMap<Character, Integer> hash)
	{
		PriorityQueue<Node> prio=new PriorityQueue<>(hash.size(), 
				new Comparator<Node>()
				{
			public int compare(Node n1, Node n2)
			{
				return (n1.frequency-n2.frequency);
			}
				});
		for(Character c: hash.keySet())
		{
			Node n=new Node();
			n.chars=String.valueOf(c);
			n.frequency=hash.get(c);
			prio.add(n);
		}
		
		int size=prio.size()-1;
		for(int i=0; i<size ; i++)
		{
			Node n1=prio.poll();
			Node n2=prio.poll();
			
			Node newNode=new Node();
			newNode.chars=n1.chars+n2.chars;
			newNode.frequency=n1.frequency+n2.frequency;
			newNode.leftNode=n1;
			newNode.rightNode=n2;
			
			prio.add(newNode);
		}
		return prio.poll();
	}
	public static HashMap<Character, String> coding(Node n)
	{
		HashMap<Character, String> hash=new HashMap<>();
		trace(n, hash, "");
		return hash;
	}
	public static void trace(Node n, HashMap<Character, String> hash, String s)
	{
		if(n.leftNode==null && n.rightNode==null)
			hash.put(n.chars.toCharArray()[0], s);
		if(n.leftNode!=null)
			trace(n.leftNode, hash, new String(s+"0"));
		if(n.rightNode!=null)
			trace(n.rightNode, hash, new String(s+"1"));
	}

}
