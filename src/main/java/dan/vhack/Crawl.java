package dan.vhack;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.fasterxml.jackson.core.JsonParseException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.options.Option;
import com.mashape.unirest.http.options.Options;
import com.mashape.unirest.request.HttpRequest;
import com.mongodb.DB;
import com.mongodb.MongoClient;

import net.jodah.failsafe.ExecutionContext;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import net.jodah.failsafe.function.CheckedBiConsumer;
import net.jodah.failsafe.function.CheckedConsumer;
import net.jodah.failsafe.function.ContextualCallable;

public class Crawl {

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

	private static MongoCollection scans;
	private static MongoCollection money;

	@SuppressWarnings("unchecked")
	static RetryPolicy unirestRetryPolicy = new RetryPolicy().retryOn(UnirestException.class, JsonParseException.class)
			.withMaxRetries(5);

	public static void main(String[] args) throws UnirestException, KeyManagementException, NoSuchAlgorithmException,
			KeyStoreException, InterruptedException {

		Actions.prepareUniRest();

		prepareDB();

		UserData userData = getUserData();
		System.out.println(userData);

		// doINeedMoney(userData);
		// generateMoney(userData);
//		 performAnyUpgrades(userData);
		// performAnyBotnet(userData);
		// buyPackages(userData);

		while (true) {
			try {
				while (!doINeedMoney(userData)) {
					System.out.println("I don't need money at the minute, pausing for 1 min");
					Thread.sleep(1 * 60 * 1000);
				}
				int count = 0;
				while (count <= 10) {
					System.out.println("%%%% COUNT - " + count + " %%%%");
					generateMoney(userData);
					count++;
				}
				userData = getUserData();
				buyPackages(userData);
				performAnyUpgrades(userData);
				performAnyBotnet(userData);

			} catch (UnirestException e) {
				// e.printStackTrace();
				System.out.println("---- Error with http res");
			}
		}

	}

	private static void buyPackages(UserData userData) {
		if (userData.getBonus() > 0) {
			System.out.println("Bonus package available");
			// TODO - Open bonus package - /v/1/vh_openFreeBonus.php?
			// openBonusPackage(userData);
		}

		while (userData.getNetcoins() >= 200) {
			System.out.println("Enough netcoins to buy a package: " + userData.getNetcoins());
			BonusData bonusData = openPremBonus(userData);
			userData.setNetcoins(bonusData.getBleft());
			String bonusDataStringResult = translateBonusDataResult(bonusData);
			System.out.println(bonusDataStringResult);
		}
	}

	private static String translateBonusDataResult(BonusData bonusData) {
		if (bonusData.isError()) {
			return "Error opening prem bonus";
		} else {
			String type = "";
			String amount = "";
			switch (bonusData.getType()) {
			case "0":
				type = "NetCoins";
				amount = String.valueOf(bonusData.getWin());
				break;
			case "1":
				type = "Money";
				amount = String.valueOf(bonusData.getWin());
				break;
			case "2":
				type = getBonusUpgradeType(bonusData.getWin());
				amount = String.valueOf(bonusData.getLvl());
				break;
			case "3":
				type = "BotNet PC";
				amount = "1";
				break;
			}
			String text = "Received: " + amount + " " + type;
			return text;
		}

	}

	private static String getBonusUpgradeType(int win) {
		switch (win) {
		case 1:
			return "Firewall";
		case 2:
			return "Antivirus";
		case 3:
			return "SDK";
		case 4:
			return "IP-Spoofing";
		case 5:
			return "Spam";
		case 6:
			return "Scan";
		case 7:
			return "AdWare";
		default:
			return "Unknown";
		}
	}

