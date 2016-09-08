var easyuiExt = function(){
   return {
       initCombobox:function(){
            $('.easyui-combobox').combobox({
                onHidePanel: function () {
                    var _options = $(this).combobox('options');
                    var _data = $(this).combobox('getData');
                    var _value = $(this).combobox('getValue');
                    var _b = false;
                    for (var i = 0; i < _data.length; i++) {
                        if (_data[i][_options.valueField] === _value) {
                            _b = true;
                            break;
                        }
                    }
                    if (!_b) {
                        $(this).combobox('setValue', '');
                    }
                 }
            });
       }
   };
}();
var Message = function () {
    return {
        //提示消息
        alert: function (msg, fn) {
            if (fn) {
                $.messager.alert('消息', msg, '', fn);
            } else {
                $.messager.alert('消息', msg);
            }
        },
        //消息提示
        info: function (msg, fn) {
            if (fn) {
                $.messager.alert('消息', msg, 'info', fn);
            } else {
                $.messager.alert('消息', msg, 'info');
            }
        },
        //警告消息
        warn: function (msg, fn) {
            if (fn) {
                $.messager.alert('警告', msg, 'warning', fn);
            } else {
                $.messager.alert('警告', msg, 'warning');
            }
        },
        //错误消息
        error: function (msg, fn) {
            if (fn) {
                $.messager.alert('错误', msg, 'error', fn);
            } else {
                $.messager.alert('错误', msg, 'error');
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
        confirm: function (msg, callback) {
            $.messager.confirm('确认消息', msg, callback);
        }
    }
}();

var ustc = function () {
    return {
        //右下角滑动提示框
        slideMsg: function (msg, timeout) {
            $.messager.show({
                title: '提示消息',
                msg: msg,
                timeout: timeout ? timeout : 3000,
                showType: 'show'
            });
        },
        //图片等比例缩小放大
        autoResizeImage: function (maxWidth, maxHeight, objImg) {
            var img = new Image();
            img.src = objImg.src;
            setTimeout(function () {
                var width = img.width;
                var height = img.height;
                if (width > maxWidth) {
                    objImg.width = maxWidth;
                    objImg.height = height * maxWidth / width;
                }
            }, 100);
        },
        /**
         * 查看图片
         * @param value
         * @returns
         */
        photo: function (value) {
            art.dialog({
                content: '<img src="/mobileImages2/' + value + '"/>',
                width: 'auto',
                height: 'auto',
                zIndex: "20000",
                left: '15%',
                top: '15%',
                lock: true,
                cancelVal: '关闭',
                cancel: true
            });
        }
    };
}();
////---------------------------------------------------  
// 日期格式化  
// 格式 YYYY/yyyy/YY/yy 表示年份  
// MM/M 月份  
// W/w 星期  
// dd/DD/d/D 日期  
// hh/HH/h/H 时间  
// mm/m 分钟  
// ss/SS/s/S 秒  
//---------------------------------------------------  
if (!Date.prototype.Format) {
    Date.prototype.Format = function (formatStr)
    {
        var str = formatStr;
        var Week = ['日', '一', '二', '三', '四', '五', '六'];

        str = str.replace(/yyyy|YYYY/, this.getFullYear());
        str = str.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100).toString() : '0' + (this.getYear() % 100));

        str = str.replace(/MM/, this.getMonth() + 1 > 9 ? (this.getMonth() + 1).toString() : '0' + (this.getMonth() + 1));
        str = str.replace(/M/g, this.getMonth() + 1);

        str = str.replace(/w|W/g, Week[this.getDay()]);

        str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
        str = str.replace(/d|D/g, this.getDate());

        str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
        str = str.replace(/h|H/g, this.getHours());
        str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes().toString() : '0' + this.getMinutes());
        str = str.replace(/m/g, this.getMinutes());

        str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
        str = str.replace(/s|S/g, this.getSeconds());

        return str;
    }
}

if (!Array.prototype.indexOf)
{
    Array.prototype.indexOf = function (elt /*, from*/)
    {
        var len = this.length >>> 0;

        var from = Number(arguments[1]) || 0;
        from = (from < 0)
                ? Math.ceil(from)
                : Math.floor(from);
        if (from < 0)
            from += len;
        for (; from < len; from++)
        {
            if (from in this &&
                    this[from] === elt)
                return from;
        }
        return -1;
    };
}

$.extend($.fn.validatebox.defaults.rules, {
    maxLength: {
        validator: function (value, param) {
            return value.length <= param[0];
        },
        message: '最多不超过{0}个字.'
    }
});
$.extend($.fn.validatebox.defaults.rules, {
    equals: {
        validator: function (value, param) {
            return value === $(param[0]).val();
        },
        message: '密码两次输入不一致。'
    },
    bigthan: {
        validator: function (value, param) {
            return value >= $(param[0]).val();
        },
        message: '{1}要不小于{2}。'
    },
    smallthan: {
        validator: function (value, param) {
            return value <= $(param[0]).val();
        },
        message: '{1}要不大于{2}。'
    }
});

function submitForm(formSelector, fun) {
    $(formSelector).form('submit', {
        success: function (data) {
            data = eval("(" + data + ")");
            if (data) {
                if (data.code === 'true') {
                    Message.alert(data.message, fun);
                } else {
                    Message.alert(data.message);
                }
            }
        }
    });
}

function clearForm(formSelector) {
    $(formSelector).form('clear');
}

$.fn.datebox.defaults.formatter = function (date) {
    var y = date.getFullYear();
    var m = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : '0' + (date.getMonth() + 1);
    var d = date.getDate() > 9 ? date.getDate() : '0' + date.getDate();
    return y + '-' + m + '-' + d;
};
