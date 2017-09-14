//定义一个自定义的MessageBox
var myMsg =function(titles,message){
	var msg = Ext.Msg.show({
	    title: titles,
	    msg: message,
	    modal:false,
	    icon: Ext.MessageBox.INFO,
	});
	msg.setPagePosition( 1200, 480, false );
	setTimeout(function(){
        
		msg.close();
        
    },3000);
 }

// 自定义一个警告框
var myWarn = function(msg){
		Ext.Msg.show({
		    title:'警告',
		    msg: msg,
		    buttons: Ext.Msg.OK,
		    icon: Ext.Msg.WARNING
		});
}

var myAlertMsg = function(title,msg){
	Ext.MessageBox.alert(title,msg);
	
}


var myComboBox = function(fields,url,display,value){
	// The data store containing the list of states
	var states = Ext.create('Ext.data.Store', {
	    fields: fields,
	    proxy: {
	        type: 'ajax',
	        url: url,
	        reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
	            type: 'json', //返回数据类型为json格式
	        }
	   
	    },
	});

	// Create the combo box, attached to the states data store
	Ext.create('Ext.form.ComboBox', {
	    fieldLabel: 'Choose State',
	    store: states,
	    queryMode: 'remote',
	    displayField: display,
	    valueField: value,
	    renderTo: Ext.getBody()
	});
	
}






var toInt = function(str){
	
	
	return Number(str);
}
// get userNumber/studentNumber/teacherNumber
var getNumStart = function(){
	
	var date = new Date();
	var year = date.getFullYear();
	var yy = year.toString().substr(2, 2);
	return yy;
}

var getSchoolYearAtNow = function(){
	
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	if (month >=8){
		return year+"-"+(Number(year)+1);
	}
	if (month <8){
		return (Number(year)-1)+"-"+year;
	}
}

var getTermAtNow = function(){
	
	var date = new Date();
	var month = date.getMonth()+1;
	if (month >=8){
		return 1;
	}
	if (month <8){
		return 2;
	}
}






