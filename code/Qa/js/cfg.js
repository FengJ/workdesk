var KEditor = {};
KEditor.cfg = {
	cssPath : 'js/lib/editor/plugins/code/prettify.css',
	allowFileManager : true,
	resizeMode : 1,
	height : 340
};

var SYS = {};

SYS.cfg = {
	URL : 'http://localhost:8080/Workdesk'
};

Acc.cfg = {
	USERNAME_TEMP : '电子邮件地址',
	LOGIN_URL : SYS.cfg.URL+'/security/login'
};

