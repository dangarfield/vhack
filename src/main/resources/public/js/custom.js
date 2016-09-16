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
					var key = data.substring(0,data.indexOf("|"));
					var val = data.substring(data.indexOf("|")+1);
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