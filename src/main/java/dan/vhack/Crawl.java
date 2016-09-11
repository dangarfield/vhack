package dan.vhack;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

public class Crawl {

	private static List<String> MAX_LEVEL_REACHED = new ArrayList<String>();
	
	private static String RESOURCE_RAM = "ram";
	private static String RESOURCE_INTERNET = "inet";
	private static String RESOURCE_CPU = "cpu";
	private static String RESOURCE_HDD = "hdd";
	
	private static String RESOURCE_FIREWALL = "fw";
	private static String RESOURCE_ANTIVIRUS = "av";
	private static String RESOURCE_IPSPOOFING = "ipsp";
	private static String RESOURCE_SCAN = "scan";
	private static String RESOURCE_SDK = "sdk";
	private static String RESOURCE_SPAM = "spam";
	private static String RESOURCE_ADWARE = "adw";
	
	
	
	public static void main(String[] args)
			throws UnirestException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

		Actions.prepareUniRest();

		UserData userData = getUserData();
		System.out.println(userData);
		
//		generateMoney(userData);
//		performAnyUpdates(userData);
		
		int count = 0;
		while (true) {
			count++;
			try {
				
				System.out.println("%%%% COUNT - " + count + " %%%%");
				generateMoney(userData);
				if(count > 10) {
					userData = getUserData();
					performAnyUpdates(userData);
					count = 0;
				}
			} catch (UnirestException e) {
				//e.printStackTrace();
				System.out.println("---- Error with http res");
			}
		}
		
		
	}
	
