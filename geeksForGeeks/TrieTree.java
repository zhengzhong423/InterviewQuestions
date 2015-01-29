package geeksForGeeks;

class TrieTree {
	TrieTreeNode root=new TrieTreeNode(' ');
	class TrieTreeNode
	{
		char ch;
		TrieTreeNode[] children;
		Boolean isEnd;
		public TrieTreeNode(char c)
		{
			this.ch=c;
			this.children=new TrieTreeNode[26];
			this.isEnd=false;
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TrieTree tt=new TrieTree();
		
		tt.insert("abccd");
		System.out.println(tt.check("abcd"));
	}
	public boolean check(String str)
	{
		if (str == null || str.length() == 0) {  
            return false;  
        }
		char[] chs=str.toCharArray();
		TrieTreeNode cur=root;
		for(int i=0; i<chs.length; i++)
		{
			int index=chs[i]-'a';
			if(cur.children[index]==null)
				return false;
			if(chs[i]==cur.children[(int)chs[i]-'a'].ch)
				cur=cur.children[index];
			else
				return false;
		}
		return cur.isEnd;
	}
	public void insert(String str)
	{
		if (str == null || str.length() == 0) {  
            return;  
        }
		char[] chs=str.toCharArray();
		TrieTreeNode cur=root;
		for(int i=0; i<chs.length; i++)
		{
			int index=chs[i]-'a';
			if(cur.children[index]==null)
				cur.children[index]=new TrieTreeNode(chs[i]);
			cur=cur.children[index];
			if(i==chs.length-1)
				cur.isEnd=true;
		}
	}

}
