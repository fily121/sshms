var Message = function(){
	return {
		//提示消息
		alert:function(msg,fn){
			if(fn){
				$.messager.alert('消息',msg,'',fn);
			}else{
				$.messager.alert('消息',msg);
			}
		},
		
		//消息提示
		info:function(msg,fn){
			if(fn){
				$.messager.alert('消息',msg,'info',fn);
			}else{
				$.messager.alert('消息',msg,'info');
			}
		},
		
		//警告消息
		warn:function(msg,fn){
			if(fn){
				$.messager.alert('警告',msg,'warning',fn);
			}else{
				$.messager.alert('警告',msg,'warning');
			}
		},
		
		//错误消息
		error:function(msg,fn){
			if(fn){
				$.messager.alert('错误',msg,'error',fn);
			}else{
				$.messager.alert('错误',msg,'error');
			}
		},
		
		
		/**
		 * 确认消息
		 * demo:
		 * Message.confirm('yes or no?',function(r){
		 *		if(r){
		 *			Ict.alert('yes');
		 *		}else{
		 *			Ict.alert('no');
		 *		}
		 *	});
		 */
		confirm : function(msg,callback){  
			$.messager.confirm('确认消息', msg, callback);  
		}
	}
}();

$(function(){
	ustc.initTabPanel();
})
var ustc = function(){
	return {
		// 初始化tabpanel
		initTabPanel : function() {
			$('#mainPanel').tabs({
				fit : true,
				border : false,
				onSelect : function(title, index) {
					if (title == '首页') {
						$('#frame' + title).attr('src', '../leftframe/right');
					}
				},
				onContextMenu : function(e, title) {
					// 阻止默认的右键单击行为
					e.preventDefault();
					$('#mainPanel').tabs('select', title);
					$('#mm').menu('show', {
						left : e.pageX,
						top : e.pageY
					});
				}
			});
		},
		//添加Tab
		addTab:function(title,href,iconCls,closable){
			title = title.replace("(", "（");
			title = title.replace(")", "）");
			$.mainPanel = null;
			if (window.top != window.self) {
				$.mainPanel = $('#mainPanel',parent.document);
			}else{
				$.mainPanel = $('#mainPanel');
			}
			var exist = $.mainPanel.tabs('exists',title);
			if(exist){
				$.mainPanel.tabs('select', title);
				$('#frame'+title).attr('src', href);
			}else{
				var content = '<iframe id="frame'+title+'" name="frame'+title+'" scrolling="auto" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';  
				$.mainPanel.tabs('add',{  
		            title:title,  
		            content:content,
		            iconCls:iconCls,
		            closable:closable,
		            tools:[
		            	{
		            		iconCls:'icon-mini-refresh',
		            		handler:function(){
		            			$('#frame'+title).attr('src', href);
		            		}
		           		}
		            ]
		        });  
			}
		},
		
		//取得所有可以关闭的tab
		getClosableTabs :function(){
			var tabs = $('#mainPanel').tabs('tabs');
			var closableTabs = new Array();
			for (var i = 0; i < tabs.length; i++) {
				var panel = tabs[i];
				var closable = panel.panel('options').closable;
				if(closable==true){
					closableTabs.push(i);
				}
			}
			return closableTabs;
		},
		
		//移除可以关闭的所有tab
		removeTabs:function(){
			var closableTabs = this.getClosableTabs();
			if(closableTabs.length>0){
				var tab = closableTabs.shift();
				$('#mainPanel').tabs('close',tab);
				if(closableTabs.length>0){
					this.removeTabs();
				}
			}
		},
		
		//关闭选中标签页
		closeSelectedTab:function(){
			var panel = $('#mainPanel').tabs('getSelected');
			var closable = panel.panel('options').closable;
			var title = panel.panel('options').title;
			if(closable==true){
				$('#mainPanel').tabs('close',title);
			}
		},
		
		//关闭所有标签页
		closeAllTab:function(){
			this.removeTabs();
		},
		
		//关闭除选中之外的所有tab
		removeOtherTab:function(){
			var panel = $('#mainPanel').tabs('getSelected');
			var title = panel.panel('options').title;
			
			var tabs = $('#mainPanel').tabs('tabs');
			var closableTabs = new Array();
			for (var i = 0; i < tabs.length; i++) {
				var p = tabs[i];
				var closable = p.panel('options').closable;
				var tt = p.panel('options').title;
				if(title!=tt && closable==true){
					closableTabs.push(i);
				}
			}
			
			if(closableTabs.length>0){
				var tab = closableTabs.shift();
				$('#mainPanel').tabs('close',tab);
				if(closableTabs.length>0){
					this.removeOtherTab();
				}
			}
		},
		//关闭其他标签
		closeOtherTab:function(){
			this.removeOtherTab();
		},
        
		//右下角滑动提示框
		slideMsg : function(msg,timeout){
            $.messager.show({  
                title:'提示消息',  
                msg:msg, 
                timeout:timeout?timeout:3000,
                showType:'show'  
            });  
        },
        
        //打开窗口（默认使用）
        openWin : function(title,width,height,href){
		   $('#commonWindow').window({
			     title: title,
			     width: width,
			     shadow: false,
			     closed: false,
				 cache:  false,
			     height: height,
				 collapsible:false,
				 minimizable:false,
				 maximizable:false,
				 resizable:false,
				 href:href,
//				 content:content,
				 top:(document.body.clientHeight-height)/2,   
		         left:(document.body.scrollWidth-width)/2,
				 modal:true
			});
		},
		
		//弹出窗口（特殊情况下选择使用）
		openWin2 : function(title,width,height,href){
          var content = '<iframe scrolling="auto" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';  
          parent.$('#commonWindow').window({
			     title: title,
			     width: width,
			     shadow: false,
			     closed: false,
				 cache:  false,
			     height: height,
				 collapsible:false,
				 minimizable:false,
				 maximizable:false,
				 resizable:false,
				 content:content,
				 top:(parent.document.body.clientHeight-height)/2 ,   
		         left:(parent.document.body.scrollWidth-width)/2,
				 modal:true
			});	
		},
		//打开对话框
     
		//关闭窗口
		closeWin : function (){
			$('#commonWindow').window('close');
	 	},
	 	
	 	//关闭弹窗
	 	closeWin2 : function(){
	 		parent.$('#commonWindow').window('close');
	 	},
	 	//图片等比例缩小放大
	 	autoResizeImage:function(maxWidth,maxHeight,objImg){
	 		var img = new Image();
	 		img.src = objImg.src;
	 		setTimeout(function(){
				var width = img.width;
				var height = img.height;
				if(width > maxWidth){
					objImg.width = maxWidth;
					objImg.height = height*maxWidth/width;
				}
			},100);
	 	},
	 	/**
		 * 查看图片
		 * @param value
		 * @returns
		 */
		photo : function(value){
			art.dialog({
				content : '<img src="/mobileImages2/'+value+'"/>',
				width:'auto',
				height:'auto',
				zIndex : "20000",
				left: '15%',
			    top: '15%',
			    lock : true,
			    cancelVal: '关闭',
			    cancel: true
			});
		}
	};
}();

