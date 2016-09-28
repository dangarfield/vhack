(function() {
	
	var VH = VH || {};
	
	VH.user = (function() {
		var init = function() {
//			console.log("init");
			botnetFormat();
			bindButtons();
			bindWebsockets();
		};

		var botnetFormat = function() {
			$(".list-group-item.botnet").each(function(index) {
				var d = $(this).data("botnet");
				var id = d.substring(0,d.indexOf(" "));
				var lvl = d.substring(d.lastIndexOf(" ")+1);
				$(this).find(".botnet-id").html(id);
				$(this).find(".botnet-lvl").html(lvl);
				$(this).find(".botnet-lvl").addClass("val-botnet-lvl-"+(index+1));
			})
		};
		var bindButtons = function() {
			$("button.btn-action").click(function(e) {
				e.preventDefault();
				var url = $(this).data("action");
				$.ajax({
					type: "GET",
					url: url,
					success: function(result) {
						if(result.hasOwnProperty("error")) {
							var error = "<strong>Error!</strong> Something went wrong, try again later";
							$(".alert").hide();
							$(".alert.alert-danger").html(error);
							$(".alert.alert-danger").removeClass("hidden-xl-down");
							$(".alert.alert-danger").show();
						} else {
							if(result.collectionRunning) {
								$(".alert").hide();
								$(".alert.alert-success").removeClass("hidden-xl-down");
								$(".alert.alert-success").show();
								$(".btn-action[data-action*='start']").prop('disabled', true);
								$(".btn-action[data-action*='stop']").prop('disabled', false);
							} else {
								$(".alert").hide();
								$(".alert.alert-info").removeClass("hidden-xl-down");
								$(".alert.alert-info").show();
								$(".btn-action[data-action*='start']").prop('disabled', false);
								$(".btn-action[data-action*='stop']").prop('disabled', true);
							}
						}
					}
				});
			});
		};

		var bindWebsockets = function() {
			var ws = new WebSocket("ws://" + location.hostname + ":" + location.port + "/events");
			
			ws.onconnect = function () { console.log("WebSocket connected") };
			ws.onmessage = function (msg) {
				var data = msg.data;
				if(data == "Prompt for registration") {
//					console.log("Prompt for registration - received");
					var username = $("h1").data("username");
					ws.send("register|"+username);
				} else if(data.startsWith("info") | data.startsWith("error") | data.startsWith("collect") | data.startsWith("package") | data.startsWith("upgrade")) {
					console.log(data);
					var splitData = data.split("|");
					var key = splitData[0];
					var val = splitData[1];
					var d = new Date();
					var m = parseInt(d.getMinutes());
					if(m < 10) {
						m = "0" + m;
					}
					var s = parseInt(d.getSeconds());
					if(s < 10) {
						s = "0" + s;
					}
					var t = d.getHours() + ":" + m + ":" + s;
					var linesToRemove = $(".log .inner .line").length - 4;
					if(linesToRemove > 0) {
						$(".log .inner .line:lt("+linesToRemove+")").remove();
					}
					$(".log .inner").append("<pre class=\"line\">"+t+" <span class=\"tag tag-default\">"+key + "</span> " + val + "</pre>")
					
					if(data.startsWith("collect")) {
						var newMoney = splitData[2];
						console.log(newMoney);
						updateAndHighlight("money", newMoney);
					}
				} else if(data.startsWith("chat")) {
					console.log(data);
					var dataElements = data.split("|||");
					
					var line = "";
					if(dataElements.length > 4) {
						//alert(data);
						var user = dataElements[1];
						var msg = dataElements[2];
						
//						return scanData.getIp() + "|" +
//						scanData.getFirewall() + "|" + 
//						scanData.getAntivirus() + "|" + 
//						scanData.getSdk() + "|" + 
//						scanData.getSpam() + "|" + 
//						scanData.getScan() + "|" + 
//						scanData.getMoney() + "|" + 
//						scanData.getSuccess() + "|" + 
//						scanData.getLastScanned();
						
						var ip = dataElements[3];
						var fw = dataElements[4];
						var av = dataElements[5];
						var sdk = dataElements[6];
						var spam = dataElements[7];
						var scan = dataElements[8];
						var money = dataElements[9];
						var suc = dataElements[10];
						var date = dataElements[11];
						
						line = "<pre class=\"line\"><span class=\"tag tag-default\">"+user + "</span> " + msg + "<br/>";
						line = line + "<span class=\"tag tag-success\">"+ip+"</span> ";
						line = line + "<span class=\"tag tag-success\">FW: "+fw+"</span> ";
						line = line + "<span class=\"tag tag-success\">AV: "+av+"</span> ";
						line = line + "<span class=\"tag tag-success\">SDK: "+sdk+"</span> ";
						line = line + "<span class=\"tag tag-success\">Spam: "+spam+"</span> ";
						line = line + "<span class=\"tag tag-success\">Scan: "+scan+"</span> ";
						line = line + "<span class=\"tag tag-success\">$ "+money+"</span> ";
						line = line + "<span class=\"tag tag-success\">"+suc+"%</span> ";
						line = line + "<span class=\"tag tag-success\">"+date+"</span>";
						line = line + "<button type=\"button\" class=\"btn btn-primary btn-action\" data-action=\"/user/dangarfield/scan-"+ip+"\" disabled=\"\">SCAN</button>";
						line = line + "<button type=\"button\" class=\"btn btn-primary btn-action\" data-action=\"/user/dangarfield/attack-"+ip+"\" disabled=\"\">ATTACK</button>";
						line = line + "</pre>";
					} else {
						var user = dataElements[1];
						var msg = dataElements[2];
						line = "<pre class=\"line\"><span class=\"tag tag-default\">"+user + "</span> " + msg + "</pre>";
					}
					var linesToRemove = $(".chat .inner .line").length - 49;
					if(linesToRemove > 0) {
						$(".chat .inner .line:lt("+linesToRemove+")").remove();
					}
					$(".chat .inner").append(line);
					
					
				} else if(data.startsWith("{")) {
					var j = JSON.parse(data);
//					console.log(j);
					for (var key in j.userData) {
						if (j.hasOwnProperty(key)) {
							var val = j[key];
							if(val !== Object(val)) {
//								console.log(key + " NOT OBJECT -> " + val);
								updateAndHighlight(key, val);
							}
						}
					}
					for (var key in j.botnetInfoData) {
						if (j.hasOwnProperty(key)) {
							var val = j[key];
							if(val !== Object(val)) {
//								console.log(key + " NOT OBJECT -> " + val);
								updateAndHighlight(key, val);
							}
						}
					}
					var botnetInfoData = j.botnetInfoData;
//					console.log(botnetInfoData);
					for(var i in botnetInfoData.data)
					{
					     var id = botnetInfoData.data[i].bID;
					     var lvl = botnetInfoData.data[i].bLVL;
//					     console.log(id + " - " + lvl);
					     updateAndHighlight("botnet-lvl-"+id, lvl);
					}

					var taskData = j.taskData;
//					console.log(taskData);
					j.list = [];
					for (var i in taskData.data) {
						var item = taskData.data[i].type;
//						console.log(item);
						if (j.list.hasOwnProperty(item)) {
							j.list[item] = j.list[item] + 1;
						} else {
							j.list[item] = 1;
						}
					}
					
					for (var key in j.list) {
						var val = j.list[key];
//						console.log(key + " - " + val);
						updateAndHighlight("train-"+key, val);
					}
//					console.log(j.list);
				} else {
					console.log(msg);
					console.log("Don't know what to do with ws msg.data: " +  data);
				}
			};
			ws.onclose = function () { console.log("WebSocket connection closed") };
			
			//ws.send("Register: {{userData.auth.username}}");
		}
		
		var updateAndHighlight = function(key, val) {
			var el = $(".val-"+key);
			var initial = el.html();
			el.html(val);
			if(""+val != ""+initial) {
//				console.log("el");
//				console.log(el);
		        el.before("<span/>")
		        el.prev()
		            .width(el.width())
		            .height(el.height())
		            .css({
		                "position": "absolute",
		                "background-color": "#ffff99",
		                "opacity": ".9"   
		            })
		            .fadeOut(500);
			}	
			
			
		}
		return {
			init : init
		};
	})();
	
	
	$(function() {
		VH.user.init();
	})
})();