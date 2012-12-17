var Acc = {};

Acc.login = (function() {
	return {
		showEventBind : function(id) {
			$(id).bind("click", function() {
				Acc.login.showHtml();
				Acc.login.eventBind();
			});
		},
		showHtml : function() {
			$('body').append(Templates.login_html);
			$('.login_gray').show();
			$('.login_div').hide();
			$('.login_div').slideDown(500);
		},
		removeHtml : function() {
			$('.login_gray').hide(500);
			$('.login_div').hide(1000);
			$('.login_gray').remove();
			$('.login_div').remove();
		},

		loginEvent : function() {
			$(login).attr('disabled', "true");
			var u = $(username).attr("value");
			var p = $(password).attr("value");
			var r = $(remeberme).attr("checked");
			Log.info(u + "---Login");
			Acc.login.login(u, p, function(data) {
				Log.info(data.success);
				$(login).removeAttr("disabled");
			});
		},

		login : function(uname, pword, callback) {
			$.ajax({
				type : 'POST',
				url : Acc.cfg.LOGIN_URL,
				data : {
					'username' : uname,
					'password' : pword
				},
				success : callback
			});
		},
		eventBind : function() {
			$(login_back).bind('click', Acc.login.removeHtml);
			$(login_cancel).bind('click', Acc.login.removeHtml);

			$(username).attr("value", Acc.cfg.USERNAME_TEMP);
			$(password).attr("value", Acc.cfg.PASSWORD_TEMP);
			$(username).off().on("focus", function() {
				var _u = $(username).attr("value");
				if(_u == Acc.cfg.USERNAME_TEMP) {
					$(username).attr("value", "");
				}
			}).on("blur", function() {
				var _u = $(username).attr("value");
				if(_u == "") {
					$(username).attr("value", Acc.cfg.USERNAME_TEMP);
				}
			});

			$(login).bind("click", Acc.login.loginEvent);
		}
	};
})();
