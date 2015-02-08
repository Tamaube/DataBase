package main;

import java.util.ArrayList;

public class LigneRes extends ArrayList<String> implements Comparable<LigneRes>
{
	ArrayList<String> tab;
	
	public ArrayList<String> getTab() {return tab;}
	
	public LigneRes()
	{
		tab = new ArrayList<String>();
	}

	@Override
	public int compareTo(LigneRes arg0)
	{
		return tab.get(0).compareTo(arg0.getTab().get(0));
	}
	
	@Override
	public String get(int index)
	{
		return tab.get(index);
	}
	
	@Override
	public int size()
	{
		return tab.size();
	}
}
