
public class Reward<T> {
	int amount;
	rewardType rt;
	Reward(T account, rewardType rt, int amount){
		this.rt = rt;
		this.amount = amount;
		Account acc = (Account) account;
		String msg;
		if(rt.equals(rewardType.IN_KIND)) {
			msg = "You have been randomly selected to win an item worth "+amount + " please collect your reward from your nearest bank";
		} else {
			msg = "You have been randomly selected to win USD " + amount + " the money has been credited to your balance";
		}
		acc.reward = msg;
	}
	
}
