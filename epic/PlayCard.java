package epic;

public class PlayCard {

	public static void main(String[] args) {
		PlayCard pc=new PlayCard();
		System.out.println(pc.helper("8D4F5E2E6F3C6A3F"));
	}
	public boolean helper(String seq)
	{
		if(seq.length()==0)
			return true;
		if(seq.length()<8)
			return false;

		
		while(seq.length()>=8)
		{
			int pos=0;
			String newSeq=remove(seq.substring(0	, 8))+seq.substring(8);
			while(newSeq.length()==seq.length())
			{
				pos=pos+2;
				if(8+pos>seq.length())
					return false;
				newSeq=seq.substring(0,pos)+remove(seq.substring(0+pos, 8+pos))+seq.substring(8+pos);
			}
			pos=0;
			seq=newSeq;
		}
		
		if(seq.length()==0)
			return true;
		return false;
	}
	private String remove(String s) {
		if(s.charAt(0)==s.charAt(6))
			return "";
		if(s.charAt(1)==s.charAt(7))
			return s.substring(0,2)+s.substring(6);
		return s;
	}

}
