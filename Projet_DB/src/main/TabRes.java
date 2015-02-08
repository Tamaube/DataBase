package main;

import java.util.ArrayList;

public class TabRes extends ArrayList<ArrayList<String>>
{
	ArrayList<LigneRes> tab;
	
	@Override
	public boolean add(ArrayList<String> a)
	{
		return tab.add((LigneRes)a);
	}
}