//	https://vhackxt.com/v/1/vh_tasks.php?user=eyIiOiIiLCJ1aGFzaCI6IiIsInBhc3MiOiJwZXJmZWN0aW9uIiwidGltZSI6IjE0NzM1Mzk0NjMiLCJ1c2VyIjoiZGFuZ2FyZmllbGQifQ&pass=349668eaffde30b0f2d8f2eec99eb339
//	https://vhackxt.com/v/1/vh_tasks.php?user=eyIiOiIiLCJ0aW1lIjoiMTQ3MzUzOTQ2MCIsInVzZXIiOiJkYW5nYXJmaWVsZCIsInBhc3MiOiJwZXJmZWN0aW9uIiwidWhhc2giOiJhZmU3YTQ2OWQyNmM1NTMyYTE3OGY0NDI2MjIyMTg2Y2EwY2ZkMjVjMDQxNDI3MzgzNzM2ZjcxZWI3MGQ3N2IzIn0&pass=fac513d69254b571b1d7305ce961522c		
		
	private static boolean performAnyUpdates(UserData userData) throws UnirestException {
//		TaskData taskData = getTaskData(userData);
//		System.out.println(taskData);
		
		
		//if(!MAX_LEVEL_REACHED.contains("inet")) { //MAX 10
		if(userData.getInet() < 10) {
			System.out.println("Upgrade internet");
			upgrade(RESOURCE_INTERNET, userData);
			return true;
		}
//		if(!MAX_LEVEL_REACHED.contains("cpu")) { //MAX 10
		if(userData.getCpu() < 10) {
			System.out.println("Upgrade CPU");
			upgrade(RESOURCE_CPU, userData);
			return true;
		}
//		if(!MAX_LEVEL_REACHED.contains("hdd")) { //MAX 10
		if(userData.getHdd() < 10) {
			System.out.println("Upgrade HDD");
			upgrade(RESOURCE_HDD, userData);
			return true;
		}
//		if(!MAX_LEVEL_REACHED.contains("ram")) { //MAX 14
		if(userData.getRam() < 14) {
			System.out.println("Upgrade RAM");
			upgrade(RESOURCE_RAM, userData);
			return true;
		}
		
//		if(taskData.freeSlots() > 0) {
//			System.out.println("Free slots");
			
			int av = userData.getAv();
			
			if(userData.getScan()*4 < av) {
				System.out.println("Upgrade scan");
				upgrade(RESOURCE_SCAN, userData);
				return true;
			}
			if(userData.getSdk()*4 < av) {
				System.out.println("Upgrade sdk");
				upgrade(RESOURCE_SDK, userData);
				return true;
			}
			if(userData.getFw()*4 < av) {
				System.out.println("Upgrade firewall");
				upgrade(RESOURCE_FIREWALL, userData);
				return true;
			}
//			if(userData.getSpam()*4 < av) {
//				System.out.println("Upgrade spam");
//				upgrade(RESOURCE_SPAM, userData);
//				return true;
//			}
			System.out.println("Upgrade Antivirus");
			upgrade(RESOURCE_ANTIVIRUS, userData);
			return true;
//		}
		// TODO something about botnets
//		return false;
	}
	
	private static void upgrade(String item, UserData userData) throws UnirestException {
//		UpgradeInfoData upgradeData = getUpgradeInfo(userData);
//		System.out.println(upgradeData);
		

		UpgradeResultData upgradeResultData = doUpgrade(item, userData);
//		System.out.println(upgradeResultData);
		
		if(upgradeResultData.getResult().equals("0")) {
			System.out.println("&&&&&&& Successful upgrade of " + item);
		} else if(upgradeResultData.getResult().equals("1")) {
			int money = Integer.valueOf(upgradeResultData.getMoney()).intValue();
			int costs = Integer.valueOf(upgradeResultData.getCosts()).intValue();
			int need = costs - money;
			System.out.println("&&&&&&& Unsuccessful upgrade of " + item + " (Need: " + need + " more money - costs: " + costs + ")");
		} else if(upgradeResultData.getResult().equals("2")) {
			System.out.println("&&&&&&& Unsuccessful upgrade of " + item + " (Max level reached)");
			if(!MAX_LEVEL_REACHED.contains(item)) {
				MAX_LEVEL_REACHED.add(item);	
			}
		} else if(upgradeResultData.getResult().equals("3")) {
			System.out.println("&&&&&&& Unsuccessful upgrade of " + item + " (Not enough tasks)");
		}
	}

	private static UpgradeResultData doUpgrade(String item, UserData userData) throws UnirestException {
		String upgradeInfoUrl = Actions.generateActionUrl("utype", item, "vh_addUpdate.php", userData);
//		System.out.println(upgradeInfoUrl);
		HttpRequest req = Unirest.get(upgradeInfoUrl);
		HttpResponse<UpgradeResultData> res = req.asObject(UpgradeResultData.class);
		UpgradeResultData upgradeResultData = res.getBody();
		return upgradeResultData;
	}
	
	private static UpgradeInfoData getUpgradeInfo(String item, UserData userData) throws UnirestException {
		String upgradeInfoUrl = Actions.generateActionUrl("", "", "vh_tasks.php", userData);
		System.out.println(upgradeInfoUrl);
		HttpRequest req = Unirest.get(upgradeInfoUrl);
		HttpResponse<UpgradeInfoData> res = req.asObject(UpgradeInfoData.class);
		UpgradeInfoData upgradeInfoData = res.getBody();
		return upgradeInfoData;
	}

	private static TaskData getTaskData(UserData userData) throws UnirestException {
		String taskUrl = Actions.generateActionUrl("", "", "vh_tasks.php", userData);
		System.out.println(taskUrl);
		HttpRequest req = Unirest.get(taskUrl);

		HttpResponse<String> resS = req.asString();
		System.out.println(resS.getBody());
		
		//{"":"","time":"1473543107","user":"dangarfield","pass":"perfection","uhash":"d2652a4190a33db06756017682f8e89700eb82482446b7c407cec7d5d7cc07bb"}
		//{"":"","uhash":"8241e00bc6cb9c861b1347df42f3f821d09ae2ddb4f837344758e78cb7b9f72c","pass":"perfection","time":"1473543113","user":"dangarfield"}
		HttpResponse<TaskData> res = req.asObject(TaskData.class);
		TaskData taskData = res.getBody();
		return taskData;
	}
	
	private static void generateMoney(UserData userData) throws UnirestException {
		System.out.println("--- NEW NETWORK DATA ---");
		NetworkData networkData = getNetworkData(userData);
//		System.out.println(networkData);
		
		for (NetworkDataItem target : networkData.getData()) {
			int fw = target.getFw();
			
			if(target.getAttacked().equals("0") && fw >= 7 && fw < userData.getScan()) {
				System.out.println("scan: " + target);
				
				ScanData scanData = getScanData(target.getIp(), userData.getSdk(), userData);
				System.out.println(scanData);
				
				if(!scanData.isError() && scanData.getAntivirus() < userData.getSdk() && scanData.getSuccess() >= 60 && scanData.getMoney() >= 100000) {
					System.out.println("LOOKS LIKE A GOOD TARGET");
					launchTrojan(target.getIp(), userData);
				}
			}
		}
	}

	private static void launchTrojan(String ip, UserData userData) throws UnirestException  {
		String trojanUrl = Actions.generateActionUrl("target", ip, "vh_trTransfer.php", userData);
		
		HttpRequest req = Unirest.get(trojanUrl);
		HttpResponse<TrojanData> res = req.asObject(TrojanData.class);
		TrojanData trojanResult = res.getBody();
		System.out.println(trojanResult);
		
		if(trojanResult.getResult().equals("0")) {
			userData.setMoney(trojanResult.getNewmoney());
			System.out.println(userData);
			System.out.println("####### New Money: " + userData.getMoney() + " #######");
		} else {
			System.out.println("Didn't get any money");
		}
	}

	private static ScanData getScanData(String ip, int mySDK, UserData userData) throws UnirestException {
		String scanUrl = Actions.generateActionUrl("target", ip , "vh_scan.php", userData);
//		System.out.println(scanUrl);
		HttpRequest req = Unirest.get(scanUrl);
		HttpResponse<String> res = req.asString();
		String scanResult = res.getBody();
		
		String[] lines = scanResult.split("\n");
		ScanData scanData = new ScanData();
		if(lines.length == 14) {
			try {
				scanData.setUsername(lines[1].replace("          [ + ] Username: ", ""));
				scanData.setFirewall(Integer.valueOf(lines[2].replaceAll("[^0-9]", "")).intValue());
				scanData.setAntivirus(Integer.valueOf(lines[3].replaceAll("[^0-9]", "")).intValue());
				scanData.setScan(Integer.valueOf(lines[4].replaceAll("[^0-9]", "")).intValue());
				scanData.setSdk(Integer.valueOf(lines[5].replaceAll("[^0-9]", "")).intValue());
				scanData.setSpam(Integer.valueOf(lines[6].replaceAll("[^0-9]", "")).intValue());
				
				scanData.setMoney(Integer.valueOf(lines[7].replaceAll("[^0-9]", "")).intValue());
				
				scanData.setAnonymous(lines[9].contains(": YES"));
				
				scanData.setSuccess(Integer.valueOf(lines[13].replaceAll("[^0-9]", "")).intValue());
			
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("Exception translating scan");
				scanData.setError(false);
			}
		} else {
			System.out.println("Unknown number of lines");
			scanData.setError(true);
		}
		return scanData;
	}

	private static UserData getUserData() throws UnirestException {
		String updateUrl = Actions.generateActionUrl("", "", "vh_update.php", null);
//		System.out.println(updateUrl);
		HttpRequest req = Unirest.get(updateUrl);
		HttpResponse<UserData> res = req.asObject(UserData.class);
		UserData userData = res.getBody();
		return userData;
	}
	
	private static NetworkData getNetworkData(UserData userData) throws UnirestException {
		String networkUrl = Actions.generateActionUrl("global", "0", "vh_network.php", userData);
//		System.out.println(networkUrl);
		
		HttpRequest req = Unirest.get(networkUrl);
		HttpResponse<NetworkData> res = req.asObject(NetworkData.class);
		NetworkData networkData = res.getBody();
		return networkData;
	}

}