/**
 * 输出保留指定小数位的值
 * @x 要转换的值
 * @maxDec 要保留的小数位
 */
function keep2w(x, maxDec) {
	var f = parseFloat(x);    
	if (isNaN(f)) {    
		return '0.00';    
	}    
	var f = Math.round(x*100)/100;    
	var s = f.toString();    
	var rs = s.indexOf('.');    
	if (rs < 0) {    
		rs = s.length;    
		s += '.';    
	}    
	while (s.length <= rs + 2) {    
		s += '0';    
	}    
	return s;    
}


//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    
    //按需求返回变量名
    return(projectName);
}


var sy = $.extend({}, sy);/*定义一个全局变量*/

var grid;

var tab;

var Rowsgg=null;

//提示框变量
var title;
var message;

$(document).ready(function(){
	//点击树节点，添加tab页面
  $('#tree').tree({
	onClick: function(node){
		//console.info(node);
		if(node.attributes.url.trim()!="/"){
			//发送请示时，一般都要在url前面加上项目名称作为请求路径，否则会找不到页面，以前我用时可以不加也没问题，没仔细研究
			var url=getRootPath()+node.attributes.url;		 
			//console.info(url);
		    ustc.addTab(node.text,url,node.text,true);
		}
	}
  });

});

/**************************  grid  **************************/

