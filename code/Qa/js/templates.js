/**
 * 页面模板
 */
Templates = {
	// 首页相关
	app_main : template('<div id="content_main"><div id="content_main_left"><div style="height: 25px;font-size: 18px;">综合资讯</div><div id="app_news"></div></div><div id="content_main_center"><div style="height: 25px;font-size: 18px;">技术分享</div><div id="app_share"></div></div><div id="content_main_right"><div style="height: 25px;font-size: 18px;" id="app_question_title">最新提问</div><div id="app_question"></div></div></div>'),
	
	// 子菜单
	submenu:['<span>综合资讯</span> &nbsp; <span>技术分享</span> &nbsp; <span>最新提问</span>','<span>活跃</span> &nbsp; <span>最新提问</span> &nbsp; <span>尚未回答</span>'],

	// 首页界面
	main_app_news : template('<ul><% for (var i = 0; i < list.length; i++){ %><li class="news"><div class="title"><p><%=list[i].title %></p></div><div class="tips"><div class="news_time">2012年11月11日  11:11</div></div></div></li><% } %></ul>'),
	main_app_share : template('<ul><% for (var i = 0; i < list.length; i++){ %><li class="news"><div class="title"><p><%=list[i].title %></p></div><div class="tips"><% include("main_app_tips", list[i]) %></div></div></li><% } %></ul>'),
	main_app_question : template('<ul><% for (var i = 0; i < list.length; i++){ %><li class="news"><div class="title"><p><%=list[i].title %></p></div><div class="tips"><% include("main_app_tips", list[i]) %></div></div></li><% } %></ul>'),
	main_app_tips : template('main_app_tips', '<% for (var i = 0; i < tips.length; i++){ %><div class="tip"><%=tips[i].name %></div><% } %>'),


	// 问答区
	app_question : '<div id="content_main"><div id="ques_left"><div id="ques_left_title"><span>技术问答</span><div id="btn_ask" class="btn_ask">我要提问</div></div><div id="ques_questions"></div></div><div id="ques_right"><div id="ques_tips_hot"><span>热门标签</span></div><div id="tips_hot"></div></div></div>',
	question_list:template('<ul><% for (var i = 0; i < list.length; i++){ %><li class="ques"><div class="ques_title"><span><%=list[i].title %></span><span class="ques_answer_num">10</span></div><div class="ques_info"><div class="tips"><div class="tip"><span>Java</span></div><div class="tip"><span>数据库</span></div></div><span>发布于 13小时前 ，最后回答(1小时前)：quque</span></div></li><% } %></ul>'),
	question_hottips : template('<% for (var i = 0; i < list.length; i++){ %><div class="ques_tip"><%=list[i].tip %></div><% } %>'),
	
	// 新增问题页面
	question_add_html :[
		'<div id="content_main">',
			'<div id="ques_left">',
				'<div id="ques_left_title">',
					'<span>我的提问</span>',
					'<div id="btn_ask_save" class="btn_ask">保存提问</div>',
					'<div id="btn_ask_commit" class="btn_ask">提交提问</div>',
				'</div><div id="ques_new">',
					'<div id="ques_title_div"><span>标  题：</span><input type="text" class="tips_title" id="ques_title" /></div>',
				'<div id="ques_tips_div">',
					'<span>标  签：</span>',
					'<input type="text" class="tips_input" id="ques_tip1" /> ',
					'<input type="text" class="tips_input" id="ques_tip2" /> ',
					'<input type="text" class="tips_input" id="ques_tip3" /> ',
					'<input type="text" class="tips_input" id="ques_tip4" /> ',
					'<input type="text" class="tips_input" id="ques_tip5" /> ',
					'<div class="ques_new_tip">准确的关联开源软件，可让更多专家看到这个问题（最多5个）输入软件名首字，例如 Ubuntu 的 u 字，将会出现软件列表</div>',
				'</div>',
				'<div id="ques_new_fck"><textarea name="content" style="width:100%;height:100%;"></textarea></div>',
			'</div></div>',
		'<div id="ques_right"><div id="ques_tips_hot"><span>我的标签</span></div><div id="tips_hot"></div></div>'
	],
	// 登录界面
	login_html : '<div class="login_gray"></div><div class="login_div"><div id="login_div_head"><div id="login_back"></div></div><div id="login_div_form"><form method="POST" id="loginform"><p class="title">Login</p><p><input type="text" id="username" /></p><p><input type="password" id="password" /></p><p><button id="login">LOG IN</button> <button id="login_cancel">CANCEL</button></p><p><input type="checkbox" id="remeberme" />记住我的密码</p></form></div></div>',
	end:''
};