	private static BonusData openPremBonus(UserData userData) {
		@SuppressWarnings("rawtypes")
		BonusData bonusData = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String taskUrl = Actions.generateActionUrl("", "", "vh_openPremBonus.php", userData);
				// System.out.println(taskUrl);
				HttpRequest req = Unirest.get(taskUrl);

				HttpResponse<String> res = req.asString();
				String body = res.getBody();

				// System.out.println(body);

				if (body.equals("0") || body.equals("1")) {
					BonusData bonusData = new BonusData();
					bonusData.setError(true);
					return bonusData;
				} else if (body.startsWith("{")) {
					ObjectMapper objectMapper = (ObjectMapper) Options.getOption(Option.OBJECT_MAPPER);
					BonusData bonusData = objectMapper.readValue(body, BonusData.class);
					return bonusData;
				} else {
					BonusData bonusData = new BonusData();
					bonusData.setError(true);
					return bonusData;
				}
				// //{"":"","time":"1473543107","user":"dangarfield","pass":"perfection","uhash":"d2652a4190a33db06756017682f8e89700eb82482446b7c407cec7d5d7cc07bb"}
				// //{"":"","uhash":"8241e00bc6cb9c861b1347df42f3f821d09ae2ddb4f837344758e78cb7b9f72c","pass":"perfection","time":"1473543113","user":"dangarfield"}
				// HttpResponse<TaskData> res2 = req.asObject(TaskData.class);
				// TaskData taskData = res2.getBody();
				// return taskData;
			}
		}, BonusData.class);

		return bonusData;
	}

	private static boolean doINeedMoney(UserData userData) throws UnirestException {
		// Check if there are any empty task slots
		TaskData taskData = getTaskData(userData);
		if (taskData.getRam() - taskData.freeSlots() > 0) {
			System.out.println("Need money - Free slots available");
			return true;
		}

		// Check if there are any non full bots
		BotnetInfoData botnetInfoData = getBotnetInfo(userData);
		System.out.println(botnetInfoData);
		for (BotnetInfoDataItem botnetInfoDataItem : botnetInfoData.getData()) {
			if (botnetInfoDataItem.getbLVL() < 100) {
				System.out.println("Need money - Botnet PCs need upgrading");
				return true;
			}
		}

		// If either are true, return true, else false
		System.out.println("No money required - Waiting for a few minutes");
		return false;
	}

	private static TaskData getTaskData(UserData userData) throws UnirestException {
		@SuppressWarnings("rawtypes")
		TaskData taskData = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String taskUrl = Actions.generateActionUrl("", "", "vh_tasks.php", userData);
				// System.out.println(taskUrl);
				HttpRequest req = Unirest.get(taskUrl);

				HttpResponse<String> res = req.asString();
				String body = res.getBody();

				// System.out.println(body);

				if (body.equals("0")) {
					TaskData taskData = new TaskData();
					taskData.setRam(userData.getRam());
					return taskData;
				} else if (body.startsWith("{")) {
					ObjectMapper objectMapper = (ObjectMapper) Options.getOption(Option.OBJECT_MAPPER);
					TaskData taskData = objectMapper.readValue(body, TaskData.class);
					return taskData;
				} else {
					TaskData taskData = new TaskData();
					taskData.setRam(0);
					return taskData;
				}
				// //{"":"","time":"1473543107","user":"dangarfield","pass":"perfection","uhash":"d2652a4190a33db06756017682f8e89700eb82482446b7c407cec7d5d7cc07bb"}
				// //{"":"","uhash":"8241e00bc6cb9c861b1347df42f3f821d09ae2ddb4f837344758e78cb7b9f72c","pass":"perfection","time":"1473543113","user":"dangarfield"}
				// HttpResponse<TaskData> res2 = req.asObject(TaskData.class);
				// TaskData taskData = res2.getBody();
				// return taskData;
			}
		}, TaskData.class);

		return taskData;
	}

	private static void performAnyBotnet(UserData userData) throws UnirestException {
		BotnetInfoData botnetInfoData = getBotnetInfo(userData);
		System.out.println(botnetInfoData);

		boolean upgradeOK = true;
		while (upgradeOK) {
			upgradeOK = upgradeBotnet(userData, botnetInfoData.getData());
		}
		System.out.println("No more botnet upgrades possible at the minute");

		if (botnetInfoData.getCanAtt1() == 1) {
			System.out.println("KFM-Solutions company attack available");
			attackCompany(userData, "1", "");
		} else {
			System.out.println("KFM-Solutions company attack not available");
		}
		if (botnetInfoData.getCanAtt2() == 1) {
			System.out.println("vHack Server company attack available");
			attackCompany(userData, "2", "2");
		} else {
			System.out.println("vHack Server company attack not available");
		}
		if (botnetInfoData.getCanAtt3() == 2) {
			System.out.println("TBC company attack available");
			attackCompany(userData, "3", "3");
		} else {
			System.out.println("TBC company attack not available");
		}

	}

	private static void attackCompany(UserData userData, String companyID, String pathAppendix)
			throws UnirestException {

		@SuppressWarnings("rawtypes")
		String attackCompanyData = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String attackCompanyUrl = Actions.generateActionUrl("company", companyID,
						"vh_attackCompany" + pathAppendix + ".php", userData);
				// System.out.println(attackCompanyUrl);
				HttpRequest req = Unirest.get(attackCompanyUrl);
				HttpResponse<String> res = req.asString();
				return res.getBody();
			}
		}, String.class);

		if (attackCompanyData.equals("0")) {
			System.out.println("Company attack - SUCCESS");
		} else if (attackCompanyData.equals("1") || attackCompanyData.equals("2")) {
			System.out.println("Company attack - BLOCKED");
		} else if (attackCompanyData.equals("3")) {
			System.out.println("Company attack not available");
		}
	}

	private static boolean upgradeBotnet(UserData userData, List<BotnetInfoDataItem> botnetInfoDataItems)
			throws UnirestException {
		if (botnetInfoDataItems != null && !botnetInfoDataItems.isEmpty()) {
			botnetInfoDataItems.sort(new Comparator<BotnetInfoDataItem>() {
				@Override
				public int compare(BotnetInfoDataItem a, BotnetInfoDataItem b) {
					return a.getbLVL() - b.getbLVL();
				}
			});
			BotnetInfoDataItem upgradeItem = botnetInfoDataItems.get(0);
			return performBotnetUpgrade(userData, upgradeItem);
		}
		return false;
	}

	private static boolean performBotnetUpgrade(UserData userData, BotnetInfoDataItem upgradeItem)
			throws UnirestException {

		@SuppressWarnings("rawtypes")
		BotnetUpgradeResultData botnetUpgradeResultData = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String upgradeUrl = Actions.generateActionUrl("bID", String.valueOf(upgradeItem.getbID()),
						"vh_upgradeBotnet.php", userData);
				HttpRequest req = Unirest.get(upgradeUrl);
				HttpResponse<String> res = req.asString();

				String value = res.getBody();
				// System.out.println(value);

				if (value.startsWith("{")) {
					ObjectMapper objectMapper = (ObjectMapper) Options.getOption(Option.OBJECT_MAPPER);
					BotnetUpgradeResultData botnetUpgradeResultData = objectMapper.readValue(value,
							BotnetUpgradeResultData.class);
					return botnetUpgradeResultData;
				} else {
					BotnetUpgradeResultData botnetUpgradeResultData = new BotnetUpgradeResultData();
					botnetUpgradeResultData.setError(true);
					return botnetUpgradeResultData;
				}
			}
		}, BotnetUpgradeResultData.class);

		if (!botnetUpgradeResultData.isError()) {
			System.out.println(upgradeItem);
			upgradeItem.setbLVL(botnetUpgradeResultData.getNewLevel());
			upgradeItem.setbPRICE(botnetUpgradeResultData.getNewLevel() * 100000);
			upgradeItem.setbSTR(botnetUpgradeResultData.getStrength());
			return true;
		} else {
			System.out.println("Botnet upgrade not possible");
			return false;
		}

	}

	private static BotnetInfoData getBotnetInfo(UserData userData) throws UnirestException {
		@SuppressWarnings("rawtypes")
		BotnetInfoData botnetInfoData = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String botnetInfoUrl = Actions.generateActionUrl("", "", "vh_botnetInfo.php", userData);
				// System.out.println(botnetInfoUrl);
				HttpRequest req = Unirest.get(botnetInfoUrl);
				HttpResponse<BotnetInfoData> res = req.asObject(BotnetInfoData.class);
				BotnetInfoData botnetInfoData = res.getBody();
				return botnetInfoData;
			}
		}, BotnetInfoData.class);
		return botnetInfoData;

	}

	private static void prepareDB() {

		@SuppressWarnings({ "resource", "deprecation" })
		DB db = new MongoClient().getDB("vhack");
		Jongo jongo = new Jongo(db);
		scans = jongo.getCollection("scans");
		money = jongo.getCollection("money");

//		MongoCursor<ScanData> datas = scans.find().sort("{_id:-1}").as(ScanData.class);
//		int count = 0;
//		for (ScanData d : datas) {
//			
//			System.out.println(count + " - " + d);
////			d.setScore(generateScore(d));
//			String orig = d.getUsername();
//			if(orig == null) {
//				orig = "";
//			}
//			d.setUsername(orig.replace("          [ + ] Username: ", "").replace("          [ - ] Username: ", ""));
//			scans.save(d);
//			count++;
//		}
		
		// Aggregation for money per minute:

		// db.money.aggregate([
		// {"$match":{"ip":"203.128.40.111"}},
		// { "$group": {
		// "_id": {
		// "$add": [
		// { "$subtract": [
		// { "$subtract": [ "$date", new Date(0) ] },
		// { "$mod": [
		// { "$subtract": [ "$date", new Date(0) ] },
		// 1000 * 60
		// ]}
		// ]},
		// new Date(0)
		// ]
		// },
		// "count": { "$sum": 1 },
		// "money": { "$sum": "$money" }
		// }},
		// {"$sort":{"_id":1}}
		// ]);
	}

	private static void performAnyUpgrades(UserData userData) throws UnirestException {
		boolean continueUpgrading = true;
		while (continueUpgrading) {
			continueUpgrading = performAnyUpgradesRecursive(userData);
		}
		System.out.println("No more upgrades");
	}

	private static boolean performAnyUpgradesRecursive(UserData userData) throws UnirestException {
		// TaskData taskData = getTaskData(userData);
		// System.out.println(taskData);

		// if(!MAX_LEVEL_REACHED.contains("inet")) { //MAX 10
		if (userData.getInet() < 10) {
			System.out.println("Upgrade internet");
			return upgrade(RESOURCE_INTERNET, userData);
		}
		// if(!MAX_LEVEL_REACHED.contains("cpu")) { //MAX 10
		if (userData.getCpu() < 10) {
			System.out.println("Upgrade CPU");
			return upgrade(RESOURCE_CPU, userData);
		}
		// if(!MAX_LEVEL_REACHED.contains("hdd")) { //MAX 10
		if (userData.getHdd() < 10) {
			System.out.println("Upgrade HDD");
			return upgrade(RESOURCE_HDD, userData);
		}
		// if(!MAX_LEVEL_REACHED.contains("ram")) { //MAX 14
		if (userData.getRam() < 14) {
			System.out.println("Upgrade RAM");
			return upgrade(RESOURCE_RAM, userData);
		}

		List<UpgradeCalc> upgradeCalcList = new ArrayList<UpgradeCalc>();
		upgradeCalcList.add(new UpgradeCalc("Firewall", 60, RESOURCE_FIREWALL, userData.getFw()));
		upgradeCalcList.add(new UpgradeCalc("Antirus", 60, RESOURCE_ANTIVIRUS, userData.getAv()));
		upgradeCalcList.add(new UpgradeCalc("SDK", 100, RESOURCE_SDK, userData.getSdk()));
		upgradeCalcList.add(new UpgradeCalc("IP-Spoofing", 60, RESOURCE_IPSPOOFING, userData.getIpsp()));
		upgradeCalcList.add(new UpgradeCalc("Spam", 100, RESOURCE_SPAM, userData.getSpam()));
		upgradeCalcList.add(new UpgradeCalc("Scan", 60, RESOURCE_SCAN, userData.getScan()));
		upgradeCalcList.add(new UpgradeCalc("AdWare", 80, RESOURCE_ADWARE, userData.getAdw()));

		int max = 0;
		for (UpgradeCalc upgradeCalc : upgradeCalcList) {
			int lvl = upgradeCalc.getExistingLevel();
			if (lvl > max) {
				max = lvl;
			}
		}
		BigDecimal maxBig = BigDecimal.valueOf(max);
		for (UpgradeCalc upgradeCalc : upgradeCalcList) {
			BigDecimal lvl = BigDecimal.valueOf(upgradeCalc.getExistingLevel());
			BigDecimal weight = BigDecimal.valueOf(upgradeCalc.getWeight());
			double score = maxBig.divide(lvl, MathContext.DECIMAL32).multiply(weight).doubleValue();
			upgradeCalc.setScore(score);
			// System.out.println(upgradeCalc);
		}
		upgradeCalcList.sort(new Comparator<UpgradeCalc>() {
			@Override
			public int compare(UpgradeCalc a, UpgradeCalc b) {
				return Double.valueOf(b.getScore()).compareTo(Double.valueOf(a.getScore()));
			}
		});
		UpgradeCalc upgradeItem = upgradeCalcList.get(0);
		System.out.println("Upgrading: " + upgradeItem.getType());
		return upgrade(upgradeItem.getMessageValue(), userData);
	}

	private static boolean upgrade(String item, UserData userData) throws UnirestException {
		UpgradeResultData upgradeResultData = doUpgrade(item, userData);
		// System.out.println(upgradeResultData);

		if (upgradeResultData.getResult().equals("0")) {
			System.out.println("&&&&&&& Successful upgrade of " + item);
			return true;
		} else if (upgradeResultData.getResult().equals("1")) {
			int money = Integer.valueOf(upgradeResultData.getMoney()).intValue();
			int costs = Integer.valueOf(upgradeResultData.getCosts()).intValue();
			int need = costs - money;
			System.out.println("&&&&&&& Unsuccessful upgrade of " + item + " (Need: " + need + " more money - costs: "
					+ costs + ")");
			return false;
		} else if (upgradeResultData.getResult().equals("2")) {
			System.out.println("&&&&&&& Unsuccessful upgrade of " + item + " (Max level reached)");
			return false;
		} else if (upgradeResultData.getResult().equals("3")) {
			System.out.println("&&&&&&& Unsuccessful upgrade of " + item + " (Not enough tasks)");
			return false;
		} else {
			return false;
		}
	}

	private static UpgradeResultData doUpgrade(String item, UserData userData) throws UnirestException {

		@SuppressWarnings("rawtypes")
		UpgradeResultData upgradeResultData = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String upgradeInfoUrl = Actions.generateActionUrl("utype", item, "vh_addUpdate.php", userData);
				// System.out.println(upgradeInfoUrl);
				HttpRequest req = Unirest.get(upgradeInfoUrl);
				HttpResponse<UpgradeResultData> res = req.asObject(UpgradeResultData.class);
				UpgradeResultData upgradeResultData = res.getBody();
				return upgradeResultData;
			}
		}, UpgradeResultData.class);
		return upgradeResultData;
	}

	private static void generateMoney(UserData userData) throws UnirestException {
		System.out.println("--- NEW NETWORK DATA ---");
		NetworkData networkData = getNetworkData(userData);
		// System.out.println(networkData);

		for (NetworkDataItem target : networkData.getData()) {
			int fw = target.getFw();

			if (target.getAttacked().equals("0") && fw >= 7 && fw < userData.getScan()) {
				System.out.println("scan: " + target);

				ScanData scanData = getScanData(target.getIp(), userData.getSdk(), userData);
				System.out.println(scanData);
				scans.save(scanData);

				if (!scanData.isError() && scanData.getAntivirus() < userData.getSdk() && scanData.getSuccess() >= 60
						&& scanData.getMoney() >= 100000) {
					System.out.println("LOOKS LIKE A GOOD TARGET");
					launchTrojan(target.getIp(), userData);
				}
			}
		}
	}

	private static void launchTrojan(String ip, UserData userData) throws UnirestException {

		@SuppressWarnings("rawtypes")
		TrojanData trojanResult = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String trojanUrl = Actions.generateActionUrl("target", ip, "vh_trTransfer.php", userData);

				HttpRequest req = Unirest.get(trojanUrl);
				HttpResponse<TrojanData> res = req.asObject(TrojanData.class);
				TrojanData trojanResult = res.getBody();
				System.out.println(trojanResult);
				return trojanResult;
			}
		}, TrojanData.class);

		if (trojanResult.getResult().equals("0")) {
			userData.setMoney(trojanResult.getNewmoney());
			System.out.println(userData);
			System.out.println("####### New Money: " + userData.getMoney() + " #######");
			MoneyData moneyData = new MoneyData();
			moneyData.setIp(userData.getIp());
			moneyData.setDate(new Date());
			moneyData.setMoney(trojanResult.getAmount());
			money.save(moneyData);
		} else {
			System.out.println("Didn't get any money");
		}
	}

	private static ScanData getScanData(String ip, int mySDK, UserData userData) throws UnirestException {

		@SuppressWarnings("rawtypes")
		String scanResult = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String scanUrl = Actions.generateActionUrl("target", ip, "vh_scan.php", userData);
				// System.out.println(scanUrl);
				HttpRequest req = Unirest.get(scanUrl);
				HttpResponse<String> res = req.asString();
				String scanResult = res.getBody();
				return scanResult;
			}
		}, String.class);

		String[] lines = scanResult.split("\n");
		ScanData scanData = new ScanData();
		scanData.setIp(ip);
		scanData.setLastScanned(new Date());

		if (lines.length == 14) {
			try {
				scanData.setUsername(lines[1].replace("          [ + ] Username: ", "").replace("          [ - ] Username: ", ""));
				scanData.setFirewall(Integer.valueOf(lines[2].replaceAll("[^0-9]", "")).intValue());
				scanData.setAntivirus(Integer.valueOf(lines[3].replaceAll("[^0-9]", "")).intValue());
				scanData.setScan(Integer.valueOf(lines[4].replaceAll("[^0-9]", "")).intValue());
				scanData.setSdk(Integer.valueOf(lines[5].replaceAll("[^0-9]", "")).intValue());
				scanData.setSpam(Integer.valueOf(lines[6].replaceAll("[^0-9]", "")).intValue());

				scanData.setMoney(Integer.valueOf(lines[7].replaceAll("[^0-9]", "")).intValue());

				scanData.setAnonymous(lines[9].contains(": YES"));

				scanData.setSuccess(Integer.valueOf(lines[13].replaceAll("[^0-9]", "")).intValue());

				scanData.setScore(generateScore(scanData));
				
			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("Exception translating scan");
				scanData.setError(false);
			}
		} else {
			System.out.println("Unknown number of lines");
			scanData.setError(true);
		}
		return scanData;
	}

	private static int generateScore(ScanData scanData) {
		int score = 0; 
		score += scanData.getFirewall() * 3;
		score += scanData.getAntivirus() * 3;
		score += scanData.getSdk() * 5;
		//score += scanData.get * 3; // IP Spoofing unknown 
		score += scanData.getSpam() * 5; //
		score += scanData.getScan() * 3;
		//score += scanData.get * 3; / Adware unknown
		
		
		int adwareAndSpoofingEstimation = BigInteger.valueOf(score).divide(BigInteger.valueOf(19)).intValue() * 7;
		score += adwareAndSpoofingEstimation;
		
		// Assume full hardware bonus
		score += 3000;
		return score;
	}

	private static UserData getUserData() throws UnirestException {

		@SuppressWarnings("rawtypes")
		UserData result = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String updateUrl = Actions.generateActionUrl("", "", "vh_update.php", null);
				// System.out.println(updateUrl);
				HttpRequest req = Unirest.get(updateUrl);
				HttpResponse<UserData> res = req.asObject(UserData.class);
				UserData userData = res.getBody();
				return userData;
			}
		}, UserData.class);

		return result;
	}

	private static NetworkData getNetworkData(UserData userData) {

		@SuppressWarnings("rawtypes")
		NetworkData result = retryCall(new ContextualCallable() {
			@Override
			public Object call(ExecutionContext context) throws Exception {
				String networkUrl = Actions.generateActionUrl("global", "0", "vh_network.php", userData);
				// System.out.println(networkUrl);

				HttpRequest req = Unirest.get(networkUrl);
				HttpResponse<NetworkData> res = req.asObject(NetworkData.class);
				NetworkData networkData = res.getBody();
				return networkData;
			}
		}, NetworkData.class);

		return result;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> T retryCall(ContextualCallable method, Class<T> clazz) {
		Object result = Failsafe.with(unirestRetryPolicy).onRetry(new CheckedBiConsumer<Object, Throwable>() {

			@Override
			public void accept(Object t, Throwable u) throws Exception {
				System.out.println("Retrying");
			}

		}).onFailure(new CheckedConsumer() {
			@Override
			public void accept(Object e) throws Exception {
				System.out.println("Failure: " + e);
				throw (UnirestException) e;
			}
		}).get(method);
		return (T) result;
	}

}
