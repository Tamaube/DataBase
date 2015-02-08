package main;

import java.util.ArrayList;

public class TabRes extends ArrayList<ArrayList<String>>
{
	ArrayList<LigneRes> tab;
	
	public TabRes()
	{
		tab = new ArrayList<LigneRes>();
	}
	
	public boolean add(LigneRes a)
	{
		return tab.add(a);
	}
	
	@Override
	public LigneRes get(int index)
	{
		return tab.get(index);
	}
	
	@Override
	public int size()
	{
		return tab.size();
	}
}
