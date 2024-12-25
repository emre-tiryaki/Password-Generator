package Backend;

import java.util.ArrayList;
import java.util.Random;

public class Generation {

	private ArrayList<ArrayList<Character>> allChars;
	private boolean capital;
	private boolean nonCapital;
	private boolean special;
	private boolean num;

	public Generation(boolean capital, boolean nonCapital, boolean special, boolean num) {
		this.capital = capital;
		this.nonCapital = nonCapital;
		this.special = special;
		this.num = num;
		allChars = getAllChars();
	}

	public String generatePassword(int size) {
		String res = "";
		Random rand = new Random();
		int index = rand.nextInt(allChars.size());
		
		for(int i = 0;i < size;i++) {
			res += allChars.get(index).get(rand.nextInt(allChars.get(index).size()));
			index = rand.nextInt(allChars.size());
		}
		return res;
	}

	
	
	private ArrayList<ArrayList<Character>> getAllChars() {
		ArrayList<ArrayList<Character>> res = new ArrayList<>();
		
		if (this.capital)
			res.add(getCapitalChars());
		if (this.nonCapital)
			res.add(getNonCapitalChars());
		if (this.special)
			res.add(getSpecialChars());
		if (this.num)
			res.add(getNumChars());

		return res;
	}

	private ArrayList<Character> getNumChars() {
		ArrayList<Character> res = new ArrayList<>();
		char tmp = '0';

		while (tmp <= '9') {
			res.add(tmp);
			tmp++;
		}
		return res;
	}

	private ArrayList<Character> getSpecialChars() {
		ArrayList<Character> res = new ArrayList<>();

		res.add('!');
		res.add('@');
		res.add('#');
		res.add('$');

		return res;
	}

	private ArrayList<Character> getNonCapitalChars() {
		ArrayList<Character> res = new ArrayList<>();
		char tmp = 'a';

		while (tmp <= 'z') {
			res.add(tmp);
			tmp++;
		}
		return res;
	}

	private ArrayList<Character> getCapitalChars() {
		ArrayList<Character> res = new ArrayList<>();
		char tmp = 'A';

		while (tmp <= 'Z') {
			res.add(tmp);
			tmp++;
		}
		return res;
	}

	public void setAllChars(ArrayList<ArrayList<Character>> allChars) {
		this.allChars = allChars;
	}

}
