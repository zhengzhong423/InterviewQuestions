package interesting;

public class TrieTree {
	
	TrieTreeNode root;
	
	public class TrieTreeNode
	{
		char val;
		TrieTreeNode[] children=new TrieTreeNode[26];
		boolean isEnd;
	}
	
	public TrieTree()
	{
		this.root=new TrieTreeNode();
	}
	
	public static void main(String[] args) {
		TrieTree tree=new TrieTree();
		tree.insert("abcd", tree);
		tree.insert("ab", tree);
		
		System.out.println(tree.lookUp(tree, "abcd"));
	}
	
	public void insert(String s, TrieTree tree)
	{
		TrieTreeNode root=tree.root;
		for(int i=0; i<s.length(); i++)
		{
			char ch=s.charAt(i);
			if(root.children[(int)ch-'a']==null)
			{
				TrieTreeNode cur=tree.new TrieTreeNode();
				cur.val=ch;
				root.children[(int)ch-'a']=cur;
			}
			
			root=root.children[(int)ch-'a'];
			
			if(i==s.length()-1)
				root.isEnd=true;
		}
	}
	
	public boolean lookUp(TrieTree tree, String str)
	{
		TrieTreeNode root=tree.root;
		for(int i=0; i<str.length(); i++)
		{
			char ch=str.charAt(i);
			if(root.children[(int)ch-'a']==null)
				return false;
			else
				root=root.children[(int)ch-'a'];
		}
		return root.isEnd;
	}
}
