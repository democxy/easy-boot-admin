/**
 * 
 */

var checkboxUtils = {
		/**
		 * 全选按钮
		 * @param allName 全选复选框name属性名
		 * @param checkboxName 待全选的复选框name属性
		 */
		jsCheckAll:function(allName,checkboxName){
			var ch=document.getElementsByName(checkboxName);
			if(document.getElementsByName(allName)[0].checked==true){
				for(var i=0;i<ch.length;i++){
					ch[i].checked=true;
				}
			}else{
				for(var i=0;i<ch.length;i++){
					ch[i].checked=false;
				}
			}
		},

		/**
		 * 获取所有选中的值
		 */
		getAllCheckValue:function(checkboxName){
			var str = [];
			var ch=document.getElementsByName(checkboxName);
			for(var i=0;i<ch.length;i++){
				if(ch[i].checked){
//					str+=ch[i].value+",";
					str.push(ch[i].value);
				}
			}
			return str;
		},
		
		/**
		 * 通过判断所有选项是否都选中，改变全选框状态
		 * @param allName
		 * @param checkboxName
		 */
		changeAllType:function (allName,checkboxName){
			//获取到全选按钮的对象
			var check = document.getElementsByName(allName);
			//标签获取到所有的复选框
			var checkBox = document.getElementsByName(checkboxName);
			for(var i=0;i<checkBox.length;i++){
				if(!checkBox[i].checked){
					check[0].checked = false;
					break;
				}else{
					check[0].checked = true;
				}
			}
		}


}