//datagrid的一些方法调用
function getKeys(rows,key){
	var keyArr="";//必须赋初始值，否则行第一次循环时的值为undefined
	
	if(rows.length!=0){

		for(var i=0;i<rows.length;i++){

			if(keyArr!==""){
				keyArr+=",";
			}
			keyArr+="'"+rows[i][key]+"'";
		}
	}

	return keyArr;
}

/*
 * 判断是否有选中行
 */
function f_getGridRows(oGrid){
   	
	var rows=oGrid.datagrid('getSelections');
	
	if(rows.length==0){
		Message.alert('没有选中行，请选择一行进行编辑操作！');
		return false;
	}else if(rows.length>1){
		Message.alert('你选择了多行数据，只能选择一行数据进行编辑！');
		return false;
	}
	
	return true;
}

//删除操作，这时的url传参数时不再用param.id形式，因为后台使用了hibernate，为了更好的用面向对象，这里用了keyValue，后台用实体类接收
function f_del(gridId,urlValue,keyValue){
	
//	console.info(gridId);
	
	var rows=[];	
	rows=$('#'+gridId).datagrid('getSelections');
				
	var keys= getKeys(rows,keyValue);
	
	//console.info(keys);

	if(keys!='' && keys!=null){
		$.messager.confirm('警告','您确认要删除选中的行吗？',function(r){    
		    if (r){   
		    	
		    	$.ajax({  		    		
					url:urlValue+"?param.keys="+keys,
					
					type : "post",
					dataType:"json",
					success:function(data){
						if(data.msg){
						     $('#'+gridId).datagrid('load',{});	//利用空参数，刷新数据			
						     showMsg(data.msg);	
						}else if(data.err){
							Message.alert(data.err); 
						}
						
					},
					error:function(data){
						Message.alert(data.err);    	
					}
				});
		    			    	
		    }    
		});
	}else{
		Message.alert('没有选中任何行，请选择行后再操作!');    
	}
		
};






/**************************  form  **************************/

/*将form表单内的元素序列化为对象，扩展Jquery的一个方法 === 来源easyui孙宇*/ 
sy.serializeObject = function (form) { 
    var o = {};
    $.each(form.serializeArray(), function (index) {
        if (o[this['name']]) {
            o[this['name']] = o[this['name']] + "," + this['value'];
        } else {
            o[this['name']] = this['value'];
        }
    });
    return o;
};

//验证密码是否一致
$.extend($.fn.validatebox.defaults.rules, {
	eqPwd : {/* 验证两次密码是否一致功能 */
		validator : function(value, param) {
			console.info(value);
			console.info(param);
			return value == $(param[0]).val();
		},
		message : '密码不一致！'
	}
});

//解决validatebox初始化验证问题
$(function () {
    $('input.easyui-validatebox').validatebox('disableValidation')
    .focus(function () { $(this).validatebox('enableValidation');})
    .blur(function () { 
    	$(this).validatebox('validate');
    });
 });


/************************** tree  ****************************/
$.fn.tree.defaults.loadFilter = function(data, parent) {
	var opt = $(this).data().tree.options;
	var idFiled, textFiled, parentField;
	if (opt.parentField) {
		idFiled = opt.idFiled || 'id';
		textFiled = opt.textFiled || 'text';
		parentField = opt.parentField;
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idFiled]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['text'] = data[i][textFiled];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['text'] = data[i][textFiled];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};
