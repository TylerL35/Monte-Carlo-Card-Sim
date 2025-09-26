import java.util.ArrayList;
public class Main {
	public static void main(String args[]) {
		deck d = new deck();
		card temp;
		int r = 26;
		int b = 26;
		int choice; // 0 if black 1 if red
		int s = 0;
		ArrayList<Integer> score = new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++)
		{
			r = 26;
			b = 26;
			s = 0;
			for (int j = 0; j < 52; j++)
			{
				temp = d.drawCard(false);
				if (r == b)
				{
					choice = (int) Math.random();
				}
				else if (r > b)
				{
					choice = 1;
				}
				else 
				{
					choice = 0;
				}
				
				if (temp.getSuite() == 1 || temp.getSuite() == 2)
				{
					b--;
					if (choice == 0)
						s++;
				}
				else
				{
					r--;
					if (choice == 1)
						s++;
				}
				
				
			}
			d.shuffle();
			score.add(s);
		}
		double avg = 0.0;
		double win = 0.0;
		double loss = 0.0;
		for (int i = 0; i < score.size(); i++)
		{
			avg += score.get(i);
			if (score.get(i) >= 27)
				win += 1.0;
			else
				loss += 1.0;
		}
		System.out.println("Average: " + avg / 10000.0);
		System.out.println("Winrate: " + win / (loss + win));
	}
}