
public class Reward<T> {
	int amount;
	rewardType rt;
	<T extends Account> Reward(T account, rewardType rt, int amount){
		this.rt = rt;
		this.amount = amount;
		T acc =  (T) account;
		String msg;
		if(rt.equals(rewardType.IN_KIND)) {
			msg = "You have been randomly selected to win an item worth "+amount + " please collect your reward from your nearest bank";
		} else {
			msg = "You have been randomly selected to win USD " + amount + " the money has been credited to your balance";
		}
//		acc.reward = msg;
	}
	
}
